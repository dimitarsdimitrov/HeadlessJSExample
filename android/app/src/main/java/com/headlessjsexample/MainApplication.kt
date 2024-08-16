package com.headlessjsexample

import android.app.Application
import com.facebook.react.PackageList
import com.facebook.react.ReactApplication
import com.facebook.react.ReactHost
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.load
import com.facebook.react.defaults.DefaultReactHost.getDefaultReactHost
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.soloader.SoLoader
import com.facebook.react.shell.MainReactPackage
import com.facebook.react.HeadlessJsTaskService
import android.content.Intent
import java.util.Arrays

class MainApplication : Application(), ReactApplication {

  override val reactNativeHost: ReactNativeHost =
      object : DefaultReactNativeHost(this) {
          /*
        override fun getPackages(): List<ReactPackage> =
            PackageList(this).packages.apply {
              // Packages that cannot be autolinked yet can be added manually here, for example:
              // add(MyReactNativePackage())
            }

        override fun getJSMainModuleName(): String = "index"
*/
        override fun getUseDeveloperSupport(): Boolean = BuildConfig.DEBUG

        override val isNewArchEnabled: Boolean = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED
        override val isHermesEnabled: Boolean = BuildConfig.IS_HERMES_ENABLED

          override fun getPackages(): List<ReactPackage> {
              return listOf(
                  MainReactPackage(),
                  HeadlessJsTaskServicePackage() // Register your package here
              )
          }

          override fun getJSMainModuleName(): String {
              return "index"
          }


      }



  override val reactHost: ReactHost
    get() = getDefaultReactHost(applicationContext, reactNativeHost)


   override fun onCreate() {

       super.onCreate()
       SoLoader.init(this, /* native exopackage */ false)
/*
       // Initialize and start the HeadlessJsTaskService
       val intent = Intent(applicationContext, MyHeadlessJsTaskService::class.java)
       applicationContext.startService(intent)

       // Ensure we are acquiring the wake lock correctly
       HeadlessJsTaskService.acquireWakeLockNow(applicationContext)*/
   }
}
