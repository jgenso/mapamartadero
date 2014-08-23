package mapmartadero
package comet

import net.liftweb._
import http._
import actor._
import mapmartadero.model.GeneralEvent
import com.foursquare.rogue.LiftRogue._

object EventsServer extends LiftActor with ListenerManager {

  var page = 1

  val itemsPerPage = 10

  def createUpdate = UpdateEventsNg()

  /**
   * Process messages that are sent to the Actor.  In this case, we're looking for String that is sent
   * to the TimeServer.  We assign it to our message,and then update all the listeners.
   */
  override def lowPriority = {
    case t@UpdateEventsNg() => {
      val total = GeneralEvent.count
      val totalPages = total / itemsPerPage + (if (total % itemsPerPage == 0) 0 else 1)
      if (total > itemsPerPage && page < totalPages -1)
        page = page + 1
      else page = 1
      updateListeners(UpdateEventsNg())
    }
    case other => println("Error wrong Msg")
  }
}

