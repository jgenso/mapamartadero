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

  @Column(name="ID_ACTIVIDAD")
  override lazy val idField = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="ID_ARTISTA")
  lazy val artistId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="ID_AMBIENTE")
  lazy val ambientId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="ID_TIPOACTIVIDAD")
  lazy val activityTypeId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="ID_PROPPUESTA")
  lazy val proposalId = new LongField(this, 0L) {
    override def shouldDisplay_? = false
  }

  @Column(name="NOMBRE_ACTIVIDAD")
  lazy val name = new StringField(this, 200)

  @Column(name="HORA_ACTIVIDAD")
  lazy val hour = new StringField(this, 250)

  @Column(name="COSTO_ACTIVIDAD")
  lazy val cost = new StringField(this, 300)

  @Column(name="BREVE_ACTIVIDAD")
  lazy val breve = new StringField(this, 10000)

  @Column(name="DETALLE_ACTIVIDAD")
  lazy val detail = new StringField(this, 10000)

  @Column(name="IMAGEN_ACTIVIDAD")
  lazy val image = new StringField(this, 100)

}

object Activity extends Activity with MetaRecord[Activity]