
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object list_Scope0 {
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

class list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[java.util.List[Apartment],String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(currentPage: java.util.List[Apartment], nameFilter: String, facFilter: String, typeFilter: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*16.2*/header/*16.8*/(title:String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*16.26*/("""
    """),format.raw/*17.5*/("""<th class="header">
        <a href=""""),_display_(/*18.19*/link()),format.raw/*18.25*/("""">"""),_display_(/*18.28*/title),format.raw/*18.33*/("""</a>
    </th>
""")))};def /*7.2*/link/*7.6*/() = {{
    // Generate the link
    routes.HomeController.list(nameFilter,facFilter,typeFilter)

}};
Seq[Any](format.raw/*1.101*/("""


"""),format.raw/*6.42*/("""
"""),format.raw/*11.2*/("""

"""),format.raw/*15.36*/("""
"""),format.raw/*20.2*/("""

"""),_display_(/*22.2*/main/*22.6*/ {_display_(Seq[Any](format.raw/*22.8*/("""

    """),format.raw/*24.5*/("""<h1 id="homeTitle">"""),_display_(/*24.25*/Messages("apartments.list.title", currentPage.size())),format.raw/*24.78*/("""</h1>


    """),_display_(/*27.6*/if(flash.containsKey("success"))/*27.38*/ {_display_(Seq[Any](format.raw/*27.40*/("""
        """),format.raw/*28.9*/("""<div class="alert-message warning">
            <strong>Done!</strong> """),_display_(/*29.37*/flash/*29.42*/.get("success")),format.raw/*29.57*/("""
        """),format.raw/*30.9*/("""</div>
    """)))}),format.raw/*31.6*/("""

    """),format.raw/*33.5*/("""<div id="actions">

        <form action=""""),_display_(/*35.24*/link()),format.raw/*35.30*/("""" method="GET">
                Name: <input type="search" id="nameSearchBox" name="fn" value=""""),_display_(/*36.81*/nameFilter),format.raw/*36.91*/("""" placeholder="Filter by apartment name...">
                <br />
                Type:<input type="search" id="typeSearchBox" name="ft" value=""""),_display_(/*38.80*/typeFilter),format.raw/*38.90*/("""" placeholder="Filter by apartment type...">
                <br />
                Facility:<input type="search" id="facSearchBox" name="ff" value=""""),_display_(/*40.83*/facFilter),format.raw/*40.92*/("""" placeholder="Filter by facilities...">
                <br />
                <input type="submit" id="searchsubmit" value="Filter" class="btn primary">
        </form>

    </div>

    """),_display_(/*47.6*/if(currentPage.size() == 0)/*47.33*/ {_display_(Seq[Any](format.raw/*47.35*/("""

        """),format.raw/*49.9*/("""<div class="well">
            <em>Nothing to display</em>
        </div>

    """)))}/*53.7*/else/*53.12*/{_display_(Seq[Any](format.raw/*53.13*/("""

        """),format.raw/*55.9*/("""<table class="apartments zebra-striped">
            <thead>
                <tr>
                    """),_display_(/*58.22*/header("Apartment name")),format.raw/*58.46*/("""
                    """),_display_(/*59.22*/header("Apartment Type")),format.raw/*59.46*/("""
                    """),_display_(/*60.22*/header("Latitude")),format.raw/*60.40*/("""
                    """),_display_(/*61.22*/header("Longitude")),format.raw/*61.41*/("""
                    """),_display_(/*62.22*/header("Facilities")),format.raw/*62.42*/("""
                """),format.raw/*63.17*/("""</tr>
            </thead>
            <tbody>

                """),_display_(/*67.18*/for(apartment <- currentPage) yield /*67.47*/ {_display_(Seq[Any](format.raw/*67.49*/("""
                    """),format.raw/*68.21*/("""<tr>
                        <td><a href=""""),_display_(/*69.39*/routes/*69.45*/.HomeController.findById(apartment.id)),format.raw/*69.83*/("""">"""),_display_(/*69.86*/apartment/*69.95*/.getName),format.raw/*69.103*/("""</a></td>

                        <td>
                            """),_display_(/*72.30*/apartment/*72.39*/.getApartmentType.getName),format.raw/*72.64*/("""

                        """),format.raw/*74.25*/("""</td>
                        <td>
                            """),_display_(/*76.30*/apartment/*76.39*/.getLatitude),format.raw/*76.51*/("""
                        """),format.raw/*77.25*/("""</td>
                        <td>
                            """),_display_(/*79.30*/apartment/*79.39*/.getLongitude),format.raw/*79.52*/("""
                        """),format.raw/*80.25*/("""</td>
                        <td>
                            """),_display_(/*82.30*/apartment/*82.39*/.getFacilitiesToString),format.raw/*82.61*/("""
                        """),format.raw/*83.25*/("""</td>
                    </tr>
                """)))}),format.raw/*85.18*/("""

            """),format.raw/*87.13*/("""</tbody>
        </table>

    """)))}),format.raw/*90.6*/("""

""")))}),format.raw/*92.2*/("""

"""))
      }
    }
  }

  def render(currentPage:java.util.List[Apartment],nameFilter:String,facFilter:String,typeFilter:String): play.twirl.api.HtmlFormat.Appendable = apply(currentPage,nameFilter,facFilter,typeFilter)

  def f:((java.util.List[Apartment],String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentPage,nameFilter,facFilter,typeFilter) => apply(currentPage,nameFilter,facFilter,typeFilter)

  def ref: this.type = this

}


}

/**/
object list extends list_Scope0.list
              /*
                  -- GENERATED --
                  DATE: Sun Dec 17 00:02:12 CET 2017
                  SOURCE: D:/Workspace/HoliduSearchChallenge/holidu-search-challenge/app/views/list.scala.html
                  HASH: b6b8e720f4fbfa76b68b088d6da64da9da3fc789
                  MATRIX: 783->1|961->458|975->464|1070->482|1103->488|1169->527|1196->533|1226->536|1252->541|1292->236|1303->240|1437->100|1470->233|1499->343|1531->455|1560->559|1591->564|1603->568|1642->570|1677->578|1724->598|1798->651|1840->667|1881->699|1921->701|1958->711|2058->784|2072->789|2108->804|2145->814|2188->827|2223->835|2295->880|2322->886|2446->983|2477->993|2653->1142|2684->1152|2863->1304|2893->1313|3115->1509|3151->1536|3191->1538|3230->1550|3332->1635|3345->1640|3384->1641|3423->1653|3556->1759|3601->1783|3651->1806|3696->1830|3746->1853|3785->1871|3835->1894|3875->1913|3925->1936|3966->1956|4012->1974|4108->2043|4153->2072|4193->2074|4243->2096|4314->2140|4329->2146|4388->2184|4418->2187|4436->2196|4466->2204|4565->2276|4583->2285|4629->2310|4685->2338|4778->2404|4796->2413|4829->2425|4883->2451|4976->2517|4994->2526|5028->2539|5082->2565|5175->2631|5193->2640|5236->2662|5290->2688|5372->2739|5416->2755|5481->2790|5516->2795
                  LINES: 27->1|31->16|31->16|33->16|34->17|35->18|35->18|35->18|35->18|37->7|37->7|42->1|45->6|46->11|48->15|49->20|51->22|51->22|51->22|53->24|53->24|53->24|56->27|56->27|56->27|57->28|58->29|58->29|58->29|59->30|60->31|62->33|64->35|64->35|65->36|65->36|67->38|67->38|69->40|69->40|76->47|76->47|76->47|78->49|82->53|82->53|82->53|84->55|87->58|87->58|88->59|88->59|89->60|89->60|90->61|90->61|91->62|91->62|92->63|96->67|96->67|96->67|97->68|98->69|98->69|98->69|98->69|98->69|98->69|101->72|101->72|101->72|103->74|105->76|105->76|105->76|106->77|108->79|108->79|108->79|109->80|111->82|111->82|111->82|112->83|114->85|116->87|119->90|121->92
                  -- GENERATED --
              */
          