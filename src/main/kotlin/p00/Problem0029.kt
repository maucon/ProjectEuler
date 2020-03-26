package p00

import java.math.BigInteger
import java.util.*

class Problem0029 {
    fun solve(): Int {
        val sorted = HashSet<BigInteger>()
        for (a in 2..100) {
            var number = BigInteger.valueOf(a.toLong())
            for (b in 2..100) {
                number = number.multiply(BigInteger.valueOf(a.toLong()))
                sorted.add(number)
            }
        }
        return sorted.size
    }
}