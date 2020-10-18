package com.m3chladon.earthquakeanalyst.ui.fragment.eventdetails

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.mert.baseproject.core.base.BaseFragment
import com.m3chladon.earthquakeanalyst.R
import com.m3chladon.earthquakeanalyst.data.Constants.KEY_EVENT_DATA
import com.m3chladon.earthquakeanalyst.databinding.FragmentEventDetailsBinding
import com.m3chladon.earthquakeanalyst.extensions.navigateWithBundle
import com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.list.EventListItem
import com.m3chladon.earthquakeanalyst.ui.fragment.eventdetails.list.EventDetailsAdapter
import com.m3chladon.earthquakeanalyst.vm.EventDetailsFragmentViewModel

class EventDetailsFragment :
    BaseFragment<EventDetailsFragmentViewModel, FragmentEventDetailsBinding>(
        EventDetailsFragmentViewModel::class.java
    ) {

    private val detailsAdapter: EventDetailsAdapter by lazy {
        EventDetailsAdapter(vm.dataList)
    }

    override fun configureViewModel(viewModel: EventDetailsFragmentViewModel) {

    }

    override fun configureDataBinding(binding: FragmentEventDetailsBinding) {
        binding.viewModel = vm
        bindAdapter()

        binding.fabMap.setOnClickListener {
            navigateWithBundle(
                R.id.action_eventDetailsFragment_to_singleMapFragment, bundleOf(
                    KEY_EVENT_DATA to vm.eventItem
                )
            )
        }
    }

    private fun bindAdapter() {
        bd.apply {
            rvDetails.setHasFixedSize(true)
            rvDetails.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rvDetails.adapter = detailsAdapter
        }

    }

    override fun readBundle(bundle: Bundle) {
        bundle.getParcelable<EventListItem>(KEY_EVENT_DATA)?.let {
            setContent(it)
        }
    }

    private fun setContent(event: EventListItem) {
        bd.apply {
            lblMag.text = event.mag
            lblDepth.text = event.felt
            lblPlace.text = event.place
        }

        vm.bindData(event)
        detailsAdapter.notifyDataSetChanged()
    }

    override fun getLayoutRes(): Int = R.layout.fragment_event_details

}