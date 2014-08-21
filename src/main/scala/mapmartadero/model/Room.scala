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

class Room private() extends Record[Room] with KeyedRecord[Long] {
  override def meta: MetaRecord[Room] = Room

  @Column(name="ID_AMBIENTE")
  override lazy val idField = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="NOMBRE_AMBIENTE")
  lazy val name = new StringField(this, 200) {
    override def shouldDisplay_? = false
  }

  @Column(name="CODIGO_AMBIENTE")
  lazy val code = new StringField(this, 10) {
    override def shouldDisplay_? = false
  }

  @Column(name="USO")
  lazy val uso = new StringField(this, 500) {
    override def shouldDisplay_? = false
  }

  @Column(name="USO_COMPATIBLE")
  lazy val usoCompatible = new StringField(this, 500) {
    override def shouldDisplay_? = false
  }

  @Column(name="USO_ACTUAL")
  lazy val usoActual = new StringField(this, 500) {
    override def shouldDisplay_? = false
  }

  @Column(name="CAPACIDAD_AMBIENTE")
  lazy val capacity = new StringField(this, 200) {
    override def shouldDisplay_? = false
  }

  @Column(name="ESTADO_AMBIENTE")
  lazy val status = new StringField(this, 200) {
    override def shouldDisplay_? = false
  }

  @Column(name="DESCRIPCION_AMBIENTE")
  lazy val description = new StringField(this, 10000) {
    override def shouldDisplay_? = false
  }

  @Column(name="PATH_AMBIENTE")
  lazy val path = new StringField(this, 200) {
    override def shouldDisplay_? = false
  }

  @Column(name="RESERVABLE")
  lazy val isReservable = new BooleanField(this, false)

  @Column(name="RESERVABLE_TURNOS")
  lazy val isReservableTurnos = new BooleanField(this, false)

  @Column(name="PLANO_TECNICO")
  lazy val planoTecnico = new StringField(this, 200) {
    override def shouldDisplay_? = false
  }

  @Column(name="PANEO_AMBIENTE")
  lazy val paneoAmbiente = new StringField(this, 200) {
    override def shouldDisplay_? = false
  }

}

object Room extends Room with MetaRecord[Room]
