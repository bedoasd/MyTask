package com.example.senatask.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.senatask.R
import com.example.senatask.adapter.NewsAdapter
import com.example.senatask.databinding.FragmentDetailsBinding
import com.example.senatask.databinding.FragmentNewsBinding
import com.example.senatask.myviewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_details.*
import org.junit.Test

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    lateinit var binding: FragmentDetailsBinding
    val args: DetailsFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val article = args.article

        binding.backIc.setOnClickListener {
            findNavController().popBackStack()
        }

        val imageUrl=article.media[0].media_metadata[0].url
        Glide.with(iv_article).load(imageUrl).into(iv_article)
        binding.tvTitle.text = article.title
        binding.tvPublishedBy.text = article.published_date
        binding.tvDate.text = article.published_date

        binding.btnShare.setOnClickListener {

          shareImage(imageUrl)

        }


    }

    fun shareImage(url:String){
        val sendIntent = Intent(
            Intent.ACTION_SEND
        ).apply {
            putExtra(Intent.EXTRA_TEXT,url)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(
            sendIntent,null
        )
        startActivity(shareIntent)
    }





}