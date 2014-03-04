import java.io.File
import org.scalatest.{Matchers, FlatSpec}
import scala.io.Source

/**
 * Created by russell on 04/03/14.
 */
class OcrReaderSpec extends FlatSpec with Matchers{
  "An Ocr reader" should "parse a file correctly" in {
    val reader = new OcrReader()
    val source = Source.fromFile(getClass().getResource("/testfile1").getFile())
    reader.parse(source) should be (List(123456789))
  }

  val one = "     |  |"
  val two = " _  || "
  val three = " _  _| _|"
  val four = "   |_|  |"
  val five = " _ |_  _|"
  val six = " _ |_ |_|"
  val seven = " _   |  |"
  val eight = " _ |_||_|"
  val nine = " _ |_| _|"

  it should "parse individual number strings directly" in {
    val reader = new OcrReader()
    reader.parseNumber(one) should be (1)
    reader.parseNumber(two) should be (2)
    reader.parseNumber(three) should be (3)
    reader.parseNumber(four) should be (4)
    reader.parseNumber(five) should be (5)
    reader.parseNumber(six) should be (6)
    reader.parseNumber(seven) should be (7)
    reader.parseNumber(eight) should be (8)
    reader.parseNumber(nine) should be (9)


  }


}
