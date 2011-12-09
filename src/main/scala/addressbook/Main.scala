package addressbook
import java.io.File

object Main {

  def main(args: Array[String]) {
    val abook = AddressBook.fromFile(new File("abook.txt"))
    println(abook.size)
  }
}
