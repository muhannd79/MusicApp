package org.fooshtech.musicapplication.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.fragment_classic.view.*
import org.fooshtech.musicapplication.R
import org.fooshtech.musicapplication.adapter.MusicAdapter
import org.fooshtech.musicapplication.adapter.OnItemClickListener
import org.fooshtech.musicapplication.model.MusicResponse
import org.fooshtech.musicapplication.model.ResultLItem
import org.fooshtech.musicapplication.request.RetrofitNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ClassicFragment : Fragment(),OnItemClickListener {

    lateinit var item: ArrayList<ResultLItem>
    lateinit var adapter: MusicAdapter
    lateinit var recyclerView : RecyclerView

    lateinit var ref_layout : SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val  view = inflater.inflate(R.layout.fragment_classic, container, false)

        item = ArrayList()

        recyclerView = view.rv_frag2_classic
        recyclerView.layoutManager= LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)


        ref_layout =view.sepRef_rv_classic_list
        ref_layout.isRefreshing = true
        ref_layout.setOnRefreshListener {
            item.clear()
            adapter.notifyDataSetChanged()
            retrofitCall()
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        retrofitCall()
    }

    private fun retrofitCall() {

        RetrofitNetwork
            .initRetrofit()
            .getMusicList("classick")
            .enqueue(object  : Callback<MusicResponse> {

                override fun onResponse(
                    call: Call<MusicResponse>,
                    response: Response<MusicResponse>
                ) {
                    if(response.isSuccessful){
                        Log.d("tmz","Musice List="+response.body())
                        item= response.body()?.results as ArrayList<ResultLItem>
                        fillData(item)
                        ref_layout.isRefreshing = false
                    }
                }


                override fun onFailure(call: Call<MusicResponse>, t: Throwable) {
                    Toast.makeText(activity,"Error, try again later", Toast.LENGTH_SHORT).show()
                    Log.d("tmz","error="+t.message)
                    ref_layout.isRefreshing = false

                }

            })


    }

    private fun fillData(list: ArrayList<ResultLItem>) {
        list.also {
            adapter = MusicAdapter(it,this)
            recyclerView.adapter= adapter
        }
    }

    override fun onItemClick(position: Int) {
        Log.d("tmz","imte="+item[position].collectionName)
        val nextintent = Intent(Intent.ACTION_VIEW, Uri.parse(item[position].previewUrl))
        startActivity(nextintent)

    }


}