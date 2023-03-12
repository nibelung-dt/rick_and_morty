package com.tarasov_denis.rick_and_morty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.tarasov_denis.rick_and_morty.databinding.ActivityMainBinding
import com.tarasov_denis.rick_and_morty.ui.Characters.DetailCharacterFragment
import com.tarasov_denis.rick_and_morty.ui.Characters.ListCharactersFragment
import com.tarasov_denis.rick_and_morty.ui.Episodes.ListEpisodesFragment
import com.tarasov_denis.rick_and_morty.ui.Locations.ListLocationsFragment

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

/*
1) переместить VM в пакет ui
2) настроить получение списка персонажей
3) переименовать в CharacterResponse
4) создать сущность Character
5) создать маппер для Character

 */


class MainActivity : AppCompatActivity() {
/*
    val viewModel: CharacterViewModel by lazy {
        ViewModelProvider(this).get(CharacterViewModel::class.java)
    }
 */
// private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
      //  setTheme(R.style.Theme_Rick_and_morty)
        /*
        Handler(Looper.getMainLooper()).postDelayed({
            setTheme(R.style.Theme_Rick_and_morty);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main) }, 3000)
         */

        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
      //  setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            binding.toolbar.title = "Персонажи"
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, ListCharactersFragment()) //DetailCharacterFragment())
                .commit()
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
        when(item.itemId) {
            R.id.characters -> {
                binding.toolbar.title = "Персонажи"
                launchFragment(ListCharactersFragment())
                true
            }
            R.id.locations -> {
                binding.toolbar.title = "Локации"
                launchFragment(ListLocationsFragment())
                true
            }
            R.id.episodes -> {
                binding.toolbar.title = "Эпизоды"
                launchFragment(ListEpisodesFragment())
                true
            }
            else -> false
            }
        }
    }

    fun launchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container_view, fragment)
            .commit()
    }
}


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