package ir.ahe.abbas.newstest.Home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.qualifiers.ActivityContext
import ir.ahe.abbas.newstest.Models.News
import ir.ahe.abbas.newstest.R
import javax.inject.Inject

class RvNewsAdapter  constructor( var c:Context, var newsList: List<News>) : RecyclerView.Adapter<RvNewsAdapter.RvNewsViewHolder>() {


    inner class RvNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imvImage:ImageView=itemView.findViewById(R.id.imv_itemNews_image)
        var txtTitle:TextView=itemView.findViewById(R.id.txt_itemNews_title)
    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvNewsViewHolder {

        return RvNewsViewHolder(LayoutInflater.from(c).inflate(R.layout.item_news,parent,false))
    }

    override fun onBindViewHolder(holder: RvNewsViewHolder, position: Int) {
        var news=newsList.get(position)

        holder.txtTitle.text=news.title
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}