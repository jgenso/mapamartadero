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

class Workshop private() extends Record[Workshop] with KeyedRecord[Long] {
  override def meta: MetaRecord[Workshop] = Workshop

  @Column(name="ID_TALLER")
  override lazy val idField = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="ID_AREA")
  lazy val areaId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="ID_ARTISTA")
  lazy val artistId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="NOMBRE_TALLER")
  lazy val name = new StringField(this, 250)

  @Column(name="BREVE_TALLER")
  lazy val breve = new StringField(this, 1000) {
    override def shouldDisplay_? = false
  }

  @Column(name="CONTENIDO_TALLER")
  lazy val content = new StringField(this, 10000) {
    override def shouldDisplay_? = false
  }

  @Column(name="COSTO_TALLER")
  lazy val cost = new StringField(this, 500) {
    override def shouldDisplay_? = false
  }

  @Column(name="HORA_TALLER")
  lazy val hour = new StringField(this, 500) {
    override def shouldDisplay_? = false
  }

  @Column(name="DESTINADO_A")
  lazy val intendedFor = new StringField(this, 200) {
    override def shouldDisplay_? = false
  }

  @Column(name="REQUERIMIENTOS")
  lazy val requirements = new StringField(this, 1000) {
    override def shouldDisplay_? = false
  }

  @Column(name="ESTADO")
  lazy val status = new StringField(this, 50) {
    override def shouldDisplay_? = false
  }

  @Column(name="pubdate_taller")
  lazy val published = new DateTimeField(this) {
    override def shouldDisplay_? = false
  }


}

object Workshop extends Workshop with MetaRecord[Workshop]
