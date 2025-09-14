package org.whosin.client

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform