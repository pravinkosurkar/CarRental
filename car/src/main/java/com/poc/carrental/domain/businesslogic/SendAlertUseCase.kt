package com.poc.carrental.domain.businesslogic

import com.poc.carrental.domain.channel.AwsChannel
import com.poc.carrental.domain.channel.CommunicationChannel
import com.poc.carrental.domain.channel.CommunicationType
import com.poc.carrental.domain.channel.FirebaseChannel
import com.poc.carrental.domain.model.Customer
import com.poc.carrental.domain.model.SpeedEvent

/**
 * Use-case responsible for mapping the configured communication type into the
 * concrete channel and executing the notifications.
 *
 * Notify to the fleet company based on configured communication channel.
 *
 */
class SendAlertUseCase(
    private val firebaseChannel: CommunicationChannel = FirebaseChannel(),
    private val awsChannel: CommunicationChannel = AwsChannel()
) {
    /**
     * Get Communication channel type.
     * @param type of the communication chanel either firebase or aws.
     * @return communication channel.
     */
    private fun getChannel(type: CommunicationType): CommunicationChannel {
        return when (type) {
            CommunicationType.FIREBASE -> firebaseChannel
            CommunicationType.AWS -> awsChannel
        }
    }

    /**
     *
     */
    fun notify(customer: Customer, event: SpeedEvent) {
        val channel = getChannel(customer.commsChannel)
        channel.notifyCompany(customer, event)
    }
}
