package d4static.dev999.easynotes.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import d4static.dev999.easynotes.adapter.DashboardItemAdapter
import d4static.dev999.easynotes.base.BaseFragment
import d4static.dev999.easynotes.databinding.FragmentDashboardLayoutBinding
import d4static.dev999.easynotes.model.DashboardItem

class DashBoardFragment : BaseFragment() {

    lateinit var binding: FragmentDashboardLayoutBinding
    lateinit var dashBoardAdapter: DashboardItemAdapter
    lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardLayoutBinding.inflate(inflater, container, false)
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        dashboardViewModel.init("Dashboard")
        dashboardViewModel.mutableLiveData.observe(this, Observer {
            setAdapter(it)
        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    fun setAdapter(items: ArrayList<DashboardItem>) {

        dashBoardAdapter = DashboardItemAdapter()
        dashBoardAdapter.updateItem(items)

        binding.recycleView.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 3)
            adapter = dashBoardAdapter

        }
    }
}