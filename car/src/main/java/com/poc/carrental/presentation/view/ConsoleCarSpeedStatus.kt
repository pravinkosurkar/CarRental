package com.poc.carrental.presentation.view

/**
 * Provide an implementation to the behaviour based on the card speed use case implementation.
 */
class ConsoleCarSpeedStatus : CarSpeedStatus {
    override fun showSpeedStatus(message: String) {
        println("STATUS: $message")
    }

    override fun showAlertToDriver(vehicleId: String, message: String) {
        println("ALERT [$vehicleId]: $message")
    }
}
