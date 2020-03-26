package p00

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

class Problem0023 {
    fun solve(): Int {
        val abundant = ArrayList<Int>()
        for (i in 0..28111) if (isAbundant(i)) abundant.add(i)
        val sum = BooleanArray(28123)
        for (i in abundant.indices) for (j in i until abundant.size) sum[if (abundant[i] + abundant[j] < 28123) abundant[i] + abundant[j] else 24] = true
        var solution = 0
        for (i in 0..28122) if (!sum[i]) solution += i
        return solution
    }

    private fun isAbundant(pNumber: Int): Boolean {
        if (pNumber < 12) return false
        val squareRoot = sqrt(pNumber.toDouble())
        var sum = if (squareRoot.toInt().toDouble().pow(2.0) == pNumber.toDouble()) squareRoot.toInt() + 1 else 1
        var i = 2
        while (i < squareRoot) {
            if (pNumber % i == 0) sum += i + pNumber / i
            i++
        }
        return sum > pNumber
    }
}