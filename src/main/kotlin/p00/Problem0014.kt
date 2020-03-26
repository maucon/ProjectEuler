package p00

class Problem0014 {

    fun solve(): Long {
        var longestChain = 0
        var bestNumber: Long = 0
        val chainLengths = IntArray(1000000)
        for (i in 1..999999) {
            var number = i.toLong()
            var chain = 0
            while (number != 1L) {
                if (number < 1000000 && chainLengths[number.toInt()] != 0) {
                    chain += chainLengths[number.toInt()]
                    break
                }
                chain++
                if (number % 2 == 0L) number /= 2 else {
                    number = (number * 3 + 1) / 2
                    chain++
                }
            }
            chainLengths[i] = chain
            if (chain > longestChain) {
                bestNumber = i.toLong()
                longestChain = chain
            }
        }

        return bestNumber
    }

}