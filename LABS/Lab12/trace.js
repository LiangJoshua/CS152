function handlerMaker(obj) {
    return {
        // Fundamental traps
        deleteProperty: function (target, name) {
            if (name in target) {
                delete target[name];
                console.log('property removed: ' + name);
            }

        },
        getOwnPropertyDescriptor: function (name) {
            var desc = Object.getOwnPropertyDescriptor(obj, name);

            if (desc !== undefined) {
                desc.configurable = true;
            }
            return desc;

        },
        getPropertyDescriptor: function (name) {
            var desc = Object.getPropertyDescriptor(obj, name);
            desc.configurable = true;
            if (desc !== undefined) {
                desc.configurable = true;
            }
            return desc;
        },

        getOwnPropertyNames: function () {

            return Object.getOwnPropertyNames(obj);
        },
        getPropertyNames: function () {
            return Object.getPropertyNames(obj);
        },
        defineProperty: function (name, desc) {
            Object.defineProperty(obj, name, desc);
        },


        fix: function () {

            if (Object.isFrozen(obj)) {
                return Object.getOwnPropertyNames(obj).map(function (name) {
                    return Object.getOwnPropertyDescriptor(obj, name);
                });
            }

            return undefined;
        },

        // derived traps
        has: function (name) {
            console.log('testing if ' + name + ' is in ' + obj);
            return name in obj;
        },
        hasOwn: function (name) {
            console.log('testing if ' + obj + ' has ' + name + ' as a property.');
            return Object.prototype.hasOwnProperty.call(obj, name);
        },
        get: function (receiver, name) {
            console.log('retrieving ' + obj[name] + ' from ' + obj + '[' + name + ']');
            return obj[name];
        },
        set: function (receiver, name, val) {
            console.log('setting ' + '[' + name + '] to ' + val);
            obj[name] = val;
            return true;
        }, // bad behavior when set fails in non-strict mode

        keys: function () {
            console.log('fetching keys from ' + obj);
            return Object.keys(obj)
        }
    };
}


var constantVals = {
    pi: 3.14,
    e: 2.718,
    goldenRatio: 1.30357
};

var proxy = new Proxy(constantVals, handlerMaker(constantVals));

proxy.a = 1;
proxy.b = 2;
proxy.e;
proxy.c = 3;
delete proxy.c;
proxy.c;
'pi' in proxy;


