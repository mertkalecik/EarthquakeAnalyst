package com.m3chladon.earthquakeanalyst.component

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.BindingAdapter

/**
 * Custom View
 */
class RoundedButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttribute: Int = 0
) : AppCompatButton(context, attrs, defStyleAttribute) {


    @BindingAdapter("stringRes")
    fun setText(button: RoundedButton, stringRes: Int) {
        if (stringRes != 0) {
            button.text = button.context.getString(stringRes)
        }
    }

}