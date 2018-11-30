package edu.sjsu.fwjs;

import java.util.ArrayList;
import java.util.List;

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
    private Expression e1;
    private Expression e2;

    public BinOpExpr(Op op, Expression e1, Expression e2) {
        this.op = op;
        this.e1 = e1;
        this.e2 = e2;
    }

    @SuppressWarnings("incomplete-switch")
    public Value evaluate(Environment env) {
        Value v = new NullVal();
        if (e1.evaluate(env) instanceof IntVal && e2.evaluate(env) instanceof IntVal) {
            int i1 = ((IntVal) e1.evaluate(env)).toInt();
            int i2 = ((IntVal) e2.evaluate(env)).toInt();
            switch (op) {
                case ADD:
                    v = new IntVal(i1 + i2);
                    break;
                case SUBTRACT:
                    v = new IntVal(i1 - i2);
                    break;
                case MULTIPLY:
                    v = new IntVal(i1 * i2);
                    break;
                case DIVIDE:
                    v = new IntVal(i1 / i2);
                    break;
                case MOD:
                    v = new IntVal(i1 % i2);
                    break;
                case GT:
                    v = new BoolVal(i1 > i2);
                    break;
                case GE:
                    v = new BoolVal(i1 >= i2);
                    break;
                case LT:
                    v = new BoolVal(i1 < i2);
                    break;
                case LE:
                    v = new BoolVal(i1 <= i2);
                    break;
                case EQ:
                    v = new BoolVal(i1 == i2);
                    break;
            }
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
        Value v = null;
        if (((BoolVal) cond.evaluate(env)).toBoolean())
            v = thn.evaluate(env);
        else
            v = els.evaluate(env);

        return v;


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
        if (this.exp == null) {
            return new NullVal();
        }
        env.createVar(this.varName, this.exp.evaluate(env));
        return null;
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
        env.updateVar(varName, e.evaluate(env));
        return e.evaluate(env);
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
        ClosureVal closure = new ClosureVal(this.params, this.body, env);
        return closure;
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

