package com.poc.carrental.data.repository

import com.poc.carrental.domain.channel.CommunicationType
import com.poc.carrental.domain.model.Customer

/**
 * Repository contract to get the data from the datasource.
 */
interface CustomerRepositoryContract {
    /**
     * Return the data of customer based on customer Id.
     *
     * @param customerId unique id to update customer info.
     * @return customer information belongs to customer id.
     */
    fun getCustomer(customerId: String): Customer?

    /**
     * Update speed limit of the customer id.
     *
     * @param customerId unique id to update customer info.
     * @param newLimit set updated speed limit of vehicle specific to customer.
     * @return the status of the speed update.
     */
    fun updateSpeedLimit(customerId: String, newLimit: Int): Boolean

    /**
     * Update the communication channel.
     *
     * @param customerId unique id to update customer info.
     * @param newChannel update channel info
     */
    fun updateCommsChannel(customerId: String, newChannel: CommunicationType): Boolean
}
