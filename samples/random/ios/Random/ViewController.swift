//
//  ViewController.swift
//  Random
//
//  Created by Michael Pardo on 4/26/19.
//  Copyright © 2019 oolong. All rights reserved.
//

import UIKit
import Closures
import core

class ViewController: UIViewController {

    @IBOutlet weak var dieFaceLabel: UILabel!
    @IBOutlet weak var rollButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let _ = Random().runtime(render: render)
    }
    
    private func render(props: Random.Props, dispatch: @escaping (Random.Msg) -> KotlinUnit) {
        dieFaceLabel.text = "\(props.dieFace)"
        rollButton.onTap { dispatch(props.onRoll()) }
    }

}
