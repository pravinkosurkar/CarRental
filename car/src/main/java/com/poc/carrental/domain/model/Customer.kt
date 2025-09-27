package com.poc.carrental.domain.model

import com.poc.carrental.domain.channel.CommunicationType

/**
 * Represent the customer with the [id], [name], [maxSpeed] and [commsChannel].
 *
 * @property id customer id
 * @property name customer name
 * @property maxSpeed car speed constraints
 * @property commsChannel communication channel to notify the fleet company
 */
data class Customer(
    val id: String,
    val name: String,
    var maxSpeed: Int,
    var commsChannel: CommunicationType
)