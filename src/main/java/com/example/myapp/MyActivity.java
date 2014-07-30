package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import javax.inject.Inject;

public class MyActivity extends Activity {
  @Inject @FirstLaunch BooleanPreference firstLaunchPreference;

  private TextView message;
  private Button clickMeButton;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ((App) getApplication()).inject(this);

    setContentView(R.layout.main);

    message = (TextView) findViewById(R.id.message);

    clickMeButton = (Button) findViewById(R.id.click_me);
    clickMeButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        message.setVisibility(View.VISIBLE);
        message.setText("Hello Singapore Android Meetup!");
      }
    });

    TextView firstLaunchText = (TextView) findViewById(R.id.first_launch_message);
    if (firstLaunchPreference.get()) {
      firstLaunchPreference.set(false);
      firstLaunchText.setVisibility(View.VISIBLE);
      firstLaunchText.setText("You can see me only in the first time launching this app :)");
    } else {
      firstLaunchText.setVisibility(View.GONE);
      firstLaunchText.setText("");
    }
  }
}
