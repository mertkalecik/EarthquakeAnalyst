package com.m3chladon.earthquakeanalyst.ui.fragment

import android.os.Bundle
import androidx.core.os.bundleOf
import com.base.mert.baseproject.core.base.BaseFragment
import com.m3chladon.earthquakeanalyst.R
import com.m3chladon.earthquakeanalyst.data.Constants.KEY_EVENT_DATA
import com.m3chladon.earthquakeanalyst.data.repo.EventRepository
import com.m3chladon.earthquakeanalyst.databinding.FragmentHomeBinding
import com.m3chladon.earthquakeanalyst.extensions.navigateWithAnim
import com.m3chladon.earthquakeanalyst.extensions.navigateWithBundle
import com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.list.toEarthquakeViewEntity
import com.m3chladon.earthquakeanalyst.vm.HomeFragmentViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeFragment: BaseFragment<HomeFragmentViewModel, FragmentHomeBinding>(HomeFragmentViewModel::class.java) {

    @Inject
    lateinit var eventRepository: EventRepository

    override fun readBundle(bundle: Bundle) {}

    override fun configureViewModel(viewModel: HomeFragmentViewModel) {
        setContent()
    }

    private fun setContent() {
        if (vm.eventList.isNullOrEmpty()) {
            GlobalScope.launch {
                withContext(Dispatchers.Default) { eventRepository.getAllEvents() }
                    .also {
                        it?.let {
                            vm.eventList = it.toMutableList()
                            vm.progEarth = it.size.toFloat()
                            vm.resultText = "${it.size}"
                            vm.numEarthquake = "${it.size}/500"
                        }
                    }
            }
        } else {
            vm.eventList.let {
                vm.progEarth = it.size.toFloat()
                vm.resultText = "${it.size}"
                vm.numEarthquake = "${it.size}/500"
            }
        }
    }

    override fun configureDataBinding(binding: FragmentHomeBinding) {
        binding.viewModel = vm

        binding.roundedButton.setOnClickListener {
            val bundle = bundleOf(
                KEY_EVENT_DATA to vm.eventList.toEarthquakeViewEntity()
            )
            navigateWithBundle(R.id.action_homeFragment_to_earthquakeFragment, bundle)
        }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_home
}