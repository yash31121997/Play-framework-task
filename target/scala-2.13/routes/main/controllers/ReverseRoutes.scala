// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:4
package controllers {

  // @LINE:28
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:15
  class ReverseDashboardController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def getDashboard(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "getDashboard")
    }
  
    // @LINE:18
    def logout(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "logout")
    }
  
  }

  // @LINE:23
  class ReverseForgotPasswordController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def forgotPassword(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "forgotPassword")
    }
  
    // @LINE:25
    def verifyOtp(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "verifyOtp")
    }
  
  }

  // @LINE:11
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:12
    def createUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createUser")
    }
  
  }

  // @LINE:4
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:4
    def index: Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:5
    def explore: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "explore")
    }
  
    // @LINE:6
    def tutorial: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tutorial")
    }
  
  }

  // @LINE:21
  class ReverseChangePasswordController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def changePassword(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "changePassword")
    }
  
  }

  // @LINE:10
  class ReverseMyController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def authenticate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "authenticate")
    }
  
  }


}
