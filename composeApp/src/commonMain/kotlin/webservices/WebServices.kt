package webservices

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import webservices.Config.baseUrl

class WebServices {

    private val client = HttpClient()

    suspend fun getProducts(): String {
        val response: HttpResponse = client.get(baseUrl + "products")
        return response.bodyAsText()
    }
}

























