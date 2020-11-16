package com.example.androidmvvmjava.network;

import com.example.androidmvvmjava.responses.TVShowsDetailsResponse;
import com.example.androidmvvmjava.responses.TVShowsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("most-popular")
    Call<TVShowsResponse> getMostPopularTVShows(
            @Query("page") int page
    );

    @GET("show-details")
    Call<TVShowsDetailsResponse> getTVShowDetails(
            @Query("q") String tvShowId
    );
}
