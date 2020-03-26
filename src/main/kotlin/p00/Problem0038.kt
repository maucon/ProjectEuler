package p00

class Problem0038 {
    fun solve(): Int {
        for (i in 9876 downTo 9123) {
            val number = "" + i + i * 2
            if (isPandigital(number)) return number.toInt()
        }
        return 0
    }

    private fun isPandigital(pNumber: String): Boolean {
        if (pNumber.length != 9 || pNumber.contains("" + 0)) return false
        for (i in 1..9) if (!pNumber.contains("" + i)) return false
        return true
    }
}