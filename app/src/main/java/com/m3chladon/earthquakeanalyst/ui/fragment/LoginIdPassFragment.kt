package com.m3chladon.earthquakeanalyst.ui.fragment


import android.content.Intent
import android.os.Bundle
import android.view.View
import com.base.mert.baseproject.core.base.BaseFragment
import com.m3chladon.earthquakeanalyst.R
import com.m3chladon.earthquakeanalyst.databinding.FragmentLoginIdPassBinding
import com.m3chladon.earthquakeanalyst.ui.activity.MainActivity
import com.m3chladon.earthquakeanalyst.vm.LoginIdPassViewModel

class LoginIdPassFragment: BaseFragment<LoginIdPassViewModel, FragmentLoginIdPassBinding>(LoginIdPassViewModel::class.java) {


    override fun readBundle(bundle: Bundle) {

    }

    override fun configureDataBinding(binding: FragmentLoginIdPassBinding) {
        binding.button1.setOnClickListener(View.OnClickListener {
            vm.onButtonClicked()
        })
        binding.appCompatTextView.text = "Merto"
    }

    override fun configureViewModel(viewModel: LoginIdPassViewModel) {
        vm.clickItemActionLiveData.observeForever {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_login_id_pass

}