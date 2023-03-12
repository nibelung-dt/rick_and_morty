package com.tarasov_denis.rick_and_morty.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import com.tarasov_denis.rick_and_morty.data.remote.responses.CharacterResponse
import com.tarasov_denis.rick_and_morty.data.remote.responses.ListCharactersResponse
import io.reactivex.Single


interface RickAndMortyService {

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int) : Response<CharacterResponse>

  //  @GET("character/")
  //  suspend fun getCharactersList() : Response<ListCharactersResponse>


    @GET("character/{id}")
    fun rxGetCharacterById(@Path("id") id: Int) : Single<CharacterResponse>

    @GET("character/")
    fun rxGetCharactersList() : Single<ListCharactersResponse>

    @GET("character/?page={number}")
    fun rxGetCharactersPage(@Path("number") number: Int) : Single<ListCharactersResponse>

    /*
    suspend fun getCharactersPage(
        @Query("page") pageIndex: Int


    подставить ?page=1
    "?page="  number: Int
     */

//  Observable<User> getUser()
//  Single<Response<Character>>

   // @GET("character/{id}")
   // fun rxGetCharacterById2(@Path("id") id: Int): Observable<Character>

}