//
//  ViewController.swift
//  Time
//
//  Created by Michael Pardo on 4/26/19.
//  Copyright © 2019 oolong. All rights reserved.
//

import Cocoa
import core

class ViewController: NSViewController {

    @IBOutlet weak var timeLabel: NSTextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let _ = Time().runtime(render: render)
    }
    
    private func render(props: Time.Props, dispatch: @escaping (Time.Msg) -> KotlinUnit) {
        let formatter = DateFormatter()
        formatter.dateFormat = "yyyy-MM-dd HH:mm:ss"
        timeLabel.stringValue = formatter.string(from: Date())
    }
    
}

