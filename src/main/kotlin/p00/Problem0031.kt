package p00

class Problem0031 {
    private val COINS = intArrayOf(200, 100, 50, 20, 10, 5, 2, 1)
    fun solve(): Int {
        return possibilities(200, 0)
    }

    private fun possibilities(pValue: Int, pCoin: Int): Int {
        if (pValue == 0) return 0
        var possibilities = 0
        for (i in pCoin..7) if (COINS[i] < pValue) possibilities += possibilities(pValue - COINS[i], i) else if (COINS[i] == pValue) possibilities++
        return possibilities
    }
}