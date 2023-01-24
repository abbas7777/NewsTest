package ir.ahe.abbas.newstest.home

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
import ir.ahe.abbas.newstest.models.News
import ir.ahe.abbas.newstest.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HostFragment : Fragment() {

    private lateinit var viewBinding: FragmentHomeBinding
    private lateinit var rvNews: RecyclerView
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewBinding = FragmentHomeBinding.inflate(inflater)

        setUpViews()
        getNews()
        return viewBinding.root
    }

    private fun setUpViews() {
        rvNews = viewBinding.rvHomeFragmentNews
        rvNews.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)


        homeViewModel.getNews(
            "Apple",
            "2023-01-12",
            "popularity",
            "79819d81c81c4b5aa23c25e99ce15029"
        )


    }


    private fun getNews() {
        homeViewModel.news.observe(viewLifecycleOwner) {

            if (it == null) {
                Toast.makeText(requireActivity(), "connection error !", Toast.LENGTH_SHORT)
                    .show()
            }
            val rvNewsAdapter =
                RvNewsAdapter(requireActivity(), it, object : RvNewsAdapter.OnNewsClickListener {
                    override fun onClick(item: News) {

                        Navigation.findNavController(viewBinding.root)
                            .navigate(HostFragmentDirections.actionBnavHomeToDetailFragment(item))

                    }

                })
            //Log.i("ACE", "setUpViews: " + it.get(0).author)
            rvNews.adapter = rvNewsAdapter
        }
    }

}