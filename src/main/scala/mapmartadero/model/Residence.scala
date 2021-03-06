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

class Residence private() extends Record[Residence] with KeyedRecord[Long] {
  override def meta: MetaRecord[Residence] = Residence

  @Column(name="ID_RESIDENCIA")
  override lazy val idField = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="CODIGO_RESIDENCIA")
  lazy val code = new StringField(this, 10) {
    override def shouldDisplay_? = false
  }

  @Column(name="CAPACIDAD_RESIDENCIA")
  lazy val capacity = new StringField(this, 200) {
    override def shouldDisplay_? = false
  }

  @Column(name="ESTADO_RESIDENCIA")
  lazy val status = new StringField(this, 200) {
    override def shouldDisplay_? = false
  }

  @Column(name="DESCRIPCION_RESIDENCIA")
  lazy val descripcion = new StringField(this, 10000) {
    override def shouldDisplay_? = false
  }

  @Column(name="RESERVABLE")
  lazy val isReservable = new BooleanField(this, false)

}

object Residence extends Residence with MetaRecord[Residence]
