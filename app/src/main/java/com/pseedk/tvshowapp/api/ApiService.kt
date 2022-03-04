package com.pseedk.tvshowapp.api

import com.pseedk.tvshowapp.helper.Constants
import com.pseedk.tvshowapp.models.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>
}