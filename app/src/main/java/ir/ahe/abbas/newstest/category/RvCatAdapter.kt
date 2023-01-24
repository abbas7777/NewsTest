package ir.ahe.abbas.newstest.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.ahe.abbas.newstest.models.Cat
import ir.ahe.abbas.newstest.R

class RvCatAdapter (var context: Context,var list: List<Cat>,var onCatClickListner: OnCatClickListner) : RecyclerView.Adapter<RvCatAdapter.RvCatViewHolder>() {

    inner class RvCatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var parent:RelativeLayout=itemView.findViewById(R.id.rl_itemCat_parent)
        var txtTitle:TextView=itemView.findViewById(R.id.txt_itemCat_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvCatViewHolder {

        return RvCatViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cat,parent,false))
    }

    override fun onBindViewHolder(holder: RvCatViewHolder, position: Int) {
        var  cat=list.get(position)

        holder.txtTitle.text=cat.title

        holder.parent.setOnClickListener({
            onCatClickListner.onClick(cat.value)
        })

    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnCatClickListner{
        fun onClick(value :String)
    }
}