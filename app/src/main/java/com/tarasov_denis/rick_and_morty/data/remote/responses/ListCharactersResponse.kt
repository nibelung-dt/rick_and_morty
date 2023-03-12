package com.tarasov_denis.rick_and_morty.data.remote.responses

data class ListCharactersResponse(
    val info: Info = Info(),
    val results: List<CharacterResponse> // = listOf<CharacterResponse>()
) {
    data class Info(
        val count : Int = 0,
        val pages: Int = 0,
        val next: String? = null,
        val prev: String? = null
    )
}

// val listOfCharacters : List<Character>  = listOf<Character>()

/*
    data class Results (

        val id: Int,
        val name: String,
        val status: String,
        val species: String,
        val type: String,
        val gender: String,
        val origin : Character.Origin = Character.Origin(),     // место происхожения
        //   val origin: Origin(),  //String, // тип object - Name and link to the character's origin location
        val location: Character.Location = Character.Location(), // тип object - Name and link to the character's last known location endpoint
        val image: String, // url
        val episode: List<String>, //urls
        // val url: String, // url
        val created: String
    )

 */


