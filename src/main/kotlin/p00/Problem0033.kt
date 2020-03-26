package p00

class Problem0033 {
    fun solve(): Int {
        var numerator = 1
        var denominator = 1
        for (i in 10..98) for (j in i + 1..99) if (("" + i)[1] == ("" + j)[0] && ("" + i)[1] != '0' && ("" + ("" + i)[0]).toDouble() / ("" + ("" + j)[1]).toDouble() == i
                / j.toDouble()) {
            numerator *= i
            denominator *= j
        }
        return denominator / gcd(numerator, denominator)
    }

    private fun gcd(pA: Int, pB: Int): Int {
        return if (pA == pB) pA else if (pA > pB) gcd(pA - pB, pB) else gcd(pB - pA, pA)
    }
}