package com.normalgravity.wordbank.test.core

import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

trait BaseTestSpec extends FlatSpec with Matchers with BeforeAndAfter with MockFactory
