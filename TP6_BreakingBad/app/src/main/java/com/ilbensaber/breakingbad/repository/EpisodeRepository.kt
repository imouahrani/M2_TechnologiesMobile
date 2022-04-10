package com.ilbensaber.breakingbad.repository

import androidx.lifecycle.LiveData
import com.ilbensaber.breakingbad.database.EpisodeDao
import com.ilbensaber.breakingbad.model.EntityEpisode

class EpisodeRepository(private val dao: EpisodeDao) {

    val allEpisode: LiveData<List<EntityEpisode>> = dao.showEpisodes()

    suspend fun insert(epis:List<EntityEpisode>) {
        dao.addEpisodes(epis)
    }

    suspend fun check() = dao.checkEmptyEpisodes()

}