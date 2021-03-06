package com.onoireszta.rendertex;

import android.widget.EditText;

public class MyEditText {
	
	private EditText editText;
	private int cursorPosition;
	private CharSequence beforeCursor;
	private CharSequence afterCursor;
	
	public MyEditText( EditText myEditText ){
		editText = myEditText;
	}
	
	public void setText( String text ){
		editText.setText( text );	
	}
	
	public String getTextWithoutTag(){
		return android.text.Html.fromHtml( 
				editText.getText().toString().replaceAll( "<", "< ") ).toString();
		//return editText.getText().toString();
		//return editText.getText().toString().replaceAll( "<", " " );
	}
	
	public void addText( String text ){
		cursorPosition = editText.getSelectionStart();
		beforeCursor = editText.getText().toString().subSequence( 0, cursorPosition );
		afterCursor = editText.getText().toString().subSequence( cursorPosition, editText.getText().toString().length() );
		
		String result = beforeCursor + "" + text + "" + afterCursor;
		
		editText.setSelection(0);
		
		editText.setText( result );
		editText.setSelection( (beforeCursor + text ).length()/*result.length()*/ ); //set cursor position at the end 
	}
	
	public EditText getEditText(){
		return editText;
	}
}
