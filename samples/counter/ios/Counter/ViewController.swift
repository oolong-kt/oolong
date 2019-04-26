//
//  ViewController.swift
//  Counter
//
//  Created by Michael Pardo on 4/26/19.
//  Copyright © 2019 oolong. All rights reserved.
//

import UIKit
import Closures
import core

class ViewController: UIViewController {
    
    
    @IBOutlet weak var countLabel: UILabel!
    @IBOutlet weak var incrementButton: UIButton!
    @IBOutlet weak var decrementButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let _ = Counter().runtime(render: render)
    }

    private func render(props: Counter.Props, dispatch: @escaping (Counter.Msg) -> KotlinUnit) {
        countLabel.text = "\(props.count)"
        incrementButton.onTap { dispatch(props.onIncrement()) }
        decrementButton.onTap { dispatch(props.onDecrement()) }
    }
    
}
