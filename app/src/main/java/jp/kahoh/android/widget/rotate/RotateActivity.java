package jp.kahoh.android.widget.rotate;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

/**
 * Created by kaho on 15/09/01.
 */
public class RotateActivity extends Activity {

	public static final String INTENT_KEY_IS_PORTRAIT = "INTENT_KEY_IS_PORTRAIT";

	public static final int SCREEN_ORIENTATION_PORTRAIT = 0;

	public static final int SCREEN_ORIENTATION_LANDSCAPE = 1;

	public static final int SCREEN_ORIENTATION_REVERSE_PORTRAIT = 2;

	public static final int SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 3;

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);

		Intent intent = getIntent();
		int orientationType = intent.getIntExtra(INTENT_KEY_IS_PORTRAIT, -1);

		//TODO 同じ向きなら処理をしない
		switch (orientationType) {
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
