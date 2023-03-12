package com.tarasov_denis.rick_and_morty.domain

import com.tarasov_denis.rick_and_morty.data.remote.responses.CharacterResponse
import com.tarasov_denis.rick_and_morty.domain.entities.Character

interface Mapper<S, R> {

    fun map(data: S): R


    class CharacterMapper() : Mapper<CharacterResponse, Character> {
        override fun map(data: CharacterResponse): Character {

            val newCharacter = Character(
                id = data.id,
                name = data.name,
                species = data.species,
                status = data.status,
                type = data.type,
                gender = data.gender,
                origin = Character.Origin(
                    name = data.origin.name,
                    url = data.origin.url
                ),
                location = Character.Location(
                    name = data.location.name,
                    url = data.location.url
                ),
                image = data.image,
                episode = data.episode,
                created = data.created
            )
            return newCharacter
        }
    }
}



