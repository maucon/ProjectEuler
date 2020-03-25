package p00

class Problem0003 {

    fun solve(): Long {
        var num = 600851475143

        var i = 2
        while (num > i * i) {
            while (num % i == 0L) num /= i
            i++
        }

        return num
    }

}