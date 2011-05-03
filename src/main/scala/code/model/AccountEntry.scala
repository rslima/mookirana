package code.model

import net.liftweb.mapper._

/**
 * Created by IntelliJ IDEA.
 * User: rslima
 * Date: 03/05/11
 * Time: 14:16
 * To change this template use File | Settings | File Templates.
 */

object EntryType extends Enumeration {
  val Expense = Value(1,"Despesa")
  val Income = Value(2,"Receita")
}

object Responsible extends Enumeration {
  val Husband = Value(1,"Marido")
  val Wife = Value(2,"Esposa")
}

object EntrySource extends Enumeration {
  val Cash = Value(1,"Dinheiro")
  val Check = Value(2,"Conta-Corrente")
  val Credit = Value(3,"Cartão de Crédito")
}

class AccountEntry  extends LongKeyedMapper[AccountEntry] with IdPK {
  def getSingleton = AccountEntry

  object entryDate extends MappedDate(this)
  object payee extends MappedString(this,300)
  object responsible extends MappedEnum(this,Responsible)
  object category extends MappedString(this,90)
  object entryType extends MappedEnum(this,EntryType)
  object entryValue extends MappedDecimal(this,java.math.MathContext.DECIMAL64,2)

}

object AccountEntry extends AccountEntry with LongKeyedMetaMapper[AccountEntry]
