package controllers

import play.api.mvc.{Action, Controller}

class HealthController extends Controller {

  def ping = Action { Ok("pong") }
}

