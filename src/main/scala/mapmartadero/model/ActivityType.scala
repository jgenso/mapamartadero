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

class ActivityType private() extends Record[ActivityType] with KeyedRecord[Long] {
  override def meta: MetaRecord[ActivityType] = ActivityType

  @Column(name="ID_TIPOACTIVIDAD")
  override lazy val idField = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="NOMBRE_TIPOACTIVIDAD")
  lazy val name = new StringField(this, 200) {
    override def shouldDisplay_? = false
  }

}

object ActivityType extends ActivityType with MetaRecord[ActivityType]
