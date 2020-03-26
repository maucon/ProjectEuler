package p00

import java.util.*

class Problem0036 {
    private val BINARY = intArrayOf(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768,
            65536, 131072, 262144, 524288)

    fun solve(): Int {
        var sum = 1
        for (i in 2..20) {
            val palindromes = generateBinaryPalindromes(i)
            for (palindrome in palindromes) {
                val decimal = binaryToDecimal(palindrome)
                if (isPalindrom("" + decimal) && decimal < 1000000) sum += decimal
            }
        }
        return sum
    }

    private fun generateBinaryPalindromes(pLength: Int): ArrayList<BooleanArray> {
        val palindromes = ArrayList<BooleanArray>()
        val amount = Math.pow(2.0, Math.floor((pLength - 2) / 2.toDouble()) + pLength % 2).toInt()
        for (i in 0 until amount) palindromes.add(BooleanArray(pLength))
        for (i in 0 until amount) {
            val p = palindromes[i]
            p[0] = true
            p[p.size - 1] = true
        }
        var steps = 1
        var i = 1
        while (i < pLength / 2.0) {
            var j = 0
            while (j < amount) {
                for (h in j until j + steps) {
                    val p = palindromes[h]
                    p[i] = true
                    p[p.size - 1 - i] = true
                }
                j += steps * 2
            }
            steps *= 2
            i++
        }
        return palindromes
    }

    private fun binaryToDecimal(pNumber: BooleanArray): Int {
        var sum = 0
        for (i in pNumber.indices) if (pNumber[i]) sum += BINARY[i]
        return sum
    }

    private fun isPalindrom(s: String): Boolean {
        if (s.length <= 1) return true
        return if (s[0] == s[s.length - 1]) isPalindrom(s.substring(1, s.length - 1)) else false
    }
}