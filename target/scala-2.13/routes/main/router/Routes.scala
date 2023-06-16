// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:4
  HomeController_6: controllers.HomeController,
  // @LINE:10
  MyController_5: controllers.MyController,
  // @LINE:11
  UserController_3: controllers.UserController,
  // @LINE:15
  DashboardController_0: controllers.DashboardController,
  // @LINE:21
  ChangePasswordController_1: controllers.ChangePasswordController,
  // @LINE:23
  ForgotPasswordController_2: controllers.ForgotPasswordController,
  // @LINE:28
  Assets_4: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:4
    HomeController_6: controllers.HomeController,
    // @LINE:10
    MyController_5: controllers.MyController,
    // @LINE:11
    UserController_3: controllers.UserController,
    // @LINE:15
    DashboardController_0: controllers.DashboardController,
    // @LINE:21
    ChangePasswordController_1: controllers.ChangePasswordController,
    // @LINE:23
    ForgotPasswordController_2: controllers.ForgotPasswordController,
    // @LINE:28
    Assets_4: controllers.Assets
  ) = this(errorHandler, HomeController_6, MyController_5, UserController_3, DashboardController_0, ChangePasswordController_1, ForgotPasswordController_2, Assets_4, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_6, MyController_5, UserController_3, DashboardController_0, ChangePasswordController_1, ForgotPasswordController_2, Assets_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """explore""", """controllers.HomeController.explore"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tutorial""", """controllers.HomeController.tutorial"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """authenticate""", """controllers.MyController.authenticate()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.UserController.login(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createUser""", """controllers.UserController.createUser(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getDashboard""", """controllers.DashboardController.getDashboard(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.DashboardController.logout(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """changePassword""", """controllers.ChangePasswordController.changePassword(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """forgotPassword""", """controllers.ForgotPasswordController.forgotPassword(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """verifyOtp""", """controllers.ForgotPasswordController.verifyOtp(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:4
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_6.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Routes
 This file defines all application routes (Higher priority routes first)
 ~~~~""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_HomeController_explore1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("explore")))
  )
  private[this] lazy val controllers_HomeController_explore1_invoker = createInvoker(
    HomeController_6.explore,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "explore",
      Nil,
      "GET",
      this.prefix + """explore""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_HomeController_tutorial2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tutorial")))
  )
  private[this] lazy val controllers_HomeController_tutorial2_invoker = createInvoker(
    HomeController_6.tutorial,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "tutorial",
      Nil,
      "GET",
      this.prefix + """tutorial""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_MyController_authenticate3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("authenticate")))
  )
  private[this] lazy val controllers_MyController_authenticate3_invoker = createInvoker(
    MyController_5.authenticate(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MyController",
      "authenticate",
      Nil,
      "POST",
      this.prefix + """authenticate""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_UserController_login4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_UserController_login4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_3.login(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "login",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UserController_createUser5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createUser")))
  )
  private[this] lazy val controllers_UserController_createUser5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_3.createUser(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "createUser",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """createUser""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_DashboardController_getDashboard6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getDashboard")))
  )
  private[this] lazy val controllers_DashboardController_getDashboard6_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      DashboardController_0.getDashboard(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "getDashboard",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """getDashboard""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:18
  private[this] lazy val controllers_DashboardController_logout7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_DashboardController_logout7_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      DashboardController_0.logout(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "logout",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """logout""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:21
  private[this] lazy val controllers_ChangePasswordController_changePassword8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("changePassword")))
  )
  private[this] lazy val controllers_ChangePasswordController_changePassword8_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ChangePasswordController_1.changePassword(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChangePasswordController",
      "changePassword",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """changePassword""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:23
  private[this] lazy val controllers_ForgotPasswordController_forgotPassword9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("forgotPassword")))
  )
  private[this] lazy val controllers_ForgotPasswordController_forgotPassword9_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ForgotPasswordController_2.forgotPassword(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForgotPasswordController",
      "forgotPassword",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """forgotPassword""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_ForgotPasswordController_verifyOtp10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("verifyOtp")))
  )
  private[this] lazy val controllers_ForgotPasswordController_verifyOtp10_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      ForgotPasswordController_2.verifyOtp(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForgotPasswordController",
      "verifyOtp",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """verifyOtp""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_Assets_versioned11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned11_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:4
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_6.index)
      }
  
    // @LINE:5
    case controllers_HomeController_explore1_route(params@_) =>
      call { 
        controllers_HomeController_explore1_invoker.call(HomeController_6.explore)
      }
  
    // @LINE:6
    case controllers_HomeController_tutorial2_route(params@_) =>
      call { 
        controllers_HomeController_tutorial2_invoker.call(HomeController_6.tutorial)
      }
  
    // @LINE:10
    case controllers_MyController_authenticate3_route(params@_) =>
      call { 
        controllers_MyController_authenticate3_invoker.call(MyController_5.authenticate())
      }
  
    // @LINE:11
    case controllers_UserController_login4_route(params@_) =>
      call { 
        controllers_UserController_login4_invoker.call(
          req => UserController_3.login(req))
      }
  
    // @LINE:12
    case controllers_UserController_createUser5_route(params@_) =>
      call { 
        controllers_UserController_createUser5_invoker.call(
          req => UserController_3.createUser(req))
      }
  
    // @LINE:15
    case controllers_DashboardController_getDashboard6_route(params@_) =>
      call { 
        controllers_DashboardController_getDashboard6_invoker.call(
          req => DashboardController_0.getDashboard(req))
      }
  
    // @LINE:18
    case controllers_DashboardController_logout7_route(params@_) =>
      call { 
        controllers_DashboardController_logout7_invoker.call(
          req => DashboardController_0.logout(req))
      }
  
    // @LINE:21
    case controllers_ChangePasswordController_changePassword8_route(params@_) =>
      call { 
        controllers_ChangePasswordController_changePassword8_invoker.call(
          req => ChangePasswordController_1.changePassword(req))
      }
  
    // @LINE:23
    case controllers_ForgotPasswordController_forgotPassword9_route(params@_) =>
      call { 
        controllers_ForgotPasswordController_forgotPassword9_invoker.call(
          req => ForgotPasswordController_2.forgotPassword(req))
      }
  
    // @LINE:25
    case controllers_ForgotPasswordController_verifyOtp10_route(params@_) =>
      call { 
        controllers_ForgotPasswordController_verifyOtp10_invoker.call(
          req => ForgotPasswordController_2.verifyOtp(req))
      }
  
    // @LINE:28
    case controllers_Assets_versioned11_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned11_invoker.call(Assets_4.versioned(path, file))
      }
  }
}
