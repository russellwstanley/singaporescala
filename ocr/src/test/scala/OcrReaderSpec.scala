import java.io.File
import main.scala.OcrReader
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by Singapore Scala Programmers on 04/03/14.
 */
class OcrReaderSpec extends FlatSpec with Matchers{
  "An Ocr reader" should "parse a file correctly" in {
    val reader = new OcrReader()
    val file = new File(getClass().getResource("/testfile1").getFile())
    file.exists() should be (true)
    reader.parse(file.getAbsolutePath()) should be (List(List(1,2,3,4,5,6,7,8,9)))
  }

  val one   = "     |  |"
  val two   = " _  _||_ "
  val three = " _  _| _|"
  val four  = "   |_|  |"
  val five  = " _ |_  _|"
  val six   = " _ |_ |_|"
  val seven = " _   |  |"
  val eight = " _ |_||_|"
  val nine =  " _ |_| _|"

  it should "parse individual number strings correctly" in {
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
