package com.withjetpack.daggerhiltimplementaion.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.withjetpack.daggerhiltimplementaion.R
import com.withjetpack.daggerhiltimplementaion.model.UserProfile
import com.withjetpack.daggerhiltimplementaion.viewmodel.UserProfileViewModel

@Composable
fun UserProfileScreen(viewModel: UserProfileViewModel) {
    // Collect the userProfile state as a Composable
    val userProfile by viewModel.userProfile.collectAsState(null)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Vehicle Profile") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back button click */ }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(
                        onClick = { /* Handle settings button click */ }
                    ) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Profile Image and Vehicle Details
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    userProfile?.profileImage?.let { it1 -> painterResource(id = it1) }?.let { it2 ->
                        Image(
                            painter = it2,
                            contentDescription = null,
                            modifier = Modifier
                                .size(120.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colors.primary)
                        )
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.Start
                    ) {
                        userProfile?.vehicleName?.let { it1 ->
                            Text(
                                text = it1,
                                style = MaterialTheme.typography.h5.copy(fontSize = 20.sp),
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Text(
                            text = "${userProfile?.vehicleType} - ${userProfile?.vehicleModel}",
                            style = MaterialTheme.typography.subtitle1,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Vehicle Information
                userProfile?.fuelType?.let { it1 -> VehicleInfoItem("Fuel Type", it1) }
                userProfile?.fuelLevel?.let { it1 -> VehicleInfoItem("Fuel Level", it1) }
                userProfile?.sensorData?.let { it1 -> VehicleInfoItem("Sensor Data", it1) }
                userProfile?.engineStatus?.let { it1 -> VehicleInfoItem("Engine Status", it1) }
            }
        }
    )
}

@Composable
fun VehicleInfoItem(title: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.body1.copy(color = Color.Gray),
            )
            Text(
                text = value,
                style = MaterialTheme.typography.body1,
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(
            onClick = { /* Handle edit button click */ }
        ) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = null)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    val userProfile = UserProfile(
        "Vehicle 1",
        "Model X",
        "Electric",
        "Electric",
        "90%",
        R.drawable.ic_launcher_foreground,
        "Sensor Data Placeholder",
        "Engine Running"
    )
    UserProfileScreen(UserProfileViewModel())
}
