package androi.com.stella.stella_android.Model

import android.content.Context

/**
 * Created by hyun on 2018. 2. 25..
 */
data class Token(var token: String? = null) {
    //토큰 클래스를 생성하려면 context를 보내야 한다
    var context: Context? = null

    constructor(comingApllicationContext: Context) : this() {
        context = comingApllicationContext
    }

    var newToken: String
        set(value) {
            token = saveToken(value)
        }
        get() {
            return returnToken()
        }

    val saveToken: (String) -> String = { comingToken ->
        context?.getSharedPreferences("user_token", Context.MODE_PRIVATE)?.apply {
            this.edit().apply() {
                putString("user_token", comingToken)
                commit()
            }
        }
        comingToken
    }

    val returnToken: () -> String = {
        context?.getSharedPreferences("user_token", Context.MODE_PRIVATE)?.let {
            it.getString("user_token", "")
        } ?: ""
    }
}

