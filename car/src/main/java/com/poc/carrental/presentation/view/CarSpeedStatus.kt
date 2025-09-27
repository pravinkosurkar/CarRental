package com.poc.carrental.presentation.view

/**
 * Represent the UI update based on the speed limit.
 */
interface CarSpeedStatus {
    fun showSpeedStatus(message: String)
    fun showAlertToDriver(vehicleId: String, message: String)
}
