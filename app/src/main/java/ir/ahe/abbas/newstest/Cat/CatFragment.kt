package ir.ahe.abbas.newstest.Cat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.ahe.abbas.newstest.Models.Cat
import ir.ahe.abbas.newstest.R
import ir.ahe.abbas.newstest.databinding.FragmentCatBinding


class CatFragment : Fragment() {


    lateinit var viewBinding: FragmentCatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding=FragmentCatBinding.inflate(inflater)

        setUpViews()
        return viewBinding.root
    }

    private fun setUpViews() {
        var rvCat:RecyclerView=viewBinding.rvHomeFragmentCat
        rvCat.layoutManager=LinearLayoutManager(requireActivity(),RecyclerView.VERTICAL,false)


        var catBBC=Cat("BBC News" , "bbc-news")
        var catCNN=Cat("CNN News" , "cnn")
        var catFox=Cat("FOX News" , "fox-news")

        var catList=ArrayList<Cat>()

        catList.add(catBBC)
        catList.add(catCNN)
        catList.add(catFox)

        rvCat.adapter=RvCatAdapter(requireActivity(),catList,object :RvCatAdapter.OnCatClickListner{
            override fun onClick(value: String) {

                viewBinding.root.findNavController().navigate(CatFragmentDirections.actionBnavCatToNewsFragment(value))
            }
        })

    }

}