package db;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.TestDataBase;
import model.Roominfo;
import model.User;

public class RoominfoManagerTest {

	@Test
	public void 会議室一覧を表示_成功() {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story05/dbaccess_test.xls");

		// 登録済みのRIDを指定して、データベースからオブジェクトを読み込み
		RoominfoManager rm = new RoominfoManager();
		Roominfo room = rm.getRoominfo(1);

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(room.getRid(),is(1));
		assertThat(room.getBuilding(), is("総合研究棟"));
		assertThat(room.getFloor(),is("6階"));
		assertThat(room.getNumber(),is("607室"));
		assertThat(room.getArea(),is(60));
		assertThat(room.getCapacity(),is(60));
	}

	public void 会議室一覧を表示_失敗() {
		// データベースにテストデータを挿入
		TestDataBase db=new TestDataBase();
		db.setTestData("./testdata/story05/dbaccess_test.xls");

		// 登録されていないRIDを指定して、データベースからオブジェクトを読み込み
		RoominfoManager rm = new RoominfoManager();
		Roominfo room = rm.getRoominfo(99);

		// 読み込んだオブジェクトのプロパティの値が適切かどうかをチェック
		assertThat(room,nullValue());
	}

}
