package com.nj.test.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nj.test.R
import com.nj.test.view.adapter.QuoteAdapter
import com.nj.test.viewmodel.MainActivityVM
import kotlinx.android.synthetic.main.fragment_output.*

class OutputFragment : Fragment() {
    lateinit var viewModel: MainActivityVM
    lateinit var quoteAdapter: QuoteAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_output, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            viewModel = ViewModelProviders.of(it).get(MainActivityVM::class.java)
        }
        initrecyclerView()
        //viewModel.observeQuoteList()
        observeQuoteList()
    }

    private fun initrecyclerView() {
        quoteAdapter = QuoteAdapter()
        quoteList.layoutManager = LinearLayoutManager(activity)
        quoteList.hasFixedSize()
        quoteList.adapter = quoteAdapter
    }

    private fun observeQuoteList() {
        viewModel.observeQuoteList().observe(
            this,
            Observer {
                it?.let { quoteAdapter.setData(it) }
                quoteAdapter.notifyDataSetChanged()
            }
        )
    }
}