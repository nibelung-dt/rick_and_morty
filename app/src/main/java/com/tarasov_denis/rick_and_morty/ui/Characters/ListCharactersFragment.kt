package com.tarasov_denis.rick_and_morty.ui.Characters

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tarasov_denis.rick_and_morty.R
import com.tarasov_denis.rick_and_morty.data.remote.responses.CharacterResponse
import com.tarasov_denis.rick_and_morty.databinding.*


class ListCharactersFragment : Fragment() {

    val viewModel: ListCharactersViewModel by lazy {
        ViewModelProvider(this).get(ListCharactersViewModel::class.java)
    }

   // private lateinit var adapter: ListCharactersAdapter
    //  private lateinit var imageView: ImageView
    private lateinit var imageAddress: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentListCharactersBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = GridLayoutManager(context, 2)
        val recyclerView: RecyclerView? = view.findViewById(R.id.recycler_list_characters)

        recyclerView?.layoutManager = layoutManager  // new AutoFitGridLayoutManager(this, 500)
        recyclerView?.setHasFixedSize(true)

        viewModel.rxRefreshCharacterList()
        viewModel.listCharactersLiveData.observe(viewLifecycleOwner) { response ->
            Log.d("Denis", "VM запущена")
            if (response == null) {
                Log.d("Denis", "response == null")
                return@observe
            }
            recyclerView?.adapter = ListCharactersAdapter(response.results)  // ListCharactersFragment()
        }

    }
/*
    val rick = CharacterResponse(1, "Rick", "aa", "dd", "fff", "dgf",
    CharacterResponse.Origin("ddd", "ddss"), CharacterResponse.Location("sss", "dss"),
    "dgfds", listOf("dd"), "hgh")
 */

}