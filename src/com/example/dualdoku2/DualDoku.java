package com.example.dualdoku2;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class DualDoku extends Activity
{
	private PuzzleView puzzle;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        puzzle = new PuzzleView(this); 
		setContentView(puzzle); 
		puzzle.requestFocus();	
		
    }
}