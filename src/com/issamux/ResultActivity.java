/*
 * @author issamux
 */

package com.issamux;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {

	public static final String EXTRA_KEY = "myChoice";
	private Intent intent;
	private TextView myChoiceTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_activity);
		initUI();
		intent = getIntent();
		if (intent != null) {
			if (intent.hasExtra("myChoice")) {
				myChoiceTextView.append(" " + intent.getExtras().getString("myChoice"));
			}
		}
	}

	private void initUI() {
		myChoiceTextView = (TextView) findViewById(R.id.textView1);
	}
}
