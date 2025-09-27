package com.poc.carrental.domain.model

/**
 * Represent the car rental ith the a [rentalId], [customerId], [vehicleId],
 * [startTime] and [endTime].
 *
 * @property rentalId car rent id
 * @property customerId customer id
 * @property vehicleId car unique identity
 * @property startTime trip start time
 * @property endTime trip end time
 */
data class CarRental(
    val rentalId: String,
    val customerId: String,
    val vehicleId: String,
    val startTime: Long,
    val endTime: Long
)