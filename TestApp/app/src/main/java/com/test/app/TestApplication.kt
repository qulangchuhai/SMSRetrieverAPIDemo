package com.test.app

import android.app.Application
import android.content.IntentFilter
import com.google.android.gms.auth.api.phone.SmsRetriever

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppSignatureHashHelper(this).appSignatures
        startSMSListener()
    }

    private fun startSMSListener() {
        val client = SmsRetriever.getClient(this)
        client.startSmsRetriever()
    }
}