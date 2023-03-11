package com.tarasov_denis.rick_and_morty.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.tarasov_denis.rick_and_morty.R
import com.tarasov_denis.rick_and_morty.data.CharacterViewModel
import com.tarasov_denis.rick_and_morty.data.remote.RetrofitNetwork
import com.tarasov_denis.rick_and_morty.databinding.FragmentDetailCharacterBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rx.Subscriber


class DetailCharacterFragment : Fragment() {

    val viewModel: CharacterViewModel by lazy {
        ViewModelProvider(this).get(CharacterViewModel::class.java)
    }

  //  private lateinit var imageView: ImageView
    private lateinit var imageAddress: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentDetailCharacterBinding.inflate(inflater, container, false)
/*
        viewModel.rxRefreshCharacter(4)
        viewModel.characterByIdLiveData.observe(viewLifecycleOwner) { response ->
           // Log.d("Denis", "VM запущена")
            if (response == null) {
                Log.d("Denis", "response == null")
                return@observe
            }
            binding.name.text = response.name
            binding.status.text = response.status
            binding.species.text = response.species
            binding.gender.text = response.gender
            binding.created.text = response.created
            binding.location.text = response.location.name
            binding.origin.text = response.origin.name
            imageAddress = response.image

            Glide
                .with(this)
                .load(imageAddress)
                .into(binding.imageView)

           // Log.d("Denis", "ответ сервера получен")
        }

 */

        // получаем список персонажей
        viewModel.rxRefreshCharacterList()
        viewModel.listCharactersLiveData.observe(viewLifecycleOwner) { response ->
            Log.d("Denis", "VM запущена")
            if (response == null) {
                Log.d("Denis", "response == null")
                return@observe
            }
            binding.name.text = response.results[100].name
            Log.d("Denis", response.results[100].name)
        }

        // этот код работает
/*
        viewModel.refreshCharacter(3)
        viewModel.characterByIdLiveData.observe(this) { response ->
            Log.d("Denis", "VM запущена")
            if (response == null) {
                Log.d("Denis", "response == null")
                return@observe
            }
            Log.d("Denis", response.name)
            binding.name.text = response.name
            binding.status.text = response.status
            binding.species.text = response.species
            // binding.type.text = response.type
            binding.gender.text = response.gender
           // binding.episode.text = response.episode
            binding.created.text = response.created
            binding.location.text = response.location.name
            binding.origin.text = response.origin.name

            imageAddress = response.image

            Glide
                .with(this)
                .load(imageAddress)
                .into(binding.imageView)
        }

 */


        // этот код работает без использования ViewModel
/*
        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            RetrofitNetwork.rxApiClient.rxGetCharacterById(5)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { response ->
                    // здесь можно будет запускать маппер
                    binding.name.text = response.name
                    binding.name.text = response.name
                    binding.status.text = response.status
                    binding.species.text = response.species
                    binding.gender.text = response.gender
                    binding.created.text = response.created
                    binding.location.text = response.location.name
                    binding.origin.text = response.origin.name
                    imageAddress = response.image

                    Glide
                        .with(this)
                        .load(imageAddress)
                        .into(binding.imageView)
                }

 */
            /*
                    ,{t ->
                    onFailure(t)
                })
             */
        return binding.root
      //  return inflater.inflate(R.layout.fragment_detail_character, container, false)
    }

//    https://code.tutsplus.com/tutorials/connect-to-an-api-with-retrofit-rxjava-2-and-kotlin--cms-32133

}