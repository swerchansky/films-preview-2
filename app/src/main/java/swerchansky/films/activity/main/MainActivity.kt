package swerchansky.films.activity.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import swerchansky.films.FilmsApplication
import swerchansky.films.compose.screen.FilmsScreen
import swerchansky.films.ui.viewModel.FilmsViewModel
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModel: FilmsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as FilmsApplication).appComponent.create(this).inject(this)

        setContent {
            FilmsScreen(viewModel)
        }
    }
}
