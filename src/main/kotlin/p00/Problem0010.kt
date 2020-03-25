package p00

import kotlin.math.sqrt

class Problem0010 {

    fun solve(): Long {
        val toN = 2000000
        val values = BooleanArray(toN)
        val sqrt = sqrt(toN.toDouble()).toInt()
        var sum = 2L

        for (i in 3..sqrt step 2)
            if (!values[i]) {
                sum += i
                for (j in i * i until toN step i + i) values[j] = true
            }
        for (i in sqrt + 1 until toN step 2) if (!values[i]) sum += i

        return sum
    }

}