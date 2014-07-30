package com.example.myapp;

import android.app.Application;
import dagger.ObjectGraph;

public class App extends Application {
  private ObjectGraph objectGraph;

  @Override public void onCreate() {
    super.onCreate();

    buildObjectGraphAndInject();
  }

  private void buildObjectGraphAndInject() {
    objectGraph = ObjectGraph.create(getModules());
  }

  protected Object[] getModules() {
    return new Object[] {
        new AppModule(this)
    };
  }

  public void inject(Object o) {
    objectGraph.inject(o);
  }
}
