package com.example.studyfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import base.BaseFragment
import com.example.studyfragment.databinding.FragmentMainBinding
import com.example.studyfragment.databinding.FragmentSecondBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondFragment: BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {

    private val BASE_URL: String = "https://jsonplaceholder.typicode.com"
    private var comments: List<String> = listOf()


    override fun onBindView() {
        binding.dataView.layoutManager = LinearLayoutManager(binding.root.context, RecyclerView.VERTICAL, false)
        getAllComments()
    }

    private fun getAllComments(){
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyAPI::class.java)
        api.getCommments().enqueue(object : Callback<List<Comments>> {
            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {
                if(response.isSuccessful){

                    response.body()?.let {
                        comments = it.map {
                            it.name
                        }
                        binding.dataView.adapter = DataAdapter(comments)
                    }
                }
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                Log.i(">>> Error Message from Server", "${t.message}")
            }

        })
    }

}