package com.cooksdev.dagger2sample.domain;


import com.cooksdev.dagger2sample.data.Api;

import javax.inject.Inject;
import javax.inject.Singleton;

public class GetUserUseCase {

    Api api;

    @Inject
    public GetUserUseCase(Api api) {
        this.api = api;
    }
}
