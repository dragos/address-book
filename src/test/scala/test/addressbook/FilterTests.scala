package test.addressbook
import java.io.File

import org.junit.Test
import org.junit.Assert

import addressbook.AddressBook

class FilterTests {

  @Test
  def testFilterNames() {
    val abook = AddressBook.fromFile(new File("abook.txt"))
    val firstNames = abook.findByName("Williams") map (_.firstName)
    println(firstNames)
    Assert.assertEquals(Set("John", "Sharon"), firstNames.toSet)
  }
}