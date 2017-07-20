object AplusB {
  def main(args: Array[String]): Unit = {
    val add = (x: Int, y: Int) => x + y
    val inputs = scala.io.StdIn.readLine().split(' ')
    val inputNums = inputs.map(x => x.toInt)
    println(add(inputNums(0), inputNums(1)))
  }
}
