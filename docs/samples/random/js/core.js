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
  var to = Kotlin.kotlin.to_ujzrz7$;
  var equals = Kotlin.equals;
  var none = $module$oolong.oolong.effect.none_30y1fr$;
  var IntRange = Kotlin.kotlin.ranges.IntRange;
  var CoroutineImpl = Kotlin.kotlin.coroutines.CoroutineImpl;
  var nextInt = $module$oolong.oolong.random.nextInt_qokxtc$;
  Random$Msg$Roll.prototype = Object.create(Random$Msg.prototype);
  Random$Msg$Roll.prototype.constructor = Random$Msg$Roll;
  Random$Msg$NewFace.prototype = Object.create(Random$Msg.prototype);
  Random$Msg$NewFace.prototype.constructor = Random$Msg$NewFace;
  function Random() {
    Random_instance = this;
    this.init = Random$init$lambda(this);
    this.update = Random$update$lambda(this);
    this.view = Random$view$lambda;
    this.rollDie_0 = Random$rollDie$lambda;
  }
  function Random$Model(face) {
    if (face === void 0)
      face = 0;
    this.face = face;
  }
  Random$Model.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Model',
    interfaces: []
  };
  Random$Model.prototype.component1 = function () {
    return this.face;
  };
  Random$Model.prototype.copy_za3lpa$ = function (face) {
    return new Random$Model(face === void 0 ? this.face : face);
  };
  Random$Model.prototype.toString = function () {
    return 'Model(face=' + Kotlin.toString(this.face) + ')';
  };
  Random$Model.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.face) | 0;
    return result;
  };
  Random$Model.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.face, other.face))));
  };
  function Random$Msg() {
  }
  function Random$Msg$Roll() {
    Random$Msg$Roll_instance = this;
    Random$Msg.call(this);
  }
  Random$Msg$Roll.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Roll',
    interfaces: [Random$Msg]
  };
  var Random$Msg$Roll_instance = null;
  function Random$Msg$Roll_getInstance() {
    if (Random$Msg$Roll_instance === null) {
      new Random$Msg$Roll();
    }
    return Random$Msg$Roll_instance;
  }
  function Random$Msg$NewFace(face) {
    Random$Msg.call(this);
    this.face = face;
  }
  Random$Msg$NewFace.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'NewFace',
    interfaces: [Random$Msg]
  };
  Random$Msg$NewFace.prototype.component1 = function () {
    return this.face;
  };
  Random$Msg$NewFace.prototype.copy_za3lpa$ = function (face) {
    return new Random$Msg$NewFace(face === void 0 ? this.face : face);
  };
  Random$Msg$NewFace.prototype.toString = function () {
    return 'NewFace(face=' + Kotlin.toString(this.face) + ')';
  };
  Random$Msg$NewFace.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.face) | 0;
    return result;
  };
  Random$Msg$NewFace.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.face, other.face))));
  };
  Random$Msg.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Msg',
    interfaces: []
  };
  function Random$Props(dieFace, onRoll) {
    this.dieFace = dieFace;
    this.onRoll = onRoll;
  }
  Random$Props.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Props',
    interfaces: []
  };
  Random$Props.prototype.component1 = function () {
    return this.dieFace;
  };
  Random$Props.prototype.component2 = function () {
    return this.onRoll;
  };
  Random$Props.prototype.copy_i115xd$ = function (dieFace, onRoll) {
    return new Random$Props(dieFace === void 0 ? this.dieFace : dieFace, onRoll === void 0 ? this.onRoll : onRoll);
  };
  Random$Props.prototype.toString = function () {
    return 'Props(dieFace=' + Kotlin.toString(this.dieFace) + (', onRoll=' + Kotlin.toString(this.onRoll)) + ')';
  };
  Random$Props.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.dieFace) | 0;
    result = result * 31 + Kotlin.hashCode(this.onRoll) | 0;
    return result;
  };
  Random$Props.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.dieFace, other.dieFace) && Kotlin.equals(this.onRoll, other.onRoll)))));
  };
  function Random$init$lambda(this$Random) {
    return function () {
      return to(new Random$Model(), this$Random.rollDie_0());
    };
  }
  function Random$update$lambda(this$Random) {
    return function (msg, model) {
      if (equals(msg, Random$Msg$Roll_getInstance()))
        return to(model, this$Random.rollDie_0());
      else if (Kotlin.isType(msg, Random$Msg$NewFace))
        return to(new Random$Model(msg.face), none());
      else
        return Kotlin.noWhenBranchMatched();
    };
  }
  function Random$view$lambda$lambda() {
    return Random$Msg$Roll_getInstance();
  }
  function Random$view$lambda(model) {
    return new Random$Props(model.face, Random$view$lambda$lambda);
  }
  function Coroutine$Random$rollDie$lambda$lambda($receiver_0, it_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$it = it_0;
  }
  Coroutine$Random$rollDie$lambda$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$Random$rollDie$lambda$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$Random$rollDie$lambda$lambda.prototype.constructor = Coroutine$Random$rollDie$lambda$lambda;
  Coroutine$Random$rollDie$lambda$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            return new Random$Msg$NewFace(this.local$it);
          case 1:
            throw this.exception_0;
          default:this.state_0 = 1;
            throw new Error('State Machine Unreachable execution');
        }
      }
       catch (e) {
        if (this.state_0 === 1) {
          this.exceptionState_0 = this.state_0;
          throw e;
        }
         else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function Random$rollDie$lambda$lambda($receiver_0, it_0, continuation_0, suspended) {
    var instance = new Coroutine$Random$rollDie$lambda$lambda($receiver_0, it_0, this, continuation_0);
    if (suspended)
      return instance;
    else
      return instance.doResume(null);
  }
  function Random$rollDie$lambda() {
    return nextInt(new IntRange(1, 6), Random$rollDie$lambda$lambda);
  }
  Random.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Random',
    interfaces: []
  };
  var Random_instance = null;
  function Random_getInstance() {
    if (Random_instance === null) {
      new Random();
    }
    return Random_instance;
  }
  Random.prototype.Model = Random$Model;
  Object.defineProperty(Random$Msg, 'Roll', {
    get: Random$Msg$Roll_getInstance
  });
  Random$Msg.NewFace = Random$Msg$NewFace;
  Random.prototype.Msg = Random$Msg;
  Random.prototype.Props = Random$Props;
  var package$random = _.random || (_.random = {});
  Object.defineProperty(package$random, 'Random', {
    get: Random_getInstance
  });
  Kotlin.defineModule('core', _);
  return _;
}(typeof core === 'undefined' ? {} : core, kotlin, oolong);
