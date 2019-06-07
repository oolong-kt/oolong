(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin', 'oolong'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'), require('oolong'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'core'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'core'.");
    }
    if (typeof oolong === 'undefined') {
      throw new Error("Error loading module 'core'. Its dependency 'oolong' was not found. Please, check whether 'oolong' is loaded prior to 'core'.");
    }
    root.core = factory(typeof core === 'undefined' ? {} : core, kotlin, oolong);
  }
}(this, function (_, Kotlin, $module$oolong) {
  'use strict';
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var Enum = Kotlin.kotlin.Enum;
  var throwISE = Kotlin.throwISE;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var emptyList = Kotlin.kotlin.collections.emptyList_287e2$;
  var none = $module$oolong.oolong.effect.none_30y1fr$;
  var to = Kotlin.kotlin.to_ujzrz7$;
  var equals = Kotlin.equals;
  var isBlank = Kotlin.kotlin.text.isBlank_gw00vp$;
  var plus = Kotlin.kotlin.collections.plus_qloxvw$;
  var getPropertyCallableRef = Kotlin.getPropertyCallableRef;
  var collectionSizeOrDefault = Kotlin.kotlin.collections.collectionSizeOrDefault_ba2ldo$;
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_ww73n8$;
  var ArrayList_init_0 = Kotlin.kotlin.collections.ArrayList_init_287e2$;
  var Collection = Kotlin.kotlin.collections.Collection;
  Todo$Visibility.prototype = Object.create(Enum.prototype);
  Todo$Visibility.prototype.constructor = Todo$Visibility;
  Todo$Msg$NoOp.prototype = Object.create(Todo$Msg.prototype);
  Todo$Msg$NoOp.prototype.constructor = Todo$Msg$NoOp;
  Todo$Msg$UpdateField.prototype = Object.create(Todo$Msg.prototype);
  Todo$Msg$UpdateField.prototype.constructor = Todo$Msg$UpdateField;
  Todo$Msg$EditingEntry.prototype = Object.create(Todo$Msg.prototype);
  Todo$Msg$EditingEntry.prototype.constructor = Todo$Msg$EditingEntry;
  Todo$Msg$UpdateEntry.prototype = Object.create(Todo$Msg.prototype);
  Todo$Msg$UpdateEntry.prototype.constructor = Todo$Msg$UpdateEntry;
  Todo$Msg$Add.prototype = Object.create(Todo$Msg.prototype);
  Todo$Msg$Add.prototype.constructor = Todo$Msg$Add;
  Todo$Msg$Delete.prototype = Object.create(Todo$Msg.prototype);
  Todo$Msg$Delete.prototype.constructor = Todo$Msg$Delete;
  Todo$Msg$DeleteComplete.prototype = Object.create(Todo$Msg.prototype);
  Todo$Msg$DeleteComplete.prototype.constructor = Todo$Msg$DeleteComplete;
  Todo$Msg$Check.prototype = Object.create(Todo$Msg.prototype);
  Todo$Msg$Check.prototype.constructor = Todo$Msg$Check;
  Todo$Msg$CheckAll.prototype = Object.create(Todo$Msg.prototype);
  Todo$Msg$CheckAll.prototype.constructor = Todo$Msg$CheckAll;
  Todo$Msg$ChangeVisibility.prototype = Object.create(Todo$Msg.prototype);
  Todo$Msg$ChangeVisibility.prototype.constructor = Todo$Msg$ChangeVisibility;
  function Todo() {
    Todo_instance = this;
    this.emptyModel = Todo$emptyModel$lambda;
    this.newEntry = Todo$newEntry$lambda;
    this.init = Todo$init$lambda(this);
    this.update = Todo$update$lambda(this);
    this.view = Todo$view$lambda(this);
    this.viewInput = Todo$viewInput$lambda;
    this.viewEntries = Todo$viewEntries$lambda(this);
    this.viewEntry = Todo$viewEntry$lambda;
    this.viewControls = Todo$viewControls$lambda(this);
    this.viewControlsCount = Todo$viewControlsCount$lambda;
    this.viewControlsFilters = Todo$viewControlsFilters$lambda(this);
    this.visibilitySwap = Todo$visibilitySwap$lambda;
    this.viewControlsClear = Todo$viewControlsClear$lambda;
  }
  function Todo$Model(entries, field, uid, visibility) {
    this.entries = entries;
    this.field = field;
    this.uid = uid;
    this.visibility = visibility;
  }
  Todo$Model.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Model',
    interfaces: []
  };
  Todo$Model.prototype.component1 = function () {
    return this.entries;
  };
  Todo$Model.prototype.component2 = function () {
    return this.field;
  };
  Todo$Model.prototype.component3 = function () {
    return this.uid;
  };
  Todo$Model.prototype.component4 = function () {
    return this.visibility;
  };
  Todo$Model.prototype.copy_6agl8h$ = function (entries, field, uid, visibility) {
    return new Todo$Model(entries === void 0 ? this.entries : entries, field === void 0 ? this.field : field, uid === void 0 ? this.uid : uid, visibility === void 0 ? this.visibility : visibility);
  };
  Todo$Model.prototype.toString = function () {
    return 'Model(entries=' + Kotlin.toString(this.entries) + (', field=' + Kotlin.toString(this.field)) + (', uid=' + Kotlin.toString(this.uid)) + (', visibility=' + Kotlin.toString(this.visibility)) + ')';
  };
  Todo$Model.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.entries) | 0;
    result = result * 31 + Kotlin.hashCode(this.field) | 0;
    result = result * 31 + Kotlin.hashCode(this.uid) | 0;
    result = result * 31 + Kotlin.hashCode(this.visibility) | 0;
    return result;
  };
  Todo$Model.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.entries, other.entries) && Kotlin.equals(this.field, other.field) && Kotlin.equals(this.uid, other.uid) && Kotlin.equals(this.visibility, other.visibility)))));
  };
  function Todo$Entry(description, completed, editing, id) {
    this.description = description;
    this.completed = completed;
    this.editing = editing;
    this.id = id;
  }
  Todo$Entry.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Entry',
    interfaces: []
  };
  Todo$Entry.prototype.component1 = function () {
    return this.description;
  };
  Todo$Entry.prototype.component2 = function () {
    return this.completed;
  };
  Todo$Entry.prototype.component3 = function () {
    return this.editing;
  };
  Todo$Entry.prototype.component4 = function () {
    return this.id;
  };
  Todo$Entry.prototype.copy_i2fqeo$ = function (description, completed, editing, id) {
    return new Todo$Entry(description === void 0 ? this.description : description, completed === void 0 ? this.completed : completed, editing === void 0 ? this.editing : editing, id === void 0 ? this.id : id);
  };
  Todo$Entry.prototype.toString = function () {
    return 'Entry(description=' + Kotlin.toString(this.description) + (', completed=' + Kotlin.toString(this.completed)) + (', editing=' + Kotlin.toString(this.editing)) + (', id=' + Kotlin.toString(this.id)) + ')';
  };
  Todo$Entry.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.description) | 0;
    result = result * 31 + Kotlin.hashCode(this.completed) | 0;
    result = result * 31 + Kotlin.hashCode(this.editing) | 0;
    result = result * 31 + Kotlin.hashCode(this.id) | 0;
    return result;
  };
  Todo$Entry.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.description, other.description) && Kotlin.equals(this.completed, other.completed) && Kotlin.equals(this.editing, other.editing) && Kotlin.equals(this.id, other.id)))));
  };
  function Todo$Visibility(name, ordinal) {
    Enum.call(this);
    this.name$ = name;
    this.ordinal$ = ordinal;
  }
  function Todo$Visibility_initFields() {
    Todo$Visibility_initFields = function () {
    };
    Todo$Visibility$ALL_instance = new Todo$Visibility('ALL', 0);
    Todo$Visibility$ACTIVE_instance = new Todo$Visibility('ACTIVE', 1);
    Todo$Visibility$COMPLETED_instance = new Todo$Visibility('COMPLETED', 2);
  }
  var Todo$Visibility$ALL_instance;
  function Todo$Visibility$ALL_getInstance() {
    Todo$Visibility_initFields();
    return Todo$Visibility$ALL_instance;
  }
  var Todo$Visibility$ACTIVE_instance;
  function Todo$Visibility$ACTIVE_getInstance() {
    Todo$Visibility_initFields();
    return Todo$Visibility$ACTIVE_instance;
  }
  var Todo$Visibility$COMPLETED_instance;
  function Todo$Visibility$COMPLETED_getInstance() {
    Todo$Visibility_initFields();
    return Todo$Visibility$COMPLETED_instance;
  }
  Todo$Visibility.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Visibility',
    interfaces: [Enum]
  };
  function Todo$Visibility$values() {
    return [Todo$Visibility$ALL_getInstance(), Todo$Visibility$ACTIVE_getInstance(), Todo$Visibility$COMPLETED_getInstance()];
  }
  Todo$Visibility.values = Todo$Visibility$values;
  function Todo$Visibility$valueOf(name) {
    switch (name) {
      case 'ALL':
        return Todo$Visibility$ALL_getInstance();
      case 'ACTIVE':
        return Todo$Visibility$ACTIVE_getInstance();
      case 'COMPLETED':
        return Todo$Visibility$COMPLETED_getInstance();
      default:throwISE('No enum constant todo.Todo.Visibility.' + name);
    }
  }
  Todo$Visibility.valueOf_61zpoe$ = Todo$Visibility$valueOf;
  function Todo$Msg() {
  }
  function Todo$Msg$NoOp() {
    Todo$Msg$NoOp_instance = this;
    Todo$Msg.call(this);
  }
  Todo$Msg$NoOp.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'NoOp',
    interfaces: [Todo$Msg]
  };
  var Todo$Msg$NoOp_instance = null;
  function Todo$Msg$NoOp_getInstance() {
    if (Todo$Msg$NoOp_instance === null) {
      new Todo$Msg$NoOp();
    }
    return Todo$Msg$NoOp_instance;
  }
  function Todo$Msg$UpdateField(str) {
    Todo$Msg.call(this);
    this.str = str;
  }
  Todo$Msg$UpdateField.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'UpdateField',
    interfaces: [Todo$Msg]
  };
  Todo$Msg$UpdateField.prototype.component1 = function () {
    return this.str;
  };
  Todo$Msg$UpdateField.prototype.copy_61zpoe$ = function (str) {
    return new Todo$Msg$UpdateField(str === void 0 ? this.str : str);
  };
  Todo$Msg$UpdateField.prototype.toString = function () {
    return 'UpdateField(str=' + Kotlin.toString(this.str) + ')';
  };
  Todo$Msg$UpdateField.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.str) | 0;
    return result;
  };
  Todo$Msg$UpdateField.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.str, other.str))));
  };
  function Todo$Msg$EditingEntry(entryId, editing) {
    Todo$Msg.call(this);
    this.entryId = entryId;
    this.editing = editing;
  }
  Todo$Msg$EditingEntry.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'EditingEntry',
    interfaces: [Todo$Msg]
  };
  Todo$Msg$EditingEntry.prototype.component1 = function () {
    return this.entryId;
  };
  Todo$Msg$EditingEntry.prototype.component2 = function () {
    return this.editing;
  };
  Todo$Msg$EditingEntry.prototype.copy_fzusl$ = function (entryId, editing) {
    return new Todo$Msg$EditingEntry(entryId === void 0 ? this.entryId : entryId, editing === void 0 ? this.editing : editing);
  };
  Todo$Msg$EditingEntry.prototype.toString = function () {
    return 'EditingEntry(entryId=' + Kotlin.toString(this.entryId) + (', editing=' + Kotlin.toString(this.editing)) + ')';
  };
  Todo$Msg$EditingEntry.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.entryId) | 0;
    result = result * 31 + Kotlin.hashCode(this.editing) | 0;
    return result;
  };
  Todo$Msg$EditingEntry.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.entryId, other.entryId) && Kotlin.equals(this.editing, other.editing)))));
  };
  function Todo$Msg$UpdateEntry(entryId, description) {
    Todo$Msg.call(this);
    this.entryId = entryId;
    this.description = description;
  }
  Todo$Msg$UpdateEntry.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'UpdateEntry',
    interfaces: [Todo$Msg]
  };
  Todo$Msg$UpdateEntry.prototype.component1 = function () {
    return this.entryId;
  };
  Todo$Msg$UpdateEntry.prototype.component2 = function () {
    return this.description;
  };
  Todo$Msg$UpdateEntry.prototype.copy_19mbxw$ = function (entryId, description) {
    return new Todo$Msg$UpdateEntry(entryId === void 0 ? this.entryId : entryId, description === void 0 ? this.description : description);
  };
  Todo$Msg$UpdateEntry.prototype.toString = function () {
    return 'UpdateEntry(entryId=' + Kotlin.toString(this.entryId) + (', description=' + Kotlin.toString(this.description)) + ')';
  };
  Todo$Msg$UpdateEntry.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.entryId) | 0;
    result = result * 31 + Kotlin.hashCode(this.description) | 0;
    return result;
  };
  Todo$Msg$UpdateEntry.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.entryId, other.entryId) && Kotlin.equals(this.description, other.description)))));
  };
  function Todo$Msg$Add() {
    Todo$Msg$Add_instance = this;
    Todo$Msg.call(this);
  }
  Todo$Msg$Add.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Add',
    interfaces: [Todo$Msg]
  };
  var Todo$Msg$Add_instance = null;
  function Todo$Msg$Add_getInstance() {
    if (Todo$Msg$Add_instance === null) {
      new Todo$Msg$Add();
    }
    return Todo$Msg$Add_instance;
  }
  function Todo$Msg$Delete(entryId) {
    Todo$Msg.call(this);
    this.entryId = entryId;
  }
  Todo$Msg$Delete.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Delete',
    interfaces: [Todo$Msg]
  };
  Todo$Msg$Delete.prototype.component1 = function () {
    return this.entryId;
  };
  Todo$Msg$Delete.prototype.copy_za3lpa$ = function (entryId) {
    return new Todo$Msg$Delete(entryId === void 0 ? this.entryId : entryId);
  };
  Todo$Msg$Delete.prototype.toString = function () {
    return 'Delete(entryId=' + Kotlin.toString(this.entryId) + ')';
  };
  Todo$Msg$Delete.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.entryId) | 0;
    return result;
  };
  Todo$Msg$Delete.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.entryId, other.entryId))));
  };
  function Todo$Msg$DeleteComplete() {
    Todo$Msg$DeleteComplete_instance = this;
    Todo$Msg.call(this);
  }
  Todo$Msg$DeleteComplete.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'DeleteComplete',
    interfaces: [Todo$Msg]
  };
  var Todo$Msg$DeleteComplete_instance = null;
  function Todo$Msg$DeleteComplete_getInstance() {
    if (Todo$Msg$DeleteComplete_instance === null) {
      new Todo$Msg$DeleteComplete();
    }
    return Todo$Msg$DeleteComplete_instance;
  }
  function Todo$Msg$Check(entryId, completed) {
    Todo$Msg.call(this);
    this.entryId = entryId;
    this.completed = completed;
  }
  Todo$Msg$Check.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Check',
    interfaces: [Todo$Msg]
  };
  Todo$Msg$Check.prototype.component1 = function () {
    return this.entryId;
  };
  Todo$Msg$Check.prototype.component2 = function () {
    return this.completed;
  };
  Todo$Msg$Check.prototype.copy_fzusl$ = function (entryId, completed) {
    return new Todo$Msg$Check(entryId === void 0 ? this.entryId : entryId, completed === void 0 ? this.completed : completed);
  };
  Todo$Msg$Check.prototype.toString = function () {
    return 'Check(entryId=' + Kotlin.toString(this.entryId) + (', completed=' + Kotlin.toString(this.completed)) + ')';
  };
  Todo$Msg$Check.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.entryId) | 0;
    result = result * 31 + Kotlin.hashCode(this.completed) | 0;
    return result;
  };
  Todo$Msg$Check.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.entryId, other.entryId) && Kotlin.equals(this.completed, other.completed)))));
  };
  function Todo$Msg$CheckAll(completed) {
    Todo$Msg.call(this);
    this.completed = completed;
  }
  Todo$Msg$CheckAll.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'CheckAll',
    interfaces: [Todo$Msg]
  };
  Todo$Msg$CheckAll.prototype.component1 = function () {
    return this.completed;
  };
  Todo$Msg$CheckAll.prototype.copy_6taknv$ = function (completed) {
    return new Todo$Msg$CheckAll(completed === void 0 ? this.completed : completed);
  };
  Todo$Msg$CheckAll.prototype.toString = function () {
    return 'CheckAll(completed=' + Kotlin.toString(this.completed) + ')';
  };
  Todo$Msg$CheckAll.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.completed) | 0;
    return result;
  };
  Todo$Msg$CheckAll.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.completed, other.completed))));
  };
  function Todo$Msg$ChangeVisibility(visibility) {
    Todo$Msg.call(this);
    this.visibility = visibility;
  }
  Todo$Msg$ChangeVisibility.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ChangeVisibility',
    interfaces: [Todo$Msg]
  };
  Todo$Msg$ChangeVisibility.prototype.component1 = function () {
    return this.visibility;
  };
  Todo$Msg$ChangeVisibility.prototype.copy_1ehgk2$ = function (visibility) {
    return new Todo$Msg$ChangeVisibility(visibility === void 0 ? this.visibility : visibility);
  };
  Todo$Msg$ChangeVisibility.prototype.toString = function () {
    return 'ChangeVisibility(visibility=' + Kotlin.toString(this.visibility) + ')';
  };
  Todo$Msg$ChangeVisibility.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.visibility) | 0;
    return result;
  };
  Todo$Msg$ChangeVisibility.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.visibility, other.visibility))));
  };
  Todo$Msg.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Msg',
    interfaces: []
  };
  function Todo$Props(input, entries, controls) {
    this.input = input;
    this.entries = entries;
    this.controls = controls;
  }
  function Todo$Props$Input(value, onUpdateField, onAdd) {
    this.value = value;
    this.onUpdateField = onUpdateField;
    this.onAdd = onAdd;
  }
  Todo$Props$Input.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Input',
    interfaces: []
  };
  Todo$Props$Input.prototype.component1 = function () {
    return this.value;
  };
  Todo$Props$Input.prototype.component2 = function () {
    return this.onUpdateField;
  };
  Todo$Props$Input.prototype.component3 = function () {
    return this.onAdd;
  };
  Todo$Props$Input.prototype.copy_h6jbtg$ = function (value, onUpdateField, onAdd) {
    return new Todo$Props$Input(value === void 0 ? this.value : value, onUpdateField === void 0 ? this.onUpdateField : onUpdateField, onAdd === void 0 ? this.onAdd : onAdd);
  };
  Todo$Props$Input.prototype.toString = function () {
    return 'Input(value=' + Kotlin.toString(this.value) + (', onUpdateField=' + Kotlin.toString(this.onUpdateField)) + (', onAdd=' + Kotlin.toString(this.onAdd)) + ')';
  };
  Todo$Props$Input.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.value) | 0;
    result = result * 31 + Kotlin.hashCode(this.onUpdateField) | 0;
    result = result * 31 + Kotlin.hashCode(this.onAdd) | 0;
    return result;
  };
  Todo$Props$Input.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.value, other.value) && Kotlin.equals(this.onUpdateField, other.onUpdateField) && Kotlin.equals(this.onAdd, other.onAdd)))));
  };
  function Todo$Props$Entries(visible, allCompleted, onCheckAll, entries) {
    this.visible = visible;
    this.allCompleted = allCompleted;
    this.onCheckAll = onCheckAll;
    this.entries = entries;
  }
  function Todo$Props$Entries$Entry(id, completed, editing, description, onCheck, onUpdateEntry, onEditingEntry, onDelete) {
    this.id = id;
    this.completed = completed;
    this.editing = editing;
    this.description = description;
    this.onCheck = onCheck;
    this.onUpdateEntry = onUpdateEntry;
    this.onEditingEntry = onEditingEntry;
    this.onDelete = onDelete;
  }
  Todo$Props$Entries$Entry.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Entry',
    interfaces: []
  };
  Todo$Props$Entries$Entry.prototype.component1 = function () {
    return this.id;
  };
  Todo$Props$Entries$Entry.prototype.component2 = function () {
    return this.completed;
  };
  Todo$Props$Entries$Entry.prototype.component3 = function () {
    return this.editing;
  };
  Todo$Props$Entries$Entry.prototype.component4 = function () {
    return this.description;
  };
  Todo$Props$Entries$Entry.prototype.component5 = function () {
    return this.onCheck;
  };
  Todo$Props$Entries$Entry.prototype.component6 = function () {
    return this.onUpdateEntry;
  };
  Todo$Props$Entries$Entry.prototype.component7 = function () {
    return this.onEditingEntry;
  };
  Todo$Props$Entries$Entry.prototype.component8 = function () {
    return this.onDelete;
  };
  Todo$Props$Entries$Entry.prototype.copy_x3cm68$ = function (id, completed, editing, description, onCheck, onUpdateEntry, onEditingEntry, onDelete) {
    return new Todo$Props$Entries$Entry(id === void 0 ? this.id : id, completed === void 0 ? this.completed : completed, editing === void 0 ? this.editing : editing, description === void 0 ? this.description : description, onCheck === void 0 ? this.onCheck : onCheck, onUpdateEntry === void 0 ? this.onUpdateEntry : onUpdateEntry, onEditingEntry === void 0 ? this.onEditingEntry : onEditingEntry, onDelete === void 0 ? this.onDelete : onDelete);
  };
  Todo$Props$Entries$Entry.prototype.toString = function () {
    return 'Entry(id=' + Kotlin.toString(this.id) + (', completed=' + Kotlin.toString(this.completed)) + (', editing=' + Kotlin.toString(this.editing)) + (', description=' + Kotlin.toString(this.description)) + (', onCheck=' + Kotlin.toString(this.onCheck)) + (', onUpdateEntry=' + Kotlin.toString(this.onUpdateEntry)) + (', onEditingEntry=' + Kotlin.toString(this.onEditingEntry)) + (', onDelete=' + Kotlin.toString(this.onDelete)) + ')';
  };
  Todo$Props$Entries$Entry.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.id) | 0;
    result = result * 31 + Kotlin.hashCode(this.completed) | 0;
    result = result * 31 + Kotlin.hashCode(this.editing) | 0;
    result = result * 31 + Kotlin.hashCode(this.description) | 0;
    result = result * 31 + Kotlin.hashCode(this.onCheck) | 0;
    result = result * 31 + Kotlin.hashCode(this.onUpdateEntry) | 0;
    result = result * 31 + Kotlin.hashCode(this.onEditingEntry) | 0;
    result = result * 31 + Kotlin.hashCode(this.onDelete) | 0;
    return result;
  };
  Todo$Props$Entries$Entry.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.id, other.id) && Kotlin.equals(this.completed, other.completed) && Kotlin.equals(this.editing, other.editing) && Kotlin.equals(this.description, other.description) && Kotlin.equals(this.onCheck, other.onCheck) && Kotlin.equals(this.onUpdateEntry, other.onUpdateEntry) && Kotlin.equals(this.onEditingEntry, other.onEditingEntry) && Kotlin.equals(this.onDelete, other.onDelete)))));
  };
  Todo$Props$Entries.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Entries',
    interfaces: []
  };
  Todo$Props$Entries.prototype.component1 = function () {
    return this.visible;
  };
  Todo$Props$Entries.prototype.component2 = function () {
    return this.allCompleted;
  };
  Todo$Props$Entries.prototype.component3 = function () {
    return this.onCheckAll;
  };
  Todo$Props$Entries.prototype.component4 = function () {
    return this.entries;
  };
  Todo$Props$Entries.prototype.copy_3aj3ae$ = function (visible, allCompleted, onCheckAll, entries) {
    return new Todo$Props$Entries(visible === void 0 ? this.visible : visible, allCompleted === void 0 ? this.allCompleted : allCompleted, onCheckAll === void 0 ? this.onCheckAll : onCheckAll, entries === void 0 ? this.entries : entries);
  };
  Todo$Props$Entries.prototype.toString = function () {
    return 'Entries(visible=' + Kotlin.toString(this.visible) + (', allCompleted=' + Kotlin.toString(this.allCompleted)) + (', onCheckAll=' + Kotlin.toString(this.onCheckAll)) + (', entries=' + Kotlin.toString(this.entries)) + ')';
  };
  Todo$Props$Entries.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.visible) | 0;
    result = result * 31 + Kotlin.hashCode(this.allCompleted) | 0;
    result = result * 31 + Kotlin.hashCode(this.onCheckAll) | 0;
    result = result * 31 + Kotlin.hashCode(this.entries) | 0;
    return result;
  };
  Todo$Props$Entries.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.visible, other.visible) && Kotlin.equals(this.allCompleted, other.allCompleted) && Kotlin.equals(this.onCheckAll, other.onCheckAll) && Kotlin.equals(this.entries, other.entries)))));
  };
  function Todo$Props$Controls(hidden, count, filters, clear) {
    this.hidden = hidden;
    this.count = count;
    this.filters = filters;
    this.clear = clear;
  }
  function Todo$Props$Controls$Count(entriesLeft) {
    this.entriesLeft = entriesLeft;
  }
  Todo$Props$Controls$Count.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Count',
    interfaces: []
  };
  Todo$Props$Controls$Count.prototype.component1 = function () {
    return this.entriesLeft;
  };
  Todo$Props$Controls$Count.prototype.copy_za3lpa$ = function (entriesLeft) {
    return new Todo$Props$Controls$Count(entriesLeft === void 0 ? this.entriesLeft : entriesLeft);
  };
  Todo$Props$Controls$Count.prototype.toString = function () {
    return 'Count(entriesLeft=' + Kotlin.toString(this.entriesLeft) + ')';
  };
  Todo$Props$Controls$Count.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.entriesLeft) | 0;
    return result;
  };
  Todo$Props$Controls$Count.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.entriesLeft, other.entriesLeft))));
  };
  function Todo$Props$Controls$Filters(allVisibilitySwap, activeVisibilitySwap, completedVisibilitySwap) {
    this.allVisibilitySwap = allVisibilitySwap;
    this.activeVisibilitySwap = activeVisibilitySwap;
    this.completedVisibilitySwap = completedVisibilitySwap;
  }
  function Todo$Props$Controls$Filters$VisibilitySwap(selected, visibility, onChangeVisibility) {
    this.selected = selected;
    this.visibility = visibility;
    this.onChangeVisibility = onChangeVisibility;
  }
  Todo$Props$Controls$Filters$VisibilitySwap.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'VisibilitySwap',
    interfaces: []
  };
  Todo$Props$Controls$Filters$VisibilitySwap.prototype.component1 = function () {
    return this.selected;
  };
  Todo$Props$Controls$Filters$VisibilitySwap.prototype.component2 = function () {
    return this.visibility;
  };
  Todo$Props$Controls$Filters$VisibilitySwap.prototype.component3 = function () {
    return this.onChangeVisibility;
  };
  Todo$Props$Controls$Filters$VisibilitySwap.prototype.copy_7qbfck$ = function (selected, visibility, onChangeVisibility) {
    return new Todo$Props$Controls$Filters$VisibilitySwap(selected === void 0 ? this.selected : selected, visibility === void 0 ? this.visibility : visibility, onChangeVisibility === void 0 ? this.onChangeVisibility : onChangeVisibility);
  };
  Todo$Props$Controls$Filters$VisibilitySwap.prototype.toString = function () {
    return 'VisibilitySwap(selected=' + Kotlin.toString(this.selected) + (', visibility=' + Kotlin.toString(this.visibility)) + (', onChangeVisibility=' + Kotlin.toString(this.onChangeVisibility)) + ')';
  };
  Todo$Props$Controls$Filters$VisibilitySwap.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.selected) | 0;
    result = result * 31 + Kotlin.hashCode(this.visibility) | 0;
    result = result * 31 + Kotlin.hashCode(this.onChangeVisibility) | 0;
    return result;
  };
  Todo$Props$Controls$Filters$VisibilitySwap.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.selected, other.selected) && Kotlin.equals(this.visibility, other.visibility) && Kotlin.equals(this.onChangeVisibility, other.onChangeVisibility)))));
  };
  Todo$Props$Controls$Filters.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Filters',
    interfaces: []
  };
  Todo$Props$Controls$Filters.prototype.component1 = function () {
    return this.allVisibilitySwap;
  };
  Todo$Props$Controls$Filters.prototype.component2 = function () {
    return this.activeVisibilitySwap;
  };
  Todo$Props$Controls$Filters.prototype.component3 = function () {
    return this.completedVisibilitySwap;
  };
  Todo$Props$Controls$Filters.prototype.copy_c7ph1a$ = function (allVisibilitySwap, activeVisibilitySwap, completedVisibilitySwap) {
    return new Todo$Props$Controls$Filters(allVisibilitySwap === void 0 ? this.allVisibilitySwap : allVisibilitySwap, activeVisibilitySwap === void 0 ? this.activeVisibilitySwap : activeVisibilitySwap, completedVisibilitySwap === void 0 ? this.completedVisibilitySwap : completedVisibilitySwap);
  };
  Todo$Props$Controls$Filters.prototype.toString = function () {
    return 'Filters(allVisibilitySwap=' + Kotlin.toString(this.allVisibilitySwap) + (', activeVisibilitySwap=' + Kotlin.toString(this.activeVisibilitySwap)) + (', completedVisibilitySwap=' + Kotlin.toString(this.completedVisibilitySwap)) + ')';
  };
  Todo$Props$Controls$Filters.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.allVisibilitySwap) | 0;
    result = result * 31 + Kotlin.hashCode(this.activeVisibilitySwap) | 0;
    result = result * 31 + Kotlin.hashCode(this.completedVisibilitySwap) | 0;
    return result;
  };
  Todo$Props$Controls$Filters.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.allVisibilitySwap, other.allVisibilitySwap) && Kotlin.equals(this.activeVisibilitySwap, other.activeVisibilitySwap) && Kotlin.equals(this.completedVisibilitySwap, other.completedVisibilitySwap)))));
  };
  function Todo$Props$Controls$Clear(hidden, entriesCompleted, onDeleteCompleted) {
    this.hidden = hidden;
    this.entriesCompleted = entriesCompleted;
    this.onDeleteCompleted = onDeleteCompleted;
  }
  Todo$Props$Controls$Clear.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Clear',
    interfaces: []
  };
  Todo$Props$Controls$Clear.prototype.component1 = function () {
    return this.hidden;
  };
  Todo$Props$Controls$Clear.prototype.component2 = function () {
    return this.entriesCompleted;
  };
  Todo$Props$Controls$Clear.prototype.component3 = function () {
    return this.onDeleteCompleted;
  };
  Todo$Props$Controls$Clear.prototype.copy_bkprbk$ = function (hidden, entriesCompleted, onDeleteCompleted) {
    return new Todo$Props$Controls$Clear(hidden === void 0 ? this.hidden : hidden, entriesCompleted === void 0 ? this.entriesCompleted : entriesCompleted, onDeleteCompleted === void 0 ? this.onDeleteCompleted : onDeleteCompleted);
  };
  Todo$Props$Controls$Clear.prototype.toString = function () {
    return 'Clear(hidden=' + Kotlin.toString(this.hidden) + (', entriesCompleted=' + Kotlin.toString(this.entriesCompleted)) + (', onDeleteCompleted=' + Kotlin.toString(this.onDeleteCompleted)) + ')';
  };
  Todo$Props$Controls$Clear.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.hidden) | 0;
    result = result * 31 + Kotlin.hashCode(this.entriesCompleted) | 0;
    result = result * 31 + Kotlin.hashCode(this.onDeleteCompleted) | 0;
    return result;
  };
  Todo$Props$Controls$Clear.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.hidden, other.hidden) && Kotlin.equals(this.entriesCompleted, other.entriesCompleted) && Kotlin.equals(this.onDeleteCompleted, other.onDeleteCompleted)))));
  };
  Todo$Props$Controls.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Controls',
    interfaces: []
  };
  Todo$Props$Controls.prototype.component1 = function () {
    return this.hidden;
  };
  Todo$Props$Controls.prototype.component2 = function () {
    return this.count;
  };
  Todo$Props$Controls.prototype.component3 = function () {
    return this.filters;
  };
  Todo$Props$Controls.prototype.component4 = function () {
    return this.clear;
  };
  Todo$Props$Controls.prototype.copy_ntb2ew$ = function (hidden, count, filters, clear) {
    return new Todo$Props$Controls(hidden === void 0 ? this.hidden : hidden, count === void 0 ? this.count : count, filters === void 0 ? this.filters : filters, clear === void 0 ? this.clear : clear);
  };
  Todo$Props$Controls.prototype.toString = function () {
    return 'Controls(hidden=' + Kotlin.toString(this.hidden) + (', count=' + Kotlin.toString(this.count)) + (', filters=' + Kotlin.toString(this.filters)) + (', clear=' + Kotlin.toString(this.clear)) + ')';
  };
  Todo$Props$Controls.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.hidden) | 0;
    result = result * 31 + Kotlin.hashCode(this.count) | 0;
    result = result * 31 + Kotlin.hashCode(this.filters) | 0;
    result = result * 31 + Kotlin.hashCode(this.clear) | 0;
    return result;
  };
  Todo$Props$Controls.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.hidden, other.hidden) && Kotlin.equals(this.count, other.count) && Kotlin.equals(this.filters, other.filters) && Kotlin.equals(this.clear, other.clear)))));
  };
  Todo$Props.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Props',
    interfaces: []
  };
  Todo$Props.prototype.component1 = function () {
    return this.input;
  };
  Todo$Props.prototype.component2 = function () {
    return this.entries;
  };
  Todo$Props.prototype.component3 = function () {
    return this.controls;
  };
  Todo$Props.prototype.copy_k9q7m$ = function (input, entries, controls) {
    return new Todo$Props(input === void 0 ? this.input : input, entries === void 0 ? this.entries : entries, controls === void 0 ? this.controls : controls);
  };
  Todo$Props.prototype.toString = function () {
    return 'Props(input=' + Kotlin.toString(this.input) + (', entries=' + Kotlin.toString(this.entries)) + (', controls=' + Kotlin.toString(this.controls)) + ')';
  };
  Todo$Props.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.input) | 0;
    result = result * 31 + Kotlin.hashCode(this.entries) | 0;
    result = result * 31 + Kotlin.hashCode(this.controls) | 0;
    return result;
  };
  Todo$Props.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && (Kotlin.equals(this.input, other.input) && Kotlin.equals(this.entries, other.entries) && Kotlin.equals(this.controls, other.controls)))));
  };
  function Todo$emptyModel$lambda() {
    return new Todo$Model(emptyList(), '', 0, Todo$Visibility$ALL_getInstance());
  }
  function Todo$newEntry$lambda(desc, id) {
    return new Todo$Entry(desc, false, false, id);
  }
  function Todo$init$lambda$lambda(closure$model, this$Todo) {
    return function () {
      return to(closure$model != null ? closure$model : this$Todo.emptyModel(), none());
    };
  }
  function Todo$init$lambda(this$Todo) {
    return function (model) {
      return Todo$init$lambda$lambda(model, this$Todo);
    };
  }
  function Todo$update$lambda$lambda(closure$msg) {
    return function (entry) {
      if (entry.id === closure$msg.entryId) {
        return entry.copy_i2fqeo$(void 0, void 0, closure$msg.editing);
      }
       else {
        return entry;
      }
    };
  }
  function Todo$update$lambda$lambda_0(closure$msg) {
    return function (entry) {
      if (entry.id === closure$msg.entryId) {
        return entry.copy_i2fqeo$(closure$msg.description);
      }
       else {
        return entry;
      }
    };
  }
  function Todo$update$lambda$lambda_1(closure$msg) {
    return function (entry) {
      if (entry.id === closure$msg.entryId) {
        return entry.copy_i2fqeo$(void 0, closure$msg.completed);
      }
       else {
        return entry;
      }
    };
  }
  function Todo$update$lambda$lambda_2(closure$msg) {
    return function (entry) {
      return entry.copy_i2fqeo$(void 0, closure$msg.completed);
    };
  }
  function Todo$update$lambda(this$Todo) {
    return function (msg, model) {
      var tmp$, tmp$_0;
      if (equals(msg, Todo$Msg$NoOp_getInstance()))
        return to(model, none());
      else if (equals(msg, Todo$Msg$Add_getInstance())) {
        tmp$ = model.uid + 1 | 0;
        if (isBlank(model.field)) {
          tmp$_0 = model.entries;
        }
         else {
          tmp$_0 = plus(model.entries, this$Todo.newEntry(model.field, model.uid));
        }
        return to(model.copy_6agl8h$(tmp$_0, '', tmp$), none());
      }
       else if (Kotlin.isType(msg, Todo$Msg$UpdateField))
        return to(model.copy_6agl8h$(void 0, msg.str), none());
      else if (Kotlin.isType(msg, Todo$Msg$EditingEntry)) {
        var updateEntry = Todo$update$lambda$lambda(msg);
        var $receiver = model.entries;
        var destination = ArrayList_init(collectionSizeOrDefault($receiver, 10));
        var tmp$_1;
        tmp$_1 = $receiver.iterator();
        while (tmp$_1.hasNext()) {
          var item = tmp$_1.next();
          destination.add_11rb$(updateEntry(item));
        }
        return to(model.copy_6agl8h$(destination), none());
      }
       else if (Kotlin.isType(msg, Todo$Msg$UpdateEntry)) {
        var updateEntry_0 = Todo$update$lambda$lambda_0(msg);
        var $receiver_0 = model.entries;
        var destination_0 = ArrayList_init(collectionSizeOrDefault($receiver_0, 10));
        var tmp$_2;
        tmp$_2 = $receiver_0.iterator();
        while (tmp$_2.hasNext()) {
          var item_0 = tmp$_2.next();
          destination_0.add_11rb$(updateEntry_0(item_0));
        }
        return to(model.copy_6agl8h$(destination_0), none());
      }
       else if (Kotlin.isType(msg, Todo$Msg$Delete)) {
        var $receiver_1 = model.entries;
        var destination_1 = ArrayList_init_0();
        var tmp$_3;
        tmp$_3 = $receiver_1.iterator();
        while (tmp$_3.hasNext()) {
          var element = tmp$_3.next();
          if (element.id !== msg.entryId)
            destination_1.add_11rb$(element);
        }
        return to(model.copy_6agl8h$(destination_1), none());
      }
       else if (equals(msg, Todo$Msg$DeleteComplete_getInstance())) {
        var $receiver_2 = model.entries;
        var destination_2 = ArrayList_init_0();
        var tmp$_4;
        tmp$_4 = $receiver_2.iterator();
        while (tmp$_4.hasNext()) {
          var element_0 = tmp$_4.next();
          if (!element_0.completed)
            destination_2.add_11rb$(element_0);
        }
        return to(model.copy_6agl8h$(destination_2), none());
      }
       else if (Kotlin.isType(msg, Todo$Msg$Check)) {
        var updateEntry_1 = Todo$update$lambda$lambda_1(msg);
        var $receiver_3 = model.entries;
        var destination_3 = ArrayList_init(collectionSizeOrDefault($receiver_3, 10));
        var tmp$_5;
        tmp$_5 = $receiver_3.iterator();
        while (tmp$_5.hasNext()) {
          var item_1 = tmp$_5.next();
          destination_3.add_11rb$(updateEntry_1(item_1));
        }
        return to(model.copy_6agl8h$(destination_3), none());
      }
       else if (Kotlin.isType(msg, Todo$Msg$CheckAll)) {
        var updateEntry_2 = Todo$update$lambda$lambda_2(msg);
        var $receiver_4 = model.entries;
        var destination_4 = ArrayList_init(collectionSizeOrDefault($receiver_4, 10));
        var tmp$_6;
        tmp$_6 = $receiver_4.iterator();
        while (tmp$_6.hasNext()) {
          var item_2 = tmp$_6.next();
          destination_4.add_11rb$(updateEntry_2(item_2));
        }
        return to(model.copy_6agl8h$(destination_4), none());
      }
       else if (Kotlin.isType(msg, Todo$Msg$ChangeVisibility))
        return to(model.copy_6agl8h$(void 0, void 0, void 0, msg.visibility), none());
      else
        return Kotlin.noWhenBranchMatched();
    };
  }
  function Todo$view$lambda(this$Todo) {
    return function (model) {
      return new Todo$Props(this$Todo.viewInput(model.field), this$Todo.viewEntries(model.visibility, model.entries), this$Todo.viewControls(model.visibility, model.entries));
    };
  }
  function Todo$viewInput$lambda$lambda(value) {
    return new Todo$Msg$UpdateField(value);
  }
  function Todo$viewInput$lambda$lambda_0() {
    return Todo$Msg$Add_getInstance();
  }
  function Todo$viewInput$lambda(task) {
    var onUpdateField = Todo$viewInput$lambda$lambda;
    var onAdd = Todo$viewInput$lambda$lambda_0;
    return new Todo$Props$Input(task, onUpdateField, onAdd);
  }
  function Todo$viewEntries$lambda$lambda(closure$visibility) {
    return function (todo) {
      switch (closure$visibility.name) {
        case 'COMPLETED':
          return todo.completed;
        case 'ACTIVE':
          return !todo.completed;
        case 'ALL':
          return true;
        default:return Kotlin.noWhenBranchMatched();
      }
    };
  }
  function Todo$viewEntries$lambda$lambda_0(closure$allCompleted) {
    return function () {
      return new Todo$Msg$CheckAll(!closure$allCompleted);
    };
  }
  function Todo$viewEntries$lambda(this$Todo) {
    return function (visibility, entries) {
      var isVisible = Todo$viewEntries$lambda$lambda(visibility);
      var predicate = getPropertyCallableRef('completed', 1, function ($receiver) {
        return $receiver.completed;
      });
      var all$result;
      all$break: do {
        var tmp$;
        if (Kotlin.isType(entries, Collection) && entries.isEmpty()) {
          all$result = true;
          break all$break;
        }
        tmp$ = entries.iterator();
        while (tmp$.hasNext()) {
          var element = tmp$.next();
          if (!predicate(element)) {
            all$result = false;
            break all$break;
          }
        }
        all$result = true;
      }
       while (false);
      var allCompleted = all$result;
      var visible = !entries.isEmpty();
      var destination = ArrayList_init_0();
      var tmp$_0;
      tmp$_0 = entries.iterator();
      while (tmp$_0.hasNext()) {
        var element_0 = tmp$_0.next();
        if (isVisible(element_0))
          destination.add_11rb$(element_0);
      }
      var destination_0 = ArrayList_init(collectionSizeOrDefault(destination, 10));
      var tmp$_1;
      tmp$_1 = destination.iterator();
      while (tmp$_1.hasNext()) {
        var item = tmp$_1.next();
        destination_0.add_11rb$(this$Todo.viewEntry(item));
      }
      return new Todo$Props$Entries(visible, allCompleted, Todo$viewEntries$lambda$lambda_0(allCompleted), destination_0);
    };
  }
  function Todo$viewEntry$lambda$lambda(id, completed) {
    return new Todo$Msg$Check(id, completed);
  }
  function Todo$viewEntry$lambda$lambda_0(id, description) {
    return new Todo$Msg$UpdateEntry(id, description);
  }
  function Todo$viewEntry$lambda$lambda_1(id, completed) {
    return new Todo$Msg$EditingEntry(id, completed);
  }
  function Todo$viewEntry$lambda$lambda_2(id) {
    return new Todo$Msg$Delete(id);
  }
  function Todo$viewEntry$lambda(todo) {
    return new Todo$Props$Entries$Entry(todo.id, todo.completed, todo.editing, todo.description, Todo$viewEntry$lambda$lambda, Todo$viewEntry$lambda$lambda_0, Todo$viewEntry$lambda$lambda_1, Todo$viewEntry$lambda$lambda_2);
  }
  function Todo$viewControls$lambda(this$Todo) {
    return function (visibility, entries) {
      var predicate = getPropertyCallableRef('completed', 1, function ($receiver) {
        return $receiver.completed;
      });
      var destination = ArrayList_init_0();
      var tmp$;
      tmp$ = entries.iterator();
      while (tmp$.hasNext()) {
        var element = tmp$.next();
        if (predicate(element))
          destination.add_11rb$(element);
      }
      var entriesCompleted = destination.size;
      var entriesLeft = entries.size - entriesCompleted | 0;
      return new Todo$Props$Controls(entries.isEmpty(), this$Todo.viewControlsCount(entriesLeft), this$Todo.viewControlsFilters(visibility), this$Todo.viewControlsClear(entriesCompleted));
    };
  }
  function Todo$viewControlsCount$lambda(entriesLeft) {
    return new Todo$Props$Controls$Count(entriesLeft);
  }
  function Todo$viewControlsFilters$lambda(this$Todo) {
    return function (visibility) {
      return new Todo$Props$Controls$Filters(this$Todo.visibilitySwap(Todo$Visibility$ALL_getInstance(), visibility), this$Todo.visibilitySwap(Todo$Visibility$ACTIVE_getInstance(), visibility), this$Todo.visibilitySwap(Todo$Visibility$COMPLETED_getInstance(), visibility));
    };
  }
  function Todo$visibilitySwap$lambda$lambda(closure$visibility) {
    return function (it) {
      return new Todo$Msg$ChangeVisibility(closure$visibility);
    };
  }
  function Todo$visibilitySwap$lambda(visibility, actualVisibility) {
    return new Todo$Props$Controls$Filters$VisibilitySwap(visibility === actualVisibility, visibility, Todo$visibilitySwap$lambda$lambda(visibility));
  }
  function Todo$viewControlsClear$lambda$lambda() {
    return Todo$Msg$DeleteComplete_getInstance();
  }
  function Todo$viewControlsClear$lambda(entriesCompleted) {
    return new Todo$Props$Controls$Clear(entriesCompleted === 0, entriesCompleted, Todo$viewControlsClear$lambda$lambda);
  }
  Todo.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Todo',
    interfaces: []
  };
  var Todo_instance = null;
  function Todo_getInstance() {
    if (Todo_instance === null) {
      new Todo();
    }
    return Todo_instance;
  }
  Todo.prototype.Model = Todo$Model;
  Todo.prototype.Entry = Todo$Entry;
  Object.defineProperty(Todo$Visibility, 'ALL', {
    get: Todo$Visibility$ALL_getInstance
  });
  Object.defineProperty(Todo$Visibility, 'ACTIVE', {
    get: Todo$Visibility$ACTIVE_getInstance
  });
  Object.defineProperty(Todo$Visibility, 'COMPLETED', {
    get: Todo$Visibility$COMPLETED_getInstance
  });
  Todo.prototype.Visibility = Todo$Visibility;
  Object.defineProperty(Todo$Msg, 'NoOp', {
    get: Todo$Msg$NoOp_getInstance
  });
  Todo$Msg.UpdateField = Todo$Msg$UpdateField;
  Todo$Msg.EditingEntry = Todo$Msg$EditingEntry;
  Todo$Msg.UpdateEntry = Todo$Msg$UpdateEntry;
  Object.defineProperty(Todo$Msg, 'Add', {
    get: Todo$Msg$Add_getInstance
  });
  Todo$Msg.Delete = Todo$Msg$Delete;
  Object.defineProperty(Todo$Msg, 'DeleteComplete', {
    get: Todo$Msg$DeleteComplete_getInstance
  });
  Todo$Msg.Check = Todo$Msg$Check;
  Todo$Msg.CheckAll = Todo$Msg$CheckAll;
  Todo$Msg.ChangeVisibility = Todo$Msg$ChangeVisibility;
  Todo.prototype.Msg = Todo$Msg;
  Todo$Props.Input = Todo$Props$Input;
  Todo$Props$Entries.Entry = Todo$Props$Entries$Entry;
  Todo$Props.Entries = Todo$Props$Entries;
  Todo$Props$Controls.Count = Todo$Props$Controls$Count;
  Todo$Props$Controls$Filters.VisibilitySwap = Todo$Props$Controls$Filters$VisibilitySwap;
  Todo$Props$Controls.Filters = Todo$Props$Controls$Filters;
  Todo$Props$Controls.Clear = Todo$Props$Controls$Clear;
  Todo$Props.Controls = Todo$Props$Controls;
  Todo.prototype.Props = Todo$Props;
  var package$todo = _.todo || (_.todo = {});
  Object.defineProperty(package$todo, 'Todo', {
    get: Todo_getInstance
  });
  Kotlin.defineModule('core', _);
  return _;
}));

//# sourceMappingURL=core.js.map
