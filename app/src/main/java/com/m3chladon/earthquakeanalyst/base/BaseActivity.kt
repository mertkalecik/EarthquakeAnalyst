package com.m3chladon.earthquakeanalyst.base


import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.base.mert.baseproject.di.factory.ViewModelFactory
import com.m3chladon.earthquakeanalyst.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity<VM: BaseViewModel, DB: ViewDataBinding>(val viewModelClazz: Class<VM>): AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var factory: ViewModelFactory

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @LayoutRes
    abstract fun getLayoutRes(): Int

    val bd by lazy {
        DataBindingUtil.setContentView(this, getLayoutRes()) as DB
    }

    val vm by lazy {
        ViewModelProviders.of(this, factory).get(viewModelClazz)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        intent.extras?.let {
            readBundle(intent.extras)
        }

        configureViewModel(vm)
        configureDataBinding(bd)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(getLayoutRes())
        initToolbar()
    }

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        if (toolbar != null)
            setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("Login")
    }


    abstract fun configureViewModel(viewModel: VM)
    abstract fun configureDataBinding(binding: DB)
    abstract fun readBundle(bundle: Bundle)

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}