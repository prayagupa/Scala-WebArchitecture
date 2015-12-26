package com.prediction.controller

import java.io.PrintWriter
import javax.annotation.Resource
import javax.servlet.annotation.WebServlet
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

import com.prediction.service.PredictService

@WebServlet(name="guess", urlPatterns = Array("/guess") )
class PredictServlet extends HttpServlet {

  //@Resource
  val predictService : PredictService = new PredictService

  @throws[Exception]
  override def doGet(request: HttpServletRequest, response: HttpServletResponse){

    val randomValue = predictService.random()
    val session = request.getSession(true)
    session.setAttribute("value", randomValue)

    println(s"dreams to mountain ${randomValue} on each request/refresh")

    request.getRequestDispatcher("/views/predict.jsp").forward(request, response)
  }

  @throws[Exception]
  override def doPost(request: HttpServletRequest, response: HttpServletResponse) {
    val number = request.getParameter("guess").toInt
    val value = request.getSession(false).getAttribute("value").toString.toInt
    val message = predictService.checkPrediction(number, value)
    request.setAttribute("message", message)
    request.setAttribute("header", "Result")
    request.getRequestDispatcher("/views/result.jsp").forward(request, response)
  }
}
