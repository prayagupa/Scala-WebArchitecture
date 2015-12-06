package com.pseudononymous.session.service

import javax.servlet.http.{HttpSession, HttpServletRequest}

import com.pseudononymous.session.domain.Person

/**
 * Created by prayagupd
 * on 11/27/15.
 */

class MemcachedService {

  var database : HttpSession = null

  def remove(request: HttpServletRequest, key: String) : HttpSession = {
    database = request.getSession
    database.removeAttribute(key)
    println(s"Removed ${key} to key value database.")
    database
  }

  def add(request : HttpServletRequest, person: Person) : HttpSession = {
      database = request.getSession
      println(s"Saving ${person.firstName} to key value database.")
      database.setAttribute(person.key, person)
      database
  }
}
