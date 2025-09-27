package com.poc.carrental.domain.channel

import com.poc.carrental.domain.model.Customer
import com.poc.carrental.domain.model.SpeedEvent

/**
 * Aws communication channel implementation.
 */
class AwsChannel : CommunicationChannel {
    override fun notifyCompany(customer: Customer, event: SpeedEvent) {
        // TODO: Replace with AWS integration
        println("AWS: Notify ${customer.name} - vehicle ${event.vehicleId} exceeded ${event.speed} km/h")
    }
}