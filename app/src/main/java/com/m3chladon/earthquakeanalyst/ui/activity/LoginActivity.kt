package com.m3chladon.earthquakeanalyst.ui.activity

import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import com.m3chladon.earthquakeanalyst.base.BaseActivity
import com.m3chladon.earthquakeanalyst.databinding.ActivityLoginBinding
import com.m3chladon.earthquakeanalyst.vm.LoginViewModel
import com.m3chladon.earthquakeanalyst.R
import dagger.android.*

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>(LoginViewModel::class.java) {

    override fun readBundle(bundle: Bundle) {

    }

    override fun configureDataBinding(binding: ActivityLoginBinding) {

    }

    override fun configureViewModel(viewModel: LoginViewModel) {

    }

    override fun getLayoutRes(): Int = R.layout.activity_login

    override fun onSupportNavigateUp() =
            findNavController(this, R.id.my_nav_host_Fragment).navigateUp()

}
