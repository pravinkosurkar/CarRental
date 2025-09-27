package com.poc.carrental.domain.channel

import com.poc.carrental.domain.model.Customer
import com.poc.carrental.domain.model.SpeedEvent

/**
 * Firebase communication channel implementation.
 */
class FirebaseChannel : CommunicationChannel {
    override fun notifyCompany(customer: Customer, event: SpeedEvent) {
        // TODO: Replace with Firebase Cloud Messaging server call
        println("Firebase: Notify ${customer.name} - vehicle ${event.vehicleId} exceeded ${event.speed} km/h")
    }
}