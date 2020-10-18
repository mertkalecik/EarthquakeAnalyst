package com.m3chladon.earthquakeanalyst.ui.fragment.eventdetails.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.m3chladon.earthquakeanalyst.R
import com.m3chladon.earthquakeanalyst.databinding.ItemEventBinding
import com.m3chladon.earthquakeanalyst.databinding.ItemEventHeaderBinding

class EventDetailsAdapter(
    private val dataList: MutableList<IEventDetails>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            R.layout.item_event_header -> {
                val binding = DataBindingUtil.inflate<ItemEventHeaderBinding>(
                    LayoutInflater.from(parent.context),
                    viewType,
                    parent,
                    false
                )
                return HeaderViewHolder(binding)
            }
            else -> {
                val binding = DataBindingUtil.inflate<ItemEventBinding>(
                    LayoutInflater.from(parent.context),
                    viewType,
                    parent,
                    false
                )
                return ItemViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is HeaderViewHolder -> holder.bind(dataList[position] as EventHeaderItem)
            is ItemViewHolder -> holder.bind(dataList[position] as EventItem)
        }
    }


    override fun getItemViewType(position: Int): Int = when(dataList[position]) {
        is EventHeaderItem -> R.layout.item_event_header
        else -> R.layout.item_event
    }

    inner class HeaderViewHolder(val binding: ItemEventHeaderBinding):
            RecyclerView.ViewHolder(binding.root) {

        fun bind(data: EventHeaderItem) {
            binding.data = data
        }
    }

    inner class ItemViewHolder(val binding: ItemEventBinding):
            RecyclerView.ViewHolder(binding.root) {

        fun bind(data: EventItem) {
            binding.data = data
        }
    }
}