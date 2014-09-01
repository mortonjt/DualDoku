package com.example.dualdoku2;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.Paint.FontMetrics; 
import android.graphics.Paint.Style; 
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;

public class PuzzleView extends View{

	private static final String TAG = "DualDoku"; 
	private final DualDoku game;
	
	private float width;   // width of one tile      
	private float height;  // height of one tile  
	private int selX;      // X index of selection
	private int selY;      // Y index of selection
	private final Rect selRect = new Rect();
	
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		width = w / 9f;
		height = h / 9f;
		getRect(selX, selY, selRect);
		Log.d(TAG, "onSizeChanged: width " + width + ", height "+ height); 
		super.onSizeChanged(w, h, oldw, oldh);
	}
	
	private void getRect(int x, int y, Rect rect) {
		rect.set((int) (x * width), 
				 (int) (y * height), 
				 (int) (x * width + width), 
				 (int) (y * height + height));
	}
	
	public PuzzleView(Context context) {
		super(context);
		this.game = (DualDoku) context; 
		setFocusable(true); 
		setFocusableInTouchMode(true);
	}
	
	public PuzzleView(Context context, AttributeSet attrs) {
		super(context,attrs);
		this.game = (DualDoku) context; 
		setFocusable(true); 
		setFocusableInTouchMode(true);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
	
		// Draw the background...
		Paint background = new Paint(); 
		background.setColor(getResources().getColor(
	         R.color.puzzle_background));
		canvas.drawRect(0, 0, getWidth(), getHeight(), background);
		
		// Draw the board...
		// Define colors for the grid lines
		Paint dark = new Paint(); 
		dark.setColor(getResources().getColor(R.color.puzzle_dark));
		Paint hilite = new Paint(); 
		hilite.setColor(getResources().getColor(R.color.puzzle_hilite));
		Paint light = new Paint(); 
		light.setColor(getResources().getColor(R.color.puzzle_light));
		int left = getPaddingLeft();
		int right = getPaddingRight();
		int top = getPaddingTop();
		int bottom = getPaddingBottom();
		Log.d(TAG, "onDraw: right " + right + ", left "+ left); 
		Log.d(TAG, "onDraw: top " + top + ", bottom "+ bottom); 
		
		// Draw the minor grid lines
		for (int i = 0; i < 9; i++) {
			canvas.drawLine(left, i * height, getWidth()-right, i * height,light);
			canvas.drawLine(left, i * height + 1, getWidth()-right, i * height + 1, light);
			canvas.drawLine(i * width, top, i * width, getHeight()-bottom,light);
			canvas.drawLine(i * width + 1, top, i * width + 1,getHeight()-bottom, light);
		}
		
		// Draw the major grid lines
		for (int i = 0; i < 9; i++) { 
			if (i % 3 != 0)
				continue;
			canvas.drawLine(left, i * height, getWidth()-right, i * height,dark);
			canvas.drawLine(left, i * height + 1, getWidth()-right, i * height+ 1, dark);
			canvas.drawLine(i * width, top, i * width, getHeight()-bottom, dark);
			canvas.drawLine(i * width + 1, top, i * width + 1, getHeight()-bottom, dark);
		}
		// Draw the numbers...
		// Define color and style for numbers
		Paint foreground = new Paint(Paint.ANTI_ALIAS_FLAG);
		foreground.setColor(getResources().getColor(
							R.color.puzzle_foreground));
		foreground.setStyle(Style.FILL);
		foreground.setTextSize(height * 0.75f);
		foreground.setTextScaleX(width / height);
		foreground.setTextAlign(Paint.Align.CENTER);
		// Draw the number in the center of the tile
		FontMetrics fm = foreground.getFontMetrics();
		// Centering in X: use alignment (and X at midpoint)
		float x = width / 2;
		
		// Draw the hints...
		// Draw the selection...
		/*
		Log.d(TAG, "selRect=" + selRect);
		Paint selected = new Paint(); 
		selected.setColor(getResources().getColor(
						  R.color.puzzle_selected));
		canvas.drawRect(selRect, selected);*/
	}
	

}
