package com.ilbensaber.breakingbad.repository

import androidx.lifecycle.LiveData
import com.ilbensaber.breakingbad.database.DeathDao
import com.ilbensaber.breakingbad.model.Death

class DeathRepository(private val deathDao: DeathDao) {

    val allDeath:LiveData<List<Death>> = deathDao.showDeaths()

    suspend fun insert(deaths:List<Death>) {
        deathDao.addDeaths(deaths)
    }

    suspend fun check() = deathDao.checkEmptyDeathList()

}