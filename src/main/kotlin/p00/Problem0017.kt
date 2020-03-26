package p00

class Problem0017 {
    private val BASIC = intArrayOf(0, 3, 3, 5, 4, 4, 3, 5, 5, 4) // 1 - 9
    private val SPECIAL = intArrayOf(3, 6, 6, 8, 8, 7, 7, 9, 8, 8) // 10 - 19
    private val TENS = intArrayOf(0, 0, 6, 6, 5, 5, 5, 7, 6, 6) // 0 - 90 (10)
    fun solve(): Int {
        var solution = 0
        for (i in 0..99) {
            val s = "" + i
            if (s.length == 1) {
                solution += BASIC[s.toInt()]
                continue
            }
            val s1 = "" + s[s.length - 2]
            val i1 = ("" + s[s.length - 1]).toInt()
            if (s1 == "1") {
                solution += SPECIAL[i1]
                continue
            }
            solution += BASIC[i1]
            solution += TENS[s1.toInt()]
        }
        solution *= 10
        for (i in 0..9) solution += BASIC[i] * 100 // "one-", "two-", "three-"
        solution += 900 * 7 // "-hundred"
        solution += 891 * 3 // "and"
        solution += 11 // "one thousand"
        return solution
    }
}