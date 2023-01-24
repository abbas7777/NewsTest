package ir.ahe.abbas.newstest.category.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ir.ahe.abbas.newstest.home.RvNewsAdapter
import ir.ahe.abbas.newstest.models.News
import ir.ahe.abbas.newstest.databinding.FragmentNewsBinding


@AndroidEntryPoint
class NewsFragment : Fragment() {

    lateinit var viewBinding: FragmentNewsBinding
    lateinit var newsType:String
    lateinit var rvNews:RecyclerView
    val newwViewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewBinding = FragmentNewsBinding.inflate(inflater)
        setUpViews()
        getNewsCat()
        return viewBinding.root
    }

    private fun setUpViews() {
        newsType=NewsFragmentArgs.fromBundle(requireArguments()).newstype
         rvNews= viewBinding.rvNewsFragmentList
        rvNews.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        newwViewModel.getCatNews(newsType,"79819d81c81c4b5aa23c25e99ce15029")

    }

    private fun getNewsCat() {


        newwViewModel.news.observe(viewLifecycleOwner,{

            if (it.size==0){
                Toast.makeText(requireActivity(),"connection error !", Toast.LENGTH_SHORT).show()
            }
            rvNews.adapter=RvNewsAdapter(requireActivity(),it,object :RvNewsAdapter.OnNewsClickListner{
                override fun onClick(item: News) {
                    Navigation.findNavController(viewBinding.root).navigate(NewsFragmentDirections.actionNewsFragmentToDetailFragment(item))

                }
            })
        })
    }
}