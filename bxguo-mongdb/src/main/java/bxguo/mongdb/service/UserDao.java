package bxguo.mongdb.service;


import bxguo.mongdb.domain.UserEntity;

/**
 * Created by summer on 2017/5/5.
 */
public interface UserDao {

    void saveUser(UserEntity user);

    UserEntity findUserByUserName(String userName);

    void updateUser(UserEntity user);

    void deleteUserById(Long id);

}
