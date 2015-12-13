package com.prediction.controller

import java.io.PrintWriter
import javax.servlet.annotation.WebServlet
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

import com.prediction.service.PredictService

@WebServlet(name="home", urlPatterns = Array("/") )
class ApplicationServlet extends HttpServlet {

  @throws[Exception]
  override def doGet(request: HttpServletRequest, response: HttpServletResponse){
    request.getRequestDispatcher("/index.jsp").forward(request, response)
  }
}
