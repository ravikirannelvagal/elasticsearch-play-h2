
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/Workspace/HoliduSearchChallenge/holidu-search-challenge/conf/routes
// @DATE:Sat Dec 16 23:28:52 CET 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  HomeController_0: controllers.HomeController,
  // @LINE:10
  SampleController_2: controllers.SampleController,
  // @LINE:16
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    HomeController_0: controllers.HomeController,
    // @LINE:10
    SampleController_2: controllers.SampleController,
    // @LINE:16
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, SampleController_2, Assets_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, SampleController_2, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """apartments""", """controllers.HomeController.list(fn:String ?= "", ff:String ?= "", ft:String ?= "")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """apartments/""" + "$" + """id<[^/]+>""", """controllers.HomeController.findById(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sample/index/""" + "$" + """id<[^/]+>""", """controllers.SampleController.index(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sample/search""", """controllers.SampleController.search()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sample/""" + "$" + """id<[^/]+>""", """controllers.SampleController.getById(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sample""", """controllers.SampleController.post()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_list1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("apartments")))
  )
  private[this] lazy val controllers_HomeController_list1_invoker = createInvoker(
    HomeController_0.list(fakeValue[String], fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "list",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """apartments"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_findById2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("apartments/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_findById2_invoker = createInvoker(
    HomeController_0.findById(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "findById",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """apartments/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_SampleController_index3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sample/index/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SampleController_index3_invoker = createInvoker(
    SampleController_2.index(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SampleController",
      "index",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """sample/index/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_SampleController_search4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sample/search")))
  )
  private[this] lazy val controllers_SampleController_search4_invoker = createInvoker(
    SampleController_2.search(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SampleController",
      "search",
      Nil,
      "GET",
      """""",
      this.prefix + """sample/search"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_SampleController_getById5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sample/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SampleController_getById5_invoker = createInvoker(
    SampleController_2.getById(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SampleController",
      "getById",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """sample/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_SampleController_post6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sample")))
  )
  private[this] lazy val controllers_SampleController_post6_invoker = createInvoker(
    SampleController_2.post(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SampleController",
      "post",
      Nil,
      "POST",
      """""",
      this.prefix + """sample"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_Assets_at7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at7_invoker = createInvoker(
    Assets_1.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Add more routes as you require below""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index())
      }
  
    // @LINE:7
    case controllers_HomeController_list1_route(params) =>
      call(params.fromQuery[String]("fn", Some("")), params.fromQuery[String]("ff", Some("")), params.fromQuery[String]("ft", Some(""))) { (fn, ff, ft) =>
        controllers_HomeController_list1_invoker.call(HomeController_0.list(fn, ff, ft))
      }
  
    // @LINE:8
    case controllers_HomeController_findById2_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_HomeController_findById2_invoker.call(HomeController_0.findById(id))
      }
  
    // @LINE:10
    case controllers_SampleController_index3_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_SampleController_index3_invoker.call(SampleController_2.index(id))
      }
  
    // @LINE:11
    case controllers_SampleController_search4_route(params) =>
      call { 
        controllers_SampleController_search4_invoker.call(SampleController_2.search())
      }
  
    // @LINE:12
    case controllers_SampleController_getById5_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_SampleController_getById5_invoker.call(SampleController_2.getById(id))
      }
  
    // @LINE:13
    case controllers_SampleController_post6_route(params) =>
      call { 
        controllers_SampleController_post6_invoker.call(SampleController_2.post())
      }
  
    // @LINE:16
    case controllers_Assets_at7_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at7_invoker.call(Assets_1.at(path, file))
      }
  }
}
