package com.m3chladon.earthquakeanalyst.ui.fragment.person.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.swipe.SwipeLayout
import com.daimajia.swipe.implments.SwipeItemRecyclerMangerImpl
import com.daimajia.swipe.interfaces.SwipeAdapterInterface
import com.daimajia.swipe.interfaces.SwipeItemMangerInterface
import com.daimajia.swipe.util.Attributes
import com.m3chladon.earthquakeanalyst.R
import com.m3chladon.earthquakeanalyst.databinding.ItemPersonBinding
import com.m3chladon.earthquakeanalyst.extensions.setDrawable
import com.m3chladon.earthquakeanalyst.ui.fragment.person.data.Person

class PersonAdapter(
    private val itemList: MutableList<Person>
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>(),
    SwipeItemMangerInterface, SwipeAdapterInterface {

    var clickListener: (person : Person) -> Unit = {}

    var swipeManager = SwipeItemRecyclerMangerImpl(this).apply {
        mode = Attributes.Mode.Single
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = DataBindingUtil.inflate<ItemPersonBinding>(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )

        return PersonViewHolder(binding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) = holder.bind(itemList[position])

    override fun getItemViewType(position: Int): Int = R.layout.item_person

    inner class PersonViewHolder(
        private val binding: ItemPersonBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Person) {
            binding.run {
                swipeManager.bindView(swipeLayout, adapterPosition)
                swipeLayout.isRightSwipeEnabled = true
                swipeA.setOnClickListener {
                    swipeManager.closeAllItems()
                    clickListener.invoke(data)
                }
                mainContent.setOnClickListener {
                    swipeManager.closeAllItems()
                }
                tvName.text = data.Name
                tvSurname.text = data.Surname
                tvPlace.text = data.Place
                tvRelation.text = data.Relation
                ivPerson.setDrawable(data.Gender)
            }
        }
    }

    override fun closeAllExcept(layout: SwipeLayout?) = swipeManager.closeAllExcept(layout)

    override fun setMode(mode: Attributes.Mode?)  {
        swipeManager.mode = mode
    }

    override fun closeAllItems() = swipeManager.closeAllItems()

    override fun removeShownLayouts(layout: SwipeLayout?) = swipeManager.removeShownLayouts(layout)

    override fun getOpenItems(): MutableList<Int> = swipeManager.openItems

    override fun isOpen(position: Int): Boolean = swipeManager.isOpen(position)

    override fun openItem(position: Int) = swipeManager.openItem(position)

    override fun getMode(): Attributes.Mode = swipeManager.mode

    override fun getOpenLayouts(): MutableList<SwipeLayout> = swipeManager.openLayouts

    override fun closeItem(position: Int) = swipeManager.closeItem(position)

    override fun getSwipeLayoutResourceId(position: Int): Int = R.id.swipe_layout
}