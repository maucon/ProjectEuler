package p00

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import java.util.*

class Problem0022 {
    fun solve(): Int {
        val names = sort(Objects.requireNonNull(readNames()))
        var sum = 0
        for (i in 1..names!!.size) sum += worth(names[i - 1]) * i
        return sum
    }

    private fun sort(pNames: ArrayList<String>?): ArrayList<String>? {
        if (pNames!!.size == 1) return pNames
        var list1: ArrayList<String>? = ArrayList(pNames.subList(0, pNames.size / 2))
        list1 = sort(list1)
        var list2: ArrayList<String>? = ArrayList(pNames.subList(pNames.size / 2, pNames.size))
        list2 = sort(list2)
        val sorted = ArrayList<String>()
        while (list1!!.size > 0 && list2!!.size > 0) {
            if (list1[0].compareTo(list2[0]) < 0) {
                sorted.add(list1[0])
                list1.removeAt(0)
            } else {
                sorted.add(list2[0])
                list2.removeAt(0)
            }
        }
        if (list1.size == 0) sorted.addAll(list2!!) else sorted.addAll(list1)
        return sorted
    }

    private fun worth(pName: String): Int {
        var worth = 0
        for (i in 0 until pName.length) worth += pName[i].toInt() - 64
        return worth
    }

    private fun readNames(): ArrayList<String>? {
        try {
            val br = BufferedReader(InputStreamReader(URL("https://projecteuler.net/project/resources/p022_names.txt").openConnection().getInputStream()))
            val s = br.readLine()
            br.close()
            return ArrayList(Arrays.asList(*s.replace("\"".toRegex(), "").split(",").toTypedArray()))
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}