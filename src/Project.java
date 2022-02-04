//Thanalak Sisattayasunthon 6210742166
//Songkeit Klinnimnaul 6210742083


import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Project extends GraphicsProgram {	
	private int count = 0;
	private double cx;
    private double cy;
    private GOval circ;
    private final int SIZE = 300;
    //Check Repetition
    boolean rc_11 = true;
    boolean rc_12 = true;
    boolean rc_13 = true;
    boolean rc_21 = true;
    boolean rc_22 = true;
    boolean rc_23 = true;
    boolean rc_31 = true;
    boolean rc_32 = true;
    boolean rc_33 = true;
    
    //Make symbol in sub's boxX
    boolean xcheck_rc_11, xcheck_rc_12, xcheck_rc_13;
    boolean xcheck_rc_21, xcheck_rc_22, xcheck_rc_23;
    boolean xcheck_rc_31, xcheck_rc_32, xcheck_rc_33;
  //Make symbol in sub's boxO
    boolean ocheck_rc_11, ocheck_rc_12, ocheck_rc_13;
    boolean ocheck_rc_21, ocheck_rc_22, ocheck_rc_23;
    boolean ocheck_rc_31, ocheck_rc_32, ocheck_rc_33;
    
    
	public void run() {
		setWidth(SIZE);
		setHeight(SIZE);
		pause(500);
		table_width();
		table_height();
	}
	public void table_width() { // create tableWidth
	    GLine line1 = new GLine();
	    line1.setStartPoint(getWidth()/3,0);
	    line1.setEndPoint(getWidth()/3,getHeight());
	    line1.setColor(Color.BLACK);
	    add(line1);
	    GLine line2 = new GLine();
	    line2.setStartPoint(getWidth()/1.5,0);
	    line2.setEndPoint(getWidth()/1.5,getHeight());
	    line2.setColor(Color.BLACK);
	    add(line2);
	}
	public void table_height() { // create tableHeight
		GLine line1 = new GLine();
	    line1.setStartPoint(0,getHeight()/3);
	    line1.setEndPoint(getWidth(),getHeight()/3);
	    line1.setColor(Color.BLACK);
	    add(line1);
	    GLine line2 = new GLine();
	    line2.setStartPoint(0,getHeight()/1.5);
	    line2.setEndPoint(getWidth(),getHeight()/1.5);
	    line2.setColor(Color.BLACK);
	    add(line2);
	}
	public void gline(double s11,double s12,double e11,double e12,
			double s21,double s22,double e21,double e22) { // draw X shape
		GLine a = new GLine(); // line1
		a.setStartPoint(s11,s12);
		a.setEndPoint(e11,e12);
		a.setColor(Color.RED);
		add(a);
		GLine b = new GLine(); // line2
		b.setStartPoint(s21,s22);
		b.setEndPoint(e21,e22);
		b.setColor(Color.RED);
		add(b);
	}
	public void goval(double g_w, double g_h,double ne_x,double ne_y) { // draw O shape
		circ = new GOval(getWidth()/3,getHeight()/3);//sizeCircle
		circ.setFilled(true);
		circ.setColor(Color.GREEN);
		add(circ,g_w-ne_x,g_h-ne_y);
	}

	public void mousePressed(MouseEvent e) {
		//position mouse
    	cx = e.getX(); 
    	cy  = e.getY();
    	
    	if(count % 2 == 0) { // checkturnOfPlayer
    		func_row1();
    		func_row2();
    		func_row3();
    	}
    	else {
    		func_row1();
    		func_row2();
    		func_row3();
    	}
	}
	public void func_row1() {
		row1_column1();
    	row1_column2();
    	row1_column3();
	}
	public void func_row2() {
		row2_column1();
    	row2_column2();
    	row2_column3();
	}
	public void func_row3() {
		row3_column1();
    	row3_column2();
    	row3_column3();	
	}
    	public void row1_column1() {
    		
    		if(cx>0 && cx<getWidth()/3 &&cy>0 && cy<getHeight()/3 && rc_11) {   		
    			if(count % 2 == 0) { //player X
    				pause(200);
    				gline(0,0,getWidth()/3,getHeight()/3 ,getWidth()/3,0,0,getHeight()/3); //show X
    				xcheck_rc_11 = true;
    			}else { // player O
    				goval(0+(getWidth()/3)/2,0+(getHeight()/3)/2,(getWidth()/3)/2,(getHeight()/3)/2);
    				ocheck_rc_11 = true;
    			}
    			count+=1;	// count the number of play
    			rc_11 = false; //check for repeat
    			findWin2();
    	}
    }
    	public void row1_column2() {    		
    		if(cx>getWidth()/3 && cx<getWidth()/1.5 &&cy>0 && cy<getHeight()/3 
    			&& rc_12) {
    			pause(200);	
        	if(count % 2 == 0) {
        		gline(getWidth()/3,0, getWidth()/1.5,getHeight()/3, getWidth()/1.5,0,getWidth()/3,getHeight()/3);
    			xcheck_rc_12 = true;
    		}else {
    			goval(getWidth()/3+(getWidth()/1.5)/2,0+(getHeight()/1.5)/2,(getWidth()/1.5)/2,(getHeight()/1.5)/2);
    			ocheck_rc_12 = true;
    		}
        	count+=1;
        	rc_12 = false;
        	findWin2();
    	}
    }
    	public void row1_column3() {		
    		if(cx>getWidth()/1.5 && cx<getWidth() &&cy>0 && cy<getHeight()/3
    			&& rc_13) {
    			pause(200);
        	if(count % 2 == 0) {
        		gline(getWidth()/1.5,0,getWidth(),getHeight()/3 ,getWidth(),0,getWidth()/1.5,getHeight()/3);  
    			xcheck_rc_13 = true;
    		}else {
    			goval(getWidth()/1.5+(getWidth())/3,0+(getHeight()/1.5)/2,(getWidth()/1.5)/2,(getHeight()/1.5)/2);
    			ocheck_rc_13 = true;
    		}
        	count+=1;
        	rc_13 = false;
        	findWin2();
    	}
    }
    	public void row2_column1() {  			
    			if(cx>0 && cx<getWidth()/3 &&cy>getHeight()/3 && cy<getHeight()/1.5 
    			&& rc_21) {
    				pause(200);		
    		if(count % 2 == 0) {
    			gline(0,getHeight()/3,getWidth()/3,getHeight()/1.5 ,getWidth()/3,getHeight()/3,0,getHeight()/1.5);
    			xcheck_rc_21 = true;
    		}else {
    			goval(0+(getWidth()/3)/2,(getHeight()/3)+(getWidth()/3)/2,(getWidth()/3)/2,(getHeight()/3)/2);
    			ocheck_rc_21 = true;
    		}
    		count+=1;
    		rc_21 = false;
    		findWin2();
    	}
    }
    	public void row2_column2() {
    			if(cx>getWidth()/3 && cx<getWidth()/1.5 &&cy>getHeight()/3 
    			&& cy<getHeight()/1.5 && rc_22) {
    				pause(200);
    			if(count % 2 == 0) {
    				gline(getWidth()/3,getHeight()/3,getWidth()/1.5,getHeight()/1.5 
    						,getWidth()/1.5,getHeight()/3,getWidth()/3,getHeight()/1.5);
    			xcheck_rc_22 = true;
    		}else {
    			goval(getWidth()/3+(getWidth()/1.5)/2,getHeight()/3+(getHeight()/1.5)/2,
    					(getWidth()/1.5)/2,(getHeight()/1.5)/2);
    			ocheck_rc_22 = true;
    		}
        	count+=1;
        	rc_22 = false;
        	findWin2();
    	}
    }
    	public void row2_column3() {
    			if(cx>getWidth()/1.5 && cx<getWidth() &&cy>getHeight()/3
    			&& cy<getHeight()/1.5 && rc_23) { 
    				pause(200);
        	if(count % 2 == 0) {
        		gline(getWidth()/1.5,getHeight()/3,getWidth(),getHeight()/1.5, 
    				getWidth(),getHeight()/3,getWidth()/1.5,getHeight()/1.5);
    			xcheck_rc_23 = true;
    		}else {
    			goval(getWidth()/1.5+(getWidth())/3,getHeight()/3+(getHeight()/1.5)/2,
    					(getWidth()/1.5)/2,(getHeight()/1.5)/2);
    			ocheck_rc_23 = true;
    		}
        	count+=1;
        	rc_23 = false;
        	findWin2();
    	} 
    }
    	public void row3_column1() {
    			if(cx>0 && cx<getWidth()/3 &&cy>getHeight()/1.5 && cy<getHeight() 
    			&& rc_31) {	 	
    				pause(200);
    		if(count % 2 == 0) {
    			gline(0,getHeight()/1.5,getWidth()/3,getHeight() ,getWidth()/3,getHeight()/1.5,0,getHeight());  
    			xcheck_rc_31 = true;
    		}else {
    			goval(0+(getWidth()/3)/2,(getHeight()/1.5)+(getWidth()/3)/2,(getWidth()/3)/2,(getHeight()/3)/2);
    			ocheck_rc_31 = true;
    		}
    		count+=1;
    		rc_31 = false;
    		findWin2();
    	}
    }			
    	public void row3_column2() {
    		if(cx>getWidth()/3 && cx<getWidth()/1.5 &&cy>getHeight()/1.5
    			&& cy<getHeight() && rc_32) { 
    			pause(200);
        	if(count % 2 == 0) {
        		gline(getWidth()/3,getHeight()/1.5,getWidth()/1.5,getHeight() 
    				,getWidth()/1.5,getHeight()/1.5,getWidth()/3,getHeight()); 
    			xcheck_rc_32 = true;
    		}else {
    			goval(getWidth()/3+(getWidth()/1.5)/2,getHeight()/1.5+(getHeight()/1.5)/2,
    					(getWidth()/1.5)/2,(getHeight()/1.5)/2);
    			ocheck_rc_32 = true;
    		}
        	count+=1;
        	rc_32 = false;
        	findWin2();
    	}
	}
    	public void row3_column3() {
    		if(cx>getWidth()/1.5 && cx<getWidth() &&cy>getHeight()/1.5 
    			&& cy<getHeight() && rc_33) {
    			pause(200);   	
        	if(count % 2 == 0) {
        		gline(getWidth()/1.5,getHeight()/1.5,getWidth(),getHeight() 
    				,getWidth(),getHeight()/1.5,getWidth()/1.5,getHeight());
    			xcheck_rc_33 = true;
    		}else {
    			goval(getWidth()/1.5+(getWidth())/3,getHeight()/1.5+(getHeight()/1.5)/2,
    					(getWidth()/1.5)/2,(getHeight()/1.5)/2);
    			ocheck_rc_33 = true;
    		}
        	count+=1;
        	rc_33 = false;
        	findWin2();
    	} 	
    }
    	public void findWin2() {
		if((xcheck_rc_11&&xcheck_rc_12&&xcheck_rc_13&&count >=3)||// win condition for X
				(xcheck_rc_21&&xcheck_rc_22&&xcheck_rc_23&&count >=3)||
				(xcheck_rc_31&&xcheck_rc_32&&xcheck_rc_33&&count >=3)||
				(xcheck_rc_11&&xcheck_rc_21&&xcheck_rc_31&&count >=3)||
				(xcheck_rc_12&&xcheck_rc_22&&xcheck_rc_32&&count >=3)||
				(xcheck_rc_13&&xcheck_rc_23&&xcheck_rc_33&&count >=3)||
				(xcheck_rc_11&&xcheck_rc_22&&xcheck_rc_33&&count >=3)||
				(xcheck_rc_13&&xcheck_rc_22&&xcheck_rc_31&&count >=3)) {
			showResult(Color.RED,"PLAYER X WIN!!");
		}
		else if((ocheck_rc_11&&ocheck_rc_12&&ocheck_rc_13&&count >=3)|| // win condition for O
				(ocheck_rc_21&&ocheck_rc_22&&ocheck_rc_23&&count >=3)||
				(ocheck_rc_31&&ocheck_rc_32&&ocheck_rc_33&&count >=3)||
				(ocheck_rc_11&&ocheck_rc_21&&ocheck_rc_31&&count >=3)||
				(ocheck_rc_12&&ocheck_rc_22&&ocheck_rc_32&&count >=3)||
				(ocheck_rc_13&&ocheck_rc_23&&ocheck_rc_33&&count >=3)||
				(ocheck_rc_11&&ocheck_rc_22&&ocheck_rc_33&&count >=3)||
				(ocheck_rc_13&&ocheck_rc_22&&ocheck_rc_31&&count >=3)) {
			showResult(Color.GREEN,"PLAYER O WIN!!");
		}
		else if(count == 9){ // can't find a winner
			showResult(Color.ORANGE,"GAME DRAW!!");
	}
}		
    	public void showResult(Color colorresult , String texted) { // pop-up is result
		GRect s = new GRect(getWidth(),getHeight()); // show background
		s.setColor(colorresult);
		s.setFilled(true);
		add(s,0,0);	
		GLabel a = new GLabel(texted); // show text
		a.setFont(new Font("ITALIC",Font.CENTER_BASELINE,30));
		add(a,getWidth()/8,getHeight()/2);
		
	}
    
}