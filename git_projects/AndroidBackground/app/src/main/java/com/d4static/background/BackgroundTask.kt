package com.d4static.background

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders


class BackgroundTask : Fragment() {

    companion object {
        fun newInstance() = BackgroundTask()
    }

    private lateinit var viewModel: BackgroundTaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.background_task_fragment, container, false);
        initView(view)
        return view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BackgroundTaskViewModel::class.java)
    }

    fun initView(view: View) {
        view.findViewById<AppCompatButton>(R.id.btnImmediate).setOnClickListener {
            viewModel.doImmediateTask();
        }
    }

}
