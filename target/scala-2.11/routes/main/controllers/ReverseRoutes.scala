
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/Workspace/HoliduSearchChallenge/holidu-search-challenge/conf/routes
// @DATE:Sat Dec 16 23:28:52 CET 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers {

  // @LINE:5
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def findById(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "apartments/" + implicitly[PathBindable[Long]].unbind("id", id))
    }
  
    // @LINE:7
    def list(fn:String = "", ff:String = "", ft:String = ""): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "apartments" + queryString(List(if(fn == "") None else Some(implicitly[QueryStringBindable[String]].unbind("fn", fn)), if(ff == "") None else Some(implicitly[QueryStringBindable[String]].unbind("ff", ff)), if(ft == "") None else Some(implicitly[QueryStringBindable[String]].unbind("ft", ft)))))
    }
  
    // @LINE:5
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
  }

  // @LINE:16
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def at(file:String): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:10
  class ReverseSampleController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def post(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "sample")
    }
  
    // @LINE:11
    def search(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "sample/search")
    }
  
    // @LINE:12
    def getById(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "sample/" + implicitly[PathBindable[Long]].unbind("id", id))
    }
  
    // @LINE:10
    def index(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "sample/index/" + implicitly[PathBindable[Long]].unbind("id", id))
    }
  
  }


}
