package com.example.myapp;

import android.content.SharedPreferences;

public class BooleanPreference {
  private final String key;
  private final SharedPreferences sharedPreferences;
  private final boolean defaultVal;

  public BooleanPreference(String key, SharedPreferences sharedPreferences, boolean defaultVal) {
    this.key = key;
    this.sharedPreferences = sharedPreferences;
    this.defaultVal = defaultVal;
  }

  public final void set(boolean val) {
    sharedPreferences.edit().putBoolean(key, val).apply();
  }

  public final boolean get() {
    return sharedPreferences.getBoolean(key, defaultVal);
  }

  public final void delete() {
    sharedPreferences.edit().remove(key).apply();
  }
}
