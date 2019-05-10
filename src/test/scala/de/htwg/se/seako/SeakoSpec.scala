package de.htwg.se.seako

import org.scalatest.{WordSpec, Matchers}

class SeakoSpec extends WordSpec with Matchers {
  "The Seako main class" should {
    "accept text input as argument without readline loop, to test it from commandLine " in {
      Seako.main(Array[String]("s"))
    }
    "quit " in {
      Seako.main(Array[String]("q")) should be ()
    }
  }
}
