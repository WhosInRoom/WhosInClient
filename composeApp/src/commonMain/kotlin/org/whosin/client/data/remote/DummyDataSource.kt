package org.whosin.client.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import org.whosin.client.core.network.ApiResult
import org.whosin.client.data.dto.response.DummyJokeResponseDto

class DummyDataSource(
    private val client: HttpClient
) {
    suspend fun getRandomJoke(): ApiResult<DummyJokeResponseDto> {
        return try {
            val response: HttpResponse = client
                .get(urlString = "https://official-joke-api.appspot.com/jokes/random")
            if (response.status.isSuccess()) {
                ApiResult.Success(
                    data = response.body(),
                    statusCode = response.status.value
                )
            } else {
                ApiResult.Error(
                    code = response.status.value,
                    message = "HTTP ${response.status.value}"
                )
            }
        } catch (t: Throwable) {
            ApiResult.Error(message = t.message, cause = t)
        }
    }
}
