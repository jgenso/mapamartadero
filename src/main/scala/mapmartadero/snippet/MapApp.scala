package mapmartadero
package snippet

import scala.xml.{NodeSeq, Text}

import net.liftweb.common._
import net.liftweb.http.S
import net.liftweb.http.js._
import net.liftweb.http.js.JsCmds._
import net.liftweb.http.js.JE._
import net.liftweb.json._
import net.liftweb.util._
import Helpers._
import JsonDSL._

import net.liftmodules.extras._
import NgJE._
import NgJsCmds._
import org.joda.time._
import mapmartadero.model.GeneralEvent
import com.foursquare.rogue.LiftRogue._

/**
 * Created by j2 on 20-08-14.
 */
object MapApp extends SnippetHelper with Loggable {

  implicit val formats = DefaultFormats

  def render(in: NodeSeq): NodeSeq = {

    /**
     * fetch mongo events
     */
    def fetchEvents(): JsCmd = {
      println("CALLED")
      val now = DateTime.now()
      val dayStart = now.withTimeAtStartOfDay()
      val dayEnd = now.plusDays(1).withTimeAtStartOfDay()
      val events = GeneralEvent.where(_.date between(dayStart, dayEnd)).fetch()
      val ret = ("events" -> events.map(_.asJValue))
      NgBroadcast("map", "after-fetch-events", Full(ret))
    }

    val funcs = JsObj(
      "fetchEvents" -> JsExtras.AjaxCallbackAnonFunc(fetchEvents)
    )

    val onload: JsCmd =
      NgModule("MapServer", Nil) ~>
        NgConstant("ServerParams", JsObj("x" -> "xx")) ~>
        NgFactory("ServerFuncs", AnonFunc(JsReturn(funcs)))


    S.appendGlobalJs(JsExtras.IIFE(onload))

    in
  }

}
