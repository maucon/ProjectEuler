package p00

class Problem0006 {

    fun solve(): Int {
        var sotsquares = 0
        var sotsum = 0

        for (i in 1..100) {
            sotsquares += i * i
            sotsum += i
        }

        return sotsum * sotsum - sotsquares
    }

}