package p00

import kotlin.math.pow
import kotlin.math.sqrt

class Problem0039 {
    fun solve(): Int {
        var highestAmount = 0
        var p = 0
        for (i in 3..1000) {
            var count = 0
            for (c in i / 3 + 1 until i / 2) {
                val squared = c.toDouble().pow(2.0).toInt()
                for (a in 1..(i - c) / 2) {
                    val b = sqrt(squared - a.toDouble().pow(2.0))
                    if (a + b + c == i.toDouble()) count++
                }
            }
            if (count > highestAmount) {
                highestAmount = count
                p = i
            }
        }
        return p
    }
}