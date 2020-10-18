package com.base.mert.baseproject.core.base


import android.content.Context

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import com.base.mert.baseproject.di.factory.ViewModelFactory
import com.m3chladon.earthquakeanalyst.base.BaseViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject



abstract class BaseFragment<VM: BaseViewModel, DB: ViewDataBinding>(private val viewModelClazz: Class<VM>): Fragment(), LifecycleOwner {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var vm: VM
    lateinit var bd: DB

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        bd = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        vm = ViewModelProviders.of(this, viewModelFactory).get(viewModelClazz)

        savedInstanceState?.let {
            readBundle(it)
        }

        arguments?.let {
            readBundle(it)
        }

        configureViewModel(vm)

        return bd.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureDataBinding(bd)
    }

    abstract fun configureViewModel(viewModel: VM)
    abstract fun configureDataBinding(binding: DB)
    abstract fun readBundle(bundle: Bundle)

    @LayoutRes
    abstract fun getLayoutRes(): Int

    open fun onBackPressed() {}

    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState ==null
}