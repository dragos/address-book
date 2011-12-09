package addressbook
import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import java.io.File
import scala.util.matching.Regex._

/** A class for holding information about people.
 */
class AddressBook {

  private val people: ArrayBuffer[Person] = ArrayBuffer()

  /** Add a new person to the database. */
  def add(p: Person) = people += p

  /** The number of people in this address book. */
  def size: Int =
    people.size
  
  /** Return all persons that have the given last name. */
  def findByName(lastName: String): Seq[Person] = 
    people.filter(_.lastName == lastName)
}

object AddressBook {
  
  /** Create a new address book from the given file. 
   * 
   *  Each line in the file is an entry containing the first name, 
   *  the last name and the phone number, separated by spaces.
   */
  def fromFile(f: File) = {
    val book = new AddressBook
    val personRegex = """(\w*)\s+(\w*)\s+(\w*)\s*""".r
    
     Source.fromFile(f).getLines() foreach { line =>
       line match {
         case personRegex(firstName, lastName, phoneNr) => 
           book.add(Person(firstName, lastName, phoneNr))
         case _ => 
           println("not matched: " + line)
       }
     }
    book
  }
}
