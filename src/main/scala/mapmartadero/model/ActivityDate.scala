package mapmartadero
package model

import net.liftweb.record.{Field, MetaRecord, Record}
import net.liftweb.squerylrecord.KeyedRecord
import org.squeryl.annotations._
import net.liftweb.record.field._
import net.liftweb.http.{Templates, SHtml, S, RequestVar}
import org.squeryl.dsl.{OneToMany, ManyToOne}
import net.liftweb.util.{CssSel, FieldError}
import net.liftweb.squerylrecord.RecordTypeMode._
import net.liftweb.util.Helpers._
import org.squeryl.{Session, Schema}
import net.liftweb.json.JsonAST._
import net.liftweb.http.js.JsCmd
import net.liftweb.http.js.JsCmds.{RedirectTo, Noop}
import xml.{Text, NodeSeq}
import net.liftweb.common._
import net.liftweb.json.JsonAST.JObject
import net.liftweb.json.JsonAST.JField
import net.liftweb.mongodb.record.field.DateField

class ActivityDate private() extends Record[ActivityDate] {
  override def meta: MetaRecord[ActivityDate] = ActivityDate

  @Column(name="ID_FECHA")
  lazy val fecha = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="ID_ACTIVIDAD")
  lazy val proposal = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

}

object ActivityDate extends ActivityDate with MetaRecord[ActivityDate]
