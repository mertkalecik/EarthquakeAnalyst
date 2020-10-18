package com.m3chladon.earthquakeanalyst.ui.fragment.person

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.mert.baseproject.core.base.BaseFragment
import com.m3chladon.earthquakeanalyst.R
import com.m3chladon.earthquakeanalyst.databinding.FragmentPersonBinding
import com.m3chladon.earthquakeanalyst.ui.fragment.person.data.Person
import com.m3chladon.earthquakeanalyst.ui.fragment.person.list.PersonAdapter
import com.m3chladon.earthquakeanalyst.vm.PersonFragmentViewModel


class PersonFragment: BaseFragment<PersonFragmentViewModel, FragmentPersonBinding>(PersonFragmentViewModel::class.java) {

    private val personAdapter: PersonAdapter by lazy {
        PersonAdapter(vm.personList).apply {
            clickListener = {
                deletePerson(it)
            }
        }
    }

    override fun configureViewModel(viewModel: PersonFragmentViewModel) {

    }

    override fun configureDataBinding(binding: FragmentPersonBinding) {
        bindAdapter()
        binding.btnAdd.setOnClickListener {

        }



        personAdapter.notifyDataSetChanged()
    }

    /**
     * Bind Adapter
     */
    private fun bindAdapter() {
        bd.apply {
            rvPerson.setHasFixedSize(true)
            rvPerson.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rvPerson.adapter = personAdapter
        }
    }

    /**
     * Delete Person
     */
    private fun deletePerson(person: Person) {
        vm.personList.remove(person)
        personAdapter.notifyDataSetChanged()
    }

    override fun readBundle(bundle: Bundle) {

    }

    override fun getLayoutRes(): Int = R.layout.fragment_person
}