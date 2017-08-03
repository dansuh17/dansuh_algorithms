fun main(args: Array<String>) {
    val a = readLine()!!.toInt()
    for (i in 0..(a - 1)) {
        println("*".repeat(a - i))
    }
}