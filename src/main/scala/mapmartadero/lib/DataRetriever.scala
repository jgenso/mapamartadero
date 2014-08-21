package mapmartadero
package lib

import mapmartadero.model.{Booking, DbSchema, GeneralEvent}
import net.liftweb.squerylrecord.RecordTypeMode._
import org.joda.time.DateTime
import mapmartadero.model.LocalRoom
import com.mongodb.WriteConcern
import net.liftweb.common.Full

/**
 * Created by j2 on 20-08-14.
 */
object DataRetriever {

  def updateDate() = {
    val startDate = DateTime.now().withTimeAtStartOfDay()
    val endDate = startDate.plusDays(1)
    val bookings = retrieveBookings(startDate, endDate)


    val workshops = DbSchema.workshops.where(workshop => workshop.idField in bookings.map(_.idField)) //ToDo verificar
  }

  def updateActivities(bookings: List[Booking], startDate: DateTime) = {
    val activities = DbSchema.activities.where(activity => activity.proposalId in bookings.map(_.idField))
    for {
      activity <- activities
      generalEvent <- GeneralEvent.findByProposal(activity.proposalId.get)
    } yield {
      generalEvent.hour(activity.hour.get).room(Full(LocalRoom(activity.roomName)))
        .cost(activity.cost.get).area(activity.activityTypeName).date(startDate.toDate)
      GeneralEvent.save(generalEvent, WriteConcern.SAFE)
    }
  }

  def updateEvents(bookings: List[Booking], startDate: DateTime) = {
    val events = DbSchema.events.where(event => event.idField in bookings.map(_.proposalId))
    for {
      event <- events
      generalEvent <- GeneralEvent.findByProposal(event.idField.get)
    } yield {
      generalEvent.hour(event.hour.get).room(Full(LocalRoom("")))
        .cost(event.cost.get).date(startDate.toDate).organize(event.organize.get)
      GeneralEvent.save(generalEvent, WriteConcern.SAFE)
    }
  }

  def retrieveBookings(startDate: DateTime, endDate: DateTime) = {
    DbSchema.bookings.where(booking => booking.bookingDate between(startDate.toDate, endDate.toDate)).toList
  }

}
