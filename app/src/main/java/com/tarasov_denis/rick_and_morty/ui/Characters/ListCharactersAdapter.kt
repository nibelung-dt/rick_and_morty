package com.tarasov_denis.rick_and_morty.ui.Characters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tarasov_denis.rick_and_morty.R
import com.tarasov_denis.rick_and_morty.data.remote.responses.CharacterResponse


/*
https://www.howtodoandroid.com/pagination-with-recyclerview/

https://medium.com/nuances-of-programming/%D1%8D%D0%BA%D1%81%D0%BF%D0%B5%D1%80%D0%B8%D0%BC%D0%B5%D0%BD%D1%82%D0%B8%D1%80%D1%83%D0%B5%D0%BC-%D1%81-2d420e248c49
здесь речь о применении пагинации к полю поиска

https://startandroid.ru/ru/courses/architecture-components/27-course/architecture-components/542-urok-14-paging-library-chast-1.html

 */
class ListCharactersAdapter
   (private val listCharacters: List<CharacterResponse>):
    RecyclerView.Adapter<ListCharactersAdapter.ViewHolderCharacter>() {

        class ViewHolderCharacter(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val name: TextView = itemView.findViewById(R.id.name)
            val species: TextView = itemView.findViewById(R.id.species)
            val status: TextView = itemView.findViewById(R.id.status)
            val gender: TextView = itemView.findViewById(R.id.gender)
            val imageView: ImageView = itemView.findViewById(R.id.imageView)
            val layout: LinearLayout = itemView.findViewById(R.id.item_character_layout)
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ViewHolderCharacter {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_character_layout, parent, false)

            Log.d("Denis", "холдер создан")
            return ViewHolderCharacter(itemView)
        }

        override fun onBindViewHolder(holder: ViewHolderCharacter, position: Int) {
          //  holder.setIsRecyclable(false)
            holder.name.text = listCharacters[position].name
            holder.species.text = listCharacters[position].species
            holder.status.text = listCharacters[position].status
            holder.gender.text = listCharacters[position].gender
            val imageAddress = listCharacters[position].image

            val context = holder.itemView.context

            Glide
                .with(context)
                .load(imageAddress)
                .into(holder.imageView)



          //  Log.d("Denis", listCharacters[position].name)
          //  val selectedCity = cities[position]
/*
            holder.layout.setOnClickListener{
                onItemClicked(selectedCity)
            }
 */
        }
        override fun getItemCount(): Int = listCharacters.size

}