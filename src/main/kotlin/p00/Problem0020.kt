package p00

import java.util.*

class Problem0020 {

    fun solve(): Int {
        val number = ArrayList<Int>()
        number.add(1)
        for (i in 1..100) {
            var help = 0
            for (h in number.indices) {
                val product = number[h] * i + help
                help = product / 10
                number[h] = product - help * 10
            }
            val string = help.toString()
            for (h in string.length - 1 downTo 0) number.add(Integer.valueOf("" + string[h]))
        }
        var solution = 0
        for (integer in number) solution += integer

        return solution
    }

}