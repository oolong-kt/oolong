//
//  ViewController.swift
//  Counter
//
//  Created by Michael Pardo on 4/26/19.
//  Copyright © 2019 oolong. All rights reserved.
//

import Cocoa
import core

class ViewController: NSViewController {

    @IBOutlet weak var countLabel: NSTextField!
    @IBOutlet weak var incrementButton: NSButton!
    @IBOutlet weak var decrementButton: NSButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let _ = Counter().runtime(render: render)
    }
    
    private func render(props: Counter.Props, dispatch: @escaping (Counter.Msg) -> KotlinUnit) {
        countLabel.stringValue = "\(props.count)"
        incrementButton.setAction { _ in dispatch(props.onIncrement()) }
        decrementButton.setAction { _ in dispatch(props.onDecrement()) }
    }

}
