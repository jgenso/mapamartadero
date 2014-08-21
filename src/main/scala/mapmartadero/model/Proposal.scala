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

class Proposal private() extends Record[Proposal] with KeyedRecord[Long] {
  override def meta: MetaRecord[Proposal] = Proposal

  @Column(name="ID_PROPUESTA")
  override lazy val idField = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="ID_PAIS")
  lazy val countryId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="ID_TIPOACTIVIDAD")
  lazy val activityTypeId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="ID_AREA")
  lazy val areaId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="EVE_ID_PROPUESTA")
  lazy val eveIdProp = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="TARJETA_ARCOIRIS")
  lazy val tarjetaArcoIris = new StringField(this, 20)

  @Column(name="NOMBRE_PROPUESTA")
  lazy val name = new StringField(this, 250) {
    override def shouldDisplay_? = false
  }

  @Column(name="CONCEPTO_PROPUESTA")
  lazy val concept = new StringField(this, 250) {
    override def shouldDisplay_? = false
  }

  @Column(name="DESCRIPCION_PROPUESTA")
  lazy val description = new StringField(this, 10000) {
    override def shouldDisplay_? = false
  }

  @Column(name="RESENIA")
  lazy val resenia = new StringField(this, 300) {
    override def shouldDisplay_? = false
  }

  @Column(name="NOMBRE_CIUDAD")
  lazy val cityName = new StringField(this, 50) {
    override def shouldDisplay_? = false
  }

  @Column(name="ESTADO")
  lazy val status = new StringField(this, 50) {
    override def shouldDisplay_? = false
  }

  @Column(name="ANO_PRODUCCION")
  lazy val prodYear = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="LEIDO_ADMIN")
  lazy val isAdminReaded = new BooleanField(this, false)

  @Column(name="LEIDO_COORDINADOR")
  lazy val isCoordReaded = new BooleanField(this, false)

  @Column(name="LEIDO_USUARIO")
  lazy val isUserReaded = new BooleanField(this, false)

  @Transient
  lazy val activity = DbSchema.activities.where(_.proposalId === id).headOption getOrElse Activity.createRecord

  def areaName = DbSchema.areas.where(_.idField === areaId).headOption.map(_.name.get) getOrElse ""

}

object Proposal extends Proposal with MetaRecord[Proposal]
