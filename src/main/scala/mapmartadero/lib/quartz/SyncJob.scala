package mapmartadero
package lib
package quartz

import org.quartz.Job
import org.quartz.JobExecutionContext
import org.quartz.JobExecutionException
import net.liftweb.common.Logger
import model._
import com.foursquare.rogue.LiftRogue._
import org.joda.time.DateTime
import net.liftweb.mongodb.{DefaultMongoIdentifier, MongoDB}
import com.mongodb.gridfs.GridFS

class SyncJob extends Job with Logger {

  def execute(context: JobExecutionContext)= try {
    DataRetriever.updateData()
  } catch {
    case e: Exception => e.printStackTrace()
  }
}
