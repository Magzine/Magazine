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

	//	View Flipper��ü�� Ȱ���� ���� OnTouchListener�̺�Ʈ ���
	
//	 ViewFlipper ������Ʈ ��ü ���� 
	
	private ViewFlipper m_viewFlipper;
	
//	 ViewFilpper �ȿ��� ��ġ�� X���� ��ǥ�� 
	
	private int m_nPreTouchPosX = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sub_view1);
		
		m_viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
		m_viewFlipper.setOnTouchListener(this);
		
		// ViewFlipper�� ���� ���̾ƿ� �߰�
		
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

//	ȭ���� ��ġ�ǰ� �������� �������� ��ġ�� ������ 
//	X��ǥ ��Ȯ���� �Ǵ��Ͽ� ������ �ִϸ��̼��� �����ϴ� �ڵ�
	
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
	
//	�ִϸ��̼� ������ ���� �޼ҵ�
	
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
