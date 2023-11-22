package com.withjetpack.daggerhiltimplementaion.di

import com.withjetpack.daggerhiltimplementaion.R
import com.withjetpack.daggerhiltimplementaion.model.UserProfile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object AppModule {

    @Provides
    fun provideUserProfile(): UserProfile {
        return UserProfile(
            "Vehicle 1",
            "Model X",
            "Electric",
            "Electric",
            "90%",
            R.drawable.ic_launcher_foreground,
            "Sensor Data Placeholder",
            "Engine Running"
        )
    }
}
