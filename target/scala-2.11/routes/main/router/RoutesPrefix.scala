
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/Workspace/HoliduSearchChallenge/holidu-search-challenge/conf/routes
// @DATE:Sat Dec 16 23:28:52 CET 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
