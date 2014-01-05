/*
 * @author issamux
 */

package com.issamux;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MyDialogFragment extends DialogFragment implements OnCheckedChangeListener {

	private View mainView;
	private CheckBox firstChoice, secondChoice, thirdChoice;
	private Context context;
	Intent intent;

	public MyDialogFragment() {
		setStyle(DialogFragment.STYLE_NO_TITLE, 0);
		// use setShowsDialog(true) and override onCreateDialog(Bundle) to create an entirely
		// custom dialog, such as an
		// AlertDialog, with its own content.
	}

	static MyDialogFragment newInstance() {
		return new MyDialogFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mainView = inflater.inflate(R.layout.diag, container, false);
		context = getActivity();
		intent = new Intent();
		intent.setClass(context, ResultActivity.class);
		initUI();
		return mainView;
	}

	private void initUI() {
		firstChoice = (CheckBox) mainView.findViewById(R.id.checkBox1);
		secondChoice = (CheckBox) mainView.findViewById(R.id.checkBox2);
		thirdChoice = (CheckBox) mainView.findViewById(R.id.checkBox3);

		firstChoice.setOnCheckedChangeListener(this);
		secondChoice.setOnCheckedChangeListener(this);
		thirdChoice.setOnCheckedChangeListener(this);

	}

	/*
	 * listener for CheckBox element
	 */
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

		if (isChecked) {
			doJob(buttonView.getText().toString());
		}

	}

	private void doJob(String choiceValue) {
		intent.putExtra(ResultActivity.EXTRA_KEY, choiceValue);
		startActivity(intent);
	}
}
