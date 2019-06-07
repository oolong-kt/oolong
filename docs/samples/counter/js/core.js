if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'core'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'core'.");
}
if (typeof oolong === 'undefined') {
  throw new Error("Error loading module 'core'. Its dependency 'oolong' was not found. Please, check whether 'oolong' is loaded prior to 'core'.");
}
var core = function (_, Kotlin, $module$oolong) {
  'use strict';
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var none = $module$oolong.oolong.effect.none_30y1fr$;
  var to = Kotlin.kotlin.to_ujzrz7$;
  var equals = Kotlin.equals;
  Counter$Msg$Increment.prototype = Object.create(Counter$Msg.prototype);
  Counter$Msg$Increment.prototype.constructor = Counter$Msg$Increment;
  Counter$Msg$Decrement.prototype = Object.create(Counter$Msg.prototype);
  Counter$Msg$Decrement.prototype.constructor = Counter$Msg$Decrement;
  function Counter() {
    Counter_instance = this;
    this.init = Counter$init$lambda;
    this.update = Counter$update$lambda;
    this.view = Counter$view$lambda;
  }
  function Counter$Model(count) {
    if (count === void 0)
      count = 0;
    this.count = count;
  }
  Counter$Model.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Model',
    interfaces: []
  };
  Counter$Model.prototype.component1 = function () {
    return this.count;
  };
  Counter$Model.prototype.copy_za3lpa$ = function (count) {
    return new Counter$Model(count === void 0 ? this.count : count);
  };
  Counter$Model.prototype.toString = function () {
    return 'Model(count=' + Kotlin.toString(this.count) + ')';
  };
  Counter$Model.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.count) | 0;
    return result;
  };
  Counter$Model.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.count, other.count))));
  };
  function Counter$Msg() {
  }
  function Counter$Msg$Increment() {
    Counter$Msg$Increment_instance = this;
    Counter$Msg.call(this);
  }
  Counter$Msg$Increment.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Increment',
    interfaces: [Counter$Msg]
  };
  var Counter$Msg$Increment_instance = null;
  function Counter$Msg$Increment_getInstance() {
    if (Counter$Msg$Increment_instance === null) {
      new Counter$Msg$Increment();
    }
    return Counter$Msg$Increment_instance;
  }
  function Counter$Msg$Decrement() {
    Counter$Msg$Decrement_instance = this;
    Counter$Msg.call(this);
  }
  Counter$Msg$Decrement.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Decrement',
    interfaces: [Counter$Msg]
  };
  var Counter$Msg$Decrement_instance = null;
  function Counter$Msg$Decrement_getInstance() {
    if (Counter$Msg$Decrement_instance === null) {
      new Counter$Msg$Decrement();
    }
    return Counter$Msg$Decrement_instance;
  }
  Counter$Msg.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Msg',
    interfaces: []
  };
  function Counter$Props(count, onIncrement, onDecrement) {
    this.count = count;
    this.onIncrement = onIncrement;
    this.onDecrement = onDecrement;
  }
  Counter$Props.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Props',
    interfaces: []
  };
  Counter$Props.prototype.component1 = function () {
    return this.count;
  };
  Counter$Props.prototype.component2 = function () {
    return this.onIncrement;
  };
  Counter$Props.prototype.component3 = function () {
    return this.onDecrement;
  };
  Counter$Props.prototype.copy_38yqri$ = function (count, onIncrement, onDecrement) {
    return new Counter$Props(count === void 0 ? this.count : count, onIncrement === void 0 ? this.onIncrement : onIncrement, onDecrement === void 0 ? this.onDecrement : onDecrement);
  };
  Counter$Props.prototype.toString = function () {
    return 'Props(count=' + Kotlin.toString(this.count) + (', onIncrement=' + Kotlin.toString(this.onIncrement)) + (', onDecrement=' + Kotlin.toString(this.onDecrement)) + ')';
  };
  Counter$Props.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.count) | 0;
    result = result * 31 + Kotlin.hashCode(this.onIncrement) | 0;
    result = result * 31 + Kotlin.hashCode(this.onDecrement) | 0;
    return result;
  };
  Counter$Props.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.count, other.count) && Kotlin.equals(this.onIncrement, other.onIncrement) && Kotlin.equals(this.onDecrement, other.onDecrement)))));
  };
  function Counter$init$lambda() {
    return to(new Counter$Model(), none());
  }
  function Counter$update$lambda(msg, model) {
    var tmp$;
    if (equals(msg, Counter$Msg$Increment_getInstance()))
      tmp$ = model.copy_za3lpa$(model.count + 1 | 0);
    else if (equals(msg, Counter$Msg$Decrement_getInstance()))
      tmp$ = model.copy_za3lpa$(model.count - 1 | 0);
    else
      tmp$ = Kotlin.noWhenBranchMatched();
    return to(tmp$, none());
  }
  function Counter$view$lambda$lambda() {
    return Counter$Msg$Increment_getInstance();
  }
  function Counter$view$lambda$lambda_0() {
    return Counter$Msg$Decrement_getInstance();
  }
  function Counter$view$lambda(model) {
    return new Counter$Props(model.count, Counter$view$lambda$lambda, Counter$view$lambda$lambda_0);
  }
  Counter.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Counter',
    interfaces: []
  };
  var Counter_instance = null;
  function Counter_getInstance() {
    if (Counter_instance === null) {
      new Counter();
    }
    return Counter_instance;
  }
  Counter.prototype.Model = Counter$Model;
  Object.defineProperty(Counter$Msg, 'Increment', {
    get: Counter$Msg$Increment_getInstance
  });
  Object.defineProperty(Counter$Msg, 'Decrement', {
    get: Counter$Msg$Decrement_getInstance
  });
  Counter.prototype.Msg = Counter$Msg;
  Counter.prototype.Props = Counter$Props;
  var package$counter = _.counter || (_.counter = {});
  Object.defineProperty(package$counter, 'Counter', {
    get: Counter_getInstance
  });
  Kotlin.defineModule('core', _);
  return _;
}(typeof core === 'undefined' ? {} : core, kotlin, oolong);
