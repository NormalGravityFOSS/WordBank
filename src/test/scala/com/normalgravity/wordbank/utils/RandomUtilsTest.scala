package com.normalgravity.wordbank.utils

import com.normalgravity.wordbank.test.core.BaseTestSpec

class RandomUtilsTest extends BaseTestSpec {
  private val list1 = List("1", "2", "3")

  "Pulling a random item from list" should "return a single element from the list" in {
    list1 should contain (RandomUtils.getRandomItemFromList(list1))
  }
}
