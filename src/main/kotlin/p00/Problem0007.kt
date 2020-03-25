package p00

class Problem0007 {

    fun solve(): Int {
        tailrec fun helper(primes: List<Int>, possiblePrimes: List<Int>): List<Int> =
                when {
                    possiblePrimes.isEmpty() -> primes
                    else -> {
                        val prime = possiblePrimes.first()
                        val sievedPossiblePrimes = possiblePrimes.filter { it % prime != 0 }
                        helper(primes + prime, sievedPossiblePrimes)
                    }
                }

        return helper(emptyList(), (2..150000).toList())[10000]
    }

}