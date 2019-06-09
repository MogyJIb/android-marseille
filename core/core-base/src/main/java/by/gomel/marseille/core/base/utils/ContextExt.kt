package by.gomel.marseille.core.base.utils

import android.content.Context
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import by.gomel.marseille.core.base.R


fun Context.toast(text: String)
    = Toast.makeText(this, text, Toast.LENGTH_LONG).apply {
        setGravity(Gravity.CENTER, 0, (-200).dp)

        val toastView = view as LinearLayout
        toastView.setBackgroundResource(R.drawable.background_toast)

        val toastMessage = toastView.findViewById(android.R.id.message) as TextView
        toastMessage.textSize = 16f
        toastMessage.setTextColor(resources.getColor(R.color.text_primary_inverse))
        toastMessage.gravity = Gravity.CENTER
        toastMessage.setPadding(16.dp, 32.dp, 16.dp, 32.dp)
    }
    .show()

