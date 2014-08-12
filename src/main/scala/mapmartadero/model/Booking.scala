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

class Booking private() extends Record[Booking] with KeyedRecord[Long] {
  override def meta: MetaRecord[Booking] = Booking

  @Column(name="id_reserva")
  override lazy val idField = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="id_persona")
  lazy val personId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="id_propuesta")
  lazy val proposalId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="fecha_reserva")
  lazy val bookingDate = new DateTimeField(this)

  @Column(name="cargo_persona")
  lazy val inChargePerson = new StringField(this, 300) {
    override def shouldDisplay_? = false
  }

  @Column(name="id_solicitante")
  lazy val applicantId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }


}

object Booking extends Booking with MetaRecord[Booking]
