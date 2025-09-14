package org.whosin.client.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    /* 로그인, 회원가입 등 인증 관련*/
    @Serializable
    data object AuthGraph: Route

    @Serializable
    data object Login: Route

    /* 메인 화면 */
    @Serializable
    data object Home: Route

    /* 마이 페이지 */
    @Serializable
    data object MyPage: Route
}