package com.technowave.broadcastreciever

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var myReceiver: MyReceiver
    companion object{
        const val MY_BROADCAST = "MY_BROADCAST"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            registerMyReceiver()
        }

        findViewById<Button>(R.id.btnUnRegister).setOnClickListener {
            unRegisterMyReceiver()
        }

        findViewById<Button>(R.id.btnSend).setOnClickListener {
            sendBroadCast()
        }

        myReceiver = MyReceiver()
    }

    private fun sendBroadCast() {
       Intent().also {intent ->
           intent.action = "com.technowave.broadcastreciever.MY_BROADCAST"
           intent.putExtra("mydata","Hello Syed")
           sendBroadcast(intent)
       }
    }

    private fun unRegisterMyReceiver() {
        unregisterReceiver(myReceiver)
    }

    private fun registerMyReceiver() {
        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        }
        registerReceiver(myReceiver, intentFilter)
    }
}