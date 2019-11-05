package d4static.dev999.easynotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import d4static.dev999.easynotes.ui.main.MainFragment
import d4static.dev999.easynotes.ui.main.NoteViewModel
import d4static.dev999.easynotes.ui.main.ViewModelFactory
import io.reactivex.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {

    private lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: NoteViewModel by viewModels()

    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
