package com.example.picasso3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_image_adapter.view.*

class AdapterImage(var context: Context, var list:ArrayList<Image>):RecyclerView.Adapter<AdapterImage.ViewHolder>(){


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(image:Image){
            Picasso.get()
                .load(image.url)
                .resize(150,150)
                .centerCrop()
                .into(itemView.image_view)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.row_image_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var image = list[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}