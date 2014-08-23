package mapmartadero
package model

/**
 * Created by j2 on 12-08-14.
 */

import scala.xml._

import net.liftweb._
import common._
import record._
import record.field._
import net.liftweb.mongodb.record.field.DateField
import net.liftweb.mongodb.record.field.{MongoCaseClassField, ObjectIdPk}
import net.liftweb.mongodb.record.{MongoMetaRecord, MongoRecord}
import com.foursquare.rogue.LiftRogue._
import org.joda.time._

class GeneralEvent private () extends MongoRecord[GeneralEvent] with ObjectIdPk[GeneralEvent] {
  def meta = GeneralEvent

  object hour extends StringField(this, 250) {
    override def displayName = "Hour"
    override def helpAsHtml = Full(Text("Event's hour"))
  }

  object room extends MongoCaseClassField[GeneralEvent, LocalRoom](this)

  object name extends StringField(this, 200)

  object cost extends StringField(this, 300)

  object area extends StringField(this, 300) //Activity Type

  object date extends DateField(this)

  object proposal extends LongField(this, 0)

  object organize extends StringField(this, 300)

  object status extends StringField(this, 300)





  object text extends StringField(this, 12) {
    override def displayName = "Text"
    override def helpAsHtml = Full(Text("The book's text"))

    override def validations =
      valMinLen(2, "Text must be at least 2 characters") _ ::
        valMaxLen(12, "Text must be 12 characters or less") _ ::
        super.validations
  }


}

object GeneralEvent extends GeneralEvent with MongoMetaRecord[GeneralEvent] {

  def findByProposal(proposal: Long): Box[GeneralEvent] = {
    Full(
      GeneralEvent.where(_.proposal eqs proposal).fetch().headOption.
        getOrElse(GeneralEvent.createRecord.proposal(proposal))
    )
  }

  def fetchTodayEvents(page: Int, itemsPerPage: Int): List[GeneralEvent] = {
    println(s"PAGE $page")
    val now = DateTime.now()
    val dayStart = now.withTimeAtStartOfDay().plusDays(4)
    val dayEnd = dayStart.plusDays(1).withTimeAtStartOfDay()
    GeneralEvent.where(_.date between(dayStart, dayEnd)).
      and(_.status neqs "Por revisar").paginate(itemsPerPage).setPage(page).fetch()
  }

  def countTodayEvents(): Long = {
    val now = DateTime.now()
    val dayStart = now.withTimeAtStartOfDay().plusDays(4)
    val dayEnd = dayStart.plusDays(1).withTimeAtStartOfDay()
    GeneralEvent.where(_.date between(dayStart, dayEnd)).
      and(_.status neqs "Por revisar").count()
  }

}


case class LocalRoom(val name: String)
