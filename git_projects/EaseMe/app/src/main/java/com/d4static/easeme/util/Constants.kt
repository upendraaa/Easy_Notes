package com.d4static.easeme.util

class Constants {

    companion object {
        var BASE_URL = "www.google.com"
        val features = arrayOf(
            "Notes", "EmailId's", "Bank Accounts", "Address",
            "Card details", "Entertainment", "Investment", "Loans", "Reminder"
        )
    }

    interface Flag {

        companion object {

            val SENT = 1;
            val UNSENT = 0;
        }
    }


}