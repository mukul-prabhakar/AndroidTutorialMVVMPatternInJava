package com.example.androidmvvmjava.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidmvvmjava.reporitories.TVShowDetailsRepository;
import com.example.androidmvvmjava.responses.TVShowsDetailsResponse;

public class TVShowDetailsViewModel extends ViewModel {

    private TVShowDetailsRepository tvShowDetailsRepository;

    public TVShowDetailsViewModel(){
        tvShowDetailsRepository = new TVShowDetailsRepository();
    }

    public LiveData<TVShowsDetailsResponse> getTVShowDetails(String tvShowId) {
        return  tvShowDetailsRepository.getTVShowDetails(tvShowId);
    }
}
