package com.pseudononymous.session.controller

import java.io.PrintWriter
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse, HttpSession}

import com.pseudononymous.session.domain.Person
import com.pseudononymous.session.service.MemcachedService

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

class ListDatabaseServlet extends HttpServlet {

   val database = new MemcachedService

   @throws[Exception]
   override def doGet(request: HttpServletRequest, response: HttpServletResponse) {
     val out : PrintWriter = response.getWriter
     listData(request.getSession(false), out)
   }


   def jsp(database: HttpSession, out: PrintWriter): Unit ={
     out.println("<html>\n" +
       "<body>\n")

     list(database, out)
     add(out)

     out.print("</body>\n" +
       "</html>")
   }

   def list(database: HttpSession, out : PrintWriter) = {

     out.println(
       "<form method=POST action=add>\n" +
         "<input type=submit value='LIST'>\n" +
         "</form>")
   }

   def add(out: PrintWriter) = {
     out.println("<html>\n" +
       "<body>\n" +
       "<form method=POST action=add>\n" +
       "Key  <input type=text name=key> <br>\n" +
       "Firstname <input type=text name=firstname> <br>\n" +
       "Lastname <input type=text name=lastname>\n" +
       "<input type=submit value='ADD'>\n" +
       "</form>\n")
   }

   def listData(database: HttpSession, out : PrintWriter) = {

     out.println("<html>\n" +
       "<body>\n")
     var rows = ""
     database.getAttributeNames.foreach { (key: String) =>
       val row : Person = database.getAttribute(key).asInstanceOf[Person]
       val uiRow = s"<tr><td>${row.key}</td><td>${row.firstName}</td></tr>\n"
       rows+=uiRow
     }
     out.println(
       s"<table>\n" +
         s"${rows}\n" +
         "</table>")

     out.print("</body>\n" +
       "</html>")
   }
 }
