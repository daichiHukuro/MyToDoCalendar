import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class getSQL{
	private static String dbname="TBC";
	public static String GetDBName(){
		return dbname;
	}
	public static String DeleteTODO(int id){


		String sql="delete from PARENT where CHILD = "+id+";\n"+
		"delete from TODO where NOTE_ID = "+id+";\n"+
		"delete from NOTE where      (ID = "+id+" and NOTE_STATUS=0);";
		return sql;
	}
	public static String DeleteCALENDAR(int id){
		String sql="delete from PARENT where PARENT = "+id+";"+
		"delete from CALENDAR where NOTE_ID = "+id+";"+
		"delete from NOTE where      (ID = "+id+" and NOTE_STATUS=1);";
		return sql;
	}
	public static String UpdateTODO(int id,String deadline,int date_long){
		if(deadline==null)deadline="null";
		else deadline="'"+deadline+"'";

		String sql="update TODO set DEADLINE= "+deadline+" ,DATE_LONGE= "+date_long+" where NOTE_ID="+id;
		return sql;
	}
	public static String UpdateCALENDAR(int id,String date,String start,String end){
		String sql="update CALENDAR set TODATE= '"+date+"' ,START_TIME= '"+start+"' ,END_TIME= '"+end+"' where NOTE_ID="+id;
		return sql;
	}
	public static String UpdateNOTE(int id,String note){
		String sql="update NOTE set NOTE='"+note+"' where ID="+id;
		return sql;
	}
	public static String AddPARENT(int parent,int child){
		String sql="insert into PARENT values("+parent+","+child+")";
		return sql;
	}
	public static String AddCALENDAR(int id,String note,String date,String start,String end){
		String sql="insert into NOTE values("+id+",1,'"+note+"');"+
		"insert into CALENDAR values("+id+",'"+date+"','"+start+"','"+end+"');";
		return sql;
	}
	public static String AddTODO(int id,String note,String deadline,int howlong){
		if(deadline==null)deadline="null";
		else deadline="'"+deadline+"'";

		String sql="insert into NOTE values("+id+",0,'"+note+"');"+
		"insert into TODO values("+id+","+deadline+","+howlong+");";
		return sql;
	}
	public static String GetNOTE(){
		String sql="select ID, NOTE, DEADLINE, DATE_LONGE from NOTE join TODO on NOTE.ID=TODO.NOTE_ID;";
		return sql;
	}
	public static String GetCALENDAR(){
		String sql="select ID, NOTE, TODATE, START_TIME, END_TIME from NOTE join CALENDAR on NOTE.ID=CALENDAR.NOTE_ID;";
		return sql;
	}
	public static String ClearTable(){
		String sql="drop table if exists PARENT;\n"+
		"drop table if exists TODO;\n"+
		"drop table if exists CALENDAR;\n"+
		"drop table if exists NOTE;\n"+
		"drop table if exists NOTE_STATUS;"+
		"drop table if exists IDM;";
		return sql;
	}
	public static String MakeTable() throws IOException{
		String sql ="";
		BufferedReader br=new BufferedReader(new FileReader("setup.sql"));
		while(br.ready()){
			sql+=br.readLine();
			sql+="\n";
		}
		return sql;
	}
	public static String[] MakeID(){
		String sql[]={"update IDM set ID=ID+1;",
		"select * from IDM"};
		return sql;
	}
	public static String GetCurrentID(){
		String sql="select * from IDM";
		return sql;
	}
}