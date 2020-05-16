package d4static.dev999.easynotes.viewmodels

import androidx.lifecycle.MutableLiveData
import d4static.dev999.easynotes.R
import d4static.dev999.easynotes.base.BaseViewModel
import d4static.dev999.easynotes.model.DashboardItem

class DashboardViewModel : BaseViewModel() {

    lateinit var mutableLiveData: MutableLiveData<ArrayList<DashboardItem>>

    override fun init(obj: Any) {
        super.init(obj)
        setDashboardItems()
    }


    fun setDashboardItems() {
        var dashboardItems = ArrayList<DashboardItem>()
        var dashboardItem = DashboardItem("Notes", "BASE64 Image", 1, R.drawable.ic_notes)
        dashboardItems.add(dashboardItem)
        dashboardItem = DashboardItem("Contacts", "BASE64 Image", 2, R.drawable.ic_contacts)
        dashboardItems.add(dashboardItem)
        dashboardItem = DashboardItem("Calendar", "BASE64 Image", 3, R.drawable.ic_calendar)
        dashboardItems.add(dashboardItem)
        dashboardItem = DashboardItem("Cards", "BASE64 Image", 4, R.drawable.ic_bank_card)
        dashboardItems.add(dashboardItem)
        dashboardItem = DashboardItem("Banks", "BASE64 Image", 5, R.drawable.ic_bank)
        dashboardItems.add(dashboardItem)

        mutableLiveData = MutableLiveData()
        mutableLiveData.value = dashboardItems
    }

}