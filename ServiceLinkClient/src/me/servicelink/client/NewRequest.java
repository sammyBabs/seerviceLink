package me.servicelink.client;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

public class NewRequest extends Activity implements View.OnClickListener{
	ImageButton ib;
	ImageView iv;
	Intent i;
	final static int cameraData=0;
	Bitmap bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_request);
		final EditText etDesc = (EditText) findViewById(R.id.etDesc);	
		initialize();

		
		// Populate Spinner with values
		final Spinner spinTrade = (Spinner) findViewById(R.id.spinTrade);
		String[] tradeArray = {"Select a trade type ",
    							"Electrical          ", 
    							"Plumbing            ", 
    							"Carpentry & Joinery ", 
    							"Motor Mechanics     ", 
    							"Alarm               ", 
    							"Gas Fitters         ", 
    							"Window Repairs      ", 
    							"Locksmiths          ", 
    							"Handyman            ", 
    							"Plasterers          ", 
    							"Appliance Repairs   ", 
    							"Roofers             ", 
    							"Ground Works        ", 
    							"Computer Systems    "};
    	
    	//Adapter identifies the array/list of items to be used to populate the spinner, by adapting array items to spinner items
    	try {
    		ArrayAdapter<?> adapter = new ArrayAdapter<Object>(this, android.R.layout.simple_spinner_item, tradeArray);
        	spinTrade.setAdapter(adapter);
        	spinTrade.setOnClickListener(new View.OnClickListener() {
        		@Override
    			public void onClick(View arg0) {
    				// TODO Auto-generated method stub
    				etDesc.selectAll();
    			}
    		});	
        	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	private void initialize() {
		iv = (ImageView) findViewById(R.id.ivReturnPic);
		ib = (ImageButton) findViewById(R.id.ibTakePic);
		ib.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {

		case R.id.ibTakePic:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i,cameraData);
			break;
		}
		}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			Bundle extras = data.getExtras();
			bmp= (Bitmap) extras.get("data");
		}	iv.setImageBitmap(bmp);
}
	}
