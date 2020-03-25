package p00

class Problem0002 {

    fun solve(): Int {
        var sum = 0
        var f0 = 1
        var f1 = 1

        while (f1 < 4000000) {
            val help = f1
            f1 += f0
            f0 = help
            if (f1 % 2 == 0) sum += f1
        }

        return sum
    }

}