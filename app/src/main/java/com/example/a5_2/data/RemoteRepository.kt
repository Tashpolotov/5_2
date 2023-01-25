package com.example.a5_2.data


import com.example.a5_2.model.Characters
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {
    fun getCharacters(page:Int ,returnOnSuccess:(Characters) ->Unit,
                      returnOnFailure:(String)->Unit){
        RetrofitClient.api.getCharacters(page).enqueue(object : Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if ( response.isSuccessful)
                    returnOnSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                returnOnFailure(t.message?:"Unknown Error")
            }
        })
    }
}