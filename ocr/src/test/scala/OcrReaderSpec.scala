import java.io.File
import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by russell on 04/03/14.
 */
class OcrReaderSpec extends FlatSpec with Matchers{
  "An Ocr reader" should "parse a file correctly" in {
    val reader = new OcrReader()
    val file = new File(getClass().getResource("/testfile1").getFile())
    file.exists() should be (true)
    reader.parse(file) should be (123456789)
  }
}
