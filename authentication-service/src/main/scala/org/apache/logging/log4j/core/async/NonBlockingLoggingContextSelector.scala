package org.apache.logging.log4j.core.async

import java.net.URI

import org.apache.logging.log4j.core.LoggerContext
import org.apache.logging.log4j.core.util.Constants
import org.apache.logging.log4j.util.PropertiesUtil

/**
  * Created by prayagupd
  * on 12/22/16.
  */

class NonBlockingLoggingContextSelector extends AsyncLoggerContextSelector {

  def isSelected: Boolean = {
    val nonBlockingIsSelected = classOf[NonBlockingLoggingContextSelector].getName ==
      PropertiesUtil.getProperties.getStringProperty(Constants.LOG4J_CONTEXT_SELECTOR)
    println(s"nonBlockingIsSelected = $nonBlockingIsSelected")
    nonBlockingIsSelected
  }

  override protected def createContext(name: String, configLocation: URI): LoggerContext = {
    println(s"Creating Non blocking logging context for $name")
    new AsyncLoggerContext(name, null, configLocation)
  }

  override protected def toContextMapKey(loader: ClassLoader): String = {
    "AsyncContext@" + Integer.toHexString(System.identityHashCode(loader))
  }

  override protected def defaultContextName: String = "DefaultAsyncContext@" + Thread.currentThread.getName
}
