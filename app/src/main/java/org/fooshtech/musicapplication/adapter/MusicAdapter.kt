package org.fooshtech.musicapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*
import org.fooshtech.musicapplication.R
import org.fooshtech.musicapplication.model.ResultLItem

class MusicAdapter(val datSet: ArrayList<ResultLItem>, val listener: OnItemClickListener) :
    RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MusicViewHolder(view)
    }


    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {

        holder.collectionName.text = datSet[position].collectionName
        holder.artistName.text = datSet[position].artistName
        holder.trackPrice.text = datSet[position].trackPrice.toString()

        Glide.with(holder.imageItem.context)
            .load(datSet[position].artworkUrl100)
            .into(holder.imageItem)

    }


    override fun getItemCount(): Int {
        return datSet.size
    }


    inner class MusicViewHolder(musicItem: View) : RecyclerView.ViewHolder(musicItem)
     {

        val imageItem: ImageView = musicItem.imageView_item
        val collectionName: TextView = musicItem.txt_item_song_collection_name
        val artistName: TextView = musicItem.txt_item_artist_name
        val trackPrice: TextView = musicItem.txt_item_track_price

        init {
            musicItem.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position)
                }
            }
        }


    }

}

