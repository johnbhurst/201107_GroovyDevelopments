@Grab("wjug.queens:domain_publish:00.00.01")
import wjug.queens.domain.Board

if (args.length == 0) {
  println("I need a number.")
  System.exit(-1)
}
size = Integer.parseInt(args[0])
Board b = new Board(size)
long start = new Date().getTime()
if (b.solve()) {
  long elapsed = new Date().getTime() - start
  for (i in 0..<size) {
    int col = b.getCol(i)
    for (j in 0..<col) {
      print(" ")
    }
    println("*")
  }
  println("" + elapsed/1000 + " seconds.")
}


