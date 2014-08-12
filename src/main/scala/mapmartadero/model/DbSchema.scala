package mapmartadero
package model

import net.liftweb.squerylrecord.RecordTypeMode._
import org.squeryl.{Schema, Table}

/**
 * Created by j2 on 11-08-14.
 */
object DbSchema extends Schema {
  val events: Table[Event] = table("event")
  val activities: Table[Activity] = table("activity")
  val bookings: Table[Booking] = table("booking")
  val residences: Table[Residence] = table("residence")


}
