package com.example.dualdoku2;
import android.app.Activity;
import android.os.Bundle;

public class Game extends Activity{
	private PuzzleView puzzleView;
	private int puzzle[] = new int[9*9];
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);    
        puzzle = getPuzzle();
        setContentView(R.layout.main);
        puzzleView = (PuzzleView) findViewById(R.id.puzzleview);
        puzzleView.requestFocus();	

    }
    private final String testPuzzle  ="009"+"000"+"000"+
									  "080"+"605"+"020"+
									  "501"+"078"+"000"+
									  
									  "000"+"000"+"700"+
									  "706"+"040"+"102"+
									  "004"+"000"+"000"+
									  
									  "000"+"720"+"903"+
									  "090"+"301"+"080"+
									  "000"+"000"+"600";
	
    /** Convert a puzzle string into an array */
	static protected int[] fromPuzzleString(String string) { 
		int[] puz = new int[string.length()];
		for (int i = 0; i < puz.length; i++) {
			puz[i] = string.charAt(i) - '0'; }
		return puz; 
	}
	
	/** Convert an array into a puzzle string */
	static private String toPuzzleString(int[] puz) { 
		StringBuilder buf = new StringBuilder();
		for (int element : puz) {
			buf.append(element);
		}
		return buf.toString(); 
	}
	private int[] getPuzzle(){
		return fromPuzzleString(testPuzzle);
	}
	
    public String getTileString(int x, int y){
    	//Just for testing purposes
    	int v = puzzle[y * 9 + x];
    	if(v==0){
    		return "";
    	}else{
    		return String.valueOf(v);
    	}
    
    }
}
