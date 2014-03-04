import java.io.File
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import main.scala.OcrReader

/**
 * Created by russell on 04/03/14.
 */
class OcrReaderSpec extends FlatSpec with Matchers{
  "An Ocr reader" should "parse a file correctly" in {
    val reader = new OcrReader()
    val file = new File(getClass().getResource("/testfile1").getFile())
    file.exists() should be (true)
    println(reader.from4To1( List("    _  _     _  _  _  _  _ ","  | _| _||_||_ |_   ||_||_|","  ||_  _|  | _||_|  ||_| _|","                           ") ))
    println(reader.parse(file.getAbsolutePath()))
  }
}
