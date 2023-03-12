package com.tarasov_denis.rick_and_morty.ui.Characters



import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.tarasov_denis.rick_and_morty.data.Repository
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import com.tarasov_denis.rick_and_morty.data.remote.responses.ListCharactersResponse
// import com.tarasov_denis.rick_and_morty.data.ListCharacters

    class ListCharactersViewModel: ViewModel() {
    private val repository = Repository()

    // private val _characterByIdLiveData = MutableLiveData<Character?>()
    // val characterByIdLiveData: LiveData<Character?> = _characterByIdLiveData

    // private val _characterByIdLiveData = MutableLiveData<Character>()
    // val characterByIdLiveData: LiveData<Character> = _characterByIdLiveData

    private val _listCharactersLiveData = MutableLiveData<ListCharactersResponse?>()
    val listCharactersLiveData: LiveData<ListCharactersResponse?> = _listCharactersLiveData


    fun rxRefreshCharacterList() {
        Log.d("Denis", "функция rxRefreshCharacterList() запущена")
        val rxResponse = repository.rxGetCharactersList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

        val observer = object : SingleObserver<ListCharactersResponse> {
            override fun onSuccess(listCharacters: ListCharactersResponse) {
                Log.d("Denis", "Успех!")
                _listCharactersLiveData.postValue(listCharacters)
            }

            override fun onSubscribe(d: Disposable) {
                //  _characterByIdLiveData.postValue(d)
            }

            override fun onError(throwable: Throwable) {
                 Log.d("Denis", "ошибка")
                //  onError?.invoke(throwable)
            }
        }
        rxResponse.subscribe(observer)
    }



}