package com.firezenk.ksp.domain

interface Command<T> {

    fun execute(): T
}