package mapmartadero
package comet

import net.liftweb.http._
import net.liftweb.util._
import net.liftweb.util.Helpers._
import scala.xml.Text
import net.liftweb.http.js.JsCmds
import net.liftweb.mongodb.MongoDB
import net.liftweb.actor.ActorLogger
import net.liftweb.http.js.JsCmd
import net.liftweb.util.Helpers
import net.liftmodules.extras.NgJE._
import net.liftmodules.extras.NgJsCmds._
import net.liftweb.http.js.JsCmds._
import net.liftweb.common._
import mapmartadero.model.GeneralEvent
import net.liftweb.json._
import net.liftweb.util._
import Helpers._
import JsonDSL._

class UpdateEvents extends CometActor with CometListener {

  /* When the component is instantiated, register as a listener with the TimeServer */
  def registerWith = EventsServer

  protected override def exceptionHandler: PartialFunction[Throwable, Unit] = {
    case e => ActorLogger.error("Actor threw an exception"+e.getStackTraceString, e)
  }

  //override def lifespan = Full(120 seconds)
  /*
  * The CometActor is an Actor, so it processes messages. In this case, we're listening for String, and when we get
  * one, update our private state and re-render the component. re-render will cause changes to be sent to the browser.
  */
  override def lowPriority = {
    /*
    * The user deleted the temp (using the button "Eliminar ahora")=> a new temp is created; reset the variables
    * to let the user choose another time
    */
    case msg@UpdateEventsNg() => {
      partialUpdate(msg.toJsCmd)
      Schedule(() => EventsServer ! UpdateEventsNg(), 10.seconds )
    }
    case other =>{
      println("ERRROR:"+other.getClass)
      partialUpdate(UpdateEventsNg().toJsCmd)
    }
  }

  def render = {
    "*" #> PassThru
  }


}

case class UpdateEventsNg() {
  implicit val formats = DefaultFormats.lossless
  def toJsCmd: JsCmd = {
    val events = GeneralEvent.fetchTodayEvents(EventsServer.page, EventsServer.itemsPerPage)
    println("EVENTS SIZE:"+events.size)
    val ret = ("events" -> events.map(_.asJValue))
    NgBroadcast("map", "after-fetch-events", Full(ret))
  }
}