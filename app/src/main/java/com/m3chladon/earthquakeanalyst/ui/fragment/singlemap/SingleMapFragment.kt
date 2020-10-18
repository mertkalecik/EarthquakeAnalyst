package com.m3chladon.earthquakeanalyst.ui.fragment.singlemap

import android.os.Bundle
import com.base.mert.baseproject.core.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.m3chladon.earthquakeanalyst.R
import com.m3chladon.earthquakeanalyst.data.Constants
import com.m3chladon.earthquakeanalyst.data.Constants.SINGLE_VIEW_ZOOM
import com.m3chladon.earthquakeanalyst.databinding.FragmentSingleMapBinding
import com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.list.EventListItem
import com.m3chladon.earthquakeanalyst.vm.SingleMapFragmentViewModel

class SingleMapFragment : BaseFragment<SingleMapFragmentViewModel, FragmentSingleMapBinding>(
    SingleMapFragmentViewModel::class.java
), OnMapReadyCallback {

    lateinit var googleMap: GoogleMap

    override fun configureViewModel(viewModel: SingleMapFragmentViewModel) {

    }

    override fun configureDataBinding(binding: FragmentSingleMapBinding) {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun readBundle(bundle: Bundle) {
        bundle.getParcelable<EventListItem>(Constants.KEY_EVENT_DATA)?.let {
            vm.eventListItem = it
        }
    }

    override fun getLayoutRes(): Int = R.layout.fragment_single_map

    override fun onMapReady(map: GoogleMap?) {
        map?.let { googleMap = it }
        vm.eventListItem?.let { setContent(it) }
    }

    private fun setContent(data: EventListItem) {
        data.latitude?.let { lat ->
            data.longitute?.let { long ->
                val latLng = LatLng(lat.toDouble(), long.toDouble())
                googleMap.moveCamera(
                    CameraUpdateFactory.newLatLngZoom(
                        latLng,
                        SINGLE_VIEW_ZOOM
                    )
                )

                val detail = data.mag ?: ""
                val place = data.place ?: ""

                googleMap.addMarker(MarkerOptions()
                    .position(latLng)
                    .title(place)
                    .snippet(detail)
                )
            }
        }

    }

}