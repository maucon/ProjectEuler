package p00

import java.math.BigInteger

class Problem0015 {
    fun solve(): BigInteger {
        return faculty(40).divide(faculty(20).pow(2))
    }

    private fun faculty(n: Int): BigInteger {
        var result = BigInteger.ONE
        for (i in 2..n) result = result.multiply(BigInteger.valueOf(i.toLong()))
        return result
    }
}