package p00

class Problem0001 {

    fun solve(): Int {
        var s = 0
        for (i in 1 until 1000) {
            if (i % 3 == 0 || i % 5 == 0) s += i
        }
        return s
    }

}