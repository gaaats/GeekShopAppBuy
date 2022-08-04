package com.example.geekshopappbuy.utils

// A generic class that contains data and status about loading this data.
sealed class ResourceVrap<T>(
    val data: T? = null,
    val exception: Throwable? = null,
) {
    val notNullData get() = data!!

    class Success<T>(data: T) : ResourceVrap<T>(data) {
    }

    class Error<T>(exception: Throwable, data: T? = null) :
        ResourceVrap<T>(exception = exception, data = data)

}