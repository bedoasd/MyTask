package com.example.senatask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.senatask.R
import com.example.senatask.adapter.NewsAdapter
import com.example.senatask.databinding.FragmentNewsBinding
import com.example.senatask.myviewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsFragment : Fragment() {
    lateinit var binding:FragmentNewsBinding
    val newsViewModel:MyViewModel by viewModels()
    val newsAdapter  = NewsAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding=FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setRecycler()


        newsAdapter.setOnItemClickListener {
            val bundle =Bundle().apply {
                putSerializable("article",it)
            }
            findNavController().navigate(
                R.id.action_newsFragment_to_detailsFragment,bundle
            )
        }


        lifecycleScope. launch {
            newsViewModel. list. collect { pagingData ->
                newsAdapter. submitData(pagingData)
            }
        }

    }
    private fun setRecycler() {
        binding.rvNews.apply {
            adapter=newsAdapter
            layoutManager = LinearLayoutManager(activity)

        }
    }
}