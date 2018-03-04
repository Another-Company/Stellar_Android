package androi.com.stella.stella_android.Utility

import androi.com.stella.stella_android.Model.Token
import android.app.Application
import android.content.Context
import okhttp3.Interceptor

/**
 * Created by hyun on 2018. 2. 25..
 */
class Stella_Application : Application() {

    var isLogin: Boolean = false
    var toen: String = ""
    val context: Context = applicationContext


    override fun onCreate() {
        super.onCreate()



    }


    val checkLogin:

    fun setupRetrofit() {
        // 통신 요청 보낼 때 설정 해주는 곳
        val interceptor = Interceptor { chain ->
            val original = chain.request()
            val builder = original.newBuilder()


            if(checkLogin()){

            }

            val request = builder.build()
            return@Interceptor chain.proceed(request)
        }
    }

}