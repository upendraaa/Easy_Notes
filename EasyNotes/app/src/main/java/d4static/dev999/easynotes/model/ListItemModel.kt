package d4static.dev999.easynotes.model

import java.util.*

data class ListItemModel(
    val id: Int, val title: String, val subTitle: String?
    , val base64: String?, val isSelected: Boolean?,
    val objType: Any, val date: Date
) {

}