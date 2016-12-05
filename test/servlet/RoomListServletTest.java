package servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.TestDataBase;
import common.TestServlet;
import db.RoominfoManager;
import model.Roominfo;
import model.User;

public class RoomListServletTest extends TestServlet {

	@Test
	public void 会議室一覧を表示_成功()throws Exception  {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story05/RoomListServlet_test.xls");

		// Postメソッドを指定
		setPost();

		// Servletを呼び出す。
		callServlet();

		// 登録済みのRIDを指定して、データベースからオブジェクトを読み込み
		RoominfoManager rm = new RoominfoManager();
		Roominfo room = rm.getRoominfo(1);

		// RequestにRoominfoオブジェクトが保存されていること（nullではないこと）を確認
		assertThat(request.getAttribute("Rooms"),notNullValue());

		// RequestからRoominfoオブジェクトを読み込み
		LinkedList<Roominfo> rooms=(LinkedList<Roominfo>)request.getAttribute("Rooms");

		// 読み込んだリストに登録されているユーザ数をチェック
		assertThat(rooms.size(),is(5));



		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(room.getRid(),is(1));
		assertThat(room.getBuilding(), is("総合研究棟"));
		assertThat(room.getFloor(),is("6階"));
		assertThat(room.getNumber(),is("607室"));
		assertThat(room.getArea(),is(60));
		assertThat(room.getCapacity(),is(60));
	}
}
