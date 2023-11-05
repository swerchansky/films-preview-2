package swerchansky.films

import android.app.Application
import swerchansky.films.di.DaggerFilmsComponent
import swerchansky.films.di.FilmsComponent

class FilmsApplication : Application() {
    val appComponent: FilmsComponent.Factory by lazy {
        DaggerFilmsComponent.factory()
    }
}
