package com.authentication.service

/**
 * Created by prayagupd
 * on 11/27/15.
 */

class LogonService {

  def isValidUser(username: Array[String], password: Array[String]) = {
    println("isValidUser " + (username(0).equals("user") && password(0).equals("pass")))
    username(0).equals("user") && password(0).equals("pass")
  }

}
