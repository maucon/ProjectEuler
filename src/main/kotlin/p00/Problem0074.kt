package p00

class Problem0074 {

    fun solve(): Int {
        var s = 0

        for (i in 2 until 1000000) {
            val list = hashSetOf(i)

            var n = i
            while (true) {
                var copyN = n
                n = 0
                while (copyN > 0) {
                    var fak = 1
                    for (j in 2..copyN % 10) fak *= j
                    n += fak
                    copyN /= 10
                }

                if (list.contains(n)) break
                list.add(n)
            }
            if (list.size >= 60) s++
        }

        return s
    }

}