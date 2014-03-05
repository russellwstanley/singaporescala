
package main.scala

import scala.io.Source

/**
 * Created by russell on 04/03/14.
 */
class OcrReader {

  def parse(filePath : String): List[List[Int]] = {
    val listOfNumbers  = for (fourLines <- Source.fromFile(filePath).getLines.grouped(4).toList) yield from4To1(fourLines.toList)
    val listOfIntNumbers = for (numbers <- listOfNumbers) yield parseNumbers(numbers)
    listOfIntNumbers
  }

  def from4To1(fours: List[String]): List[String] = {
    def internal(result: List[String], nth: Int, lines: List[(String,Int)]): List[String] = {
      if (result.size == 9) {
        result
      }
      else {
        val nthNum: String = (for ((line, index) <- lines if index!=3)
        						yield line.slice(nth, nth+3)).mkString("")

        internal(nthNum::result, nth + 3, lines)

      }
    }
    internal(List(),0,fours.zipWithIndex).reverse
  }

  def parseNumbers(numberStrings: List[String]): List[Int] = {
    numberStrings.map {parseNumber(_)}
  }


  def parseNumber(numberString : String) = numberString match {
    case "     |  |" => 1
    case " _  _||_ " => 2
    case " _  _| _|" => 3
    case "   |_|  |" => 4
    case " _ |_  _|" => 5
    case " _ |_ |_|" => 6
    case " _   |  |" => 7
    case " _ |_||_|" => 8
    case " _ |_| _|" => 9
  }
}
