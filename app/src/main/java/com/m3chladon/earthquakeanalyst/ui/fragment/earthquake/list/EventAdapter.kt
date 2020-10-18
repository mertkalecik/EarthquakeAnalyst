package com.m3chladon.earthquakeanalyst.ui.fragment.earthquake.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.m3chladon.earthquakeanalyst.R
import com.m3chladon.earthquakeanalyst.data.Event
import com.m3chladon.earthquakeanalyst.databinding.EarthquakeListItemBinding
import com.m3chladon.earthquakeanalyst.extensions.setBackground

private const val depthPostFix = "km"

class EventAdapter(
    private val dataList: List<EventListItem>
): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    var clickListener: (itemModel: EventListItem) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = DataBindingUtil.inflate<EarthquakeListItemBinding>(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )

        return EventViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) = holder.bind(dataList[position])

    override fun getItemViewType(position: Int): Int = R.layout.earthquake_list_item

    inner class EventViewHolder(
        private val binding: EarthquakeListItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: EventListItem) {
            binding.root.setOnClickListener {
                clickListener.invoke(data)
            }
            val felt = "${data.felt} $depthPostFix"
            binding.run {
                tvIcon.text = data.mag
                tvPlace.text = data.place
                tvFelt.text = felt
                tvDate.text = data.date
                tvTime.text = data.time
                tvIcon.setBackground(data.iconRes)
            }
        }
    }

}