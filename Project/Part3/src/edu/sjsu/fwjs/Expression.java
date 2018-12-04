package edu.sjsu.fwjs;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;


/**
 * FWJS expressions.
 */
public interface Expression {
    /**
     * Evaluate the expression in the context of the specified environment.
     */
    public Value evaluate(Environment env);
}

// NOTE: Using package access so that all implementations of Expression
// can be included in the same file.

/**
 * FWJS constants.
 */
class ValueExpr implements Expression {
    private Value val;

    public ValueExpr(Value v) {
        this.val = v;
    }

    public Value evaluate(Environment env) {
        return this.val;
    }
}

/**
 * Expressions that are a FWJS variable.
 */
class VarExpr implements Expression {
    private String varName;

    public VarExpr(String varName) {
        this.varName = varName;
    }

    public Value evaluate(Environment env) {
        return env.resolveVar(varName);
    }
}

/**
 * A print expression.
 */
class PrintExpr implements Expression {
    private Expression exp;

    public PrintExpr(Expression exp) {
        this.exp = exp;
    }

    public Value evaluate(Environment env) {
        Value v = exp.evaluate(env);
        System.out.println(v.toString());
        return v;
    }
}

/**
 * Binary operators (+, -, *, etc).
 * Currently only numbers are supported.
 */
class BinOpExpr implements Expression {
    private Op op;
    private List<Expression> exprs;

    public BinOpExpr(Op op, Expression e1, Expression e2) {
        this.op = op;
        this.exprs = new ArrayList();
        this.exprs.add(e1);
        this.exprs.add(e2);
    }

    @SuppressWarnings("incomplete-switch")
    public Value evaluate(Environment env) {
        List<Value> vs = this.exprs.stream().map(x -> x.evaluate(env)).collect(Collectors.toList());
        //Javascript-ish implicit type conversion
        List<Integer> vals = vs.stream().map(
                x -> {
                    if (x instanceof BoolVal)
                        return ((BoolVal) x).toBoolean() ? 1 : 0;
                    else if (x instanceof NullVal)
                        return 0;
                    else if (x instanceof ClosureVal)
                        return -1; //Handled with closureFlag above
                    return ((IntVal) x).toInt();
                }
        ).collect(Collectors.toList());
        int x = vals.get(0);
        int y = vals.get(1);
        Value v = new NullVal();

        switch (op) {
            case ADD:
                v = new IntVal(x + y);
                break;
            case SUBTRACT:
                v = new IntVal(x - y);
                break;
            case MULTIPLY:
                v = new IntVal(x * y);
                break;
            case DIVIDE:
                v = new IntVal(x / y);
                break;
            case MOD:
                v = new IntVal(x % y);
                break;
            case GT:
                v = new BoolVal(x > y);
                break;
            case GE:
                v = new BoolVal(x >= y);
                break;
            case LT:
                v = new BoolVal(x < y);
                break;
            case LE:
                v = new BoolVal(x <= y);
                break;
            case EQ:
                v = new BoolVal(x == y);
                break;
        }

        return v;
    }

}

/**
 * If-then-else expressions.
 * Unlike JS, if expressions return a value.
 */
class IfExpr implements Expression {
    private Expression cond;
    private Expression thn;
    private Expression els;

    public IfExpr(Expression cond, Expression thn, Expression els) {
        this.cond = cond;
        this.thn = thn;
        this.els = els;
    }

    public Value evaluate(Environment env) {
        Value v = cond.evaluate(env);
        Boolean cond = false;

        if (v instanceof IntVal && ((IntVal) v).toInt() != 0) {
            cond = true;
        } else if (v instanceof BoolVal && ((BoolVal) v).toBoolean()) {
            cond = true;
        }
        if (cond == true) {
            return thn.evaluate(env);
        } else if (this.els != null) {
            return els.evaluate(env);
        } else {
            return new NullVal();
        }


    }
}

/**
 * While statements (treated as expressions in FWJS, unlike JS).
 */
class WhileExpr implements Expression {
    private Expression cond;
    private Expression body;

    public WhileExpr(Expression cond, Expression body) {
        this.cond = cond;
        this.body = body;
    }

    public Value evaluate(Environment env) {
        while (((BoolVal) cond.evaluate(env)).toBoolean())

            body.evaluate(env);
        return null;
    }
}

/**
 * Sequence expressions (i.e. 2 back-to-back expressions).
 */
class SeqExpr implements Expression {
    private Expression e1;
    private Expression e2;

    public SeqExpr(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Value evaluate(Environment env) {
        e1.evaluate(env);
        return e2.evaluate(env);
    }
}

/**
 * Declaring a variable in the local scope.
 */
class VarDeclExpr implements Expression {
    private String varName;
    private Expression exp;

    public VarDeclExpr(String varName, Expression exp) {
        this.varName = varName;
        this.exp = exp;
    }

    public Value evaluate(Environment env) {
        Value v = new NullVal();
        v = exp.evaluate(env);
        env.createVar(varName, v);
        return v;
    }
}

/**
 * Updating an existing variable.
 * If the variable is not set already, it is added
 * to the global scope.
 */
class AssignExpr implements Expression {
    private String varName;
    private Expression e;

    public AssignExpr(String varName, Expression e) {
        this.varName = varName;
        this.e = e;
    }

    public Value evaluate(Environment env) {
        if (e == null) {
            return null;
        }
        Value v = e.evaluate(env);
        env.updateVar(varName, v);
        return v;

    }
}

/**
 * A function declaration, which evaluates to a closure.
 */
class FunctionDeclExpr implements Expression {
    private List<String> params;
    private Expression body;

    public FunctionDeclExpr(List<String> params, Expression body) {
        this.params = params;
        this.body = body;
    }

    public Value evaluate(Environment env) {
        return new ClosureVal(params, body, env);
    }
}

/**
 * A function declaration, which evaluates to a closure.
 */
class NewFunctionDeclExpr implements Expression {
    private String name;
    private List<String> params;
    private Expression body;

    public NewFunctionDeclExpr(String name, List<String> params, Expression body) {
        this.name = name;
        this.params = params;
        this.body = body;
    }

    public Value evaluate(Environment env) {
        return (new VarDeclExpr(this.name, new ValueExpr(new ClosureVal(params, body, env)))).evaluate(env);
    }
}


/**
 * Function application.
 */
class FunctionAppExpr implements Expression {
    private Expression f;
    private List<Expression> args;

    public FunctionAppExpr(Expression f, List<Expression> args) {
        this.f = f;
        this.args = args;
    }

    public Value evaluate(Environment env) {
        List arguments = new ArrayList<Value>();
        for (Expression expression : this.args) {
            arguments.add(expression.evaluate(env));
        }

        ClosureVal closure = ((ClosureVal) this.f.evaluate(env));
        return closure.apply(arguments);
    }
}