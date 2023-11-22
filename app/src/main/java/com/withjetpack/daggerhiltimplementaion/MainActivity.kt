package com.withjetpack.daggerhiltimplementaion
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.withjetpack.daggerhiltimplementaion.presentation.UserProfileScreen
import com.withjetpack.daggerhiltimplementaion.ui.theme.DaggerHiltImplementaionTheme
import com.withjetpack.daggerhiltimplementaion.viewmodel.UserProfileViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerHiltImplementaionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // Use HiltViewModel to get an instance of UserProfileViewModel
                    val viewModel: UserProfileViewModel = hiltViewModel()

                    // Call the composable using the obtained ViewModel
                    UserProfileScreen(viewModel)
                }
            }
        }
    }
}

