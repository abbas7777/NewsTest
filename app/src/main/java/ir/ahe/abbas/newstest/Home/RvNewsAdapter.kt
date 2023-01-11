package ir.ahe.abbas.newstest.Home

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.ahe.abbas.newstest.Models.News

class RvNewsAdapter (var c:Context,var newsList: List<News>) : RecyclerView.Adapter<RvNewsAdapter.RvNewsViewHolder>() {

    inner class RvNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvNewsViewHolder {

    }

    override fun onBindViewHolder(holder: RvNewsViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}