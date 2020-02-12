package com.d4static.easeme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.instance


class NotesFragment : Fragment() {

    val injector = KodeinInjector()
    val viewModel: NotesViewModel by injector.instance()


    companion object {
        fun newInstance() = NotesFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
