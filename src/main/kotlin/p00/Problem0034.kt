package p00

class Problem0034 {

    private val FACULTY = intArrayOf(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880)

    fun solve(): Int {
        var sum = 0
        for (i in 10..2540159) {
            if (isCurious(i)) sum += i
        }
        return sum
    }

    private fun isCurious(pNumber: Int): Boolean {
        val s = "" + pNumber
        var sum = 0
        for (i in 0 until s.length) {
            sum += FACULTY[("" + s[i]).toInt()]
            if (sum > pNumber) return false
        }
        return sum == pNumber
    }

}