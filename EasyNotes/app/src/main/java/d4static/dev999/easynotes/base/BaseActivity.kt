package d4static.dev999.easynotes.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import d4static.dev999.easynotes.R

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}
