package com.m3chladon.earthquakeanalyst.extensions


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.base.mert.baseproject.di.factory.ViewModelFactory

@Suppress("UNCHECKED_CAST")
inline fun <reified T: ViewModel> Fragment.getViewModel(factory: ViewModelFactory, body: T.() -> Unit): T {
    val vm = ViewModelProviders.of(this, factory).get(T::class.java)
    vm.body()
    return vm
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T: ViewModel> Fragment.generateExtraViewModel(body: T.() -> Unit): T {
    return ViewModelProviders.of(this).get(T::class.java)
}

fun Fragment.navigateWithAnim(action: Int) {
    findNavController().navigate(action)
}

fun Fragment.navigateWithBundle(action: Int, bundle: Bundle) =
    findNavController().navigate(action, bundle)

