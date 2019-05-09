package bimingliang.db;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AnnotationTransaction {
	
	private JdbcTemplate jdbcTemplate;
	
	public AnnotationTransaction() {
		
	}
	
	public void selectData() {
		DB db = this.jdbcTemplate.queryForObject(" select * from bi_system where id = ? ", new ParameterizedRowMapper<DB> () {
			public DB mapRow(ResultSet rs, int rowNum) throws SQLException {
				DB db = new DB();
				db.setId(rs.getInt(1));
				db.setName(rs.getString(2));
				db.setAge(rs.getInt(3));
				db.setBirthday(rs.getDate(4));
				return db;
			}
		}, 1);
		System.out.println("In Transaction ... ");
		db.toString();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void insertData() {
		Date birthday = new Date(100000);
		this.jdbcTemplate.update(" INSERT INTO SPRING_DB_TEST (ID, NAME, AGE, BIRTHDAY, COMMENTS) VALUES (?, ?, ?, ?, ?) ", "3", "BML", "7", birthday, "transaction");
		this.jdbcTemplate.update(" INSERT INTO SPRING_DB_TEST (ID, NAME, AGE, BIRTHDAY, COMMENTS) VALUES (?, ?, ?, ?, ?) ", "9", null, "9", birthday, "transaction");
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
