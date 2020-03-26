package p00

import java.util.*

class Problem0037 {
    private val DIGITS = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
    fun solve(): Int {
        val array = arrayOf("2", "3", "5", "7")
        var primes = ArrayList(Arrays.asList(*array))
        var sum = 0
        var count = 0
        while (count < 11) {
            val new_primes = ArrayList<String>()
            for (prime in primes) for (j in 0..9) {
                val s = DIGITS[j].toString() + prime
                if (isPrime(s.toInt())) new_primes.add(s)
                if (isValid(s)) {
                    count++
                    sum += s.toInt()
                }
            }
            primes = new_primes
        }
        return sum
    }

    private fun isValid(pNumber: String): Boolean {
        val length = pNumber.length
        for (i in 0 until length) if (!isPrime(pNumber.substring(0, length - i).toInt())) return false
        return true
    }

    private fun isPrime(pNumber: Int): Boolean {
        if (pNumber == 1 || pNumber != 2 && pNumber % 2 == 0) return false
        val square_root = Math.sqrt(pNumber.toDouble())
        var i = 3
        while (i <= square_root) {
            if (pNumber % i == 0) return false
            i += 2
        }
        return true
    }
}