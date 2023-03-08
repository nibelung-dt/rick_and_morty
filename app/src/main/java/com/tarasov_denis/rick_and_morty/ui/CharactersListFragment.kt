package com.tarasov_denis.rick_and_morty.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tarasov_denis.rick_and_morty.R


/**
 * A simple [Fragment] subclass.
 * Use the [CharactersListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CharactersListFragment : Fragment() {

/*
Список необходимо выполнить в виде таблицы с 2 столбцами.
Каждый элемент списка должен содержать Название персонажа
(name), Вид (species), статус (status), пол (gender) и картинку
(image). Данный список должен поддерживать пагинацию.
 */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

}