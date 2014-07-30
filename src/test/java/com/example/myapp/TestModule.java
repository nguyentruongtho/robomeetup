package com.example.myapp;

import dagger.Module;

@Module(
    injects = {
        MyActivityTest.class
    },
    library = true,
    complete = false
)
public class TestModule {
}
