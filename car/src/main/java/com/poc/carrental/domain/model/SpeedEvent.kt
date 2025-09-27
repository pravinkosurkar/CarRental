package com.poc.carrental.domain.model

/**
 * Represent the speed event [vehicleId], [speed] and [timestamp].
 *
 * @property vehicleId vehicle unique id
 * @property speed vehicle current speed
 * @property timestamp time mapping with the vehicle speed
 */
data class SpeedEvent(
    val vehicleId: String,
    val speed: Int,
    val timestamp: Long = System.currentTimeMillis()
)