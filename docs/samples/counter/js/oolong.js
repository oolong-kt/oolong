(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin', 'kotlinx-coroutines-core'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'), require('kotlinx-coroutines-core'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'oolong'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'oolong'.");
    }
    if (typeof this['kotlinx-coroutines-core'] === 'undefined') {
      throw new Error("Error loading module 'oolong'. Its dependency 'kotlinx-coroutines-core' was not found. Please, check whether 'kotlinx-coroutines-core' is loaded prior to 'oolong'.");
    }
    root.oolong = factory(typeof oolong === 'undefined' ? {} : oolong, kotlin, this['kotlinx-coroutines-core']);
  }
}(this, function (_, Kotlin, $module$kotlinx_coroutines_core) {
  'use strict';
  var coroutines = $module$kotlinx_coroutines_core.kotlinx.coroutines;
  var Unit = Kotlin.kotlin.Unit;
  var getCallableRef = Kotlin.getCallableRef;
  var COROUTINE_SUSPENDED = Kotlin.kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED;
  var CoroutineImpl = Kotlin.kotlin.coroutines.CoroutineImpl;
  var launch = $module$kotlinx_coroutines_core.kotlinx.coroutines.launch_s496o7$;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var CoroutineScope = $module$kotlinx_coroutines_core.kotlinx.coroutines.CoroutineScope;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var delay = $module$kotlinx_coroutines_core.kotlinx.coroutines.delay_s8cxhz$;
  var get_isActive = $module$kotlinx_coroutines_core.kotlinx.coroutines.get_isActive_e9pf1l$;
  var asIterable = Kotlin.kotlin.collections.asIterable_us0mfu$;
  var SupervisorJob = $module$kotlinx_coroutines_core.kotlinx.coroutines.SupervisorJob_5dx9e$;
  var withContext = $module$kotlinx_coroutines_core.kotlinx.coroutines.withContext_i5cbzn$;
  var to = Kotlin.kotlin.to_ujzrz7$;
  var Random = Kotlin.kotlin.random.Random;
  var nextInt = Kotlin.kotlin.random.nextInt_ixthlz$;
  var nextLong = Kotlin.kotlin.random.nextLong_lq3jag$;
  var nextUBytes = Kotlin.kotlin.random.nextUBytes_dg37c5$;
  var nextUBytes_0 = Kotlin.kotlin.random.nextUBytes_wucvsg$;
  var nextUInt = Kotlin.kotlin.random.nextUInt_j8mu42$;
  var nextUInt_0 = Kotlin.kotlin.random.nextUInt_nppi6x$;
  var nextUInt_1 = Kotlin.kotlin.random.nextUInt_3yup1w$;
  var nextUInt_2 = Kotlin.kotlin.random.nextUInt_d63giy$;
  var nextULong = Kotlin.kotlin.random.nextULong_j8mu42$;
  var nextULong_0 = Kotlin.kotlin.random.nextULong_otw1ua$;
  var nextULong_1 = Kotlin.kotlin.random.nextULong_3bt3ku$;
  var nextULong_2 = Kotlin.kotlin.random.nextULong_f33ad7$;
  function Oolong() {
    Oolong_instance = this;
  }
  function Oolong$runtime$lambda(closure$runtime) {
    return function () {
      closure$runtime.dispose();
      return Unit;
    };
  }
  Oolong.prototype.runtime = function (init, update, view, render, runtimeScope, effectContext, renderContext) {
    if (runtimeScope === void 0)
      runtimeScope = coroutines.GlobalScope;
    if (effectContext === void 0)
      effectContext = coroutines.Dispatchers.Default;
    if (renderContext === void 0)
      renderContext = coroutines.Dispatchers.Main;
    var runtime = new Oolong$Runtime(init, update, view, render, runtimeScope, effectContext, renderContext);
    return Oolong$runtime$lambda(runtime);
  };
  function Oolong$Runtime(init, update, view, render, runtimeScope, effectContext, renderContext) {
    if (runtimeScope === void 0)
      runtimeScope = coroutines.GlobalScope;
    if (effectContext === void 0)
      effectContext = coroutines.Dispatchers.Default;
    if (renderContext === void 0)
      renderContext = effectContext;
    this.update_0 = update;
    this.view_0 = view;
    this.render_0 = render;
    this.effectContext_0 = effectContext;
    this.renderContext_0 = renderContext;
    this.$delegate_thwly0$_0 = runtimeScope;
    this.running_0 = true;
    this.currentState_0 = null;
    var $receiver = init();
    this.currentState_0 = $receiver.first;
    this.change_0($receiver);
  }
  Oolong$Runtime.prototype.dispatch_0 = function (msg) {
    if (this.running_0) {
      this.change_0(this.update_0(msg, this.currentState_0));
    }
  };
  function Coroutine$Oolong$Runtime$change$lambda(closure$effect_0, this$Runtime_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$effect = closure$effect_0;
    this.local$this$Runtime = this$Runtime_0;
    this.local$$receiver = $receiver_0;
  }
  Coroutine$Oolong$Runtime$change$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$Oolong$Runtime$change$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$Oolong$Runtime$change$lambda.prototype.constructor = Coroutine$Oolong$Runtime$change$lambda;
  Coroutine$Oolong$Runtime$change$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$effect(this.local$$receiver, getCallableRef('dispatch', function ($receiver, msg) {
              return $receiver.dispatch_0(msg), Unit;
            }.bind(null, this.local$this$Runtime)), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.result_0;
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
  function Oolong$Runtime$change$lambda(closure$effect_0, this$Runtime_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$Oolong$Runtime$change$lambda(closure$effect_0, this$Runtime_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function Coroutine$Oolong$Runtime$change$lambda_0(this$Runtime_0, closure$state_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$this$Runtime = this$Runtime_0;
    this.local$closure$state = closure$state_0;
  }
  Coroutine$Oolong$Runtime$change$lambda_0.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$Oolong$Runtime$change$lambda_0.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$Oolong$Runtime$change$lambda_0.prototype.constructor = Coroutine$Oolong$Runtime$change$lambda_0;
  Coroutine$Oolong$Runtime$change$lambda_0.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            return this.local$this$Runtime.render_0(this.local$this$Runtime.view_0(this.local$closure$state), getCallableRef('dispatch', function ($receiver, msg) {
              return $receiver.dispatch_0(msg), Unit;
            }.bind(null, this.local$this$Runtime)));
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
  function Oolong$Runtime$change$lambda_0(this$Runtime_0, closure$state_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$Oolong$Runtime$change$lambda_0(this$Runtime_0, closure$state_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  Oolong$Runtime.prototype.change_0 = function (next) {
    var state = next.component1()
    , effect = next.component2();
    this.currentState_0 = state;
    launch(this, this.effectContext_0, void 0, Oolong$Runtime$change$lambda(effect, this));
    launch(this, this.renderContext_0, void 0, Oolong$Runtime$change$lambda_0(this, state));
  };
  Oolong$Runtime.prototype.dispose = function () {
    this.running_0 = false;
  };
  Object.defineProperty(Oolong$Runtime.prototype, 'coroutineContext', {
    get: function () {
      return this.$delegate_thwly0$_0.coroutineContext;
    }
  });
  Oolong$Runtime.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Runtime',
    interfaces: [CoroutineScope]
  };
  Oolong.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Oolong',
    interfaces: []
  };
  var Oolong_instance = null;
  function Oolong_getInstance() {
    if (Oolong_instance === null) {
      new Oolong();
    }
    return Oolong_instance;
  }
  function Coroutine$delay$lambda(closure$timeMillis_0, closure$msg_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$timeMillis = closure$timeMillis_0;
    this.local$closure$msg = closure$msg_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$delay$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$delay$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$delay$lambda.prototype.constructor = Coroutine$delay$lambda;
  Coroutine$delay$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = delay(this.local$closure$timeMillis, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            this.state_0 = 3;
            this.result_0 = this.local$closure$msg(this.local$$receiver, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 3:
            return this.local$dispatch(this.result_0);
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
  function delay$lambda(closure$timeMillis_0, closure$msg_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$delay$lambda(closure$timeMillis_0, closure$msg_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function delay_0(timeMillis, msg) {
    return delay$lambda(timeMillis, msg);
  }
  function Coroutine$interval$lambda$lambda(closure$dispatch_0, closure$msg_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$dispatch = closure$dispatch_0;
    this.local$closure$msg = closure$msg_0;
    this.local$$receiver = $receiver_0;
  }
  Coroutine$interval$lambda$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$interval$lambda$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$interval$lambda$lambda.prototype.constructor = Coroutine$interval$lambda$lambda;
  Coroutine$interval$lambda$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$closure$dispatch(this.result_0);
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
  function interval$lambda$lambda(closure$dispatch_0, closure$msg_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$interval$lambda$lambda(closure$dispatch_0, closure$msg_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function Coroutine$interval$lambda(closure$timeMillis_0, closure$msg_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$timeMillis = closure$timeMillis_0;
    this.local$closure$msg = closure$msg_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$interval$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$interval$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$interval$lambda.prototype.constructor = Coroutine$interval$lambda;
  Coroutine$interval$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            if (!get_isActive(this.local$$receiver)) {
              this.state_0 = 4;
              continue;
            }

            this.state_0 = 3;
            this.result_0 = delay(this.local$closure$timeMillis, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 3:
            if (get_isActive(this.local$$receiver)) {
              launch(this.local$$receiver, void 0, void 0, interval$lambda$lambda(this.local$dispatch, this.local$closure$msg));
            }

            this.state_0 = 2;
            continue;
          case 4:
            return Unit;
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
  function interval$lambda(closure$timeMillis_0, closure$msg_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$interval$lambda(closure$timeMillis_0, closure$msg_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function interval(timeMillis, msg) {
    return interval$lambda(timeMillis, msg);
  }
  function contramap$lambda(closure$dispatch, closure$f) {
    return function (b) {
      closure$dispatch(closure$f(b));
      return Unit;
    };
  }
  function contramap(dispatch, f) {
    return contramap$lambda(dispatch, f);
  }
  function Coroutine$none$lambda($receiver_0, it_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
  }
  Coroutine$none$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$none$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$none$lambda.prototype.constructor = Coroutine$none$lambda;
  Coroutine$none$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            return Unit;
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
  function none$lambda($receiver_0, it_0, continuation_0, suspended) {
    var instance = new Coroutine$none$lambda($receiver_0, it_0, this, continuation_0);
    if (suspended)
      return instance;
    else
      return instance.doResume(null);
  }
  function none() {
    return none$lambda;
  }
  function batch(effects) {
    return batch_0(asIterable(effects));
  }
  function Coroutine$batch$lambda$lambda(closure$effect_0, closure$dispatch_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$effect = closure$effect_0;
    this.local$closure$dispatch = closure$dispatch_0;
    this.local$$receiver = $receiver_0;
  }
  Coroutine$batch$lambda$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$batch$lambda$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$batch$lambda$lambda.prototype.constructor = Coroutine$batch$lambda$lambda;
  Coroutine$batch$lambda$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$effect(this.local$$receiver, this.local$closure$dispatch, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.result_0;
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
  function batch$lambda$lambda(closure$effect_0, closure$dispatch_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$batch$lambda$lambda(closure$effect_0, closure$dispatch_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function Coroutine$batch$lambda(closure$effects_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$effects = closure$effects_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$batch$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$batch$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$batch$lambda.prototype.constructor = Coroutine$batch$lambda;
  Coroutine$batch$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            var tmp$;
            tmp$ = this.local$closure$effects.iterator();
            while (tmp$.hasNext()) {
              var effect = tmp$.next();
              launch(this.local$$receiver, void 0, void 0, batch$lambda$lambda(effect, this.local$dispatch));
            }

            return Unit;
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
  function batch$lambda(closure$effects_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$batch$lambda(closure$effects_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function batch_0(effects) {
    return batch$lambda(effects);
  }
  function map$lambda$lambda(closure$dispatch, closure$f) {
    return function (a) {
      closure$dispatch(closure$f(a));
      return Unit;
    };
  }
  function Coroutine$map$lambda(closure$effect_0, closure$f_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$effect = closure$effect_0;
    this.local$closure$f = closure$f_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$map$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$map$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$map$lambda.prototype.constructor = Coroutine$map$lambda;
  Coroutine$map$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$effect(this.local$$receiver, map$lambda$lambda(this.local$dispatch, this.local$closure$f), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.result_0;
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
  function map$lambda(closure$effect_0, closure$f_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$map$lambda(closure$effect_0, closure$f_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function map(effect, f) {
    return map$lambda(effect, f);
  }
  function disposableEffect$lambda(closure$supervisor) {
    return function () {
      closure$supervisor.cancel_m4sck1$();
      return Unit;
    };
  }
  function Coroutine$disposableEffect$lambda$lambda(closure$effect_0, closure$dispatch_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$effect = closure$effect_0;
    this.local$closure$dispatch = closure$dispatch_0;
    this.local$$receiver = $receiver_0;
  }
  Coroutine$disposableEffect$lambda$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$disposableEffect$lambda$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$disposableEffect$lambda$lambda.prototype.constructor = Coroutine$disposableEffect$lambda$lambda;
  Coroutine$disposableEffect$lambda$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$effect(this.local$$receiver, this.local$closure$dispatch, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.result_0;
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
  function disposableEffect$lambda$lambda(closure$effect_0, closure$dispatch_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$disposableEffect$lambda$lambda(closure$effect_0, closure$dispatch_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function Coroutine$disposableEffect$lambda(closure$supervisor_0, closure$effect_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$supervisor = closure$supervisor_0;
    this.local$closure$effect = closure$effect_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$disposableEffect$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$disposableEffect$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$disposableEffect$lambda.prototype.constructor = Coroutine$disposableEffect$lambda;
  Coroutine$disposableEffect$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = withContext(this.local$$receiver.coroutineContext.plus_1fupul$(this.local$closure$supervisor), disposableEffect$lambda$lambda(this.local$closure$effect, this.local$dispatch), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.result_0;
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
  function disposableEffect$lambda_0(closure$supervisor_0, closure$effect_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$disposableEffect$lambda(closure$supervisor_0, closure$effect_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function disposableEffect(effect_0) {
    var supervisor = SupervisorJob();
    var dispose = disposableEffect$lambda(supervisor);
    return to(effect(disposableEffect$lambda_0(supervisor, effect_0)), dispose);
  }
  function bimap(next, fa, fb) {
    return to(fa(next.first), map(next.second, fb));
  }
  function Coroutine$nextBits$lambda(closure$msg_0, closure$bitCount_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$bitCount = closure$bitCount_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextBits$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextBits$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextBits$lambda.prototype.constructor = Coroutine$nextBits$lambda;
  Coroutine$nextBits$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextBits_za3lpa$(this.local$closure$bitCount), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextBits$lambda(closure$msg_0, closure$bitCount_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextBits$lambda(closure$msg_0, closure$bitCount_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextBits(bitCount, msg) {
    return nextBits$lambda(msg, bitCount);
  }
  function Coroutine$nextBoolean$lambda(closure$msg_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextBoolean$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextBoolean$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextBoolean$lambda.prototype.constructor = Coroutine$nextBoolean$lambda;
  Coroutine$nextBoolean$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextBoolean(), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextBoolean$lambda(closure$msg_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextBoolean$lambda(closure$msg_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextBoolean(msg) {
    return nextBoolean$lambda(msg);
  }
  function Coroutine$nextBytes$lambda(closure$msg_0, closure$array_0, closure$fromIndex_0, closure$toIndex_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$array = closure$array_0;
    this.local$closure$fromIndex = closure$fromIndex_0;
    this.local$closure$toIndex = closure$toIndex_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextBytes$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextBytes$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextBytes$lambda.prototype.constructor = Coroutine$nextBytes$lambda;
  Coroutine$nextBytes$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextBytes_mj6st8$(this.local$closure$array, this.local$closure$fromIndex, this.local$closure$toIndex), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextBytes$lambda(closure$msg_0, closure$array_0, closure$fromIndex_0, closure$toIndex_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextBytes$lambda(closure$msg_0, closure$array_0, closure$fromIndex_0, closure$toIndex_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextBytes(array, fromIndex, toIndex, msg) {
    return nextBytes$lambda(msg, array, fromIndex, toIndex);
  }
  function Coroutine$nextBytes$lambda_0(closure$msg_0, closure$array_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$array = closure$array_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextBytes$lambda_0.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextBytes$lambda_0.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextBytes$lambda_0.prototype.constructor = Coroutine$nextBytes$lambda_0;
  Coroutine$nextBytes$lambda_0.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextBytes_fqrh44$(this.local$closure$array), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextBytes$lambda_0(closure$msg_0, closure$array_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextBytes$lambda_0(closure$msg_0, closure$array_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextBytes_0(array, msg) {
    return nextBytes$lambda_0(msg, array);
  }
  function Coroutine$nextBytes$lambda_1(closure$msg_0, closure$size_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$size = closure$size_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextBytes$lambda_1.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextBytes$lambda_1.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextBytes$lambda_1.prototype.constructor = Coroutine$nextBytes$lambda_1;
  Coroutine$nextBytes$lambda_1.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextBytes_za3lpa$(this.local$closure$size), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextBytes$lambda_1(closure$msg_0, closure$size_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextBytes$lambda_1(closure$msg_0, closure$size_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextBytes_1(size, msg) {
    return nextBytes$lambda_1(msg, size);
  }
  function Coroutine$nextDouble$lambda(closure$msg_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextDouble$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextDouble$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextDouble$lambda.prototype.constructor = Coroutine$nextDouble$lambda;
  Coroutine$nextDouble$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextDouble(), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextDouble$lambda(closure$msg_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextDouble$lambda(closure$msg_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextDouble(msg) {
    return nextDouble$lambda(msg);
  }
  function Coroutine$nextDouble$lambda_0(closure$msg_0, closure$until_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$until = closure$until_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextDouble$lambda_0.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextDouble$lambda_0.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextDouble$lambda_0.prototype.constructor = Coroutine$nextDouble$lambda_0;
  Coroutine$nextDouble$lambda_0.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextDouble_14dthe$(this.local$closure$until), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextDouble$lambda_0(closure$msg_0, closure$until_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextDouble$lambda_0(closure$msg_0, closure$until_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextDouble_0(until, msg) {
    return nextDouble$lambda_0(msg, until);
  }
  function Coroutine$nextDouble$lambda_1(closure$msg_0, closure$from_0, closure$until_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$from = closure$from_0;
    this.local$closure$until = closure$until_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextDouble$lambda_1.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextDouble$lambda_1.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextDouble$lambda_1.prototype.constructor = Coroutine$nextDouble$lambda_1;
  Coroutine$nextDouble$lambda_1.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextDouble_lu1900$(this.local$closure$from, this.local$closure$until), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextDouble$lambda_1(closure$msg_0, closure$from_0, closure$until_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextDouble$lambda_1(closure$msg_0, closure$from_0, closure$until_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextDouble_1(from, until, msg) {
    return nextDouble$lambda_1(msg, from, until);
  }
  function Coroutine$nextFloat$lambda(closure$msg_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextFloat$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextFloat$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextFloat$lambda.prototype.constructor = Coroutine$nextFloat$lambda;
  Coroutine$nextFloat$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextFloat(), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextFloat$lambda(closure$msg_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextFloat$lambda(closure$msg_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextFloat(msg) {
    return nextFloat$lambda(msg);
  }
  function Coroutine$nextInt$lambda(closure$msg_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextInt$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextInt$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextInt$lambda.prototype.constructor = Coroutine$nextInt$lambda;
  Coroutine$nextInt$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextInt(), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextInt$lambda(closure$msg_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextInt$lambda(closure$msg_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextInt_0(msg) {
    return nextInt$lambda(msg);
  }
  function Coroutine$nextInt$lambda_0(closure$msg_0, closure$until_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$until = closure$until_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextInt$lambda_0.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextInt$lambda_0.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextInt$lambda_0.prototype.constructor = Coroutine$nextInt$lambda_0;
  Coroutine$nextInt$lambda_0.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextInt_za3lpa$(this.local$closure$until), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextInt$lambda_0(closure$msg_0, closure$until_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextInt$lambda_0(closure$msg_0, closure$until_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextInt_1(until, msg) {
    return nextInt$lambda_0(msg, until);
  }
  function Coroutine$nextInt$lambda_1(closure$msg_0, closure$from_0, closure$until_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$from = closure$from_0;
    this.local$closure$until = closure$until_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextInt$lambda_1.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextInt$lambda_1.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextInt$lambda_1.prototype.constructor = Coroutine$nextInt$lambda_1;
  Coroutine$nextInt$lambda_1.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextInt_vux9f0$(this.local$closure$from, this.local$closure$until), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextInt$lambda_1(closure$msg_0, closure$from_0, closure$until_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextInt$lambda_1(closure$msg_0, closure$from_0, closure$until_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextInt_2(from, until, msg) {
    return nextInt$lambda_1(msg, from, until);
  }
  function Coroutine$nextInt$lambda_2(closure$msg_0, closure$range_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$range = closure$range_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextInt$lambda_2.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextInt$lambda_2.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextInt$lambda_2.prototype.constructor = Coroutine$nextInt$lambda_2;
  Coroutine$nextInt$lambda_2.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, nextInt(Random.Default, this.local$closure$range), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextInt$lambda_2(closure$msg_0, closure$range_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextInt$lambda_2(closure$msg_0, closure$range_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextInt_3(range, msg) {
    return nextInt$lambda_2(msg, range);
  }
  function Coroutine$nextLong$lambda(closure$msg_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextLong$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextLong$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextLong$lambda.prototype.constructor = Coroutine$nextLong$lambda;
  Coroutine$nextLong$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextLong(), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextLong$lambda(closure$msg_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextLong$lambda(closure$msg_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextLong_0(msg) {
    return nextLong$lambda(msg);
  }
  function Coroutine$nextLong$lambda_0(closure$msg_0, closure$until_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$until = closure$until_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextLong$lambda_0.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextLong$lambda_0.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextLong$lambda_0.prototype.constructor = Coroutine$nextLong$lambda_0;
  Coroutine$nextLong$lambda_0.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextLong_s8cxhz$(this.local$closure$until), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextLong$lambda_0(closure$msg_0, closure$until_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextLong$lambda_0(closure$msg_0, closure$until_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextLong_1(until, msg) {
    return nextLong$lambda_0(msg, until);
  }
  function Coroutine$nextLong$lambda_1(closure$msg_0, closure$from_0, closure$until_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$from = closure$from_0;
    this.local$closure$until = closure$until_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextLong$lambda_1.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextLong$lambda_1.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextLong$lambda_1.prototype.constructor = Coroutine$nextLong$lambda_1;
  Coroutine$nextLong$lambda_1.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, Random.Default.nextLong_3pjtqy$(this.local$closure$from, this.local$closure$until), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextLong$lambda_1(closure$msg_0, closure$from_0, closure$until_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextLong$lambda_1(closure$msg_0, closure$from_0, closure$until_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextLong_2(from, until, msg) {
    return nextLong$lambda_1(msg, from, until);
  }
  function Coroutine$nextLong$lambda_2(closure$msg_0, closure$range_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$range = closure$range_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextLong$lambda_2.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextLong$lambda_2.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextLong$lambda_2.prototype.constructor = Coroutine$nextLong$lambda_2;
  Coroutine$nextLong$lambda_2.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, nextLong(Random.Default, this.local$closure$range), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextLong$lambda_2(closure$msg_0, closure$range_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextLong$lambda_2(closure$msg_0, closure$range_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextLong_3(range, msg) {
    return nextLong$lambda_2(msg, range);
  }
  function Coroutine$nextUBytes$lambda(closure$msg_0, closure$array_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$array = closure$array_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextUBytes$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextUBytes$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextUBytes$lambda.prototype.constructor = Coroutine$nextUBytes$lambda;
  Coroutine$nextUBytes$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, nextUBytes(Random.Default, this.local$closure$array), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextUBytes$lambda(closure$msg_0, closure$array_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextUBytes$lambda(closure$msg_0, closure$array_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextUBytes_1(array, msg) {
    return nextUBytes$lambda(msg, array);
  }
  function Coroutine$nextUBytes$lambda_0(closure$msg_0, closure$size_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$size = closure$size_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextUBytes$lambda_0.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextUBytes$lambda_0.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextUBytes$lambda_0.prototype.constructor = Coroutine$nextUBytes$lambda_0;
  Coroutine$nextUBytes$lambda_0.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, nextUBytes_0(Random.Default, this.local$closure$size), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextUBytes$lambda_0(closure$msg_0, closure$size_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextUBytes$lambda_0(closure$msg_0, closure$size_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextUBytes_2(size, msg) {
    return nextUBytes$lambda_0(msg, size);
  }
  function Coroutine$nextUInt$lambda(closure$msg_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextUInt$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextUInt$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextUInt$lambda.prototype.constructor = Coroutine$nextUInt$lambda;
  Coroutine$nextUInt$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, nextUInt(Random.Default), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextUInt$lambda(closure$msg_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextUInt$lambda(closure$msg_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextUInt_3(msg) {
    return nextUInt$lambda(msg);
  }
  function Coroutine$nextUInt$lambda_0(closure$msg_0, closure$until_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$until = closure$until_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextUInt$lambda_0.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextUInt$lambda_0.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextUInt$lambda_0.prototype.constructor = Coroutine$nextUInt$lambda_0;
  Coroutine$nextUInt$lambda_0.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, nextUInt_0(Random.Default, this.local$closure$until), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextUInt$lambda_0(closure$msg_0, closure$until_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextUInt$lambda_0(closure$msg_0, closure$until_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextUInt_4(until, msg) {
    return nextUInt$lambda_0(msg, until);
  }
  function Coroutine$nextUInt$lambda_1(closure$msg_0, closure$from_0, closure$until_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$from = closure$from_0;
    this.local$closure$until = closure$until_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextUInt$lambda_1.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextUInt$lambda_1.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextUInt$lambda_1.prototype.constructor = Coroutine$nextUInt$lambda_1;
  Coroutine$nextUInt$lambda_1.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, nextUInt_1(Random.Default, this.local$closure$from, this.local$closure$until), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextUInt$lambda_1(closure$msg_0, closure$from_0, closure$until_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextUInt$lambda_1(closure$msg_0, closure$from_0, closure$until_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextUInt_5(from, until, msg) {
    return nextUInt$lambda_1(msg, from, until);
  }
  function Coroutine$nextUInt$lambda_2(closure$msg_0, closure$range_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$range = closure$range_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextUInt$lambda_2.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextUInt$lambda_2.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextUInt$lambda_2.prototype.constructor = Coroutine$nextUInt$lambda_2;
  Coroutine$nextUInt$lambda_2.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, nextUInt_2(Random.Default, this.local$closure$range), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextUInt$lambda_2(closure$msg_0, closure$range_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextUInt$lambda_2(closure$msg_0, closure$range_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextUInt_6(range, msg) {
    return nextUInt$lambda_2(msg, range);
  }
  function Coroutine$nextULong$lambda(closure$msg_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextULong$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextULong$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextULong$lambda.prototype.constructor = Coroutine$nextULong$lambda;
  Coroutine$nextULong$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, nextULong(Random.Default), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextULong$lambda(closure$msg_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextULong$lambda(closure$msg_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextULong_3(msg) {
    return nextULong$lambda(msg);
  }
  function Coroutine$nextULong$lambda_0(closure$msg_0, closure$until_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$until = closure$until_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextULong$lambda_0.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextULong$lambda_0.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextULong$lambda_0.prototype.constructor = Coroutine$nextULong$lambda_0;
  Coroutine$nextULong$lambda_0.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, nextULong_0(Random.Default, this.local$closure$until), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextULong$lambda_0(closure$msg_0, closure$until_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextULong$lambda_0(closure$msg_0, closure$until_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextULong_4(until, msg) {
    return nextULong$lambda_0(msg, until);
  }
  function Coroutine$nextULong$lambda_1(closure$msg_0, closure$from_0, closure$until_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$from = closure$from_0;
    this.local$closure$until = closure$until_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextULong$lambda_1.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextULong$lambda_1.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextULong$lambda_1.prototype.constructor = Coroutine$nextULong$lambda_1;
  Coroutine$nextULong$lambda_1.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, nextULong_1(Random.Default, this.local$closure$from, this.local$closure$until), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextULong$lambda_1(closure$msg_0, closure$from_0, closure$until_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextULong$lambda_1(closure$msg_0, closure$from_0, closure$until_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextULong_5(from, until, msg) {
    return nextULong$lambda_1(msg, from, until);
  }
  function Coroutine$nextULong$lambda_2(closure$msg_0, closure$range_0, $receiver_0, dispatch_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$msg = closure$msg_0;
    this.local$closure$range = closure$range_0;
    this.local$$receiver = $receiver_0;
    this.local$dispatch = dispatch_0;
  }
  Coroutine$nextULong$lambda_2.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$nextULong$lambda_2.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$nextULong$lambda_2.prototype.constructor = Coroutine$nextULong$lambda_2;
  Coroutine$nextULong$lambda_2.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$msg(this.local$$receiver, nextULong_2(Random.Default, this.local$closure$range), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.local$dispatch(this.result_0);
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
  function nextULong$lambda_2(closure$msg_0, closure$range_0) {
    return function ($receiver_0, dispatch_0, continuation_0, suspended) {
      var instance = new Coroutine$nextULong$lambda_2(closure$msg_0, closure$range_0, $receiver_0, dispatch_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function nextULong_6(range, msg) {
    return nextULong$lambda_2(msg, range);
  }
  function effect(block) {
    return block;
  }
  function init(block) {
    return block;
  }
  function update(block) {
    return block;
  }
  function view(block) {
    return block;
  }
  function render(block) {
    return block;
  }
  var package$oolong = _.oolong || (_.oolong = {});
  Object.defineProperty(package$oolong, 'Oolong', {
    get: Oolong_getInstance
  });
  var package$delay = package$oolong.delay || (package$oolong.delay = {});
  package$delay.delay_bds2hq$ = delay_0;
  package$delay.interval_bds2hq$ = interval;
  var package$dispatch = package$oolong.dispatch || (package$oolong.dispatch = {});
  package$dispatch.contramap_28fxtj$ = contramap;
  var package$effect = package$oolong.effect || (package$oolong.effect = {});
  package$effect.none_30y1fr$ = none;
  package$effect.batch_jm1xyt$ = batch;
  package$effect.batch_xjjijb$ = batch_0;
  package$effect.map_kk9s55$ = map;
  package$effect.disposableEffect_rj01b0$ = disposableEffect;
  var package$next = package$oolong.next || (package$oolong.next = {});
  package$next.bimap_uwqiul$ = bimap;
  var package$random = package$oolong.random || (package$oolong.random = {});
  package$random.nextBits_rncc3r$ = nextBits;
  package$random.nextBoolean_owufd6$ = nextBoolean;
  package$random.nextBytes_pqwavb$ = nextBytes;
  package$random.nextBytes_au88ft$ = nextBytes_0;
  package$random.nextBytes_99tvt$ = nextBytes_1;
  package$random.nextDouble_pg2g8x$ = nextDouble;
  package$random.nextDouble_cqqtch$ = nextDouble_0;
  package$random.nextDouble_dais83$ = nextDouble_1;
  package$random.nextFloat_gbrjfa$ = nextFloat;
  package$random.nextInt_uub399$ = nextInt_0;
  package$random.nextInt_rncc3r$ = nextInt_1;
  package$random.nextInt_6dsumb$ = nextInt_2;
  package$random.nextInt_qokxtc$ = nextInt_3;
  package$random.nextLong_2jxopi$ = nextLong_0;
  package$random.nextLong_fzc13$ = nextLong_1;
  package$random.nextLong_r2mu5g$ = nextLong_2;
  package$random.nextLong_9qd704$ = nextLong_3;
  package$random.nextUBytes_qoqnc7$ = nextUBytes_1;
  package$random.nextUBytes_l3ziu8$ = nextUBytes_2;
  package$random.nextUInt_cfck4o$ = nextUInt_3;
  package$random.nextUInt_cxq6n7$ = nextUInt_4;
  package$random.nextUInt_my67mq$ = nextUInt_5;
  package$random.nextUInt_oneb90$ = nextUInt_6;
  package$random.nextULong_56rpup$ = nextULong_3;
  package$random.nextULong_y9ccop$ = nextULong_4;
  package$random.nextULong_fg3ijl$ = nextULong_5;
  package$random.nextULong_14izn8$ = nextULong_6;
  package$oolong.effect_rj01b0$ = effect;
  package$oolong.init_psd3f8$ = init;
  package$oolong.update_wkgkzv$ = update;
  package$oolong.view_egtspq$ = view;
  package$oolong.render_nxqxy1$ = render;
  Kotlin.defineModule('oolong', _);
  return _;
}));

//# sourceMappingURL=oolong.js.map
