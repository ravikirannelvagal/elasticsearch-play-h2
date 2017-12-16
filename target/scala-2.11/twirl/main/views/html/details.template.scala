
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object details_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class details extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Long,Apartment,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: Long, apartment: Apartment):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*6.2*/home/*6.6*/() = {{
    // Generate the link
    routes.HomeController.index()

}};
Seq[Any](format.raw/*1.34*/("""

"""),format.raw/*5.42*/("""
"""),format.raw/*10.2*/("""

"""),_display_(/*12.2*/main/*12.6*/ {_display_(Seq[Any](format.raw/*12.8*/("""
    """),format.raw/*13.5*/("""<h1>Apartment Details</h1>

    <table class="apartments zebra-striped">
        <tr>
            <td>Apartment Name</td>
            <td>"""),_display_(/*18.18*/apartment/*18.27*/.getName),format.raw/*18.35*/("""</td>
        </tr>
        <tr>
            <td>Apartment Type</td>
            <td>"""),_display_(/*22.18*/apartment/*22.27*/.getApartmentType.getName),format.raw/*22.52*/("""</td>
        </tr>
        <tr>
            <td>Latitude</td>
            <td>"""),_display_(/*26.18*/apartment/*26.27*/.getLatitude),format.raw/*26.39*/("""</td>
        </tr>
        <tr>
            <td>Longitude</td>
            <td>"""),_display_(/*30.18*/apartment/*30.27*/.getLongitude),format.raw/*30.40*/("""</td>
        </tr>
        <tr>
            <td>Facilities</td>
            <td>"""),_display_(/*34.18*/apartment/*34.27*/.getFacilitiesToString),format.raw/*34.49*/("""</td>
        </tr>
    </table>

    <a href=""""),_display_(/*38.15*/routes/*38.21*/.HomeController.index()),format.raw/*38.44*/("""" name="home">Home</a>
""")))}))
      }
    }
  }

  def render(id:Long,apartment:Apartment): play.twirl.api.HtmlFormat.Appendable = apply(id,apartment)

  def f:((Long,Apartment) => play.twirl.api.HtmlFormat.Appendable) = (id,apartment) => apply(id,apartment)

  def ref: this.type = this

}


}

/**/
object details extends details_Scope0.details
              /*
                  -- GENERATED --
                  DATE: Sat Dec 16 18:47:27 CET 2017
                  SOURCE: D:/Workspace/HoliduSearchChallenge/holidu-search-challenge/app/views/details.scala.html
                  HASH: 02c2666385fb6acceed086f6cdba6abf4c00f6cb
                  MATRIX: 757->1|867->167|878->171|981->33|1012->164|1041->244|1072->249|1084->253|1123->255|1156->261|1327->405|1345->414|1374->422|1491->512|1509->521|1555->546|1666->630|1684->639|1717->651|1829->736|1847->745|1881->758|1994->844|2012->853|2055->875|2134->927|2149->933|2193->956
                  LINES: 27->1|31->6|31->6|36->1|38->5|39->10|41->12|41->12|41->12|42->13|47->18|47->18|47->18|51->22|51->22|51->22|55->26|55->26|55->26|59->30|59->30|59->30|63->34|63->34|63->34|67->38|67->38|67->38
                  -- GENERATED --
              */
          