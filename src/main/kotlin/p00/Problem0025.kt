package p00

class Problem0025 {
    fun solve(): Int {
        var a = ArrayList<Int>()
        val b = ArrayList<Int>()
        a.add(1)
        b.add(1)
        var index = 2
        while (b.size < 1000) {
            index++
            val save = b.toMutableList()
            add(b, a)
            a = save as ArrayList<Int>
        }
        return index
    }

    private fun add(pB: ArrayList<Int>, pA: ArrayList<Int>) {
        var help = 0
        for (i in pA.indices) {
            val number = pB[i] + pA[i] + help
            help = number / 10
            pB[i] = number - help * 10
        }
        for (i in pA.size until pB.size) {
            if (help == 0) break
            val number = pB[i] + help
            help = number / 10
            pB[i] = number - help * 10
        }
        if (help > 0) {
            val s = "" + help
            for (element in s) {
                pB.add(Integer.valueOf("" + element))
            }
        }
    }
}