package com.github.imouahrani.breakingbad.data

import retrofit2.http.GET


interface CharacterApiService {

    @GET("characters")
    suspend fun getCharacters(): List<CharacterResponse>
}