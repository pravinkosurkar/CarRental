package com.poc.carrental.domain.businesslogic

import com.poc.carrental.domain.model.Customer
import com.poc.carrental.domain.model.CarRental
import com.poc.carrental.domain.model.SpeedEvent

/**
 * Use Case: if an car speed exceeds customer's configured maxSpeed then execute alert.
 * @param sendAlertUseCase alert use case.
 */
class MonitorCarSpeedUseCase(
    private val sendAlertUseCase: SendAlertUseCase
) {
    fun execute(event: SpeedEvent, carRental: CarRental, customer: Customer) {
        // Validate rental is active — basic check, it could be enhanced based on business use case
        val rentalActive = event.timestamp in carRental.startTime..carRental.endTime

        if (!rentalActive) {
            // If rental isn't active, then skip.
            println("Rental ${carRental.rentalId} is not active. Skipping.")
            return
        }

        // Business rule
        if (event.speed > customer.maxSpeed) {
            sendAlertUseCase.notify(customer, event)
        } else {
            println("Speed OK: ${event.speed} km/h for vehicle ${event.vehicleId}")
        }
    }
}