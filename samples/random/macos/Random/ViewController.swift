//
//  ViewController.swift
//  Random
//
//  Created by Michael Pardo on 4/26/19.
//  Copyright © 2019 oolong. All rights reserved.
//

import Cocoa
import core

class ViewController: NSViewController {

    @IBOutlet weak var dieFaceLabel: NSTextField!
    @IBOutlet weak var rollButton: NSButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let _ = Random().runtime(render: render)
    }
    
    private func render(props: Random.Props, dispatch: @escaping (Random.Msg) -> KotlinUnit) {
        dieFaceLabel.stringValue = "\(props.dieFace)"
        rollButton.setAction { _ in dispatch(props.onRoll()) }
    }
    
}

