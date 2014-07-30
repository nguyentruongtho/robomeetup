package com.example.myapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import javax.inject.Inject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(MyRobolectricTestRunner.class)
//@Config(emulateSdk = 16)
public class MyActivityTest {
  private MyActivity myActivity;
  @Inject @FirstLaunch BooleanPreference firstLaunchPreference;

  @Before public void setUp() {
    myActivity = Robolectric.setupActivity(MyActivity.class);
  }

  @After public void tearDown() {
    myActivity = null;
  }

  @Test public void clickOnButtonShouldShowCorrectMessage() {
    TextView message = (TextView) myActivity.findViewById(R.id.message);

    Button clickMeButton = (Button) myActivity.findViewById(R.id.click_me);
    clickMeButton.performClick();

    assertThat(message).isNotNull();
    assertThat(message.getVisibility()).isEqualTo(View.VISIBLE);
    assertThat(message.getText()).isEqualTo("Hello Singapore Android Meetup!");
  }

  @Test public void firstLaunchPreferenceShouldNotBeNull() {
    assertThat(firstLaunchPreference).isNotNull();
  }
}
