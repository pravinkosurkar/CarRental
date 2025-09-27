package com.poc.carrental.di

import com.poc.carrental.data.datasource.LocalDataSource
import com.poc.carrental.data.repository.CustomerRepository
import com.poc.carrental.data.repository.CustomerRepositoryContract
import com.poc.carrental.domain.businesslogic.MonitorCarSpeedUseCase
import com.poc.carrental.domain.businesslogic.SendAlertUseCase
import com.poc.carrental.domain.channel.AwsChannel
import com.poc.carrental.domain.channel.FirebaseChannel
import com.poc.carrental.presentation.view.CarSpeedStatus
import com.poc.carrental.presentation.viewmodel.CarSpeedViewModel

/**
 * Helper for resolving dependency outside from the class in actual it can be replaced with the DI.
 */
object DependencyHelper {
    private val localDataSource = LocalDataSource()
    private val customerRepo: CustomerRepositoryContract = CustomerRepository(localDataSource)

    private val firebase = FirebaseChannel()
    private val aws = AwsChannel()
    private val sendAlertUseCase = SendAlertUseCase(firebase, aws)
    private val monitorCarSpeedUseCase = MonitorCarSpeedUseCase(sendAlertUseCase)

    fun provideSpeedViewModel(view: CarSpeedStatus): CarSpeedViewModel {
        return CarSpeedViewModel(customerRepo, monitorCarSpeedUseCase, view)
    }
}