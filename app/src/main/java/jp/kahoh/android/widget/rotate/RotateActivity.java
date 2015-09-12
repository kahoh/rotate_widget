package jp.kahoh.android.widget.rotate;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by kaho on 15/09/01.
 */
public class RotateActivity extends Activity {

	public static final String INTENT_KEY_IS_PORTRAIT = "INTENT_KEY_IS_PORTRAIT";

	public enum ScreenOrientationType {
		SCREEN_ORIENTATION_PORTRAIT(0),
		SCREEN_ORIENTATION_LANDSCAPE(1),
		SCREEN_ORIENTATION_REVERSE_PORTRAIT(2),
		SCREEN_ORIENTATION_REVERSE_LANDSCAPE(3);

		private int intValue;

		private ScreenOrientationType(int intValue) {
			this.intValue = intValue;
		}

		public int getIntValue() {
			return intValue;
		}

		public static ScreenOrientationType resolve(int intValue) {
			for (ScreenOrientationType screenOrientationType : values()) {
				if (intValue == screenOrientationType.getIntValue()) {
					return screenOrientationType;
				}
			}
			return null;
		}
	}

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);

		Intent intent = getIntent();
		int orientationType = intent.getIntExtra(INTENT_KEY_IS_PORTRAIT, -1);

		switch (ScreenOrientationType.resolve(orientationType)) {
			case SCREEN_ORIENTATION_PORTRAIT:
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				break;
			case SCREEN_ORIENTATION_LANDSCAPE:
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
				break;
			case SCREEN_ORIENTATION_REVERSE_PORTRAIT:
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
				break;
			case SCREEN_ORIENTATION_REVERSE_LANDSCAPE:
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
				break;
		}

		finish();
	}
}
