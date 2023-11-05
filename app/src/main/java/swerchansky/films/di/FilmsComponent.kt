package swerchansky.films.di

import android.app.Activity
import dagger.BindsInstance
import dagger.Component
import swerchansky.films.activity.main.MainActivity
import swerchansky.films.data.di.NetworkModule
import swerchansky.films.data.di.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        FilmsModule::class,
        CoroutineModule::class,
        NetworkModule::class,
        RepositoryModule::class,
    ]
)
interface FilmsComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance activity: Activity): FilmsComponent
    }

    fun inject(activity: MainActivity)
}