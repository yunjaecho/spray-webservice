import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import spray.routing.SimpleRoutingApp

/**
  * Created by USER on 2018-03-09.
  */
object TestMain extends App with SimpleRoutingApp {
  val config = ConfigFactory.load();
  val host = config.getString("http.host")
  val port = config.getInt("http.port")

  implicit val system = ActorSystem("SprayWebservice")

  case class Product(number: Int, name: String, price: BigDecimal)
  val products = List(
    Product(1, "A", BigDecimal("100")),
    Product(2, "B", BigDecimal("110")),
    Product(3, "C", BigDecimal("120"))
  )

  startServer(interface = host, port = port) {
    get {
      path("hello" / Rest ) { name => {
        complete {
          s"Hello! $name"
        }
      }
      }
    } ~
      get {
        path("product" / IntNumber / "info") { productNumber => {
          complete {
            //products.find(_.number == productNumber).getOrElse("Not found")
            products.find(_.number == productNumber).fold("Not found")(_.toString)
          }
        }
        }
      } ~
      post {
        path("tell") {
          parameter('id.as[Int], 'name?) {(id, name) =>
          {
            complete {
              s"ID: $id and name is ${name.getOrElse("Unknown")}"
            }
          }
          }
        }
      }
  }
}
