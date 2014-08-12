package mapmartadero
package config

import net.liftweb._
import common._
import http._
import json._
import util.Props
import net.liftweb.squerylrecord.RecordTypeMode
import RecordTypeMode._
import java.sql.DriverManager
import org.squeryl.{Schema, Table}
import model._
import org.squeryl.adapters.MySQLInnoDBAdapter

object SquerylConfig extends Factory with Loggable {

  private def initMysql(schema: () => Schema*) {
    Class.forName("com.mysql.jdbc.Driver")
    import org.squeryl.adapters.H2Adapter
    import net.liftweb.squerylrecord.SquerylRecord
    import org.squeryl.Session
    def connection = DriverManager.getConnection(
      Props.get("db.url", "jdbc:mysql://localhost/gobernacioncbba"),
      Props.get("db.user", "root"),
      Props.get("db.password", "mysql"))

    SquerylRecord.initWithSquerylSession(Session.create(connection, new MySQLInnoDBAdapter))
    inTransaction {
      try {
        schema.map(s => {
          s().create
          s().printDdl
        })
      } catch {
        case e: Throwable => e.printStackTrace()
        throw e;
      }
    }
    LiftRules.liftRequest.append({
        case Req("console" ::_, _, _) => false
      })
  }

  def init = {
    initMysql(() => DbSchema)
  }
}

