import UIKit
import CounterCore

class ViewController: UIViewController {

    var dispose: (() -> KotlinUnit)!
    
    @IBOutlet var countLabel: UILabel!
    @IBOutlet var incrementButton: UIButton!
    @IBOutlet var decrementButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        dispose = Counter().runtime(
            render: self.render
        )
    }
    
    deinit {
        dispose()
    }
    
    func render(props: Counter.Props) -> KotlinUnit {
        countLabel.text = "\(props.count)"
        incrementButton.addTarget(self, action: #selector(getter: props.onIncrement), for: .touchUpInside)
        decrementButton.addTarget(self, action: #selector(getter: props.onDecrement), for: .touchUpInside)
        return KotlinUnit()
    }

}
