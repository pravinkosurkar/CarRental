package com.poc.carrental.presentation.viewmodel

import com.poc.carrental.data.repository.CustomerRepositoryContract
import com.poc.carrental.domain.model.CarRental
import com.poc.carrental.domain.model.SpeedEvent
import com.poc.carrental.domain.businesslogic.MonitorCarSpeedUseCase
import com.poc.carrental.presentation.view.CarSpeedStatus

/**
 * View Model for managing the car speed data on UI and trigger execution of the use case.
 *
 * @param customerRepo get the customer instance to access customer properties.
 * @param monitorCarSpeedUseCase trigger the car speed use cases from domain layer.
 * @param carSpeedStatus trigger the event to display the alert to driver.
 */
class CarSpeedViewModel(
    private val customerRepo: CustomerRepositoryContract,
    private val monitorCarSpeedUseCase: MonitorCarSpeedUseCase,
    private val carSpeedStatus: CarSpeedStatus
) {
    /**
     * Trigger the operation specific to the car speed.
     * @param event Card speed event tell about the car speed.
     * @param carRental car rental information.
     */
    fun onSpeedUpdate(event: SpeedEvent, carRental: CarRental) {
        val customer = customerRepo.getCustomer(carRental.customerId)
        when {
            customer == null -> carSpeedStatus.showSpeedStatus("Unknown customer for rental ${carRental.rentalId}")
            event.speed > customer.maxSpeed -> {
                carSpeedStatus.showAlertToDriver(event.vehicleId, "Over speed detected at ${event.speed} km/h")
                monitorCarSpeedUseCase.execute(event, carRental, customer)
            }
            else -> carSpeedStatus.showSpeedStatus("Speed OK: ${event.speed} km/h")
        }
    }
}