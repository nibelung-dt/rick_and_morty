package com.tarasov_denis.rick_and_morty.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tarasov_denis.rick_and_morty.data.remote.responses.CharacterResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.Math.max

/*
class CharacterPagingSource(
    private val coroutineScope: CoroutineScope,
    private val repository: Repository
) : PagingSource<Int, CharacterResponse>() {
    private val start_key = 1
    private var key = 1
    private fun ensureValidKey(key: Int) = max(start_key, key)

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterResponse> {
        var characterList: List<CharacterResponse>
        coroutineScope.launch {
            characterList = repository.rxGetCharactersListPage(key)
        }

        val start = params.key ?: start_key
        val range = start.until(start + params.loadSize)

        return characterList

    }

    override fun getRefreshKey(state: PagingState<Int, CharacterResponse>): Int? {
        TODO("Not yet implemented")
    }


    LoadResult.Page(
            data = range.map { number ->


                )
            },

            // Make sure we don't try to load items behind the STARTING_KEY
            prevKey = when (start) {
                start_key -> null
                else -> ensureValidKey(key = range.first - params.loadSize)
            },
            nextKey = range.last + 1
        )




}

*/