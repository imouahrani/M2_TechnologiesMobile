package com.ilbensaber.breakingbad.repository

import androidx.lifecycle.LiveData
import com.ilbensaber.breakingbad.database.CharacterDao
import com.ilbensaber.breakingbad.model.EntityCharacter

class CharacterRepository(private val dao: CharacterDao) {

    val allCharacters: LiveData<List<EntityCharacter>> = dao.showCharacters()

    suspend fun insert(chars:List<EntityCharacter>) {
        dao.addCharacters(chars)
    }

    suspend fun check() = dao.checkEmptyCharacters()

}