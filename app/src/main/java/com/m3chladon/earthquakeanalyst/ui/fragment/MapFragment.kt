package com.m3chladon.earthquakeanalyst.ui.fragment

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.base.mert.baseproject.core.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.m3chladon.earthquakeanalyst.R
import com.m3chladon.earthquakeanalyst.data.Constants.BASE_LATITUDE
import com.m3chladon.earthquakeanalyst.data.Constants.BASE_LONGITUDE
import com.m3chladon.earthquakeanalyst.data.Constants.BASE_ZOOM
import com.m3chladon.earthquakeanalyst.data.Constants.IO
import com.m3chladon.earthquakeanalyst.data.Constants.KEY_EVENT_DATA
import com.m3chladon.earthquakeanalyst.data.Constants.UI
import com.m3chladon.earthquakeanalyst.data.repo.EventRepository
import com.m3chladon.earthquakeanalyst.databinding.FragmentMapBinding
import com.m3chladon.earthquakeanalyst.extensions.navigateWithBundle
import com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.list.toEventListItem
import com.m3chladon.earthquakeanalyst.vm.MapFragmentViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject


class MapFragment : BaseFragment<MapFragmentViewModel, FragmentMapBinding>(
    MapFragmentViewModel::class.java
), OnMapReadyCallback {

    @Inject
    lateinit var eventRepository: EventRepository

    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun configureViewModel(viewModel: MapFragmentViewModel) {

    }

    override fun configureDataBinding(binding: FragmentMapBinding) {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun initializeMap() {
        GlobalScope.launch(UI){
            val list = GlobalScope.async(IO) {
                eventRepository.getAllEvents()
            }.await()

            val base = LatLng(BASE_LATITUDE, BASE_LONGITUDE)
            googleMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                    base,
                    BASE_ZOOM
                )
            )

            googleMap.setOnInfoWindowClickListener { marker ->
                val event = vm.map.get(marker)?.toEventListItem()
                navigateWithBundle(R.id.action_mapFragment_to_eventDetailsFragment, bundleOf(
                    KEY_EVENT_DATA to event
                ))
            }

            list?.forEach { event ->
                val lat = event.latitude ?: "0.0"
                val long = event.longitude ?: "0.0"
                val place = event.place ?: ""
                val mag = event.mag ?: ""

                val latLng = LatLng(lat.toDouble(), long.toDouble())

                val markerOptions = MarkerOptions()
                    .position(latLng)

                    .title(place)
                    .snippet(mag)

                val marker = googleMap.addMarker(markerOptions)
                vm.map.put(marker, event)
            }

        }
    }

    override fun onMapReady(map: GoogleMap?) {
        map?.let { googleMap = it }
        /*
        val marashta = LatLng(19.1692, 73.3416)
        map?.addMarker(MarkerOptions().position(marashta).title("Test"))
        map?.moveCamera(CameraUpdateFactory.newLatLng(marashta))*/
        initializeMap()
    }

    override fun readBundle(bundle: Bundle) {
    }

    override fun getLayoutRes(): Int = R.layout.fragment_map
}