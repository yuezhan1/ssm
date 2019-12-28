package dao;

import pojo.Account;

public interface AccountMapper {
    int insert(Account account);

    int update(Account account);

    Account select(String account);

    int delete(String account);
}
