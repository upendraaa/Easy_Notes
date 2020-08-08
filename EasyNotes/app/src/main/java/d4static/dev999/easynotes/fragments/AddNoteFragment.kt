package d4static.dev999.easynotes.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.firebase.Timestamp
import d4static.dev999.easynotes.R
import d4static.dev999.easynotes.base.BaseFragment
import d4static.dev999.easynotes.callback.OnServerResponseListener
import d4static.dev999.easynotes.databinding.FragmentAddNoteBinding
import d4static.dev999.easynotes.model.NoteFsModel
import d4static.dev999.easynotes.viewmodels.AddNoteViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM = "param"
private const val TAG = "AddNoteFragment"

private lateinit var binding: FragmentAddNoteBinding

@AndroidEntryPoint
class AddNoteFragment : BaseFragment(), OnServerResponseListener {
    private var param_notes: NoteFsModel? = null
    private val viewModel: AddNoteViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (it.getSerializable(ARG_PARAM) != null) {
                param_notes = it.getSerializable(ARG_PARAM) as NoteFsModel
            }
        }

        Log.d(TAG, "OnCreate called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_note, container, false)
        viewModel.init("Dashboard")
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setData();
        setView()
    }

    fun setView() {
        showToolbar();
        showView(binding.layoutbutton.btnLayout)
        binding.layoutbutton.btnPositive.setOnClickListener {

            var noteFsModel = NoteFsModel(
                binding.tvTitle.editText!!.text.toString(), null,
                binding.tvBody.editText!!.text.toString(), Timestamp.now(), Timestamp.now()
            )
            onPositiveClick(it, noteFsModel)
        }
        binding.layoutbutton.btnNegative.setOnClickListener {
            onNegativeClick(it, "")
        }
    }

    fun setData() {
        binding.tvTitle.editText!!.setText(param_notes!!.title)
        binding.tvBody.editText!!.setText(param_notes!!.body)
    }


    companion object {
        @JvmStatic
        fun newInstance(param: NoteFsModel) =
            AddNoteFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM, param)
                }
            }
    }

    override fun onPositiveClick(view: View, obj: Any) {
        var list = ArrayList<NoteFsModel>()
        list.add(obj as NoteFsModel)
        viewModel.addToDatabase(list)
    }

    override fun onNegativeClick(view: View, obj: Any) {
        view.findNavController().navigate(R.id.bankListFragment)

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

    override fun onSuccessListener(obj: ArrayList<Any>?) {
        Toast.makeText(requireContext(), "Data added successfully!", Toast.LENGTH_LONG).show()
    }

    override fun onFailureListener(obj: Any) {
    }


}
