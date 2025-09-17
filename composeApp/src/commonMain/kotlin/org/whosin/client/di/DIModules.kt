package org.whosin.client.di

import io.ktor.client.engine.HttpClientEngineFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.whosin.client.core.network.HttpClientFactory
import org.whosin.client.data.remote.RemoteClubDataSource
import org.whosin.client.data.remote.RemoteMemberDataSource
import org.whosin.client.data.repository.ClubRepository
import org.whosin.client.data.repository.MemberRepository
import org.whosin.client.presentation.auth.AuthViewModel
import org.whosin.client.presentation.home.HomeViewModel
import org.whosin.client.presentation.mypage.MyPageViewModel

fun appModule() = listOf(
    httpClientModule,
    dataSourceModule,
    repositoryModule,
    viewModelModule,
    platformModule
)

expect val platformModule: Module

val httpClientModule = module {
    single{ HttpClientFactory.create(get()) }
}

val dataSourceModule = module {
    single { RemoteMemberDataSource(get()) }
    single { RemoteClubDataSource(get()) }
}

val repositoryModule = module {
    single { MemberRepository(get()) }
    single { ClubRepository(get()) }
}

val viewModelModule = module {
    viewModelOf(::AuthViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::MyPageViewModel)
}
