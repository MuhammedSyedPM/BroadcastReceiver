package com.technowave.broadcastreciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val data = p1?.getStringExtra("mydata")
        Toast.makeText(p0, "Received $data", Toast.LENGTH_LONG).show()
    }

    companion object {
        private const val TAG = "MyReceiverLog"
    }
}