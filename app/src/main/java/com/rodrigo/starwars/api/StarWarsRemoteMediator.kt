package com.rodrigo.starwars.api

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator

/*
const val REMOTE_KEY = "People"
@OptIn(ExperimentalPagingApi::class)
class StarWarsRemoteMediator(
    val starWarsApi: ApiService
): RemoteMediator<Int, StarWarsPeople>(){


    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, StarWarsPeople>
    ): MediatorResult {
        return try {
            val loadKey = when(loadType){
                LoadType.PREPEND -> return  MediatorResult.Success(endOfPaginationReached = true)
                LoadType.REFRESH -> null
                LoadType.APPEND -> {
                    val remoteKey =
                }
            }
        }
    }


}*/