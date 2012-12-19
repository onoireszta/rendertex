package com.onoireszta.rendertex;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private WebView webView;
	private MyWebView myWebView;
	private Button goButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        createAndAddGoButton();
        webView = (WebView) findViewById(R.id.webView);
        myWebView = new MyWebView( webView ); 	   	

        //myWebView.loadEquation( "$$"+ "{-b"+ "\\pm" + "\\sqrt{b^2-4ac}" + "\\over" + "2a}." + "$$" );
    }

    private void createAndAddGoButton(){
    	goButton = (Button) findViewById( R.id.rendertex_go_button );
    	goButton.setOnClickListener( new OnClickListener(){
    		@Override
			public void onClick( View v ) {
    			EditText equationText = (EditText) findViewById( R.id.rendertex_edit_text );
    			myWebView.loadEquation( equationText.getText().toString() );    			
			}
    	});
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
