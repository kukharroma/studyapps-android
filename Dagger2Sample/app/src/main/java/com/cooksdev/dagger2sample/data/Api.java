package com.cooksdev.dagger2sample.data;


import javax.inject.Inject;

public class Api {

    @Inject
    public Api() {
    }

    public User getUser() {
        return new User();
    }
}
