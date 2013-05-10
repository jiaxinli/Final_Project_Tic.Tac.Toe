package com.final_proj.Li;

import java.util.Arrays;
import java.util.Random;

import com.final_proj.Li.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {
	
	private Handler mHandler = new Handler();
	Random r = new Random();
	int love=0;
	int go=0;
	int count;
	int[][] win={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
	int[][] pos1={{2,3},{4,7},{5,9}};
	int[][] pos2={{1,3},{5,8}};
	int[][] pos3={{1,2},{6,9},{5,7}};
	int[][] pos4={{1,7},{5,6}};
	int[][] pos5={{4,6},{1,9},{3,7},{2,8}};
	int[][] pos6={{4,5},{3,9}};
	int[][] pos7={{1,4},{8,9},{3,5}};
	int[][] pos8={{7,9},{2,5}};
	int[][] pos9={{1,5},{3,6},{7,8}};
	int xcount,ocount;
	int[] arrx = new int[8];
	int[] arro = new int[8];
	int[] arrAll= new int[10];
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        init();
        
    }

    public void init(){
    	count=0;
    	xcount=0;
    	ocount=0;
    	for(int x=0; x<8; x++)
    	{
    		arrx[x]=0;
    		arro[x]=0;
    	}
    	for(int x=0; x<10; x++)
    	{
    		arrAll[x]=0;
    	} 	
    	ImageButton x = (ImageButton) this.findViewById(R.id.btn1);
    	x.setOnClickListener(listener);
    	x = (ImageButton) this.findViewById(R.id.btn2);
    	x.setOnClickListener(listener);
    	x = (ImageButton) this.findViewById(R.id.btn3);
    	x.setOnClickListener(listener);
    	x = (ImageButton) this.findViewById(R.id.btn4);
    	x.setOnClickListener(listener);
    	x = (ImageButton) this.findViewById(R.id.btn5);
    	x.setOnClickListener(listener);
    	x = (ImageButton) this.findViewById(R.id.btn6);
    	x.setOnClickListener(listener);
    	x = (ImageButton) this.findViewById(R.id.btn7);
    	x.setOnClickListener(listener);
    	x = (ImageButton) this.findViewById(R.id.btn8);
    	x.setOnClickListener(listener);
    	x = (ImageButton) this.findViewById(R.id.btn9);
    	x.setOnClickListener(listener);
    }
    
    public void stop(){
    	ImageButton x = (ImageButton) this.findViewById(R.id.btn1);
    	x.setClickable(false);
    	x = (ImageButton) this.findViewById(R.id.btn2);
    	x.setClickable(false);
    	x = (ImageButton) this.findViewById(R.id.btn3);
    	x.setClickable(false);
    	x = (ImageButton) this.findViewById(R.id.btn4);
    	x.setClickable(false);
    	x = (ImageButton) this.findViewById(R.id.btn5);
    	x.setClickable(false);
    	x = (ImageButton) this.findViewById(R.id.btn6);
    	x.setClickable(false);
    	x = (ImageButton) this.findViewById(R.id.btn7);
    	x.setClickable(false);
    	x = (ImageButton) this.findViewById(R.id.btn8);
    	x.setClickable(false);
    	x = (ImageButton) this.findViewById(R.id.btn9);
    	x.setClickable(false);
    }
    
    public void robot(int x){
    	if(x==1){
    	ImageButton a = (ImageButton) this.findViewById(R.id.btn1);
    	a.setBackgroundResource(R.drawable.robot);
		a.setClickable(false);
    	}
    	else
    	if(x==2){
		ImageButton b = (ImageButton) this.findViewById(R.id.btn2);
    	b.setBackgroundResource(R.drawable.robot);
		b.setClickable(false);
    	}
    	else
		if(x==3){
		ImageButton c = (ImageButton) this.findViewById(R.id.btn3);
    	c.setBackgroundResource(R.drawable.robot);
		c.setClickable(false);
		}
		else
		if(x==4){
		ImageButton d = (ImageButton) this.findViewById(R.id.btn4);
    	d.setBackgroundResource(R.drawable.robot);
		d.setClickable(false);
		}
		else
		if(x==5){
		ImageButton e = (ImageButton) this.findViewById(R.id.btn5);
    	e.setBackgroundResource(R.drawable.robot);
		e.setClickable(false);
		}
		else
		if(x==6){
		ImageButton f = (ImageButton) this.findViewById(R.id.btn6);
    	f.setBackgroundResource(R.drawable.robot);
		f.setClickable(false);
		}
		else
		if(x==7){
		ImageButton g = (ImageButton) this.findViewById(R.id.btn7);
    	g.setBackgroundResource(R.drawable.robot);
		g.setClickable(false);
		}
		else
		if(x==8){
		ImageButton h = (ImageButton) this.findViewById(R.id.btn8);
    	h.setBackgroundResource(R.drawable.robot);
		h.setClickable(false);
		}
		else
		if(x==9){
		ImageButton i = (ImageButton) this.findViewById(R.id.btn9);
    	i.setBackgroundResource(R.drawable.robot);
		i.setClickable(false);
		}
    }

    private OnClickListener listener = new OnClickListener() {
    	
        public void onClick(View v) {

        	if(count<=8&&go==0)
        	{
        		ImageButton b= (ImageButton) v;
        		TextView tv =(TextView)findViewById(R.id.subtitle); 
        		b.setBackgroundResource(R.drawable.male);
        		arro[ocount]=Integer.parseInt((String)b.getTag());
        		b.setClickable(false);
        		tv.setText("Turn : Robot"); 
        		ocount++;
        		
        		arrAll[count]=Integer.parseInt((String)b.getTag());
        		count++;	

                mHandler.postDelayed(new Runnable() {
                    
                	public void run() {
                    	TextView tv =(TextView)findViewById(R.id.subtitle); 
                    	tv.setText("Turn : Player"); 
                    		
                    	for(int i=0;i<8;i++){   
                    		
                    		if(Arrays.toString(arro).contains(String.valueOf(win[i][0]))&&Arrays.toString(arro).contains(String.valueOf(win[i][1]))&&Arrays.toString(arro).contains(String.valueOf(win[i][2])))            			
                    		{            	        				
                    			tv.setText("Player Wins!"); 
                    			go=1;	
                    		}
                    		else
                    			if(Arrays.toString(arrx).contains(String.valueOf(win[i][0]))&&Arrays.toString(arrx).contains(String.valueOf(win[i][1]))&&Arrays.toString(arrx).contains(String.valueOf(win[i][2])))                    		
                    			{                             				
                    				tv.setText("Robot Wins!"); 
                    				go=1;
                    			}                    		                    		                  		
                    	}
                    		
                    	if(count<=8&&go==0)              		
                    	{
                    		int i=r.nextInt(11-1) + 0;
                    		int j=0;
                    		
                    		while(j==0)
                    		{
                    			if(love==0)
                    				i=r.nextInt(11-1) + 0;
                    		
                    			for(int x=0; x<count; x++)
                    			{

                    				if(arrAll[x]==i || i==0)
                    				{
                    					j=1;
                    				}
                    			}
                    		
                    			if(j==1)
                    			{
                    				i=r.nextInt(11-1) + 0;
                    				j=0;
                    			}
                    			else
                    			{
                    				love=0;
                    				if(i==1||i==3||i==7||i==9)
                    				{
                    					for(int x=0; x<3; x++)
                    					{                    			
                    						if(i==1&&Arrays.toString(arro).contains(String.valueOf(pos1[x][0]))&&Arrays.toString(arro).contains(String.valueOf(pos1[x][1]))) 			
                    						{
                    							robot(1);
                    							x=3;
                    							arrAll[count]=1;
                    							count++;   
                    							arrx[xcount]=1;                        
                    							xcount++;
                    							love=1;
                    						}
                    						else
                    							if(i==3&&Arrays.toString(arro).contains(String.valueOf(pos3[x][0]))&&Arrays.toString(arro).contains(String.valueOf(pos3[x][1]))) 			
                    							{
                    								robot(3);
                    								x=3;
                    								arrAll[count]=3;
                    								count++;   
                    								arrx[xcount]=3;                        
                    								xcount++;
                    								love=1;
                    							}
                    							else
                    								if(i==7&&Arrays.toString(arro).contains(String.valueOf(pos7[x][0]))&&Arrays.toString(arro).contains(String.valueOf(pos7[x][1]))) 			
                    								{
                    									robot(7);
                    									x=3;
                    									arrAll[count]=7;
                    									count++;   
                    									arrx[xcount]=7;                        
                    									xcount++;
                    									love=1;
                    								}
                    								else
                    									if(i==9&&Arrays.toString(arro).contains(String.valueOf(pos9[x][0]))&&Arrays.toString(arro).contains(String.valueOf(pos9[x][1]))) 			
                    									{
                    										robot(9);
                    										x=3;
                    										arrAll[count]=9;
                    										count++;   
                    										arrx[xcount]=9;                        
                    										xcount++;
                    										love=1;
                    									}
                    					}
                    				}
                    				else
                    					if(i==2||i==4||i==6||i==8)
                    					{
                    						for(int x=0; x<2; x++)
                    						{                    			
                    							if(i==2&&Arrays.toString(arro).contains(String.valueOf(pos2[x][0]))&&Arrays.toString(arro).contains(String.valueOf(pos2[x][1]))) 			
                    							{
                    								robot(2);
                    								x=3;
                    								arrAll[count]=2;
                    								count++;   
                    								arrx[xcount]=2;                        
                    								xcount++;
                    								love=1;
                    							}
                    							else
                    								if(i==4&&Arrays.toString(arro).contains(String.valueOf(pos4[x][0]))&&Arrays.toString(arro).contains(String.valueOf(pos4[x][1]))) 			
                    								{
                    									robot(4);
                    									x=3;
                    									arrAll[count]=4;
                    									count++;   
                    									arrx[xcount]=4;                        
                    									xcount++;
                    									love=1;
                    								}
                    								else
                    									if(i==6&&Arrays.toString(arro).contains(String.valueOf(pos6[x][0]))&&Arrays.toString(arro).contains(String.valueOf(pos6[x][1]))) 			
                    									{
                    										robot(6);
                    										x=3;
                    										arrAll[count]=6;
                    										count++;   
                    										arrx[xcount]=6;                        
                    										xcount++;
                    										love=1;
                    									}
                    									else
                    										if(i==8&&Arrays.toString(arro).contains(String.valueOf(pos8[x][0]))&&Arrays.toString(arro).contains(String.valueOf(pos8[x][1]))) 			
                    										{
                    											robot(8);
                    											x=3;
                    											arrAll[count]=8;
                    											count++;   
                    											arrx[xcount]=8;                        
                    											xcount++;
                    											love=1;
                    										}
                    						}
                    					}
                    					else if(i==5)
                    					{
                    			
                    						for(int x=0; x<4; x++)
                    						{ 
                    							if(i==5&&Arrays.toString(arro).contains(String.valueOf(pos5[x][0]))&&Arrays.toString(arro).contains(String.valueOf(pos5[x][1]))) 			
                    							{
                    								robot(5);
                    								x=4;
                    								arrAll[count]=5;
                    								count++;   
                    								arrx[xcount]=5;                        
                    								xcount++;
                    								love=1;
                    							}
                    						}
                    					}
                    			
                    					if(count==1)
                    					{
                    						robot(i);
                    						arrAll[count]=i;
                    						count++;   
                    						arrx[xcount]=i;                        
                    						xcount++;
                    						love=1;
                    					}
                    				
                    					if(love==1)
                    						j=1;
                    					else
                    						j=0;
                    			}
                    		}
                    	}
                	}
                }, 2000);  			
        	}
        }
    };

    public void close(View v){
    	finish();
    }
    public void restart(View v){
    	setContentView(R.layout.activity_display_message);
        init();
    } 
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
}