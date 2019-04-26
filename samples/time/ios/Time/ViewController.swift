//
//  ViewController.swift
//  Time
//
//  Created by Michael Pardo on 4/26/19.
//  Copyright © 2019 oolong. All rights reserved.
//

import UIKit
import core

class ViewController: UIViewController {

    @IBOutlet weak var timeLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let _ = Time().runtime(render: render)
    }
    
    private func render(props: Time.Props, dispatch: @escaping (Time.Msg) -> KotlinUnit) {
        let formatter = DateFormatter()
        formatter.dateFormat = "yyyy-MM-dd HH:mm:ss"
        timeLabel.text = formatter.string(from: Date())
    }

}
