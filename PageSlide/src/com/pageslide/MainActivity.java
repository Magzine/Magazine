package com.pageslide;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnTouchListener{

	//	View Flipper객체를 활용을 위한 OnTouchListener이벤트 상속
	
//	 ViewFlipper 컴포넌트 객체 선언 
	
	private ViewFlipper m_viewFlipper;
	
//	 ViewFilpper 안에서 터치된 X축의 좌표값 
	
	private int m_nPreTouchPosX = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sub_view1);
		
		m_viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
		m_viewFlipper.setOnTouchListener(this);
		
		// ViewFlipper에 서브 레이아웃 추가
		
		LinearLayout sub1 = (LinearLayout) View.inflate(this,
				R.layout.sub_view1, null);
		LinearLayout sub2 = (LinearLayout) View.inflate(this,
				R.layout.sub_view2, null);
		LinearLayout sub3 = (LinearLayout) View.inflate(this,
				R.layout.sub_view3, null);
		m_viewFlipper.addView(sub1);
		m_viewFlipper.addView(sub2);
		m_viewFlipper.addView(sub3);
	}

//	화면이 터치되고 떨어지는 과정에서 터치된 지점의 
//	X좌표 변확량을 판단하여 구동할 애니메이션을 결정하는 코드
	
	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			m_nPreTouchPosX = (int) event.getX();
		}

		if (event.getAction() == MotionEvent.ACTION_UP) {
			int nTouchPosX = (int) event.getX();

			if (nTouchPosX < m_nPreTouchPosX) {
				MoveNextView();
			} else if (nTouchPosX > m_nPreTouchPosX) {
				MovewPreviousView();
			}

			m_nPreTouchPosX = nTouchPosX;
		}

		return true;
	}
	
//	애니메이션 구현을 위한 메소드
	
	private void MoveNextView() {
		m_viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
				R.anim.appear_from_right));
		m_viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
				R.anim.appear_to_left));
		m_viewFlipper.showNext();
	}

	private void MovewPreviousView() {
		m_viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
				R.anim.appear_from_left));
		m_viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
				R.anim.appear_to_right));
		m_viewFlipper.showPrevious();
	}	
}
