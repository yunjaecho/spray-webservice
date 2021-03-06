package com.yunjae.spray.quiz

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.util.Timeout
import com.typesafe.config.ConfigFactory
import com.yunjae.spray.quiz.magement.RestInterface
import spray.can.Http

/**
  * Created by USER on 2018-03-08.
  */
object ApplicationMain extends App {

  val config = ConfigFactory.load();
  val host = config.getString("http.host")
  val port = config.getInt("http.port")

  implicit val system = ActorSystem("SprayWebservice")

  val api = system.actorOf(Props(new RestInterface()), "httpInterface")

  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(10 seconds)

  IO(Http).ask(Http.Bind(listener = api, interface = host, port = port))
    .mapTo[Http.Event]
    .map {
      case Http.Bound(address) =>
        println(s"REST interface bound to $address")
      case Http.CommandFailed(cmd) =>
        println("REST interface could not bind to " +
          s"$host:$port, ${cmd.failureMessage}")
        system.shutdown()
    }

}
