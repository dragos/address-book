package addressbook

case class Person(val firstName: String, val lastName: String, val phoneNumber: String) {

  override def toString() = 
    "%s, %s: %s".format(firstName, lastName, phoneNumber)
}