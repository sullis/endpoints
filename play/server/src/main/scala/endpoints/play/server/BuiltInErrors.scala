package endpoints.play.server

import endpoints.algebra.InvalidCodec.invalidCodec
import endpoints.{Invalid, algebra}
import play.api.http.{ContentTypes, Writeable}

trait BuiltInErrors extends algebra.BuiltInErrors { this: EndpointsWithCustomErrors =>

  def clientErrorsResponseEntity: ResponseEntity[Invalid] = {
    val playCodec = implicitly[play.api.mvc.Codec]
    Writeable(invalid => playCodec.encode(invalidCodec.encode(invalid)), Some(ContentTypes.JSON))
  }

  def serverErrorResponseEntity: ResponseEntity[Throwable] =
    clientErrorsResponseEntity.map(throwable => Invalid(throwable.getMessage))

}
