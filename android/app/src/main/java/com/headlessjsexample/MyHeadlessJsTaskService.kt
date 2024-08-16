package com.headlessjsexample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.facebook.react.HeadlessJsTaskService
import com.facebook.react.bridge.Arguments
import com.facebook.react.jstasks.HeadlessJsTaskConfig
import com.facebook.react.ReactApplication

class MyHeadlessJsTaskService : HeadlessJsTaskService() {

    // Handle when the service is started
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("HeadlessJsTaskService", "Service onStartCommand triggered")

        // Get the ReactInstanceManager from the application context
        val reactInstanceManager = (applicationContext as ReactApplication).reactNativeHost.reactInstanceManager

        // Check if the React Native instance is active
        val isReactNativeInstanceActive = reactInstanceManager.hasStartedCreatingInitialContext()

        // Log whether the React Native instance is active
        Log.d("HeadlessJsTaskService", "Is React Native instance active: $isReactNativeInstanceActive")

        // If the React Native instance is not active, start the task
        if (!isReactNativeInstanceActive) {
            startTask(getTaskConfig(intent))
        }

        // Call super method to ensure the service runs correctly
        return super.onStartCommand(intent, flags, startId)
    }

    // Get the configuration for the headless task
    override fun getTaskConfig(intent: Intent?): HeadlessJsTaskConfig? {
        // Check if the intent is not null
        if (intent == null) {
            return null
        }

        // Retrieve any extras passed with the intent
        val extras = intent.extras ?: Bundle()

        // Create a new task configuration with the intent's extras
        return HeadlessJsTaskConfig(
            "BackgroundTask", // Name of the JavaScript task
            Arguments.fromBundle(extras), // Arguments passed to the task
            5000, // Timeout for the task in milliseconds
            true  // Allow the task to run in the foreground
        )
    }
}
