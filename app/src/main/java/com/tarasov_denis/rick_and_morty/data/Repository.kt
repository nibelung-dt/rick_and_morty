package com.tarasov_denis.rick_and_morty.data

// import com.tarasov_denis.rick_and_morty.data.Character
import android.util.Log
import com.tarasov_denis.rick_and_morty.data.remote.RetrofitNetwork
import com.tarasov_denis.rick_and_morty.data.remote.responses.CharacterResponse
import com.tarasov_denis.rick_and_morty.data.remote.responses.ListCharactersResponse
import io.reactivex.Scheduler
import io.reactivex.Single
import retrofit2.Response

class Repository {

    suspend fun getCharacterById(id: Int): CharacterResponse? {
        val request = RetrofitNetwork.apiClient.getCharacterById(id)

        if (request.isSuccessful) {
            return request.body()!!
        }
        return null
    }


    fun rxGetCharacterById(id: Int): Single<CharacterResponse> {
        val request = RetrofitNetwork.rxApiClient.rxGetCharacterById(id)
        return request
    }

    fun rxGetCharactersList(): Single<ListCharactersResponse> {
        val request = RetrofitNetwork.rxApiClient.rxGetCharactersList()
        return request
    }

    fun rxGetCharactersListPage(page: Int): Single<ListCharactersResponse> {
        val request = RetrofitNetwork.rxApiClient.rxGetCharactersList()
        return request
    }
}

/*suspend fun getCharactersList(): ListCharactersResponse? {
        val request = RetrofitNetwork.apiClient.getCharactersList()

        if (request.isSuccessful) {
            return request.body()!!
        }
        return null
    }
     */