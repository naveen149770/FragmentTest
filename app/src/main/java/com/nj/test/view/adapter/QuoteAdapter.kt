package com.nj.test.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nj.test.R
import com.nj.test.model.Message
import kotlinx.android.synthetic.main.row_quote.view.*

class QuoteAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var quoteList: MutableList<Message> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return QuoteHolder (
            LayoutInflater.from(parent.context).inflate(R.layout.row_quote, parent)
        )
    }

    override fun getItemCount(): Int = quoteList.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as QuoteHolder).bind(position)
    }

    fun setData(quoteList: MutableList<Message>) {
        this.quoteList = quoteList
    }

    inner class QuoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            itemView.rowLabel.text = quoteList[position].quote
        }
    }
}