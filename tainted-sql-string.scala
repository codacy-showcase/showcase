package com.test.test

import java.sql.{Connection, ResultSet, DriverManager}
import org.slf4j.LoggerFactory

object Smth {

  def call(name: String) = {
    // ruleid: tainted-sql-string
    val sql = s"SELECT * FROM table WHERE name = ${name + "smth"};"
    val conn = DriverManager.getConnection("jdbc:mysql://localhost:8080", "guest", "password")
    val stmt = conn.createStatement()
    val rs = stmt.execute(sql)
    rs
  }

  def loggingCall(name: String) = {
    val scribe = LoggerFactory.getLogger(getClass.getSimpleName)
    scribe.warnToError("Create user" + name)
  }
  
}