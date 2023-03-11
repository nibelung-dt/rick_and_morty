package com.tarasov_denis.rick_and_morty.data

// import com.tarasov_denis.rick_and_morty.data.Character
import android.util.Log
import com.tarasov_denis.rick_and_morty.data.remote.RetrofitNetwork
import io.reactivex.Scheduler
import io.reactivex.Single
import retrofit2.Response

class Repository {

    suspend fun getCharacterById(id: Int): Character? {
        val request = RetrofitNetwork.apiClient.getCharacterById(id)

        if (request.isSuccessful) {
            return request.body()!!
        }
        return null
    }

    fun rxGetCharacterById(id: Int): Single<Character> {
        val request = RetrofitNetwork.rxApiClient.rxGetCharacterById(id)
           // .subscribeOn(Scheduler.io())
       // val request = RetrofitNetwork.rxApiClient.rxGetCharacterById(query)
         //   .subscribeOn(Scheduler.io())
/*
        if (request.isSuccessful) {
            return request.body()!!
        }
 */
        return request
    }

    fun rxGetCharactersList(): Single<ListCharacters> {
        Log.d("Denis", "функция rxGetCharactersList() запущена")
        val request = RetrofitNetwork.rxApiClient.rxGetCharactersList()
        return request
    }

}