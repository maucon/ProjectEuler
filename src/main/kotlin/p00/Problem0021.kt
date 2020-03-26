package p00

import kotlin.math.pow
import kotlin.math.sqrt

class Problem0021 {
    private val SAVE = IntArray(10001)
    fun solve(): Int {
        var sum = 0
        for (i in 2..9999) {
            if (SAVE[i] == 0) SAVE[i] = sumOfDivisors(i)
            if (SAVE[i] < 10001) {
                if (SAVE[SAVE[i]] == 0) SAVE[SAVE[i]] = sumOfDivisors(SAVE[i])
                if (i == SAVE[SAVE[i]] && i != SAVE[i]) sum += i
            } else if (i == sumOfDivisors(SAVE[i]) && i != SAVE[i]) sum += i
        }
        return sum
    }

    private fun sumOfDivisors(p: Int): Int {
        if (p == 1) return 0
        var sum = 1
        val squareRoot = sqrt(p.toDouble())
        var i = 2
        while (i < squareRoot) {
            if (p % i == 0) sum += i + p / i
            i++
        }
        if (squareRoot.toInt().toDouble().pow(2.0) == p.toDouble()) sum += squareRoot.toInt()
        return sum
    }
}