package com.normalgravity.wordbank.generators

import com.normalgravity.wordbank.test.core.BaseTestSpec

class MultiWordGeneratorTest extends BaseTestSpec {
  private val list1 = List("hungry")
  private val list2 = List("arctic")
  private val list3 = List("fox")

  "Generating a string" should "create a multi-word string when multiple lists are set in the model" in {
    (new MultiWordGenerator(List(list1, list2, list3))).generateString shouldBe "HungryArcticFox"
  }

  it should "create a single-word string when only one list is set in the model" in {
    (new MultiWordGenerator(List(list1))).generateString shouldBe "Hungry"
  }
}
