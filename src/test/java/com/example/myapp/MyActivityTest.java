package com.example.myapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(MyRobolectricTestRunner.class)
//@Config(emulateSdk = 16)
public class MyActivityTest {
  @Inject @FirstLaunch BooleanPreference firstLaunchPreference;

  @Test public void clickOnButtonShouldShowCorrectMessage() {
    MyActivity myActivity = Robolectric.setupActivity(MyActivity.class);

    TextView message = (TextView) myActivity.findViewById(R.id.message);

    Button clickMeButton = (Button) myActivity.findViewById(R.id.click_me);
    clickMeButton.performClick();

    assertThat(message).isNotNull();
    assertThat(message.getVisibility()).isEqualTo(View.VISIBLE);
    assertThat(message.getText().toString()).isEqualTo("Hello Singapore Android Meetup!");
  }

  @Test public void firstLaunchPreferenceShouldNotBeNull() {
    assertThat(firstLaunchPreference).isNotNull();
  }

  @Test public void firstLaunchMessageShouldBeShownOnFirstTimeLaunchingTheApp() {
    firstLaunchPreference.set(true);

    MyActivity myActivity = Robolectric.setupActivity(MyActivity.class);
    TextView firstLaunchText = (TextView) myActivity.findViewById(R.id.first_launch_message);

    assertThat(firstLaunchText).isNotNull();
    assertThat(firstLaunchText.getVisibility()).isEqualTo(View.VISIBLE);
    assertThat(firstLaunchText.getText().toString())
        .isEqualTo("You can see me only in the first time launching this app :)");
  }

  @Test public void secondLaunchOnwardShouldNotShowFirstLaunchMessage() {
    firstLaunchPreference.set(false);

    MyActivity myActivity = Robolectric.setupActivity(MyActivity.class);
    TextView firstLaunchText = (TextView) myActivity.findViewById(R.id.first_launch_message);
    
    assertThat(firstLaunchText).isNotNull();
    assertThat(firstLaunchText.getVisibility()).isEqualTo(View.GONE);
  }
}
