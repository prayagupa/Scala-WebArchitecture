package com.prediction

import javax.faces.bean.{SessionScoped, ManagedBean}

/**
 * Created by prayagupd
 * on 12/25/15
 */

@ManagedBean(name = "calculationBean")
@SessionScoped
class CalculationBean extends Serializable {
    var value1 : String = ""
    var value2 : String = ""
    var result : String = ""

    def add(): Unit = {
        println("Result  = " + String.valueOf(value1.toDouble + value2.toDouble))
        result = String.valueOf(value1.toDouble + value2.toDouble)
    }
}
