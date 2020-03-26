package p00

class Problem0028 {
    fun solve(): Int {
        var solution = 1
        var number = 1
        var add = 2
        for (i in 0..499) {
            solution += number * 4 + add * 10
            number += add * 4
            add += 2
        }
        return solution
    }
}