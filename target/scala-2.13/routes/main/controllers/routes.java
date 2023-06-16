// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseDashboardController DashboardController = new controllers.ReverseDashboardController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseForgotPasswordController ForgotPasswordController = new controllers.ReverseForgotPasswordController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseChangePasswordController ChangePasswordController = new controllers.ReverseChangePasswordController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseMyController MyController = new controllers.ReverseMyController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseDashboardController DashboardController = new controllers.javascript.ReverseDashboardController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseForgotPasswordController ForgotPasswordController = new controllers.javascript.ReverseForgotPasswordController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseChangePasswordController ChangePasswordController = new controllers.javascript.ReverseChangePasswordController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseMyController MyController = new controllers.javascript.ReverseMyController(RoutesPrefix.byNamePrefix());
  }

}
