package com.anisdroid.Create_Database;
import android.database.sqlite.*;
import android.content.*;
import android.database.*;

public class My_DB_Helper extends SQLiteOpenHelper
{
	
	public My_DB_Helper(Context ccc){
		super(ccc,"friends.db",null,1);
	}
	

	@Override
	public void onCreate(SQLiteDatabase p1)
	{
		// TODO: Implement this method
		p1.execSQL("CREATE TABLE friends_name(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase p1, int p2, int p3)
	{
		// TODO: Implement this method
		p1.execSQL("DROP TABLE IF EXISTS friends_name");
		onCreate(p1);
	}

	public boolean insertData(String name){
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues ccc = new ContentValues();
		
		ccc.put("NAME",name);
		
		long result = db.insert("friends_name",null,ccc);
		
		if(result == -1)
			
			return false;
			
		else
		
			return true;
		
	}
	
	public Cursor viewData(){
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor res = db.rawQuery("SELECT * FROM friends_name",null);
		
		return res;
	}
	
	public boolean updateData(String id,String name){
		
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues ccc = new ContentValues();

		ccc.put("NAME",name);
		
		db.update("friends_name",ccc,"ID = ?",new String[] {id});
		
		return true;
		
	}
	
	
	public Integer deleteData(String id){
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		return db.delete("friends_name","ID = ?",new String[] {id});
		
	}
	
	
}
