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

  @Column(name="id_propuesta")
  override lazy val idField = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="num_evento")
  lazy val number = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="breve_evento")
  lazy val breve = new StringField(this, 1000) {
    override def shouldDisplay_? = false
  }

  @Column(name="detalle_evento")
  lazy val detail = new StringField(this, 10000) {
    override def shouldDisplay_? = false
  }

  @Column(name="organiza")
  lazy val organize = new StringField(this, 10000) {
    override def shouldDisplay_? = false
  }

  @Column(name="auspicia")
  lazy val sponsors = new StringField(this, 10000)

  @Column(name="hora_evento")
  lazy val hour = new StringField(this, 500)

  @Column(name="costo_actividad")
  lazy val cost = new StringField(this, 500)

  @Column(name="destacado")
  lazy val isOutstanding = new BooleanField(this, false)

  @Column(name="varias_activities")
  lazy val hasSeveralActivities = new BooleanField(this, false)

  @Column(name="id_artista")
  lazy val artistId = new LongField(this, 0L)

  @Column(name="destinado_a")
  lazy val intendedFor = new StringField(this, 1000)

  @Column(name="requeriemientos")
  lazy val requirements = new StringField(this, 1000)

  @Column(name="imagen_evento")
  lazy val image = new StringField(this, 100)

  @Column(name="pubdate_evento")
  lazy val publishedDate = new DateTimeField(this)

}

object Event extends Event with MetaRecord[Event]
