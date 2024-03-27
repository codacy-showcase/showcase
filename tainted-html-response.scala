package controllers

import play.api._
import play.api.mvc.{Action, Controller}
import play.twirl.api.Html;

class XssController extends Controller {

  def vulnerable(value:String) = Action {
    Ok(views.html.xssHtml.render(Html.apply("Hello "+value+" !")))
  }

  def safeJson(value: String) = Action.async { implicit request: Request[AnyContent] =>
    Ok("Hello " + value + " !").as("text/json")
  }
}