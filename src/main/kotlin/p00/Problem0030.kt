package p00

class Problem0030 {
    private val POWER = intArrayOf(0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049)
    fun solve(): Int {
        var sum = 0
        for (i in 10..354293) {
            val s = "" + i
            var number = 0
            for (element in s) number += POWER[("" + element).toInt()]
            if (number == i) sum += number
        }
        return sum
    }
}