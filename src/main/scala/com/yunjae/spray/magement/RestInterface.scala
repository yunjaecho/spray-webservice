package com.yunjae.spray.magement

import akka.actor.{Actor, ActorLogging}
import akka.util.Timeout
import com.yunjae.spray.magement.QuizProtocol.Quiz
import spray.routing.{HttpService, HttpServiceActor}

/**
  * Created by USER on 2018-03-08.
  */
class RestInterface extends HttpServiceActor with RestApi{
  override def receive: Receive = ???
}


trait RestApi extends HttpService with ActorLogging {
  actor: Actor => {
    implicit val timeout = Timeout(10 seconds)
    var quizzes = Vector[Quiz]()
  }

}