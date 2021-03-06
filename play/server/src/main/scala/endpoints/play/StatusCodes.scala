package endpoints.play.server

import endpoints.algebra

import play.api.mvc.Results

trait StatusCodes extends algebra.StatusCodes {

  type StatusCode = Results.Status

  def OK = Results.Ok
  def Created = Results.Created
  def Accepted = Results.Accepted
  def NoContent = Results.Status(204)

  def BadRequest = Results.BadRequest
  def Unauthorized = Results.Unauthorized
  def Forbidden = Results.Forbidden
  def NotFound = Results.NotFound

  def InternalServerError = Results.InternalServerError
  def NotImplemented = Results.NotImplemented

}
