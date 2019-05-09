package test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import bimingliang.db.AnnotationTransaction;
import bimingliang.db.DB;
import bimingliang.db.Transaction;

public class DB05 {

	public static final String SELECT_ONE = " SELECT * FROM AGENCY_SERVICE.DBO.TEST WHERE ID = :id ";
	public static final String SELECT_MANY = " SELECT * FROM AGENCY_SERVICE.DBO.TEST WHERE Name = :name ";
	public static final String INSERT_ONE = " INSERT INTO AGENCY_SERVICE.DBO.TEST (ID, GUID, NAME, AGE, BIRTHDAY) VALUES (:id, :guid, :name, :age, :birthday) ";
	public static final String UPDATE = " UPDATE AGENCY_SERVICE.DBO.TEST SET AGE = 33 WHERE ID = :id ";
	public static final String DELETE = " DELETE FROM AGENCY_SERVICE.DBO.TEST WHERE ID = :id ";

	public static void main(String[] args) {

		// testJdbcTemplate();
		// testNamedParameterJdbcTemplate();
		testTransaction();
		// testAnnotationTransaction();
	}

	// 测试注解配置的事务
	public static void testAnnotationTransaction() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("DB.xml");
		AnnotationTransaction annotationTransaction = (AnnotationTransaction) ctx.getBean("annotationTransaction");
		annotationTransaction.selectData();
		annotationTransaction.insertData();
	}

	// 测试xml配置的事务
	public static void testTransaction() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("DB.xml");
		Transaction transaction = (Transaction) ctx.getBean("transaction");
		transaction.selectData();
		transaction.saveDataTransaction();
	}

	public static void testNamedParameterJdbcTemplate() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("DB.xml");
		Date birthday = new Date(1);
		int insertNum = 0;
		int updateNum = 0;
		int deleteNum = 0;

		NamedParameterJdbcTemplate temp = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
		// 插入一条记录
		Map<String, Object> insertParam = new HashMap<String, Object>();
		insertParam.put("id", "3");
		insertParam.put("guid", UUID.randomUUID().toString());
		insertParam.put("name", "Bright");
		insertParam.put("age", 7);
		insertParam.put("birthday", birthday);
		insertNum = temp.update(INSERT_ONE, insertParam);
		System.out.println("insertNum :" + insertNum);

		// 查询一条数据
		Map<String, Object> selectParam = new HashMap<String, Object>();
		selectParam.put("id", 2);
		DB db = temp.queryForObject(SELECT_ONE, selectParam, new ParameterizedRowMapper<DB>() {
				public DB mapRow(ResultSet rs, int rowNum) throws SQLException {
					DB db = new DB();
					db.setId(rs.getInt(1));
					db.setGuid(UUID.fromString(rs.getString(2)));
					db.setName(rs.getString(3));
					db.setAge(rs.getInt(4));
					db.setBirthday(rs.getDate(5));
					return db;
				}
			});
		System.out.println("DB id = 2 :" + db.toString());

		// 查询多条数据
		Map<String, Object> selectMoreParam = new HashMap<String, Object>();
		selectMoreParam.put("name", "Bright");
		List<Map<String, Object>> results = temp
				.queryForList(SELECT_MANY, selectMoreParam);
		for (int i = 0; i < results.size(); i++) {
			Map<String, Object> result = results.get(i);
			Iterator<Map.Entry<String, Object>> iter = result.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iter.next();
				String key = entry.getKey();
				Object val = entry.getValue();
				System.out.println(key + ":" + val);
			}
		}

		// 修改数据
		Map<String, Object> updateParam = new HashMap<String, Object>();
		updateParam.put("id", 2);
		updateNum = temp.update(UPDATE, updateParam);
		// 删除数据
		Map<String, Object> deleteParam = new HashMap<String, Object>();
		deleteParam.put("id", 11);
		deleteNum = temp.update(DELETE, deleteParam);
		System.out.println(updateNum + ":" + deleteNum);
	}

	public static void testJdbcTemplate() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("DB.xml");
		Date birthday = new Date(1);
		int updateNum = 0;
		int deleteNum = 0;

		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		// 插入一条记录
		jdbcTemplate.update(" INSERT INTO SPRING_DB_TEST (ID, NAME, AGE, BIRTHDAY, COMMENTS) VALUES (?, ?, ?, ?, ?) ", "3", "T", 11, birthday, "comments");
		// 查询一条数据
		DB db = jdbcTemplate.queryForObject(" SELECT * FROM SPRING_DB_TEST WHERE ID = ? ", new ParameterizedRowMapper<DB>() {
			public DB mapRow(ResultSet rs, int rowNum) throws SQLException {
				DB db = new DB();
				db.setId(rs.getInt(1));
				db.setName(rs.getString(2));
				db.setAge(rs.getInt(3));
				db.setBirthday(rs.getDate(4));
				return db;
			}
		}, 1);
		db.toString();
		// 查询多条数据
		List<Map<String, Object>> results = jdbcTemplate.queryForList(" SELECT * FROM SPRING_DB_TEST ");
		for (int i = 0; i < results.size(); i++) {
			Map<String, Object> result = results.get(i);
			Iterator<Map.Entry<String, Object>> iter = result.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iter.next();
				String key = entry.getKey();
				Object val = entry.getValue();
				System.out.println(key + ":" + val);
			}
		}
		// 修改数据
		updateNum = jdbcTemplate.update(" UPDATE SPRING_DB_TEST SET COMMENTS = 'UPDATE' WHERE ID = 3 ");
		// 删除数据
		deleteNum = jdbcTemplate.update(" DELETE FROM SPRING_DB_TEST WHERE ID = 1 ");
		System.out.println(updateNum + ":" + deleteNum);
	}
}
