package com.m3chladon.earthquakeanalyst.network

class Resource<T> private constructor(val status: Resource.Status, val data: T?, val apiError:NetworkError?) {
    enum class Status {
        SUCCESS, ERROR, LOADING
    }
    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(apiError: NetworkError?): Resource<T> {
            return Resource(Status.ERROR, null, apiError)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}