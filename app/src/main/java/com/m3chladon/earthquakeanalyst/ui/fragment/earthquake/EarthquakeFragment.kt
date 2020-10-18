package com.m3chladon.earthquakeanalyst.ui.fragment.earthquake

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.mert.baseproject.core.base.BaseFragment
import com.m3chladon.earthquakeanalyst.R
import com.m3chladon.earthquakeanalyst.data.Constants.KEY_EVENT_DATA
import com.m3chladon.earthquakeanalyst.data.Constants.UI
import com.m3chladon.earthquakeanalyst.data.Event
import com.m3chladon.earthquakeanalyst.data.repo.EventRepository
import com.m3chladon.earthquakeanalyst.databinding.FragmentEarthquakesBinding
import com.m3chladon.earthquakeanalyst.extensions.navigateWithAnim
import com.m3chladon.earthquakeanalyst.extensions.navigateWithBundle
import com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.data.EarthquakeViewEntity
import com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.list.EventAdapter
import com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.list.toEventListEntity
import com.m3chladon.earthquakeanalyst.vm.EarthquakeFragmentViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class EarthquakeFragment: BaseFragment<EarthquakeFragmentViewModel,
        FragmentEarthquakesBinding>(EarthquakeFragmentViewModel::class.java) {

    @Inject
    lateinit var eventRepository: EventRepository

    private val eventAdapter: EventAdapter by lazy {
        EventAdapter(vm.eventList).apply {
            clickListener = {
                navigateWithBundle(R.id.action_earthquakeFragment_to_eventDetailsFragment, bundleOf(
                    KEY_EVENT_DATA to it
                ))
            }
        }
    }

    override fun configureViewModel(viewModel: EarthquakeFragmentViewModel) {

    }

    override fun configureDataBinding(binding: FragmentEarthquakesBinding) {
        binding.viewModel = vm
        bindAdapter()
    }

    /**
     * Set Content
     */
    private fun setContent(bundleData: MutableList<Event>) {
        val list = bundleData.toEventListEntity()
        vm.eventList.addAll(list)
        eventAdapter.notifyDataSetChanged()
    }

    /**
     * Bind Adapter
     */
    private fun bindAdapter() {
        bd.apply {
            rvEarthquake.setHasFixedSize(true)
            rvEarthquake.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rvEarthquake.adapter = eventAdapter
        }
    }

    override fun readBundle(bundle: Bundle) {
        bundle.getParcelable<EarthquakeViewEntity>(KEY_EVENT_DATA)?.let {
            setContent(it.mutableList)
        }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_earthquakes
}