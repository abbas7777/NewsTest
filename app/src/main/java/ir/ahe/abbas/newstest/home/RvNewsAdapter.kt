package ir.ahe.abbas.newstest.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ir.ahe.abbas.newstest.models.News
import ir.ahe.abbas.newstest.R

class RvNewsAdapter constructor(
    private val context: Context,
    private val newsList: List<News>,
    private val onNewsClickListener: OnNewsClickListener
) :
    RecyclerView.Adapter<RvNewsAdapter.RvNewsViewHolder>() {


    inner class RvNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imvImage: ImageView = itemView.findViewById(R.id.imv_itemNews_image)
        var rlParent: RelativeLayout = itemView.findViewById(R.id.rl_itemNews_parent)
        var txtTitle: TextView = itemView.findViewById(R.id.txt_itemNews_title)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvNewsViewHolder {

        return RvNewsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_news, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RvNewsViewHolder, position: Int) {
        val news = newsList[position]

        Picasso
            .get()
            .load(news.urlToImage)
            .placeholder(R.drawable.newspaper)
            .resize(500, 500)
            .into(holder.imvImage)

        holder.txtTitle.text = news.title

        holder.rlParent.setOnClickListener {
            onNewsClickListener.onClick(news)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    interface OnNewsClickListener {
        fun onClick(item: News)
    }
}