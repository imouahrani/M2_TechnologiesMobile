package com.github.imouahrani.breakingbad

import com.flextrade.jfixture.JFixture

inline operator fun <reified T> JFixture.invoke(): T = create(T::class.java)
