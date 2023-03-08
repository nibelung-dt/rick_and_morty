package com.tarasov_denis.rick_and_morty.data

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin : Origin = Origin(),     // место происхожения
 //   val origin: Origin(),  //String, // тип object - Name and link to the character's origin location
    val location: Location = Location(), // тип object - Name and link to the character's last known location endpoint
    val image: String, // url
    val episode: List<String>, //urls
    // val url: String, // url
    val created: String
) {
    data class Location(
        val name: String = "",
        val url: String = ""
    )

    data class Origin(
        val name: String = "",
        val url: String = ""
    )
}

/*
    val episodeList: List<Episode> = listOf(),
    val gender: String = "",
    val id: Int = 0,
    val image: String = "",
    val location: Location = Location(),
    val name: String = "",
    val origin: Origin = Origin(),
    val species: String = "",
    val status: String = "",
 */
