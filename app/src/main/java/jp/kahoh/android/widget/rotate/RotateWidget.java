package jp.kahoh.android.widget.rotate;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

public class RotateWidget extends AppWidgetProvider {

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);

		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.rotate_widget);

		setOnClickPendingIntent(context, views, R.id.btn_up, RotateActivity.ScreenOrientationType.SCREEN_ORIENTATION_PORTRAIT.getIntValue());
		setOnClickPendingIntent(context, views, R.id.btn_left, RotateActivity.ScreenOrientationType.SCREEN_ORIENTATION_LANDSCAPE.getIntValue());
		setOnClickPendingIntent(context, views, R.id.btn_right, RotateActivity.ScreenOrientationType.SCREEN_ORIENTATION_REVERSE_LANDSCAPE.getIntValue());
		setOnClickPendingIntent(context, views, R.id.btn_down, RotateActivity.ScreenOrientationType.SCREEN_ORIENTATION_REVERSE_PORTRAIT.getIntValue());

		// ウィジェットの更新
		appWidgetManager.updateAppWidget(appWidgetIds, views);
	}

	private void setOnClickPendingIntent(Context context, RemoteViews views, int resId, int orientationType) {
		Intent intent = new Intent(context, RotateActivity.class);
		intent.putExtra(RotateActivity.INTENT_KEY_IS_PORTRAIT, orientationType);
		PendingIntent pendingIntent =
				PendingIntent.getActivity(context, orientationType, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		views.setOnClickPendingIntent(resId, pendingIntent);
	}
}