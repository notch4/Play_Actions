package models

/**
  * Created by yubraj on 3/22/16.
  */

case class Artist(name: String, country: String)

object Artist{

  def artilstList = Seq(
      Artist("Yubraj Pokharel", "Nepal"),
      Artist("Sudhan Pokharel", "Nepal"),
      Artist("Steven Wilson", "United Kingdom"),
      Artist("Jared Leto", "United State of America"),
      Artist("Led Zepplin", "United Kingdom"),
      Artist("Nabin K. Bhattarai", "Nepal"),
      Artist("Pink Floyd", "United Kingdom"),
      Artist("Yubraj Pokharel", "Nepal"),
      Artist("Muse", "United Kingdom"),
      Artist("Sigor rious", "Sweden")
  )

  def fetch: Seq[Artist] = {
    artilstList
  }

  def fetchByName(name: String): Seq[Artist] = {
    artilstList.filter(a => a.name.contains(name))
  }

  def fetchByCountry(country: String): Seq[Artist] = {
    artilstList.filter(a=>a.country == country)
  }

  def fetchByNameAndCountry(name: String, country: String): Seq[Artist] = {
    artilstList.filter(a => a.name.contains(name) && a.country == country)
  }

  def fetchByNameOrCountry(name: String, country: String): Seq[Artist] = {
    artilstList.filter(a => a.name.contains(name) || a.country == country)
  }

}
