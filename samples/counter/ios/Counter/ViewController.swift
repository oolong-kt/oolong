//
//  ViewController.swift
//  Counter
//
//  Created by Michael Pardo on 4/26/19.
//  Copyright © 2019 oolong. All rights reserved.
//

import UIKit
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
        incrementButton.on(.touchUpInside) { (sender, event) in dispatch(props.onIncrement()) }
        decrementButton.on(.touchUpInside) { (sender, event) in dispatch(props.onDecrement()) }
    }
    
}
