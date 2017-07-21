object AminusB {
  def main(args: Array[String]): Unit = {
    val sub = (x: Int, y: Int) => x - y
    val inputsStr = scala.io.StdIn.readLine().split(" ")
    val inputs = inputsStr.map(x => x.toInt)
    println(sub(inputs(0), inputs(1)))
  }
}

