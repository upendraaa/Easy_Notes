package d4static.dev999.easynotes.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import d4static.dev999.easynotes.R
import d4static.dev999.easynotes.base.BaseFragment
import d4static.dev999.easynotes.databinding.FragmentAddBankBinding
import d4static.dev999.easynotes.viewmodels.AddBankFragmentViewModel

private const val ARG_PARAM_BANK = "param_bank"
private const val TAG = "AddBankFragment"

private lateinit var binding: FragmentAddBankBinding
private lateinit var viewModel: AddBankFragmentViewModel


class AddBankFragment : BaseFragment() {
    private var param_notes: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param_notes = it.getString(ARG_PARAM_BANK)
        }

        Log.d(TAG, "OnCreate called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_bank, container, false)
        viewModel = ViewModelProviders.of(this).get(AddBankFragmentViewModel::class.java)
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


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddBankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM_BANK, param1)
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
