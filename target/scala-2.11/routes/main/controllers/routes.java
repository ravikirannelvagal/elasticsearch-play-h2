
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/Workspace/HoliduSearchChallenge/holidu-search-challenge/conf/routes
// @DATE:Sat Dec 16 23:28:52 CET 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseSampleController SampleController = new controllers.ReverseSampleController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseSampleController SampleController = new controllers.javascript.ReverseSampleController(RoutesPrefix.byNamePrefix());
  }

}
