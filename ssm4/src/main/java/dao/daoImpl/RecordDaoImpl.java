package dao.daoImpl;

import dao.RecordMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import pojo.Record;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordDaoImpl implements RecordMapper {
    private DriverManagerDataSource driverManagerDataSource;
    private JdbcTemplate jdbcTemplate;

    public RecordDaoImpl(DriverManagerDataSource driverManagerDataSource) {
        this.driverManagerDataSource = driverManagerDataSource;
        this.jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
    }
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Record record) {
        String sql = "insert into record ( amount, " +
                "      source_account, target_account)" +
                "    values (?, " +
                "      ?, ?)";
        return jdbcTemplate.update(sql, preparedStatement -> {
            preparedStatement.setFloat(1, record.getAmount());
            preparedStatement.setString(2, record.getSourceAccount());
            preparedStatement.setString(3, record.getTargetAccount());
        });
    }

    @Override
    public int insertSelective(Record record) {
        return 0;
    }

    @Override
    public Record selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Record record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Record record) {
        return 0;
    }
    
    public Record mapRow(ResultSet resultSet, int i) throws SQLException {
        return Record.builder().amount(resultSet.getFloat("amount"))
                .time(resultSet.getDate("date"))
                .sourceAccount("source_account")
                .targetAccount("target_account")
                .build();
    }
}
