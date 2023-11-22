package com.withjetpack.daggerhiltimplementaion.viewmodel

import androidx.lifecycle.ViewModel
import com.withjetpack.daggerhiltimplementaion.R
import com.withjetpack.daggerhiltimplementaion.model.UserProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor() : ViewModel() {

    private val _userProfile = MutableStateFlow(createStaticUserProfile())
    val userProfile: Flow<UserProfile> = _userProfile.asStateFlow()

    private fun createStaticUserProfile(): UserProfile {
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
