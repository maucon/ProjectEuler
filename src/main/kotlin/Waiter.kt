fun start(problemNumber: Int): Any {
    val pack = StringBuilder("p" + problemNumber / 100)
    while (pack.length < 3) pack.insert(1, "0")

    val pN = java.lang.StringBuilder("" + problemNumber)
    while (pN.length < 4) pN.insert(0, "0")

    return try {
        val c = Class.forName("$pack.Problem$pN").getDeclaredConstructor().newInstance()
        c.javaClass.methods[0].invoke(c)
    } catch (e: Exception) {
        // e.printStackTrace()
        "ERROR"
    }
}