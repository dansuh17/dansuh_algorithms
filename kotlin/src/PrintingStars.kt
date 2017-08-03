fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    for (i in 1..n) {
        println(" ".repeat(n - i) + "*".repeat(i))
    }
}