package p00

import kotlin.math.sqrt

class Problem0012 {

    fun solve(): Int {
        var c = 1
        var value = 1
        while (true) {
            val squareRoot = sqrt(value.toDouble())
            var count: Int = if (squareRoot.toInt().toDouble() == squareRoot) 1 else 0
            var i = 1
            while (i < squareRoot) {
                if (value % i == 0) count += 2
                i++
            }
            if (count > 500) break
            c++
            value += c
        }
        return value
    }

}