package com.tarasov_denis.rick_and_morty.domain.entities

class Character (
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin : Origin = Origin(),
    val location: Location = Location(),
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

