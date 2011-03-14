package code {
  package snippet {

    import _root_.scala.xml.{ NodeSeq, Text }
    import _root_.net.liftweb.util._
    import _root_.net.liftweb.common._
    import _root_.java.util.Date
    import code.lib._
    import Helpers._

    case class Person(id: Long, fName: String, lName: String, email: String)

    class HelloWorld {
      lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date
      val lGuys = List(
        Person(0, "Ricardo", "Lima", "rslima@gmail.com"),
        Person(1, "Rinaldi", "Maya", "rinaldi.neto@gmail.com"),
        Person(2, "Thomas", "Sant'ana", "mailleux@gmail.com"),
        Person(3, "Daniel", "Sobral", "dcsobral@gmail.com"))

      // replace the contents of the element with id "time" with the date
      def howdy = "#time *" #> date.map(_.toString)
      def items = "li *" #> (1 to 30 map ("Item " + _.toString)) & ClearClearable

      private def one_guy(p: Person) =
        ".fname *" #> p.fName &
        ".lname *" #> p.lName &
        ".email *" #> p.email

      def guys = ".person *" #> (lGuys map one_guy)

      /*
   lazy val date: Date = DependencyFactory.time.vend // create the date via factory

   def howdy = "#time *" #> date.toString
   */
    }

  }
}
