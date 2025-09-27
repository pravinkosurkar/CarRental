package com.poc.carrental.data.datasource

import com.poc.carrental.domain.channel.CommunicationType
import com.poc.carrental.domain.model.Customer
import java.util.concurrent.ConcurrentHashMap

/**
 * Memory local data source(mock). In real app, this would be the Room database update via telematics API.
 */
class LocalDataSource {
    private val customers = ConcurrentHashMap<String, Customer>()

    init {
        //two customers
        customers["CUST1"] = Customer("CUST1", "FleetOne", 80, CommunicationType.FIREBASE)
        customers["CUST2"] = Customer("CUST2", "FleetTwo", 100, CommunicationType.AWS)
    }

    /**
     * Get the customer information belongs to the customer id
     */
    fun getCustomer(id: String): Customer? = customers[id]?.copy()

    /**
     * Update customer information into local data source.
     *
     * @param customerId Unique id to the customer.
     * @param newLimit speed limit info.
     *@return status of the speed update.
     */
    fun updateSpeedLimit(customerId: String, newLimit: Int): Boolean {
        val customer = customers[customerId] ?: return false
        customer.maxSpeed = newLimit
        return true
    }

    /**
     * @param customerId Unique id to the customer.
     * @param newChannel communication channel.
     * @return return the status of channel update.
     */
    fun updateCommsChannel(customerId: String, newChannel: CommunicationType): Boolean {
        val customer = customers[customerId] ?: return false
        customer.commsChannel = newChannel
        return true
    }
}