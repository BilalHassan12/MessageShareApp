package com.smartherd.messageshareapp.activities.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.smartherd.messageshareapp.R
import com.smartherd.messageshareapp.activities.Constants
import com.smartherd.messageshareapp.activities.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {
        val TAG: String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle:Bundle? =intent.extras

        bundle?.let {
            val msg = bundle.getString(Constants.USER_MSG_KEY)
            showToast(msg)
            txvUserMessage.text = msg
        }
    }
}
