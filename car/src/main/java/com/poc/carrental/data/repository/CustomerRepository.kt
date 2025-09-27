package com.poc.carrental.data.repository

import com.poc.carrental.data.datasource.LocalDataSource
import com.poc.carrental.domain.channel.CommunicationType
import com.poc.carrental.domain.model.Customer

/**
 * Repository using the local data source in actual it can be fetch data from API or local DB
 */
open class CustomerRepository(
    private val localDataSource: LocalDataSource = LocalDataSource()
) : CustomerRepositoryContract {

    override fun getCustomer(customerId: String): Customer? {
        return localDataSource.getCustomer(customerId)
    }

    override fun updateSpeedLimit(customerId: String, newLimit: Int): Boolean {
        return localDataSource.updateSpeedLimit(customerId, newLimit)
    }

    override fun updateCommsChannel(customerId: String, newChannel: CommunicationType): Boolean {
        return localDataSource.updateCommsChannel(customerId, newChannel)
    }
}