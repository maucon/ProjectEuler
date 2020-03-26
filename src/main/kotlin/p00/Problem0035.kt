package p00

class Problem0035 {

    private val SIEVE = BooleanArray(1000000)

    fun solve(): Int {
        var j = 4
        while (j < 1000000) {
            SIEVE[j] = true
            j += 2
        }
        run {
            var i = 3
            while (i < 1000) {
                while (i < 1000 && SIEVE[i]) i++
                if (i == 1000) break
                var j = i * 2
                while (j < 1000000) {
                    SIEVE[j] = true
                    j += i
                }
                i += 2
            }
        }
        var count = 1
        var i = 3
        while (i < 1000000) {
            if (!SIEVE[i] && isCircularPrime(i)) count++
            i += 2
        }
        return count
    }

    private fun isCircularPrime(pNumber: Int): Boolean {
        val chars = ("" + pNumber).toCharArray()
        val length = chars.size
        for (i in 1 until length) {
            val s = StringBuilder()
            for (j in 0 until length) s.append(chars[(j + i) % length])
            if (SIEVE[s.toString().toInt()]) return false
        }
        return true
    }

}