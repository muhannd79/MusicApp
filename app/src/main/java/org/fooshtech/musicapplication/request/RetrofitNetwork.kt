package org.fooshtech.musicapplication.request


import org.fooshtech.musicapplication.model.MusicResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL="https://itunes.apple.com/"
const val END_POINT ="search"

interface RetrofitNetwork {

    @GET(END_POINT)
    fun getMusicList(
        @Query("term") termParam: String,
        @Query("media") mediaPara: String = "music",
        @Query("entity") entityP: String = "song",
        @Query("limit") limit: Int =50
    ) : Call<MusicResponse>


    companion object {

        fun initRetrofit() : RetrofitNetwork{

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitNetwork::class.java)
        }

    }

}





