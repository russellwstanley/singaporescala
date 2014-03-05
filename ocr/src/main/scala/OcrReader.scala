import java.io.File
import scala.io.Source

/**
 * Created by russell on 04/03/14.
 */
class OcrReader {

  val one = "     |  |"
  val two = " _  || "
  val three = " _  _| _|"
  val four = "   |_|  |"
  val five = " _ |_  _|"
  val six = " _ |_ |_|"
  val seven = " _   |  |"
  val eight = " _ |_||_|"
  val nine = " _ |_| _|"


  def parse(source : Source): List[Int] = {
    println("hellooooooo")
    //source.getLines().map(str => str.toList).toList.grouped(4).transpose
    List(0)
  }


  def parseNumber(numberString : String) = numberString match {
    case "     |  |" => 1
    case " _  || " => 2
    case " _  _| _|" => 3
    case "   |_|  |"=> 4
    case " _ |_  _|" => 5
    case " _ |_ |_|" => 6
    case " _   |  |" => 7
    case " _ |_||_|" => 8
    case " _ |_| _|" => 9
  }


}
