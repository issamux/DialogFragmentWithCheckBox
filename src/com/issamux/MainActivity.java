/*
 * @author issamux
 */

package com.issamux;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	MyDialogFragment mDialog;
	Button showDiagButton;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.main);
		showDiagButton = (Button) findViewById(R.id.showDiag);

	}

	public void showDialog(View view) {
		removeDiagifExist();
		mDialog = MyDialogFragment.newInstance();
		mDialog.show(getSupportFragmentManager(), "dialog");

	}

	@Override
	protected void onResume() {
		super.onResume();
		removeDiagifExist();
	}

	private void removeDiagifExist() {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		mDialog = (MyDialogFragment) getSupportFragmentManager().findFragmentByTag("dialog");
		if (mDialog != null) {
			mDialog.dismiss();
			ft.remove(mDialog);
		}
		ft.addToBackStack(null);
		// ft.commit();

	}

	@Override
	protected void onPause() {
		super.onPause();
		if (mDialog != null)
			mDialog = null;
	}

	@Override
	protected void onStop() {
		super.onStop();
		mDialog = null;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mDialog = null;
	}

}
