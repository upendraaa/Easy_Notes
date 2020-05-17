package d4static.dev999.easynotes.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import d4static.dev999.easynotes.R
import d4static.dev999.easynotes.base.BaseFragment
import d4static.dev999.easynotes.databinding.FragmentAddNoteBinding
import d4static.dev999.easynotes.model.ListItemModel
import d4static.dev999.easynotes.viewmodels.AddNoteViewModel

private const val ARG_PARAM = "param"
private const val TAG = "AddNoteFragment"

private lateinit var binding: FragmentAddNoteBinding
private lateinit var viewModel: AddNoteViewModel


class AddNoteFragment : BaseFragment() {
    private var param_notes: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param_notes = it.getString(ARG_PARAM)
        }

        Log.d(TAG, "OnCreate called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_note, container, false)
        viewModel = ViewModelProviders.of(this).get(AddNoteViewModel::class.java)
        viewModel.init("Dashboard")
        viewModel.mutableLiveData.observe(viewLifecycleOwner, Observer {
            setData(it)
        })


        setView();
        return binding.root
    }

    fun setView() {
        showToolbar();
        showView(binding.layoutbutton.btnLayout)
        binding.layoutbutton.btnPositive.setOnClickListener {
            onPositiveClick(it, "")
        }
        binding.layoutbutton.btnNegative.setOnClickListener {
            onNegativeClick(it, "")
        }
    }

    fun setData(item: ListItemModel) {


    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddNoteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM, param1)
                }
            }
    }

    override fun onPositiveClick(view: View, obj: Any) {
        view.findNavController().navigate(R.id.bankListFragment)
    }

    override fun onNegativeClick(view: View, obj: Any) {
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "OnAttach called")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach called")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")

    }


}
