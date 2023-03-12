package com.tarasov_denis.rick_and_morty.data.remote

import retrofit2.Response
import com.tarasov_denis.rick_and_morty.data.remote.RetrofitNetwork.rickAndMortyService
import com.tarasov_denis.rick_and_morty.data.remote.RetrofitNetwork.rxRickAndMortyService
import com.tarasov_denis.rick_and_morty.data.remote.responses.CharacterResponse
import com.tarasov_denis.rick_and_morty.data.remote.responses.ListCharactersResponse
import io.reactivex.Single


class ApiClient(
    private val rickAndMortyService: RickAndMortyService
) {

    suspend fun getCharacterById(id: Int): Response<CharacterResponse> {
        return rickAndMortyService.getCharacterById(id)
    }

   // suspend fun getCharactersList(): Response<ListCharactersResponse> {
   //     return rickAndMortyService.getCharactersList()
   // }

    fun rxGetCharacterById(id: Int): Single<CharacterResponse> {
        return rxRickAndMortyService.rxGetCharacterById(id)
    }

    fun rxGetCharactersList(): Single<ListCharactersResponse> {
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