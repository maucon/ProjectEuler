package p01

import java.net.URL
import kotlin.math.abs

class Problem0102 {

    fun solve(): Int {
        fun area(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int): Double = abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0)
        fun isInside(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int): Boolean =
                area(x1, y1, x2, y2, x3, y3) == area(0, 0, x2, y2, x3, y3) + area(x1, y1, 0, 0, x3, y3) + area(x1, y1, x2, y2, 0, 0)

        var s = 0
        for (line in URL("https://projecteuler.net/project/resources/p102_triangles.txt").readText().split("\n").slice(0 until 1000)) {
            val points = line.split(",")
            if (isInside(points[0].toInt(), points[1].toInt(), points[2].toInt(), points[3].toInt(), points[4].toInt(), points[5].toInt())) s++
        }
        return s
    }
}



