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

import com.issamux.dummyactivities.DotNet;
import com.issamux.dummyactivities.J2EE;
import com.issamux.dummyactivities.PHP;

public class MyDialogFragment extends DialogFragment implements OnCheckedChangeListener {

	private View mainView;
	private CheckBox dotNetCheckBox, j2eeCheckBox, phpCheckBox;
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
		initUI();
		return mainView;
	}

	private void initUI() {
		dotNetCheckBox = (CheckBox) mainView.findViewById(R.id.dotNet);
		j2eeCheckBox = (CheckBox) mainView.findViewById(R.id.j2ee);
		phpCheckBox = (CheckBox) mainView.findViewById(R.id.php);

		dotNetCheckBox.setOnCheckedChangeListener(this);
		j2eeCheckBox.setOnCheckedChangeListener(this);
		phpCheckBox.setOnCheckedChangeListener(this);

	}

	/*
	 * listener for CheckBox element
	 */
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

		if (buttonView.getId() == dotNetCheckBox.getId() && isChecked) {
			intent.setClass(context, DotNet.class);
		}
		else if (buttonView.getId() == phpCheckBox.getId() && isChecked) {
			intent.setClass(context, PHP.class);
		}
		else if (buttonView.getId() == j2eeCheckBox.getId() && isChecked) {
			intent.setClass(context, J2EE.class);

		}

		startActivity(intent);

	}

}
