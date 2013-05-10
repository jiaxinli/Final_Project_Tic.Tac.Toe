package com.final_proj.Li;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButton();

        
	}
	public boolean onCreateOptionsMenu(Menu menu) 

	{

	       MenuInflater inflater = getMenuInflater();

	       inflater.inflate(R.menu.main, menu);

			System.out.println("Developer: Jiaxin Li");

	       return true;

	}
	
	public void addListenerOnButton() {
		 
		final Context context = this;
 
		Button button = (Button) findViewById(R.id.onePlayer);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
			    Intent intent = new Intent(context, DisplayMessageActivity.class);
                            startActivityForResult(intent,1);
                                   		
			}	
		});
		
		Button button2 = (Button) findViewById(R.id.twoPlayers);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
			    Intent intent = new Intent(context, MainActivity_twoPlayers.class);
                            startActivityForResult(intent,1);
                                   		
			}	
		});
	}
}
 
