package com.parker.david

object Main {
  val stringToPrint: String = "hello Scala world"

  def main(args: Array[String]) = {
    //    val nums = Array(2, 7, 11, 15)
    //    val target = 9
    //    val result = twoSum(nums, target)
    //    println(result.mkString("[", ", ", "]"))

    val input = Array(
      Array(1, 2),
      Array(3, 4),
    )

//    val input = Array(
//      Array(7, 7),
//      Array(7, 7),
//    )

    val result = matrixRankTransform(input)
    println(result.map(_.mkString(",")).mkString("\n"))
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val numsWithIndex = nums.zipWithIndex
    numsWithIndex.foreach(
      element1 => numsWithIndex.foreach(
        element2 => {
          if (element1._2 != element2._2 && element1._1 + element2._1 == target) {
            return Array(element1._2, element2._2)
          }
        }
      ))
    null
  }

  def matrixRankTransform(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    //counters
    val maxDim1 = matrix.length
    val maxDim2 = matrix.head.length
    var trackerArray = Array.fill[Int](maxDim1, maxDim2)(0)
    var filledCounter = 0

    //get the min value
    val reduced = matrix.map(_.zipWithIndex.min).zipWithIndex.min
    val min = (reduced._1._1, reduced._1._2, reduced._2)

    //assign all mins to 1
    for (row <- 0 until maxDim1)
      for (col <- 0 until maxDim2)
        if (matrix(row)(col) == min._1) {
          trackerArray(row)(col) = 1
          filledCounter = filledCounter + 1
        }

    if (filledCounter == maxDim1 * maxDim2) return trackerArray

    //start iterating
    for (row <- 0 until maxDim1)
      for (col <- 0 until maxDim2)
        if (matrix(row)(col) == min._1)
          trackerArray(row)(col) = 1


    matrix
  }
}