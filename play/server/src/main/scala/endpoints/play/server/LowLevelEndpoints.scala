package endpoints.play.server

import endpoints.algebra
import play.api.mvc
import play.api.mvc._

trait LowLevelEndpoints extends algebra.LowLevelEndpoints with Endpoints {

  import playComponents.executionContext

  /** Represents a request entity as a Play `Request[AnyContent]` */
  type RawRequestEntity = mvc.Request[AnyContent]

  lazy val rawRequestEntity: BodyParser[mvc.Request[AnyContent]] =
    BodyParser { requestHeader =>
      val accumulator =
        playComponents.playBodyParsers.anyContent.apply(requestHeader)
      accumulator.map(_.right.map(anyContent => Request(requestHeader, anyContent)))
    }

  /** An HTTP response is a Play `Result` */
  type RawResponseEntity = Result

  lazy val rawResponseEntity: Result => Result = identity

}
