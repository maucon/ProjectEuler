package p00

class Problem0009 {

    fun solve(): Int {
        for (a in 2..998) {
            for (b in a - 1 downTo 1) {
                val c = 1000 - a - b
                if (a * a + b * b == c * c) return a * b * c
            }
        }

        return 0
    }

}