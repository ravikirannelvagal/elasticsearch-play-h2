
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
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

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.17*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
    <head>
        <title>Apartments database</title>
        """),format.raw/*13.47*/("""
        """),format.raw/*14.9*/("""<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(/*14.70*/routes/*14.76*/.Assets.at("stylesheets/bootstrap.min.css")),format.raw/*14.119*/("""">

        <link rel="stylesheet" media="screen" href=""""),_display_(/*16.54*/routes/*16.60*/.Assets.at("stylesheets/main.css")),format.raw/*16.94*/(""""/>
    </head>
    <body>

        <header class="topbar">
            <h1 class="fill">
                <a href=""""),_display_(/*22.27*/routes/*22.33*/.HomeController.index()),format.raw/*22.56*/("""">
                    Play sample application &mdash; Apartments database
                </a>
            </h1>
        </header>

        <section id="main">
        """),_display_(/*29.10*/content),format.raw/*29.17*/("""
        """),format.raw/*30.9*/("""</section>

    </body>
</html>
"""))
      }
    }
  }

  def render(content:Html): play.twirl.api.HtmlFormat.Appendable = apply(content)

  def f:((Html) => play.twirl.api.HtmlFormat.Appendable) = (content) => apply(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Sat Dec 16 15:28:27 CET 2017
                  SOURCE: D:/Workspace/HoliduSearchChallenge/holidu-search-challenge/app/views/main.scala.html
                  HASH: 1a857cfd529d4a01823a144962754d076a4eb261
                  MATRIX: 741->1|851->16|881->20|998->606|1035->616|1123->677|1138->683|1203->726|1289->785|1304->791|1359->825|1508->947|1523->953|1567->976|1771->1153|1799->1160|1836->1170
                  LINES: 27->1|32->1|34->3|38->13|39->14|39->14|39->14|39->14|41->16|41->16|41->16|47->22|47->22|47->22|54->29|54->29|55->30
                  -- GENERATED --
              */
          