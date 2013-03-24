package com.chattech.scala.scratchpad

import org.scalatest.FunSuite


/**
 * Created with IntelliJ IDEA.
 * User: rowan
 * Date: 23/03/2013
 * Time: 10:03
 * To change this template use File | Settings | File Templates.
 */
class ScalaTests extends FunSuite {


  test("Test binary search") {

    val names = Array("Alex", "Betty", "Carl", "David", "Elly", "Fred", "Gigi", "Harold", "Irena", "Jerry")

    var found = binarySearch(names, "Rowan")
    println("Rowan Found = " + found.toString)

    found = binarySearch(names, "Aero")
    println("Aero Found = " + found.toString)

    found = binarySearch(names, "David")
    println("David Found = " + found.toString)

    found = binarySearch(names, "Irena")
    println("Irena Found = " + found.toString)

    found = binarySearch(names, "Alex")
    println("Alex Found = " + found.toString)

    found = binarySearch(names, "Billy")
    println("Billy Found = " + found.toString)

    found = binarySearch(names, "Gigi")
    println("Gigi Found = " + found.toString)

    found = binarySearch(names, "Haarold")
    println("Haarold Found = " + found.toString)

  }


  /**
   * Range = 0 - length
   * search at i = length / 2
   * if searchString > i
   * range = i - length
   * search at i = i + ((length - i) /2)
   * search the entry at i = length/2.
   * if our search string is less than what we found
   * search then entry at i/2
   * if greater, then math.min(i*2, length)
   * @param names
   * @param searchString
   * @return
   */
  def binarySearch(names: Array[String], searchString: String): Boolean = {

    return binarySearch(names, searchString, 0, names.length)
  }

  def binarySearch(values: Array[String], searchString: String, startIndex: Integer, endIndex: Integer): Boolean = {


    var midPoint = (endIndex - startIndex) / 2

    var indexToSearchAt = startIndex + midPoint;

    indexToSearchAt = Math.min(indexToSearchAt, values.length-1)


    println("searching at entry " + indexToSearchAt)
    val entryAtMiddleIndex = values(indexToSearchAt)

    val found = stringMatch(entryAtMiddleIndex, searchString)
    if (found) {
      return found
    }

    if ((indexToSearchAt == 0) || (indexToSearchAt == values.length-1)){
      return false
    }

    if (startIndex == endIndex){
      return false
    }

    if (searchString < entryAtMiddleIndex) {
      binarySearch(values, searchString, startIndex, indexToSearchAt-1)
    } else {
      binarySearch(values, searchString, indexToSearchAt+1, endIndex)
    }

  }

  def stringMatch(input: String, searchString: String): Boolean = {
    input.equals(searchString)
  }


  /** brute force search */
  def search(names: Array[String], searchString: String): Boolean = {
    var i = 0
    while (i < names.length) {
      val found = stringMatch(names(i), searchString)
      if (found)
        return found
      i = i + 1
    }
    return false;
  }

  def helloWorld(message: String) {
    println(message)
  }

}
