package com.cooksdev.dagger2sample.presentation.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by SoftPaw on 10.11.16
 * Module for schedulers manipulate
 */
@Module
public class SchedulersModule {
    public static final String IO = "io";
    public static final String MAIN = "main";
    public static final String COMPUTATION = "computation";
    public static final String TRAMPOLINE = "trampoline";
    public static final String NEW_THREAD = "new_thread";

    @Provides
    @Singleton
    @Named(SchedulersModule.MAIN)
    Scheduler provideMainScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @Named(SchedulersModule.IO)
    Scheduler provideIOScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Named(SchedulersModule.COMPUTATION)
    Scheduler provideComputationScheduler() {
        return Schedulers.computation();
    }

    @Provides
    @Singleton
    @Named(SchedulersModule.TRAMPOLINE)
    Scheduler provideTrampolineScheduler() {
        return Schedulers.trampoline();
    }

    @Provides
    @Singleton
    @Named(SchedulersModule.NEW_THREAD)
    Scheduler provideNewThreadScheduler() {
        return Schedulers.newThread();
    }
}