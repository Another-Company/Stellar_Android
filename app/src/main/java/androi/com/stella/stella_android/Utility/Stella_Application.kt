package androi.com.stella.stella_android.Utility

import androi.com.stella.stella_android.Model.Token
import android.app.Application
import android.content.Context

/**
 * Created by hyun on 2018. 2. 25..
 */
class Stella_Application : Application() {

    var isLogin : Boolean = false
    var toen : String = ""
    val context : Context = applicationContext


    override fun onCreate() {
        super.onCreate()

        Token(this@Stella_Application).token

    }


}