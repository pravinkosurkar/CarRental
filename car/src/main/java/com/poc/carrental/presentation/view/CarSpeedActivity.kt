package com.poc.carrental.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.poc.carrental.di.DependencyHelper
import com.poc.carrental.domain.model.CarRental
import com.poc.carrental.domain.model.SpeedEvent

/**
 * Activity to launch the notification to the Driver.
 */
class CarSpeedActivity : AppCompatActivity(), CarSpeedStatus {

    private val viewModel by lazy { DependencyHelper.provideSpeedViewModel(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This data can come from the API in actual implementation
        val carRental = CarRental(
            "R1",
            "CUST1",
            "V123",
            System.currentTimeMillis(),
            System.currentTimeMillis() + 86400000
        )

        //we can use the car property Manager to get the Speed on actual.
        val events = listOf(
            SpeedEvent("V123", 70),
            SpeedEvent("V123", 95)
        )

        events.forEach { viewModel.onSpeedUpdate(it, carRental) }
    }

    override fun showSpeedStatus(message: String) {
        Log.d("CarSpeedActivity", message)
    }

    override fun showAlertToDriver(vehicleId: String, message: String) {
        Log.i("CarSpeedActivity", "ALERT [$vehicleId]: $message")
        println("Show alert to driver")
        // e.g. showDialog / HMI action
    }
}