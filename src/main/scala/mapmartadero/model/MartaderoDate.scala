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

class MartaderoDate private() extends Record[MartaderoDate] with KeyedRecord[Long] {
  override def meta: MetaRecord[MartaderoDate] = MartaderoDate

  @Column(name="ID_FECHA")
  override lazy val idField = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="ID_PROPUESTA")
  lazy val proposal = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="ID_AMBIENTE")
  lazy val room = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="FECHA")
  lazy val date = new DateTimeField(this) {
    override def shouldDisplay_? = false
  }

  @Column(name="TURNO")
  lazy val turn = new StringField(this, 10) {
    override def shouldDisplay_? = false
  }

}

object MartaderoDate extends MartaderoDate with MetaRecord[MartaderoDate]
