package p00

class Problem0040 {
    private val DIGITS = intArrayOf(10, 100, 1000, 10000, 100000, 1000000)
    fun solve(): Int {
        var solution = 1
        var digit = 0
        var step = 1
        var n = 0
        while (digit < 1000000) {
            val help = Math.pow(10.0, step - 1.toDouble()).toInt()
            for (i in help until help * 10) {
                if (digit + step >= DIGITS[n]) {
                    solution *= ("" + ("" + i)[DIGITS[n] - digit - 1]).toInt()
                    n++
                }
                digit += step
                if (n == 6) break
            }
            step++
        }
        return solution
    }
}