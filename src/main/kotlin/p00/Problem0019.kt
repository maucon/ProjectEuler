package p00

class Problem0019 {

    private val DAYS = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    fun solve(): Int {
        var solution = 0
        var day = 2 // 01.01.1901 -> Tuesday
        for (year in 1901..2000) for (month in 0..11) {
            day += DAYS[month]
            if (month == 1 && year % 4 == 0) day++
            if (day % 7 == 0) solution++
        }

        return solution
    }

}