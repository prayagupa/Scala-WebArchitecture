package com.pseudononymous.session.controller

import com.pseudononymous.session.domain.Person

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import java.io.PrintWriter
import javax.servlet.http.{HttpSession, HttpServlet, HttpServletRequest, HttpServletResponse}

import com.pseudononymous.session.service.MemcachedService

class AddToDatabaseServlet extends HttpServlet {

  val database = new MemcachedService

  @throws[Exception]
  override def doPost(request: HttpServletRequest, response: HttpServletResponse) {
    val out : PrintWriter = response.getWriter

    var key = ""
    var fname = ""
    var lname = ""

    val params = request.getParameterMap.asScala
    params.foreach { case (entry: String, val1: Array[String]) =>
      entry match {
        case "key" => key = val1(0)
        case "firstname" => fname = val1(0)
        case "lastname" => lname = val1(0)
        case _ => println()
      }
    }
    println(s"sesion exists = ${request.getSession(false)}")
    database.add(request, new Person(key, fname, lname))

    //response.sendRedirect("list.jsp")
    jsp(request.getSession(false), out)
  }


  def jsp(database: HttpSession, out: PrintWriter): Unit ={
    out.println("<html>\n" +
      "<body>\n")

    listData(database, out)
    list(out)
    add(out)
    remove(out)

    out.print("</body>\n" +
      "</html>")
  }

  def list(out : PrintWriter) = {

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

  def listData(database: HttpSession, out : PrintWriter) = {
//
//    out.println("<html>\n" +
//      "<body>\n")
    out.print("<h2>Persons</h2>")
    var rows = ""
    database.getAttributeNames.foreach { (key: String) =>
      val row : Person = database.getAttribute(key).asInstanceOf[Person]
      val uiRow = s"<tr><td>${row.key}</td><td>${row.firstName}</td><td>${row.lastName}</td></tr>\n"
      rows+=uiRow
    }

    out.println(
      s"<table>\n" +
        s"${rows}\n" +
        "</table>")

//    out.print("</body>\n" +
//      "</html>")
  }
}
