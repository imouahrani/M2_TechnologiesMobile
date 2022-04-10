package com.github.imouahrani.breakingbad

import com.github.imouahrani.breakingbad.core.coroutine.CoroutineDispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class UnitTestCoroutineDispatcherProvider : CoroutineDispatcherProvider {
    override val main: CoroutineDispatcher
        get() = Dispatchers.Unconfined
    override val io: CoroutineDispatcher
        get() = Dispatchers.Unconfined
}