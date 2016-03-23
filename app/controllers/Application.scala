package controllers

import models.Artist
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Redirect(routes.Application.listArtist)
  }

  def listArtist = Action {
    Ok(views.html.home(Artist.fetch))
  }

  def fetchArtistByName(name: String) = Action{
    Ok(views.html.home(Artist.fetchByName(name)))
  }

  def search(name: String, country: String) = Action {
    val artists = Artist.fetchByNameOrCountry(name, country)
    if(artists.isEmpty){
      NoContent
    }
    else{
      Ok(views.html.home(artists))
    }
  }

  def search2(name: Option[String], country: String) = Action {
    val result = name match{
      case Some(n) => Artist.fetchByNameOrCountry(n, country)
      case None => Artist.fetchByCountry(country)
    }
    if(result.isEmpty){
      NoContent
    }
    else {
      Ok(views.html.home(result))
    }
  }


}
