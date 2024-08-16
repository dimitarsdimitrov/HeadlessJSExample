// HeadlessJsTaskServicePackage.kt
package com.headlessjsexample

import android.content.Intent
import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod




class HeadlessJsTaskServiceModule(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    override fun getName(): String {
        return "HeadlessJsTaskServiceModule"
    }

    @ReactMethod
    fun startService() {
        val intent = Intent(reactContext, MyHeadlessJsTaskService::class.java)
        intent.action = "com.headlessjsexample.HEADLESS_TASK"

        reactContext.startService(intent)

        Log.d("HeadlessJsTaskService", "Service started")

    }


}

