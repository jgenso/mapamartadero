package mapmartadero
package lib

import mapmartadero.model._
import net.liftweb.squerylrecord.RecordTypeMode._
import org.joda.time.DateTime
import com.mongodb.WriteConcern
import net.liftweb.common.{Logger, Loggable, Full}
import mapmartadero.model.LocalRoom

/**
 * Created by j2 on 20-08-14.
 */
object DataRetriever extends Logger {

  def updateData() = inTransaction {
    val startDate = DateTime.now().withTimeAtStartOfDay().plusDays(4)
    val endDate = startDate.plusDays(1)
    val dates = retrieveDates(startDate, endDate)
    updateProposals(dates, startDate)
   // ToDo val workshops = DbSchema.workshops.where(workshop => workshop.idField in bookings.map(_.idField)) //ToDo verificar
  }

  def updateProposals(dates: List[MartaderoDate], startDate: DateTime) = {
    val proposals = DbSchema.proposals.where(p => p.idField in dates.map(_.proposal) and p.status <> "Por revisar")
    for {
      proposal <- proposals
      generalEvent <- GeneralEvent.findByProposal(proposal.id)
    } yield {
      info(s"PROCESSING PROPOSAL: ${proposal.name.get}")
      generalEvent.hour(proposal.event.hour.get).name(proposal.name.get)
        .room(Full(LocalRoom(proposal.roomName)))
        .cost(proposal.event.cost.get).area(proposal.areaName).date(startDate.toDate)
      GeneralEvent.save(generalEvent, WriteConcern.SAFE)
      info("END PROCESSING PROPOSAL: ${proposal.name.get}")
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
    val query = DbSchema.bookings.where(booking => booking.bookingDate between(startDate.toDate, endDate.toDate))
    query.toList
  }

  def retrieveDates(startDate: DateTime, endDate: DateTime) = {
    val query = DbSchema.martaderoDates.where(date => date.date between(startDate.toDate, endDate.toDate))
    query.toList
  }

}
