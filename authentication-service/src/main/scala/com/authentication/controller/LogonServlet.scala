package com.authentication.controller

import java.util
import java.io.PrintWriter
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

import com.authentication.service.LogonService
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.core.config.ConfigurationException
import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration

import scala.io.Source

class LogonServlet extends HttpServlet {

  val logonService = new LogonService

  initProperties()

  def initProperties() {
    Source.fromFile("src/main/resources/app.conf").getLines().foreach(kv => {
      val key: String = kv.split("=")(0)
      val value: String = kv.split("=")(1)
      println("Setting system property " + key + "=" + value)
      System.setProperty(key, value)
    })
  }

  val logger = LogManager.getLogger(classOf[LogonServlet])

  @throws[Exception]
  override def doGet(request: HttpServletRequest, response: HttpServletResponse) {
    val out: PrintWriter = response.getWriter
    out.println("<html>")
    out.println("<body>")

    if (hasParams(request)) {
      if (logonService.isValidUser(request.getParameterMap.get("username"), request.getParameterMap.get("password"))) {
        logger.info("valid user.")
        out.println("Welcome user")
      } else {
        out.println("Wrong user id or password.")
        form(out)
      }
    } else {
      form(out)
    }
    out.println("</body>")
    out.println("</html>")
    out.close()
  }

  def hasParams(request: HttpServletRequest): Boolean = {
    logger.info("hasParams " + (request.getParameterMap.containsKey("username") && request.getParameterMap.containsKey("password")))
    request.getParameterMap.containsKey("username") && request.getParameterMap.containsKey("password")
  }

  def form(out: PrintWriter) = {
    out.println("<form method=GET action=LogonServlet>")
    out.println("Username=<input type=text name=username> <br>")
    out.println("Password=<input type=text name=password>")
    out.println("<input type=submit value='Logon'>")
    out.println("</form>")
  }
}
