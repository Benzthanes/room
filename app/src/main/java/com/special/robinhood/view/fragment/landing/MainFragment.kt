package com.special.robinhood.view.fragment.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.special.robinhood.databinding.FragmentMainBinding
import com.special.robinhood.view.adapter.SampleAdapter
import com.special.robinhood.view.fragment.BaseFragment

class MainFragment : BaseFragment(), SampleAdapter.OnHolderClickListener {

    private var binding: FragmentMainBinding? = null
    lateinit var adapter: SampleAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            binding?.apply {
                textTitle1.text = it.getString(DATA1)
                textTitle2.text = it.getString(DATA2)
            }
        }
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = SampleAdapter(this, arrayListOf("KFC", "MK", "CHESTER"))
        binding?.apply {
            recyclerView.adapter = adapter
        }
    }

    override fun onClick(display: String) {
        // onclick
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        private const val DATA1 = "DATA1"
        private const val DATA2 = "DATA2"
        @JvmStatic
        fun newInstance(data1: String, data2: String) = MainFragment().apply {
            arguments = Bundle().apply {
                putString(DATA1, data1)
                putString(DATA2, data2)
            }
        }
    }
}
