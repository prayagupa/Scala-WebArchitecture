package com.authentication.controller

import java.io.PrintWriter
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

import com.authentication.service.LogonService

class LogonServlet extends HttpServlet {

  val logonService = new LogonService

  @throws[Exception]
  override def doGet(request: HttpServletRequest, response: HttpServletResponse){
    val out : PrintWriter = response.getWriter
    out.println("<html>")
    out.println("<body>")

    if(hasParams(request)) {
      if(logonService.isValidUser(request.getParameterMap.get("username"), request.getParameterMap.get("password"))) {
        println("valid user.")
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

  def hasParams(request: HttpServletRequest) : Boolean = {
    println("hasParams " + (request.getParameterMap.containsKey("username") && request.getParameterMap.containsKey("password")))
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
