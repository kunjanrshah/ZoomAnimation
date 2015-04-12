package com.drc.zoomanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class ZoomAnimation extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button ok=(Button)findViewById(R.id.ok);
        final ImageView image1=(ImageView)findViewById(R.id.image1);
        ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AnimationSet animSet = new AnimationSet(false);
				Animation rotate=AnimationUtils.loadAnimation(ZoomAnimation.this,R.anim.roratation);
				Animation scale=AnimationUtils.loadAnimation(ZoomAnimation.this,R.anim.scaling);
				
				animSet.addAnimation(rotate);
				animSet.addAnimation(scale);
				
			    animSet.setInterpolator(new AccelerateDecelerateInterpolator());
			    image1.clearAnimation();
			    animSet.setFillAfter(true);  //this code for after done animation. state is not reset.
			    image1.startAnimation(animSet);
				//animSet.start();
			}
		});
    }
}