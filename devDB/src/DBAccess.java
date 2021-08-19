import java.io.IOException;

import com.android.tools.r8.internal.db;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAccess extends SQLiteOpenHelper{
	private static final int DBVERSION=1;
	DBAccess(Context context){
		super(context,getSQL.GetDBName(),null,this.DBVERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		try {
			db.execSQL(getSQL.MakeTable());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	public boolean deleteTODO(SQLiteDatabase db,int id){
		String sql=getSQL.DeleteTODO(id);
		db.execSQL(sql);
		return true;
	}
	public boolean deleteCALENDAR(SQLiteDatabase db,int id){
		String sql = getSQL.DeleteCALENDAR(id);
		db.execSQL(sql);
		return true;
	}
	public boolean updateTODO(SQLiteDatabase db,int id,String deadline,int date_long){
		String sql=getSQL.UpdateTODO(id, deadline, date_long);
		db.execSQL(sql);
		return true;
	}
	public boolean updateCALENDAR(SQLiteDatabase db,int id,String date,String start,String end){
		String sql=getSQL.UpdateCALENDAR(id, date, start, end);
		db.execSQL(sql);
		return true;
	}
	public boolean updateNOTE(SQLiteDatabase db,int id,String note){
		String sql=getSQL.UpdateNOTE(id, note);
		db.execSQL(sql);
		return true;
	}
	public boolean addPARENT(SQLiteDatabase db,int parent,int child){
		String sql=getSQL.AddPARENT(parent, child);
		db.execSQL(sql);
		return true;
	}
	public int addCALENDAR(SQLiteDatabase db,String note,String date,String start,String end){

		int id=makeID();
		String sql =getSQL.AddCALENDAR(id, note, date, start, end);
		db.execSQL(sql);
		return id;
	}
	public int addTODO(SQLiteDatabase db,String note,String deadline,int howlong){
		int id=makeID();
		String sql =getSQL.AddTODO(id, note, deadline, howlong);
		db.execSQL(sql);
		return id;
	}
	public Cursor getNOTE(SQLiteDatabase db){
		String sql=getSQL.GetNOTE();
		Cursor cr=db.rawQuery(sql, null);
		cr.moveToFirst();
		return cr;
	}
	public Cursor getCALENDAR(SQLiteDatabase db){
		String sql=getSQL.GetCALENDAR();
		Cursor cr=db.rawQuery(sql, null);
		cr.moveToFirst();
		return cr;
	}
	public boolean clearTable(SQLiteDatabase db){
		String sql=getSQL.ClearTable();
		db.execSQL(sql);
		return true;
	}
	public boolean makeTable(SQLiteDatabase db) throws IOException{
		String sql=getSQL.MakeTable();
		db.execSQL(sql);
		return true;
	}
	public int makeID(SQLiteDatabase db){
		String sql[]=getSQL.MakeID();
		db.execSQL(sql[0]);
		Cursor cr=db.rawQuery(sql[1], null);
		int id=cr.getInt(0);
		return id;
	}
	public int getCurrentID(SQLiteDatabase db){
		String sql=getSQL.GetCurrentID();
		Cursor cr=db.rawQuery(sql, null);
		int id=cr.getInt(0);
		return id;
	}
}