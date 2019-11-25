package service;

import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public void say() {
        this.userDao.say();
        System.out.println("userService Say Hello World !");
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao=userDao;
    }
}
