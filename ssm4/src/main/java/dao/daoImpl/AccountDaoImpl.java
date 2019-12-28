package dao.daoImpl;

import dao.AccountMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pojo.Account;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountMapper, RowMapper<Account> {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public AccountDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int insert(Account account) {
        String sql = " insert into bank( balance,account)    values (?, ?)";
        return jdbcTemplate.update(sql, preparedStatement -> {
            preparedStatement.setFloat(1, account.getBalance());
            preparedStatement.setString(2, account.getAccount());
        });


    }

    public int update(Account account) {
        String sql = " update bank" +
                "    set balance= ?" +
                "    where account = ?";
        return jdbcTemplate.update(sql, preparedStatement -> {
            preparedStatement.setFloat(1, account.getBalance());
            preparedStatement.setString(2, account.getAccount());
        });
    }

    public Account select(String account) {

        String sql = " select *" +
                "    from bank" +
                "    where account ='" + account + "'";
        return jdbcTemplate.queryForObject(sql, this);
    }

    public int delete(String account) {

        String sql = "delete from bank where account='" + account + "'";
        return jdbcTemplate.update(sql);
    }


    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        return Account.builder().account(resultSet.getString("account")).balance(resultSet.getFloat("balance")).build();

    }
}
