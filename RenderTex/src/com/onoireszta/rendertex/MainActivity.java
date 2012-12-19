package com.onoireszta.rendertex;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	//private WebView webView;
	private MyWebView myWebView;
	private MyEditText myEditText;
	private Button goButton;
	//useful buttons
	private Button integralButton;
	private Button fractionButton;
	private Button functionButton;
	private Button sumButton;
	private Button productButton;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = new MyWebView( (WebView) findViewById( R.id.webView ) );
        myEditText = new MyEditText( (EditText) findViewById( R.id.rendertex_edit_text ) );
        
        createAndAddGoButton();
        createUsefulButton();        
                    
        //myWebView.loadEquation( "$$"+ "{-b"+ "\\pm" + "\\sqrt{b^2-4ac}" + "\\over" + "2a}." + "$$" );
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private void createAndAddGoButton(){
    	goButton = (Button) findViewById( R.id.rendertex_go_button );
    	goButton.setOnClickListener( new OnClickListener(){
    		@Override
			public void onClick( View v ) {
    			myWebView.loadEquation( myEditText.getText() );	
    		}
    	});
    }

    private void createUsefulButton(){    	
    	integralButton = (Button) findViewById( R.id.integral_button );
    	fractionButton = (Button) findViewById( R.id.fraction_button );
    	functionButton = (Button) findViewById( R.id.function_button );
    	sumButton	   = (Button) findViewById( R.id.sum_button	 	 );
    	productButton  = (Button) findViewById( R.id.product_button	 );
    	
    	// set Click Listener
        integralButton.setOnClickListener( 	this );
        fractionButton.setOnClickListener( 	this );
        functionButton.setOnClickListener( 	this );
        sumButton.setOnClickListener(		this );
        productButton.setOnClickListener(	this );
        /*productButton.setOnClickListener( new OnClickListener() {
        	@Override
			public void onClick(View arg0) {
        		EditText et = (EditText) findViewById( R.id.rendertex_edit_text );
        		et.setText( "\\prod_{n=1}^n" );				
			}
		});*/
    }
    
	@Override
	public void onClick( View v ) {
		
		switch( v.getId() ){
		case( R.id.integral_button ):
			myEditText.addText( "\\int" );
			break;
		case( R.id.fraction_button ):
			myEditText.addText( "\\frac{}{}" );
			break;
		case( R.id.function_button ):
			myEditText.addText( "f(x)=" );
			break;
		case( R.id.sum_button ):
			myEditText.addText( "\\sum\\limits_{i=1}^n" );
			break;
		case( R.id.product_button ):
			myEditText.addText( "\\prod_{n=1}^n" );
			break;		
		default:
			myEditText.addText( "default" );
			break;
		}
	}
}
