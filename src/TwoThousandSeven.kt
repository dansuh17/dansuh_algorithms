/**
 * 백준 문제 1924번 '2007년'
 * https://www.acmicpc.net/problem/1924
 */
fun main(args: Array<String>) {
    val stringArgs: List<String> = readLine()!!.split(" ")
    val month: Int = stringArgs[0].toInt()
    val day: Int = stringArgs[1].toInt()

    var totalDays: Int = 0
    for (i in 1..(month - 1)) {
        if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
            totalDays += 31
        } else if (i == 2) {
            totalDays += 28
        } else if (i == 4 || i == 6 || i == 9 || i == 11) {
            totalDays += 30
        }
    }

    totalDays += (day - 1)
    val dayNum = totalDays % 7
    if (dayNum == 0)  println("MON")
    else if (dayNum == 1) println("TUE")
    else if (dayNum == 2) println("WED")
    else if (dayNum == 3) println("THU")
    else if (dayNum == 4) println("FRI")
    else if (dayNum == 5) println("SAT")
    else if (dayNum == 6) println("SUN")
}
