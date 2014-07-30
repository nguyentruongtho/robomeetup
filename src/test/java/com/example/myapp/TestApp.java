package com.example.myapp;

import dagger.internal.loaders.GeneratedAdapters;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.robolectric.TestLifecycleApplication;

public class TestApp extends App
  implements TestLifecycleApplication
{
  @Override protected Object[] getModules() {
    Object[] runtimeModules = super.getModules();
    List<Object> includingTestingModules = new ArrayList<Object>(Arrays.asList(runtimeModules));
    includingTestingModules.add(new TestModule());
    return includingTestingModules.toArray();
  }

  @Override public void beforeTest(Method method) {

  }

  @Override public void prepareTest(Object test) {
    injectIfNecessary(test);
  }

  @Override public void afterTest(Method method) {

  }

  private void injectIfNecessary(Object test) {
    if (isApplicableForInjection(test)) {
      inject(test);
    }
  }

  private boolean isApplicableForInjection(Object test) {
    try {
      Class.forName(test.getClass().getName() + GeneratedAdapters.INJECT_ADAPTER_SUFFIX);
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }
}
