package com.anisdroid.Create_Database;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.database.*;

public class MainActivity extends Activity 
{
	My_DB_Helper ddd;
	
	EditText eee;
	EditText id;
	
	Button add_bt;
	
	Button view_bt;
	
	Button update_bt;
	
	Button delete_bt;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		ddd = new My_DB_Helper(this);
		
		eee = (EditText)findViewById(R.id.name);
		id = (EditText)findViewById(R.id.id);
		
		
		add_bt = (Button)findViewById(R.id.add_button);
		
		view_bt = (Button)findViewById(R.id.view_button);
		
		update_bt = (Button)findViewById(R.id.update_button);
		
		delete_bt = (Button)findViewById(R.id.delete_button);
		
		add_bt.setOnClickListener(
		
			new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					
					boolean bbb = ddd.insertData(eee.getText().toString());
					
					if(bbb = true)
						
						Toast.makeText(MainActivity.this,"Data inserted..",Toast.LENGTH_SHORT).show();
					
					else
						
						Toast.makeText(MainActivity.this,"Data not inserted..",Toast.LENGTH_SHORT).show();
					
						
				}

				
				
				
			}
		
		);
		
		
		view_bt.setOnClickListener(
		
			new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					
					Cursor res = ddd.viewData();
					
					StringBuffer buf = new StringBuffer();
					
					while(res.moveToNext()){
						
						buf.append("ID : "+res.getString(0)+"\n");
						
						buf.append("NAME : "+res.getString(1)+"\n\n");
						
					}
					
					AlertDialog.Builder ale = new AlertDialog.Builder(MainActivity.this);
					
					ale.setCancelable(true);
					
					ale.setTitle("List Of Your Friends Name");
					
					ale.setMessage(buf.toString());
					
					ale.show();
					
				}

				
				
				
			}
		);
		
		
		update_bt.setOnClickListener(
		
			new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					
					boolean uuu = ddd.updateData(id.getText().toString(),
									eee.getText().toString());
									
					if(uuu = true)

						Toast.makeText(MainActivity.this,"Data updated",Toast.LENGTH_SHORT).show();

					else

						Toast.makeText(MainActivity.this,"Data not updated..",Toast.LENGTH_SHORT).show();
					
					
				}
				
				
				
				
			}
		
		);
		
		delete_bt.setOnClickListener(
		
			new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					
					Integer del = ddd.deleteData(id.getText().toString());
					
					if(del > 0)
						Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_SHORT).show();

					else

						Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_SHORT).show();
					
					
				}

				
			}
		
		);
		
    }
}
