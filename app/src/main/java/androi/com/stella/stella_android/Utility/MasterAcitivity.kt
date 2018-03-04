package androi.com.stella.stella_android.Utility

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by hyun on 2018. 3. 4..
 */
class MasterAcitivity : AppCompatActivity() {
    protected var application : Stella_Application? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        application = getApplication() as Stella_Application


        application.
    }
}

