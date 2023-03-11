package com.tarasov_denis.rick_and_morty.data.remote

import retrofit2.Response
import com.tarasov_denis.rick_and_morty.data.Character
import com.tarasov_denis.rick_and_morty.data.ListCharacters
import com.tarasov_denis.rick_and_morty.data.remote.RetrofitNetwork.rickAndMortyService
import com.tarasov_denis.rick_and_morty.data.remote.RetrofitNetwork.rxRickAndMortyService
import io.reactivex.Single


class ApiClient(
    private val rickAndMortyService: RickAndMortyService
) {

    suspend fun getCharacterById(id: Int): Response<Character> {
        return rickAndMortyService.getCharacterById(id)
    }

    fun rxGetCharacterById(id: Int): Single<Character> {
        return rxRickAndMortyService.rxGetCharacterById(id)
    }

    fun rxGetCharactersList(): Single<ListCharacters> {
        return rxRickAndMortyService.rxGetCharactersList()
    }

/*
    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): MyResponse<T> {
        return try {
            MyResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            MyResponse.failure(e)
        }
    }
 */

}