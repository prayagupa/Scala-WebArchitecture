package com.pseudononymous.session.controller

import java.io.PrintWriter
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

import com.pseudononymous.session.service.MemcachedService

class ApplicationServlet extends HttpServlet {

  @throws[Exception]
  override def doGet(request: HttpServletRequest, response: HttpServletResponse){
    val out : PrintWriter = response.getWriter
    jsp(out)
    out.close()
  }

  def jsp(out: PrintWriter): Unit ={
    out.println("<html>\n" +
      "<body>\n")

    list(out)
    add(out)
    remove(out)

    out.print("</body>\n" +
      "</html>")
  }

  def list(out: PrintWriter) = {

    out.println(
      "<form method=POST action=add>\n" +
      "<input type=submit value='LIST'>\n" +
      "</form>")
  }


  def add(out: PrintWriter) = {
    out.print("<h2>Add person</h2>")
    out.println("<html>\n" +
      "<body>\n" +
      "<form method=POST action=add>\n" +
      "Key  <input type=text name=key> <br>\n" +
      "Firstname <input type=text name=firstname> <br>\n" +
      "Lastname <input type=text name=lastname>\n" +
      "<input type=submit value='ADD'>\n" +
      "</form>\n")
  }

  def remove(out : PrintWriter) = {
    out.print("<h2>Remove person</h2>")
    out.println(
      "<form method=POST action=remove>\n" +
        "Key  <input type=text name=key> <br>\n" +
        "<input type=submit value='REMOVE'>\n" +
        "</form>")
  }
}
