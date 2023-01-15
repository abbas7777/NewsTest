package ir.ahe.abbas.newstest.Home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.ahe.abbas.newstest.Models.News
import ir.ahe.abbas.newstest.R
import ir.ahe.abbas.newstest.databinding.FragmentHomeBinding
import kotlinx.coroutines.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HostFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


@AndroidEntryPoint
class HostFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var viewBinding: FragmentHomeBinding
    val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding=FragmentHomeBinding.inflate(inflater)

        setUpViews()
        return viewBinding.root
    }

    private fun setUpViews() {
        val rvNews=viewBinding.rvHomeFragmentNews
        rvNews.layoutManager=LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)



        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.STARTED){


                homeViewModel.getNews("Apple","2023-01-12","popularity","79819d81c81c4b5aa23c25e99ce15029")


                homeViewModel.news?.observe(viewLifecycleOwner, Observer {
                    val rvNewsAdapter = RvNewsAdapter(requireActivity(), it, object :RvNewsAdapter.OnNewsClickListner{
                        override fun onClick(item: News) {
                            val bundle= bundleOf("newsmodel" to News)
                            viewBinding.root.findNavController().navigate(R.id.action_bnav_home_to_detailFragment,bundle)
                        }

                    })
                    //Log.i("ACE", "setUpViews: " + it.get(0).author)
                    rvNews.adapter = rvNewsAdapter
                })
            }

        }







    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HostFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HostFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}