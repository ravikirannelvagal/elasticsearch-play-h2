
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/Workspace/HoliduSearchChallenge/holidu-search-challenge/conf/routes
// @DATE:Sat Dec 16 23:28:52 CET 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:5
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def findById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.findById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "apartments/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
    // @LINE:7
    def list: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.list",
      """
        function(fn0,ff1,ft2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "apartments" + _qS([(fn0 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("fn", fn0)), (ff1 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("ff", ff1)), (ft2 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("ft", ft2))])})
        }
      """
    )
  
    // @LINE:5
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseSampleController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def post: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SampleController.post",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sample"})
        }
      """
    )
  
    // @LINE:11
    def search: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SampleController.search",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sample/search"})
        }
      """
    )
  
    // @LINE:12
    def getById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SampleController.getById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sample/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
    // @LINE:10
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SampleController.index",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sample/index/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
  }


}
