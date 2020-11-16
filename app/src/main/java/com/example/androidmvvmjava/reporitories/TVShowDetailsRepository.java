package com.example.androidmvvmjava.reporitories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidmvvmjava.network.ApiClient;
import com.example.androidmvvmjava.network.ApiService;
import com.example.androidmvvmjava.responses.TVShowsDetailsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TVShowDetailsRepository {

    private ApiService apiService;

    public TVShowDetailsRepository(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<TVShowsDetailsResponse> getTVShowDetails(String tvShowId) {
        MutableLiveData<TVShowsDetailsResponse> data = new MutableLiveData<>();
        apiService.getTVShowDetails(tvShowId).enqueue(new Callback<TVShowsDetailsResponse>() {
            @Override
            public void onResponse(@NonNull Call<TVShowsDetailsResponse> call, @NonNull Response<TVShowsDetailsResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<TVShowsDetailsResponse> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
