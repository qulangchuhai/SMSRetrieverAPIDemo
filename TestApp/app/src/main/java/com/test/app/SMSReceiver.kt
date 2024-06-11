package com.test.app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status
import java.util.regex.Pattern

class SMSReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION == intent.action) {
            val extras = intent.extras
            val status = extras?.get(SmsRetriever.EXTRA_STATUS) as? Status?
            when (status?.statusCode) {
                CommonStatusCodes.SUCCESS -> {
                    /*<#> Your ExampleApp code is: 123456 FA+9qCX9VVd*/
                    val message = extras?.get(SmsRetriever.EXTRA_SMS_MESSAGE) as String?
                    //然后我们根据我们短信下发的具体格式写正则来获取到我们的实际字符串
                    //比如我们就是纯数字 6位
                    val pattern = Pattern.compile("[0-9]{6}")
                    val matcher = pattern.matcher(message)
                    if (matcher.find()) {
                        // match the 6-digit verification code
                        val smsContent = matcher.group()
                    }
                }

                CommonStatusCodes.TIMEOUT -> {

                }

                CommonStatusCodes.API_NOT_CONNECTED -> {
                }

                CommonStatusCodes.NETWORK_ERROR -> {
                }

                CommonStatusCodes.ERROR -> {
                }
            }
        }
    }
}