package com.example.myapp;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(
    injects = {
        MyActivity.class
    }
)
public class AppModule {
  private final App app;

  public AppModule(App app) {
    this.app = app;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return app;
  }

  @Provides @Singleton SharedPreferences provideAppSharePreferences(Context context) {
    return context.getSharedPreferences("app", Context.MODE_PRIVATE);
  }

  @Provides @Singleton @FirstLaunch BooleanPreference provideFirstLaunchPreference(
      SharedPreferences sharedPreferences) {
    return new BooleanPreference("first_launch", sharedPreferences, true);
  }
}
