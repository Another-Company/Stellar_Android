package androi.com.stella.stella_android.View

import androi.com.stella.stella_android.Model.Token
import androi.com.stella.stella_android.R
import androi.com.stella.stella_android.Utility.Stella_Application
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        Token(this@MainActivity).saveToken("adf")
        Log.d("token", "token : "+Token(this@MainActivity).returnToken())


    }
}
