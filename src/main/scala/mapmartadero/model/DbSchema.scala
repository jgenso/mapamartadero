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


}
