package ir.ahe.abbas.newstest.Detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import ir.ahe.abbas.newstest.Models.News
import ir.ahe.abbas.newstest.R
import ir.ahe.abbas.newstest.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {




    lateinit var viewBinding: FragmentDetailBinding
    lateinit var news: News
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDetailBinding.inflate(inflater)
        news= DetailFragmentArgs.fromBundle(requireArguments()).news
        setUpViews()

        return viewBinding.root
    }

    private fun setUpViews() {
        val imvImage:ImageView=viewBinding.imvDetailFragmentImage
        val txtTitle:TextView=viewBinding.txtDetailFragmentTitle
        val txtContent:TextView=viewBinding.txtDetailFragmentContent
        val txtPublishTime:TextView=viewBinding.txtDetailFragmentPublishTime

        txtTitle.text=news.title
        txtContent.text=news.content
        txtPublishTime.text=news.publishedAt

        Picasso.get().load(news.urlToImage).into(imvImage)
    }


}