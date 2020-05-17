package d4static.dev999.easynotes.dashboard

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
import androidx.recyclerview.widget.GridLayoutManager
import d4static.dev999.easynotes.R
import d4static.dev999.easynotes.adapter.DashboardItemAdapter
import d4static.dev999.easynotes.base.BaseFragment
import d4static.dev999.easynotes.callback.OnItemClickListener
import d4static.dev999.easynotes.databinding.FragmentDashboardLayoutBinding
import d4static.dev999.easynotes.model.DashboardItem
import d4static.dev999.easynotes.viewmodels.DashboardViewModel

private const val ARG_PARAM = "param"
private const val TAG = "DashBoardFragment"

private lateinit var binding: FragmentDashboardLayoutBinding
private lateinit var viewModel: DashboardViewModel


class DashBoardFragment : BaseFragment(), OnItemClickListener {
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
            DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard_layout, container, false)
        viewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        viewModel.init("Dashboard")
        viewModel.mutableLiveData.observe(viewLifecycleOwner, Observer {
            setAdapter(it)
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

    lateinit var dashBoardAdapter: DashboardItemAdapter
    fun setAdapter(items: ArrayList<DashboardItem>) {

        dashBoardAdapter = DashboardItemAdapter(this)
        dashBoardAdapter.updateItem(items)

        binding.recycleView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 3)
            adapter = dashBoardAdapter

        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashBoardFragment().apply {
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

    override fun onItemClick(obj: Any?, view: View?) {

        navigate(requireView(), R.id.noteListFragment)
    }

    override fun onLongClick(obj: Any?, view: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(obj: Any?, view: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}
