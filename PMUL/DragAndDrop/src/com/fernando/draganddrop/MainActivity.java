package com.fernando.draganddrop;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
  
	private Button[] btn = new Button[4];
	private int r = 0;

	@Override
  	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
    
	    setContentView(R.layout.activity_main);
	    btn[0] = (Button) findViewById(R.id.button1);
	    btn[0].setTag("1");
	    btn[1] = (Button) findViewById(R.id.button2);
	    btn[1].setTag("2");
	    btn[2] = (Button) findViewById(R.id.button3);
	    btn[2].setTag("3");
	    btn[3] = (Button) findViewById(R.id.button4);
	    btn[3].setTag("4");
	    
	    for(int i = 0; i < btn.length; i++) {
	    	btn[i].setOnLongClickListener(new MyClickListener());
	    }
	   
	    findViewById(R.id.linearLayout1).setOnDragListener(new MyDragListener());
	    findViewById(R.id.linearLayout2).setOnDragListener(new MyDragListener());
	    findViewById(R.id.linearLayout1).setBackgroundColor(Color.BLUE);
	    findViewById(R.id.linearLayout2).setBackgroundColor(Color.RED);
	}

	private final class MyClickListener implements OnLongClickListener {
		@Override
		public boolean onLongClick(View view) {
			ClipData.Item item = new ClipData.Item((CharSequence)view.getTag());
	        String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
	        ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);
	        DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
	        view.startDrag( data, shadowBuilder, view, 0);
	        view.setVisibility(View.INVISIBLE);
	        
	        return true;
		}	
	}
	
	class MyDragListener implements OnDragListener {
		@Override
		public boolean onDrag(View v, DragEvent event) {
			
		    switch (event.getAction()) {
		    case DragEvent.ACTION_DRAG_STARTED:
		        break;
		        
		    case DragEvent.ACTION_DRAG_ENTERED:
		        break;
		        
		    case DragEvent.ACTION_DRAG_EXITED:
		    	break;
		        
		    case DragEvent.ACTION_DROP:
				if(v == findViewById(R.id.linearLayout2)) {
				   	View view = (View) event.getLocalState();
				   	ViewGroup viewgroup = (ViewGroup) view.getParent();
				   	if(viewgroup.getId() != v.getId()) {
					   	viewgroup.removeView(view);
						        
					   	TextView text = (TextView) findViewById(R.id.textView1);
					   	r += Integer.parseInt(view.getTag().toString());
					   	text.setText("Puntos: " + String.valueOf(r));
						           
					   	LinearLayout containView = (LinearLayout) v;
					   	containView.addView(view);
				   	}
				   	view.setVisibility(View.VISIBLE);
				   	break;
				} else {
				   	View view = (View) event.getLocalState();
				   	ViewGroup viewgroup = (ViewGroup) view.getParent();
				   	if(viewgroup.getId() != v.getId()) {
					   	viewgroup.removeView(view);
						        
					   	TextView text = (TextView) findViewById(R.id.textView1);
					   	r -= Integer.parseInt(view.getTag().toString());
					   	text.setText("Puntos: " + String.valueOf(r));
						           
					   	LinearLayout containView = (LinearLayout) v;
					   	containView.addView(view);
				   	}
				   	view.setVisibility(View.VISIBLE);
				   	break;
				}
		    	  
		    case DragEvent.ACTION_DRAG_ENDED:
		    	break;
		    
		    default:
		        break;
		    }
		    return true;
		}
	}
}