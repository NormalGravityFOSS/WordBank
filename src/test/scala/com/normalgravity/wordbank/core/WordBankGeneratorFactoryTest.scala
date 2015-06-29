package com.normalgravity.wordbank.core

import com.normalgravity.wordbank.generators.MultiWordGenerator
import com.normalgravity.wordbank.test.core.BaseTestSpec

import scala.util.{Failure, Try}

class WordBankGeneratorFactoryTest extends BaseTestSpec {
  private val list1 = List("Hungry", "Thriving", "Active", "Mating")
  private val list2 = List("Arctic", "Mountain", "Sea", "Desert")
  private val list3 = List("Bass", "Fox", "Tiger", "Antelope")
  private val genericFailMessage = "Should have thrown exceptions"

  "The factory" should "be able to create a MultiWordGenerator when give just a basic list of lists" in {
    WordBankGeneratorFactory.createGenerator(List(list1, list2, list3)) shouldBe a [MultiWordGenerator]
  }

  it should "throw IllegalArgumentException when passing in a null list of lists" in {
    Try {WordBankGeneratorFactory.createGenerator(null)} match {
      case Failure(x) => x shouldBe a [IllegalArgumentException]
      case _ => fail(genericFailMessage)
    }
  }

  it should "throw IllegalArgumentException when passing in an empty list of lists" in {
    Try {WordBankGeneratorFactory.createGenerator(List.empty[List[String]])} match {
      case Failure(x) => x shouldBe a [IllegalArgumentException]
      case _ => fail(genericFailMessage)
    }
  }

  it should "throw IllegalArgumentException when one element in the list of lists is null" in {
    Try {WordBankGeneratorFactory.createGenerator(List(null, list2, list3))} match {
      case Failure(x) => x shouldBe a [IllegalArgumentException]
      case _ => fail(genericFailMessage)
    }
  }

  it should "throw IllegalArgumentException when one element in the list of lists is empty" in {
    Try {WordBankGeneratorFactory.createGenerator(List(List.empty[String], list2, list3))} match {
      case Failure(x) => x shouldBe a [IllegalArgumentException]
      case _ => fail(genericFailMessage)
    }
  }

  "Converting Single List to Multi List" should "create a list of lists with a length of the number passed in" in {
    WordBankGeneratorFactory.convertListSingleToMulti(3, list1) should have length 3
  }

  it should "create a list of lists with all the same list for each element" in {
    WordBankGeneratorFactory.convertListSingleToMulti(3, list1) should be (List(list1, list1, list1))
  }

  it should "throw IllegalArgumentException when the length of the list to return is 0" in {
    Try {WordBankGeneratorFactory.convertListSingleToMulti(0, List.empty)} match {
      case Failure(x) => x shouldBe a [IllegalArgumentException]
      case _ => fail(genericFailMessage)
    }
  }

  it should "throw IllegalArgumentException when the length of the list to return is negative" in {
    Try {WordBankGeneratorFactory.convertListSingleToMulti(-22, List.empty)} match {
      case Failure(x) => x shouldBe a [IllegalArgumentException]
      case _ => fail(genericFailMessage)
    }
  }

  it should "throw IllegalArgumentException when the length of the passed in list is null" in {
    Try {WordBankGeneratorFactory.convertListSingleToMulti(1, null)} match {
      case Failure(x) => x shouldBe a [IllegalArgumentException]
      case _ => fail(genericFailMessage)
    }
  }
}
