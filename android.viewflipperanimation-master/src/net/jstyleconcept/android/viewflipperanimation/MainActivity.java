package net.jstyleconcept.android.viewflipperanimation;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
	ViewFlipper viewFlipper;
	float startX,endX;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags
		(
			WindowManager.LayoutParams.FLAG_FULLSCREEN,
			WindowManager.LayoutParams.FLAG_FULLSCREEN
		);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.layout_mainactivity);
		viewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper1);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch(event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				startX=event.getX();
				break;
			case MotionEvent.ACTION_UP:
				endX=event.getX();
				if(startX>endX) { /* Flip Left */
					viewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.infromright));
					viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.outtoleft));
					viewFlipper.showNext();
				}
				if(startX<endX) { /* Flip Right */
					viewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.infromleft));
					viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.outtoright));
					viewFlipper.showPrevious();
				}
				break;
		}
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.layout_mainactivity,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent=new Intent(MainActivity.this,SourceCodeActivity.class);
		switch(item.getOrder()) {
			case 0:
				startActivity(intent);
				break;
			case 1:
				finish();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}