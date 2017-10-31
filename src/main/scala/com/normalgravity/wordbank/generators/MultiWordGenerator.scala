package com.normalgravity.wordbank.generators

import com.normalgravity.wordbank.utils.RandomUtils

/**
 * Generator that creates strings straight from the map.
 */
class MultiWordGenerator(val model: List[List[String]]) extends WordBankGenerator {

  /**
   * Generate the random string from the model in the format:
   *  String1String2Stringn
   * @return The generatedString
   */
  override def generateString: String = model.map(RandomUtils.getRandomItemFromList(_)).map(caseWords).mkString("")
}
