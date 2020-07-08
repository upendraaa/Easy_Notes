package d4static.dev999.easynotes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import d4static.dev999.easynotes.base.BaseActivity
import d4static.dev999.easynotes.dashboard.DashboardActivity
import d4static.dev999.easynotes.manager.PreferenceManager
import kotlinx.android.synthetic.main.layout_appbar.*

class Register : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setSupportActionBar(toolbar)
        toolbar.setTitle("Register")
    }

    override fun onStart() {
        super.onStart()
        startDashboardActivity();
        /*// Choose authentication providers
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )

// Create and launch sign-in intent
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            RC_SIGN_IN
        )*/
    }

    // [START auth_fui_result]
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser


                val email = user!!.email
                val mobile = user.phoneNumber
                val name = user.displayName
                val photoUri = user.photoUrl
                val userId = user.uid
                PreferenceManager.getPreference().setData(PreferenceManager.USER_ID, userId)
                PreferenceManager.getPreference().setData(PreferenceManager.EMAIL_ID, email)
                PreferenceManager.getPreference().setData(PreferenceManager.MOBILE_NUMBER, mobile)


              startDashboardActivity();


            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }
    // [END auth_fui_result]

    private fun signOut() {
        // [START auth_fui_signout]
        AuthUI.getInstance()
            .signOut(this)
            .addOnCompleteListener {
                // ...
            }
        // [END auth_fui_signout]
    }

    private fun delete() {
        // [START auth_fui_delete]
        AuthUI.getInstance()
            .delete(this)
            .addOnCompleteListener {
                // ...
            }
        // [END auth_fui_delete]
    }

    private fun themeAndLogo() {
        val providers = emptyList<AuthUI.IdpConfig>()

        // [START auth_fui_theme_logo]
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setLogo(R.drawable.ic_launcher_background) // Set logo drawable
                .setTheme(R.style.AppTheme) // Set theme
                .build(),
            RC_SIGN_IN
        )
        // [END auth_fui_theme_logo]
    }

    private fun privacyAndTerms() {
        val providers = emptyList<AuthUI.IdpConfig>()
        // [START auth_fui_pp_tos]
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setTosAndPrivacyPolicyUrls(
                    "https://example.com/terms.html",
                    "https://example.com/privacy.html"
                )
                .build(),
            RC_SIGN_IN
        )
        // [END auth_fui_pp_tos]
    }

    fun startDashboardActivity(){
        startActivity(
            Intent(
                this,
                DashboardActivity::class.java
            )
        )
    }

    companion object {

        private const val RC_SIGN_IN = 123
    }
}
