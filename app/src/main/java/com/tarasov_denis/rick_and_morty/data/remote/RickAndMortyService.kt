package com.tarasov_denis.rick_and_morty.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import com.tarasov_denis.rick_and_morty.data.Character
import io.reactivex.Observable
import io.reactivex.Single


interface RickAndMortyService {

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int) : Response<Character>


    @GET("character/{id}")
    fun rxGetCharacterById(@Path("id") id: Int) : Single<Character>
//  Observable<User> getUser()
//  Single<Response<Character>>

   // @GET("character/{id}")
   // fun rxGetCharacterById2(@Path("id") id: Int): Observable<Character>

}