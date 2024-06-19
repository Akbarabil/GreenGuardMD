package com.example.greenguard.view.customView

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.example.greenguard.R

class PasswordCustomField : AppCompatEditText {
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                sequence: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

            override fun onTextChanged(
                sequence: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
                if (sequence.length < 8) {
                    val errorIcon: Drawable? = ContextCompat.getDrawable(
                        context,
                        R.drawable.baseline_error
                    )
                    errorIcon?.setBounds(0, 0, errorIcon.intrinsicWidth, errorIcon.intrinsicHeight)

                    val errorMessage = context.getString(R.string.error_password)
                    setError(errorMessage, errorIcon)
                } else {
                    error = null
                }
            }

            override fun afterTextChanged(editable: Editable?) {

            }
        })
    }
}