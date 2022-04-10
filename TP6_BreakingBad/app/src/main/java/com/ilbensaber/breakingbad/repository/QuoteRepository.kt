package com.ilbensaber.breakingbad.repository

import androidx.lifecycle.LiveData
import com.ilbensaber.breakingbad.database.QuoteDao
import com.ilbensaber.breakingbad.model.Quote

class QuoteRepository(private val quoteDao:QuoteDao) {

    val quotelist: LiveData<List<Quote>> = quoteDao.showQuotes()

    suspend fun insert(quotes:List<Quote>) {
        quoteDao.addQuotes(quotes)
    }

    suspend fun check() = quoteDao.checkEmptyQuoteList()

}