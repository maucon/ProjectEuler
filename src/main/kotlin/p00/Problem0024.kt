package p00

import java.util.*

class Problem0024 {
    fun solve(): String {
        val numbers = IntArray(10)
        var target = 999999
        val array = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val list = ArrayList(listOf(*array))
        val solution = StringBuilder()
        for (i in 0..9) {
            val fac = faculty(9 - i)
            numbers[i] = target / fac
            target %= fac
            solution.append(list[numbers[i]])
            list.removeAt(numbers[i])
        }
        return solution.toString()
    }

    private fun faculty(n: Int): Int {
        var result = 1
        for (i in 2..n) result *= i
        return result
    }
}