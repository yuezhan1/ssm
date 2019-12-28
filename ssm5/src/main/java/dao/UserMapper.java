package dao;

import pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectByIdList(List<Integer> idList);

    List<User> selectByIdName(String name);

    List<User> selectAll();



    User getUserByOrder(long orderId);




    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}