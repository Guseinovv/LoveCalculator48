package com.example.lovecalculator48.history

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator48.R
import com.example.lovecalculator48.App
import com.example.lovecalculator48.core.BaseFragment
import com.example.lovecalculator48.databinding.FragmentHistoryBinding


class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {
    lateinit var adapter: HistoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun inflate(): FragmentHistoryBinding {
        return FragmentHistoryBinding.inflate(layoutInflater)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeHistory()
    }


    private fun observeHistory() {
        App.dp.historyDao().getAll().observe(viewLifecycleOwner) { data ->
            Log.e("ololo", "onViewCreated$data")
            adapter = HistoryAdapter(data)
            binding.recucleview.adapter = this.adapter

            rename()
        }
    }


    private fun rename() {
        adapter.onClick = {
            val bundle = Bundle()
            bundle.putString("key1", it.firstname)
            findNavController().navigate(R.id.loveFragment, bundle)
        }
    }
}