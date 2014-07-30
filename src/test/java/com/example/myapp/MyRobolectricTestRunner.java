package com.example.myapp;

import java.io.File;
import org.junit.runners.model.InitializationError;
import org.robolectric.AndroidManifest;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.res.Fs;
import org.robolectric.res.FsFile;

public class MyRobolectricTestRunner extends RobolectricTestRunner {
  public MyRobolectricTestRunner(Class<?> testClass) throws InitializationError {
    super(testClass);
  }

  @Override protected AndroidManifest getAppManifest(Config config) {
    if (config.manifest().equals(Config.DEFAULT)) {
      return new CustomAndroidManifest(Fs.newFile(new File("."))) {
      };
    }
    return super.getAppManifest(config);
  }

  private class CustomAndroidManifest extends AndroidManifest {
    public CustomAndroidManifest(FsFile fsFile) {
      super(fsFile);
    }

    @Override public int getTargetSdkVersion() {
      return 16;
    }

    @Override public String getApplicationName() {
      return TestApp.class.getName();
    }
  }
}
