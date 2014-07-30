package com.example.myapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 16)
public class MyActivityTest {
  @Test public void clickOnButtonShouldShowCorrectMessage() {
    MyActivity myActivity = Robolectric.setupActivity(MyActivity.class);

    TextView message = (TextView) myActivity.findViewById(R.id.message);

    Button clickMeButton = (Button) myActivity.findViewById(R.id.click_me);
    clickMeButton.performClick();

    assertThat(message).isNotNull();
    assertThat(message.getVisibility()).isEqualTo(View.VISIBLE);
    assertThat(message.getText()).isEqualTo("Hello Singapore Android Meetup!");
  }
}
