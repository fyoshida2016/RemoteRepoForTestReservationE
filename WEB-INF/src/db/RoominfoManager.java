package db;

import java.sql.ResultSet;
import java.util.LinkedList;

import common.DataBaseManager;
import model.Roominfo;
import model.User;


public class RoominfoManager extends DataBaseManager{

	protected Object copyRecord(ResultSet rs) throws Exception{
		Roominfo room = new Roominfo();
		room.setRid(rs.getInt("RID"));
		room.setBuilding(rs.getString("Building").trim());
		room.setFloor(rs.getString("floor").trim());
		room.setNumber(rs.getString("Number").trim());
		room.setArea(rs.getInt("Area"));
		room.setCapacity(rs.getInt("Capacity"));
		return room;
	}

	public Roominfo getRoominfo(int rid){
		String sql = "";
		sql += "Select * from Roominfo Where ";
		sql += " RID = "+ rid;
		return (Roominfo)getRecord(sql);
	}

	public LinkedList<Roominfo> getRoominfoList(){
		String sql = "";
		sql += "Select * from Roominfo";

		return (LinkedList<Roominfo>)getRecords(sql);
	}
}
