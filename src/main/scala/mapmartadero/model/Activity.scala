package mapmartadero.model

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

class Activity private() extends Record[Activity] with KeyedRecord[Long] {
  override def meta: MetaRecord[Activity] = Activity

  @Column(name="id_actividad")
  override lazy val idField = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="id_artista")
  lazy val artistId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="id_ambiente")
  lazy val ambientId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="id_tipoactividad")
  lazy val activityTypeId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="id_prppuesta")
  lazy val proposalId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="nombre_actividad")
  lazy val name = new StringField(this, 200)

  @Column(name="hora_actividad")
  lazy val hour = new StringField(this, 250)

  @Column(name="costo_actividad")
  lazy val cost = new StringField(this, 300)

  @Column(name="breve_actividad")
  lazy val breve = new StringField(this, 10000)

  @Column(name="detalle_actividad")
  lazy val detail = new StringField(this, 10000)

  @Column(name="imagen_actividad")
  lazy val image = new StringField(this, 100)

}

object Activity extends Activity with MetaRecord[Activity]