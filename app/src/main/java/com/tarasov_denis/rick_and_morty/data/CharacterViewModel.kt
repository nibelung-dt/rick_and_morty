package com.tarasov_denis.rick_and_morty.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class CharacterViewModel: ViewModel() {
    private val repository = Repository()

   // private val _characterByIdLiveData = MutableLiveData<Character?>()
   // val characterByIdLiveData: LiveData<Character?> = _characterByIdLiveData

   // private val _characterByIdLiveData = MutableLiveData<Character>()
   // val characterByIdLiveData: LiveData<Character> = _characterByIdLiveData

    private val _listCharactersLiveData = MutableLiveData<ListCharacters>()
    val listCharactersLiveData: LiveData<ListCharacters> = _listCharactersLiveData

    // этот метод работает
    /*
    fun refreshCharacter(id: Int) {
        viewModelScope.launch {
            val response = repository.getCharacterById(id)
            _characterByIdLiveData.postValue(response)
        }
    }
     */
/*
    fun rxRefreshCharacter(id: Int) {
            val rxResponse = repository.rxGetCharacterById(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())

            val observer = object : SingleObserver<Character> {
                override fun onSuccess(character: Character) {
                    Log.d("Denis", "Успех!")
                    _characterByIdLiveData.postValue(character)
                }

                override fun onSubscribe(d: Disposable) {
                  //  _characterByIdLiveData.postValue(d)
                }

                override fun onError(throwable: Throwable) {
                   // _characterByIdLiveData.value
                  //  onError?.invoke(throwable)
                }
            }
        rxResponse.subscribe(observer)
        }
 */

    fun rxRefreshCharacterList() {
        Log.d("Denis", "функция rxRefreshCharacterList() запущена")
        val rxResponse = repository.rxGetCharactersList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

        val observer = object : SingleObserver<ListCharacters> {
            // Log.d("Denis", "Успех!")
            override fun onSuccess(listCharacters: ListCharacters) {
                Log.d("Denis", "Успех!")
               // Log.d("Denis", "Успех!")
               // listCharacters
                _listCharactersLiveData.postValue(listCharacters)
            }

            override fun onSubscribe(d: Disposable) {
                //  _characterByIdLiveData.postValue(d)
            }

            override fun onError(throwable: Throwable) {
                // _characterByIdLiveData.value
                //  onError?.invoke(throwable)
            }
        }
        rxResponse.subscribe(observer)
    }



}