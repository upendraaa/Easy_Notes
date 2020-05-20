package d4static.dev999.easynotes.callback

interface OnServerResponseListener {

    fun onSuccessListener(obj: ArrayList<Any>?)
    fun onFailureListener(obj: Any)
}