package com.tarasov_denis.rick_and_morty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.tarasov_denis.rick_and_morty.data.CharacterViewModel
import com.tarasov_denis.rick_and_morty.ui.DetailCharacterFragment

/*
Character
    DetailCharacter
Содержит список эпизодов. Можно перейти в DetailEpisode и в DetailLocation

ListCharacters

Location
    DetailLocation
ListLocations

Episode
    DetailEpisode
ListEpisodes
 */

// data/model
// https://medium.com/dsc-sastra-deemed-to-be-university/retrofit-with-viewmodel-in-kotlin-part-1-f9e705e77144



class MainActivity : AppCompatActivity() {
/*
    val viewModel: CharacterViewModel by lazy {
        ViewModelProvider(this).get(CharacterViewModel::class.java)
    }
 */

    override fun onCreate(savedInstanceState: Bundle?) {
      //  setTheme(R.style.Theme_Rick_and_morty)
        /*
        Handler(Looper.getMainLooper()).postDelayed({
            setTheme(R.style.Theme_Rick_and_morty);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main) }, 3000)
         */

        super.onCreate(savedInstanceState)

       // val binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, DetailCharacterFragment())
                .commit()
        }

        /*
        val textView = findViewById<TextView>(R.id.textView)
        viewModel.refreshCharacter(3)
        viewModel.characterByIdLiveData.observe(this) { response ->
            if (response == null) {
                Log.d("Denis", "response == null")
                return@observe
            }
            textView.text = response.name
            Log.d("Denis", response.name)
        }
         */
    }
}
// https://developer.alexanderklimov.ru/android/library/moshi.php

/*
 Handler(Looper.getMainLooper()).postDelayed(Runnable { navigator().goToMainFragment() }, 3000)
 */

/*
   // setTheme(R.style.Theme.Rick_and_morty)  Handler(Looper.getMainLooper()).postDelayed(Runnable { navigator().goToMainFragment() }, 3000)
     //   Handler(Looper.getMainLooper()).postDelayed({ setTheme(R.style.Theme_Rick_and_morty) }, 2000)
        /*
        val viewModel = ViewModelProvider(this).get(CharactersViewModel::class.java)
        viewModel.getCharacter()
        viewModel.myResponse.observe(this, Observer {
           // Log.d("Denis", it.name)
          //  Log.d("Denis", it.name)
            Log.d("Denis", "успех!")
            /*
            for (character in it) {
                Log.d("Denis", character.name)
            }
             */
        })

         */



 //  val response = CharacterNetwork.retrofit.getCharacterById(1)
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
              //  .create(CharacterService::class.java)
            //  .create(CharacterService::class.java)
            //  .client(httpClient.build())

        val rickApp: CharacterService = retrofit.create(CharacterService::class.java)
        rickApp.getCharacterById(1).enqueue(object : Callback<Character> {
            override fun onResponse(call: Response<Character>, response: Response<Character>) {
                Log.d("Denis", response.toString())
                if (!response.isSuccessful) {
                    Log.d("Denis", "not succes")
                }
            }

            override fun onFailure(call: Response<Character>, t: Throwable) {
                Log.d("Denis", "failure")
            }
        })
 */