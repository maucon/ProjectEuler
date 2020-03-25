package p00

class Problem0004 {

    fun solve(): Int {
        var largest = 0
        for (a in 999 downTo 100)
            for (b in 999 downTo 100) {
                val n = a * b
                if (n < largest) break
                if (n.toString().reversed() == n.toString()) largest = n
            }
        return largest
    }

}