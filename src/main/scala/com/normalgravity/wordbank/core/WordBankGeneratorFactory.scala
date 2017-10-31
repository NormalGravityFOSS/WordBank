package com.normalgravity.wordbank.core

import com.normalgravity.wordbank.generators.{MultiWordGenerator, WordBankGenerator}

/**
 * Factory Object to build get a string generator.
 */
object WordBankGeneratorFactory {

  /**
   * Factory Function to create a generator.
   * @param populatedBank The base word bank to use as a model.
   * @return The new Generator.
   */
  def createGenerator(populatedBank: List[List[String]]): WordBankGenerator = {
    validateList(populatedBank)
    return new MultiWordGenerator(populatedBank)
  }

  /**
   * Simple validator of the list coming in.
   * @param list The list of lists to validate.
   * @throws IllegalArgumentException When any of the lists are empty or null or the whole list of list is empty or null.
   */
  private def validateList(list: List[List[String]]) = {
    if(list == null || list.isEmpty || !list.filter(x => {x == null || x.isEmpty}).isEmpty) {
      throw new IllegalArgumentException ("There needs to be a list of lists passed in.")
    }
  }

  /**
   * Builds a list of lists from just one list. Meant to use one word bank to create multiple words in the string
   * @param n The number of words to have in the string.
   * @param wordBank The Single source list.
   * @return List of lists. Should be the same list in memory reused.
   * @throws IllegalArgumentException When n isn't a positive number larger than 0 or the list is null.
   */
  def convertListSingleToMulti(n: Int, wordBank: List[String]): List[List[String]] = {
    if(n > 0 && wordBank != null) {
      return (1 to n).map(x => wordBank).toList
    } else {
      throw new IllegalArgumentException ("There needs to be a list passed in and the number of words should be positive.")
    }
  }
}
