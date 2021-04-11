package com.nj.test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nj.test.model.Message

class MainActivityVM : ViewModel() {
    private var quoteObserver: MutableLiveData<MutableList<Message>> = MutableLiveData()
    private var quotes : MutableList<Message> = mutableListOf()
    // observe from output fragment
    fun observeQuoteList(): MutableLiveData<MutableList<Message>> = quoteObserver

    // called from input frag
    fun addQuote(message: Message) {
        quotes.add(message)
        quoteObserver.value = quotes
    }
}