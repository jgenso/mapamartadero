package mapmartadero
package model

import net.liftweb.squerylrecord.RecordTypeMode._
import org.squeryl.{Schema, Table}

/**
 * Created by j2 on 11-08-14.
 */
object DbSchema extends Schema {
  val events: Table[Event] = table("EVENTO")
  val activities: Table[Activity] = table("ACTIVIDAD")
  val bookings: Table[Booking] = table("RESERVA")
  val residences: Table[Residence] = table("RESIDENCIA")
  val workshops: Table[Workshop] = table("TALLER")
  val activityTypes: Table[ActivityType] = table("TIPOACTIVIDAD")
  val areas: Table[Area] = table("AREA")
  val rooms: Table[Room] = table("AMBIENTE")
  val martaderoDates: Table[MartaderoDate] = table("FECHA")
  val activityDates: Table[ActivityDate] = table("FECHA_ACTIVIDAD")
  val workshopDates: Table[WorkshopDate] = table("FECHA_TALLER")
  val proposals: Table[Proposal] = table("PROPUESTA")

}
