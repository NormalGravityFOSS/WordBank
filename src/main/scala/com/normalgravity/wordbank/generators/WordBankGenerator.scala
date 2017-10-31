package com.normalgravity.wordbank.generators

/**
 * Basic interface for the generator.
 */
trait WordBankGenerator {

  /**
   * Generate the random string.
   */
  def generateString: String

  /**
   * Converts a string to first letter capitalized and the rest lowercase.
   * @param word The word to convert.
   * @return The converted word.
   */
  protected def caseWords(word: String): String = word.toLowerCase.capitalize
}
