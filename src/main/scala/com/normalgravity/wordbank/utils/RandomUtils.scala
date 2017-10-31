package com.normalgravity.wordbank.utils

import scala.util.Random

/**
 * Utilities around RandomUtils
 */
object RandomUtils {

  /**
   * Generically gets item from a list.
   * @param list The list to grab from.
   * @tparam T The datatype of the elements in a list.
   * @return The item from the list.
   */
  def getRandomItemFromList[T](list: List[T]): T = list((new Random()).nextInt(list.length))
}
