package com.nj.test.view.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.nj.test.R
import com.nj.test.model.Message
import com.nj.test.viewmodel.MainActivityVM
import kotlinx.android.synthetic.main.fragment_input.*
import kotlinx.android.synthetic.main.fragment_input.view.*

class InputFragment : Fragment() {

    lateinit var viewModel: MainActivityVM
    lateinit var views: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        views = inflater.inflate(R.layout.fragment_input, container, false)
        return views
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            viewModel = ViewModelProviders.of(it).get(MainActivityVM::class.java)
        }
        uploadAction()
        print("Input fragment")
        print("Input fragment")
    }

    fun uploadAction() {
        var userInput = userInput.text
        views.uploadBtn.setOnClickListener {
            print("Input fragment clicked")
            if(!TextUtils.isEmpty(userInput)) {
                viewModel.addQuote(Message(quote = userInput.toString()))
            }
        }
    }
}