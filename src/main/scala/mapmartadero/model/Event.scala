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

class Event private() extends Record[Event] with KeyedRecord[Long] {
  override def meta: MetaRecord[Event] = Event

  @Column(name="ID_PROPUESTA")
  override lazy val idField = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="NUM_EVENTO")
  lazy val number = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="BREVE_EVENTO")
  lazy val breve = new StringField(this, 1000) {
    override def shouldDisplay_? = false
  }

  @Column(name="DETALLE_EVENTO")
  lazy val detail = new StringField(this, 10000) {
    override def shouldDisplay_? = false
  }

  @Column(name="ORGANIZA")
  lazy val organize = new StringField(this, 10000) {
    override def shouldDisplay_? = false
  }

  @Column(name="AUSPICIA")
  lazy val sponsors = new StringField(this, 10000)

  @Column(name="HORA_EVENTO")
  lazy val hour = new StringField(this, 500)

  @Column(name="COSTO_EVENTO")
  lazy val cost = new StringField(this, 500)

  @Column(name="DESTACADO")
  lazy val isOutstanding = new BooleanField(this, false)

  @Column(name="VARIAS_ACTIVIDADES")
  lazy val hasSeveralActivities = new BooleanField(this, false)

  @Column(name="ID_ARTISTA")
  lazy val artistId = new LongField(this, 0L)

  @Column(name="DESTINADO_A")
  lazy val intendedFor = new StringField(this, 1000)

  @Column(name="REQUERIMIENTOS")
  lazy val requirements = new StringField(this, 1000)

  @Column(name="IMAGEN_EVENTO")
  lazy val image = new StringField(this, 100)

  @Column(name="PUBDATE_EVENTO")
  lazy val publishedDate = new OptionalDateTimeField(this)

}

object Event extends Event with MetaRecord[Event]
