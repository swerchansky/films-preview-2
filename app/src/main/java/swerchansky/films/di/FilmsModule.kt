package swerchansky.films.di

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import dagger.Module
import dagger.Provides

@Module
class FilmsModule {
    @Provides
    fun provideLifecycleCoroutineScope(activity: Activity): LifecycleCoroutineScope =
        (activity as ComponentActivity).lifecycleScope
}