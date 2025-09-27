package com.poc.carrental.domain.channel

import com.poc.carrental.domain.model.Customer
import com.poc.carrental.domain.model.SpeedEvent

/**
 * Communication channel to notify the fleet company.
 */
interface CommunicationChannel {
    /**
     * Notify the fleet company / admin about the event.
     */
    fun notifyCompany(customer: Customer, event: SpeedEvent)
}
