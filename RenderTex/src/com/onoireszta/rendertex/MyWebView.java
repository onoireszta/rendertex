package com.onoireszta.rendertex;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

public class MyWebView extends WebView {
	
	private String customHtmlBeforeEquation;
	private String customHtmlAfterEquation;
	
	public MyWebView(Context context) {
		super(context);
		init();
	}
	
	public MyWebView(Context context, AttributeSet attrs) {
			super(context, attrs);
			init();
	}

	public MyWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init(){		
		getSettings().setJavaScriptEnabled(true);
		//setWebChromeClient( new WebChromeClient() ); // show alert() from js
 	   					
		String javaScriptFileURL = "file:///android_asset/MathJax/MathJax.js";
 	   	customHtmlBeforeEquation = "<html><head>"
	   			+"<script type='text/x-mathjax-config'>" // from MathJax documentation  
	   			+"MathJax.Hub.Config({"
	   			+"extensions: [\"tex2jax.js\"],"
	   			+"jax: [\"input/TeX\", \"output/HTML-CSS\"],"
	   			+"tex2jax: {"
	   			+"inlineMath: [ ['$','$'], [\"\\(\",\"\\)\"] ],"
	   			+"displayMath: [ ['$$','$$'], [\"\\[\",\"\\]\"] ],"
	   			+"processEscapes: true"
	   			+"},"
	   			+"\"HTML-CSS\": { availableFonts: [\"TeX\"] }"
	   			+"});"
	   			+"</script>"
	   			+"<script type='text/javascript'"
	   			+"src='" + javaScriptFileURL +"'>"
	   			+"</script>"
	   			+"</head><body>";
	   	customHtmlAfterEquation = "</body></html>";
 	   	loadDataWithBaseURL("http://onoireszta", customHtmlBeforeEquation + customHtmlAfterEquation, "text/html", "UTF-8", "");
 	   	
	}
	
	public void loadEquation( String equation ){
		String resultHtml = customHtmlBeforeEquation + "$$" + equation + "$$" + customHtmlAfterEquation;
		
		loadDataWithBaseURL("http://onoireszta", resultHtml, "text/html", "UTF-8", "" );
	}
	
	@Override
	public boolean onTouchEvent( MotionEvent event ){
		getSettings().setBuiltInZoomControls( true );
		getSettings().setSupportZoom( true ); // Works?
		
		return super.onTouchEvent( event );		
	}

}
