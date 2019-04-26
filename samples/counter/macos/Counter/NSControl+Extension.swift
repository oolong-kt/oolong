//
//  AppDelegate.swift
//  Counter
//
//  Created by Michael Pardo on 4/26/19.
//  Copyright © 2019 oolong. All rights reserved.
//

import Cocoa

let NSControlActionFunctionProtocolAssociatedObjectKey = UnsafeMutablePointer<Int8>.allocate(capacity:1)

class ActionTrampoline<T>: NSObject {
    var action: (T) -> Void
    init(action: @escaping (T) -> Void) {
        self.action = action
    }
    @objc func action(_ sender: NSControl) {
        action(sender as! T)
    }
}

protocol NSControlActionFunctionProtocol {}

extension NSControlActionFunctionProtocol where Self: NSControl {
    func setAction(action: @escaping (Self) -> Void) {
        let trampoline = ActionTrampoline(action: action)
        self.target = trampoline
        self.action = Selector("action:")
        objc_setAssociatedObject(self, NSControlActionFunctionProtocolAssociatedObjectKey, trampoline, .OBJC_ASSOCIATION_RETAIN)
    }
}

extension NSControl: NSControlActionFunctionProtocol {}
