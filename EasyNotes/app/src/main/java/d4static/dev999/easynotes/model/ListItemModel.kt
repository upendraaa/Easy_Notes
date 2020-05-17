package d4static.dev999.easynotes.model

data class ListItemModel(
    val id: Int, val title: String, val subTitle: String
    , val base64: String, val isSelected: Boolean,
    val objType: Any
) {

}