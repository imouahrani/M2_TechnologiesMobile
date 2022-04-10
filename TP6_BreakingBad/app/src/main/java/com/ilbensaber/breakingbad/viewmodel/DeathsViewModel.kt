package com.ilbensaber.breakingbad.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilbensaber.breakingbad.database.RoomDB
import com.ilbensaber.breakingbad.model.Death
import com.ilbensaber.breakingbad.repository.DeathRepository
import com.ilbensaber.breakingbad.utils.NetworkState
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL

class DeathsViewModel(application: Application): AndroidViewModel(application) {

    var deaths: LiveData<List<Death>>
    var state: MutableLiveData<NetworkState> = MutableLiveData()
    private val repository: DeathRepository

    init {
        val dao = RoomDB.getDatabasenIstance(application).deathDao()
        repository = DeathRepository(dao)
        deaths = repository.allDeath
    }

    fun loadData() {
        CoroutineScope(IO).launch {
            val num = repository.check()
            if (num == 0) fetchData()
        }
    }

    private fun fetchData() {
        state.postValue(NetworkState.LOADING)
        val connection = URL("https://breakingbadapi.com/api/deaths/")
            .openConnection() as HttpURLConnection
        val data = connection.inputStream.bufferedReader().readText()
        val gson = GsonBuilder().create()
        val res = gson.fromJson(data, Array<Death>::class.java).toList()
        CoroutineScope(IO).launch { repository.insert(res) }
        state.postValue(NetworkState.LOADED)
    }
}
