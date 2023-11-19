package com.lista_contato;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private EditText editText;
	private Button buttonAdd;
	private ListView listView;
	
	private ArrayList<String> arrayList;
	private ArrayAdapter<String> arrayAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//declarando as variaveis
		editText = (EditText)findViewById(R.id.editText1);
		buttonAdd= (Button)findViewById(R.id.buttonAdd);
		listView = (ListView)findViewById(R.id.listview);
		
		arrayList = new ArrayList<String>();
		arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
		listView.setAdapter(arrayAdapter);
		
		buttonAdd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				taskAdd();
			}
		});
	}
	private void taskAdd(){
		String task = editText.getText().toString().trim();
		if(!task.isEmpty()){
			arrayList.add(task);
			arrayAdapter.notifyDataSetChanged();
			editText.setText("");
			}
	}
}
