package com.normalgravity.wordbank.generators

import com.normalgravity.wordbank.test.core.BaseTestSpec

class WordBankGeneratorTest extends BaseTestSpec {
  private val beforeString = "eGGGGTWff"
  private val afterString = "Eggggtwff"

  "Converting to caseWords" should "Convert a single word to start with uppercase letter and rest be lowercase" in {
    TestWordBankGenerator.wrappedCaseWordsFunction(beforeString) shouldBe afterString
  }
}

object TestWordBankGenerator extends WordBankGenerator {
  override def generateString: String = "1234"
  def wrappedCaseWordsFunction(str: String) = caseWords(str)
}
