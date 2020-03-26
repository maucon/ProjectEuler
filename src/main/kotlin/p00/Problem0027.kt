package p00

import java.util.*
import kotlin.math.sqrt

class Problem0027 {
    fun solve(): Int {
        val primes = primes()
        var highestAmountOfPrimes = 0
        var product = 0
        for (prime in primes) {
            var a = -999
            while (a < 1000) {
                var n = 0
                while (isPrime(n * n + a * n + prime)) n++
                if (n > highestAmountOfPrimes) {
                    highestAmountOfPrimes = n
                    product = a * prime
                }
                a += 2
            }
        }
        return product
    }

    private fun isPrime(pNumber: Int): Boolean {
        if (pNumber < 0) return false
        val squareRoot = sqrt(pNumber.toDouble()).toInt() + 1
        for (i in 2 until squareRoot) if (pNumber % i == 0) return false
        return true
    }

    private fun primes(): ArrayList<Int> {
        val allNumbers = BooleanArray(1000)
        val primes = ArrayList<Int>()
        var i = 2
        while (i < 1000) {
            while (i < 1000 && allNumbers[i]) i++
            if (i == 1000) break
            primes.add(i)
            var j = i
            while (j < 1000) {
                allNumbers[j] = true
                j += i
            }
            i++
        }
        return primes
    }
}