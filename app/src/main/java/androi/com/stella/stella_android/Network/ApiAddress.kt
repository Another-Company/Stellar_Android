package androi.com.stella.stella_android.Network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by hyun on 2018. 3. 4..
 */
interface ApiAddress{


    @GET
    abstract fun getItemListByURL(@Url url: String): Call<JsonObject>

}