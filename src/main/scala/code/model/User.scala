package code.model

import net.liftweb.mapper._
import net.liftweb.util._
import net.liftweb.common._

/**
 * Created by IntelliJ IDEA.
 * User: rslima
 * Date: 03/05/11
 * Time: 14:16
 * To change this template use File | Settings | File Templates.
 */

object User extends User with MetaMegaProtoUser[User] {
   override def dbTableName = "users"
   override def fieldOrder = List(id, firstName, lastName, email, locale, timezone, password)
   override def skipEmailValidation = true
}


class User extends MegaProtoUser[User] {
  
  def getSingleton = User


}
