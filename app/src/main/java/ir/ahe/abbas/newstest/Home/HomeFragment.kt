package ir.ahe.abbas.newstest.Home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ir.ahe.abbas.newstest.Models.News
import ir.ahe.abbas.newstest.R
import ir.ahe.abbas.newstest.databinding.FragmentHomeBinding
import kotlinx.coroutines.*

@AndroidEntryPoint
class HostFragment : Fragment() {

    lateinit var viewBinding: FragmentHomeBinding
    lateinit var rvNews:RecyclerView
    val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding=FragmentHomeBinding.inflate(inflater)

        setUpViews()
        getNews()
        return viewBinding.root
    }

    private fun setUpViews() {
         rvNews=viewBinding.rvHomeFragmentNews
        rvNews.layoutManager=LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)


        homeViewModel.getNews("Apple","2023-01-12","popularity","79819d81c81c4b5aa23c25e99ce15029")


    }


    private fun getNews() {
        homeViewModel.news.observe(viewLifecycleOwner, Observer {
            if (it.size==0){
                Toast.makeText(requireActivity(),"connection error !",Toast.LENGTH_SHORT).show()
            }
            val rvNewsAdapter = RvNewsAdapter(requireActivity(), it, object :RvNewsAdapter.OnNewsClickListner{
                override fun onClick(item: News) {

                    Navigation.findNavController(viewBinding.root).navigate(HostFragmentDirections.actionBnavHomeToDetailFragment(item))

                }

            })
            //Log.i("ACE", "setUpViews: " + it.get(0).author)
            rvNews.adapter = rvNewsAdapter
        })
    }

}