package com.example.dualdoku2;

import android.app.Activity;
import android.os.Bundle;

public class Game extends Activity{
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
