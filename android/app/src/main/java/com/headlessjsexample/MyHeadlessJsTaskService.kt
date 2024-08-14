
package com.headlessjsexample


import android.content.Intent
import android.os.Bundle
import com.facebook.react.HeadlessJsTaskService
import com.facebook.react.bridge.Arguments
import com.facebook.react.jstasks.HeadlessJsTaskConfig

class MyHeadlessJsTaskService : HeadlessJsTaskService() {
    override fun getTaskConfig(intent: Intent?): HeadlessJsTaskConfig? {
        val extras = intent?.extras
        return if (extras != null) {
            HeadlessJsTaskConfig(
                "BackgroundTask", // The task registered in JavaScript
                Arguments.fromBundle(extras),
                5000, // Timeout for the task
                true // Allow the task to run in foreground as well
            )
        } else {
            null
        }
    }
}
