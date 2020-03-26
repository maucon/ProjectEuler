package p00

import java.util.*

class Problem0032 {
    fun solve(): Int {
        var sum = 0
        val products = ArrayList<Int>()
        for (a in 2..99) {
            for (b in a + 1..9999) {
                val product = a * b
                if (("" + product).length > 10 - ("" + a).length - ("" + b).length) break
                if (pandigital(a, b, product) && !products.contains(product)) {
                    products.add(product)
                    sum += product
                }
            }
        }
        return sum
    }

    private fun pandigital(pA: Int, pB: Int, pC: Int): Boolean {
        val s = "" + pA + pB + pC
        if (s.length != 9 || s.contains("" + 0)) return false
        for (i in 1..9) if (!s.contains("" + i)) return false
        return true
    }
}