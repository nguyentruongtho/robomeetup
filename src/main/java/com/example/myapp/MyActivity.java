package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {
  private TextView message;
  private Button clickMeButton;

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    message = (TextView) findViewById(R.id.message);

    clickMeButton = (Button) findViewById(R.id.click_me);
    clickMeButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        message.setVisibility(View.VISIBLE);
        message.setText("Hello Singapore Android Meetup!");
      }
    });
  }
}
