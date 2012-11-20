package com.onoireszta.rendertex;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class MainActivity extends Activity {

	private WebView webView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
       webView = (WebView) findViewById(R.id.webView);
 	   webView.getSettings().setJavaScriptEnabled(true);
 	     
 	   String customHtml = "<html><head></head><body>"
 			   +"<script type='text/javascript'"
 	   	       +"src='http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML'>"
 	           +"</script><math display='block'><semantics><mrow><mi>x</mi><mo>=</mo>"
 	           +"<msqrt><mrow><msup><mi>b</mi><mn>2</mn></msup><mo>&#x2212;</mo>"
 	           +"<mn>4</mn><mi>a</mi><mi>c</mi></mrow></msqrt></mrow></semantics></math>"
 	           +"</body></html>";
 	   webView.loadDataWithBaseURL("http://bar", customHtml, "text/html", "UTF-8", "");
 	   //webView.loadData(customHtml, "text/html", "UTF-8");
               
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
