package com.withjetpack.daggerhiltimplementaion.model

data class UserProfile(
    val vehicleName: String,
    val vehicleModel: String,
    val vehicleType: String,
    val fuelType: String,
    val fuelLevel: String,
    val profileImage: Int,
    val sensorData: String, // Add sensor data field
    val engineStatus: String // Add engine status field
)
