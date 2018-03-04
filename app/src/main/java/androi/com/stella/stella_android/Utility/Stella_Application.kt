package androi.com.stella.stella_android.Utility

import androi.com.stella.stella_android.Model.Token
import androi.com.stella.stella_android.Network.ApiAddress
import android.app.Application
import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by hyun on 2018. 2. 25..
 */
class Stella_Application : Application() {

    var isLogin: Boolean = false
    var toen: String = ""
    val context: Context = applicationContext
    val apiAddress: ApiAddress by lazy {
        setupRetrofit()
    }


    companion object {
        val NETWORK_TIMEOUT = 5L
    }

    override fun onCreate() {
        super.onCreate()
    }


    val checkLogin: (Context) -> Boolean = { comingContext ->
        if (Token(comingContext).returnToken() != null) true else false
    }

    fun setupRetrofit(): ApiAddress {
        // 통신 요청 보낼 때 설정 해주는 곳
        val interceptor = Interceptor { chain ->
            val original = chain.request()
            val builder = original.newBuilder()


            if (checkLogin(context)) {
                builder.header("Authorization", "Token " + Token(context).returnToken())
            }

            builder.method(original.method(), original.body())
            val request = builder.build()
            val response = chain.proceed(request)
            response
        }

        val client = OkHttpClient.Builder().apply {
            connectTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addNetworkInterceptor(StethoInterceptor())
            addInterceptor(interceptor)
        }.build()

        val retrofit = Retrofit.Builder()
                .baseUrl("adf")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        return retrofit.create(ApiAddress::class.java)
    }

}