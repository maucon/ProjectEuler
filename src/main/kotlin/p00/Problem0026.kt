package p00

import java.util.*

class Problem0026 {
    fun solve(): Int {
        var solution = 0
        var border = 2
        var i = 999
        while (i >= border) {
            val recurringCycle = lenghtOfRecurringCycle(i)
            if (recurringCycle > border) {
                border = recurringCycle
                solution = i
            }
            i -= 2
        }
        return solution
    }

    fun lenghtOfRecurringCycle(b: Int): Int {
        var a = 1
        val list = ArrayList<Int>()
        while (a != 0) {
            a %= b
            for (i in list.indices) if (list[i] == a) return list.size
            list.add(a)
            if (list.size >= b) return 0
            a *= 10
        }
        return 0
    }
}