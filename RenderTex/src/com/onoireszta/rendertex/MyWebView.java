package com.onoireszta.rendertex;

import android.webkit.WebView;

public class MyWebView {

	private WebView webView;
	private String customHtmlBeforeEquation;
	private String customHtmlAfterEquation;
			
	public MyWebView( WebView myWebView ) {
		webView = myWebView;
		webView.getSettings().setJavaScriptEnabled(true);
		//webView.setWebChromeClient( new WebChromeClient() ); // show alert() from js
 	   			
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
 	   	webView.loadDataWithBaseURL("http://onoireszta", customHtmlBeforeEquation + customHtmlAfterEquation, "text/html", "UTF-8", "");
	}
	
	public void loadEquation( String equation ){
		String resultantHtml = customHtmlBeforeEquation + equation + customHtmlAfterEquation;
		
		webView.loadDataWithBaseURL("http://onoireszta", resultantHtml, "text/html", "UTF-8", "" );
	}

}
