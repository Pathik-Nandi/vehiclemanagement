package com.tarento.vehiclemanagement.user.service;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.BreakIterator;
import com.tarento.vehiclemanagement.exception.CustomException;
import com.tarento.vehiclemanagement.exception.ValidationException;
import com.tarento.vehiclemanagement.user.data.UserDao;
import com.tarento.vehiclemanagement.user.dto.User;
import org.hibernate.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.Query;


@Component
@Primary
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override

    public User addUser(User user) {
        Long aadharNum = user.getAadharNum();
        List<User> aadharNumList = userDao.findByaadharNum(aadharNum);
        if (!aadharNumList.isEmpty()) {
            throw new CustomException("ERR001", "This aadhar num exists");
        }
        userDao.save(user);
        return user;
    }

    @Override
    public User getUserById(long userId) {
        Optional<User> idlist = Optional.ofNullable(userDao.findById(userId).orElseThrow(() -> new CustomException("404", "USER ID not found.")));
        User user = null;
        if (idlist.isPresent()) {
            user = idlist.get();
        }
        return user;
    }

    @Override
    public List<User> getUserByName(String userName) {
        List<User> userList=userDao.findByuserName(userName);
        List<User> resultList = new ArrayList<>();
        if(userList.isEmpty()){
            throw new ValidationException("404","User name does't exist");
        }
        else {
            userList.stream().forEach(user -> {
                if (!user.isDeleted()) {
                    resultList.add(user);
                }
                else if (user.isDeleted()) {
                    throw new ValidationException("404","User name does't exist");
                }
            });
        }
        return resultList;
    }

    @Override
    public List<User> getUserByAadhar(long aadharNum) {
        List<User> aadharList =  userDao.findByaadharNum(aadharNum);
        if(aadharList.isEmpty()){
            throw new ValidationException("404","Aadhar num doesnt exists");
        }
        return userDao.findByaadharNum(aadharNum);
    }

    @Override

    public User updateUser(User user) {
        Long aadharNum = user.getAadharNum();
        List<User> aadharList = userDao.findByaadharNum(aadharNum);
        if(!aadharList.isEmpty() && aadharList.get(0).isDeleted()){
            throw new ValidationException("404","User doesn't exists");
        } else if (aadharList.isEmpty()) {
            throw new ValidationException("404","Aadhar num doesn't exists");
        }
        return userDao.save(user);
    }
    public void deleteUser(long userId){
        Optional<User> userList =  userDao.findById(userId);
        if(userList.isEmpty() || userList.get().isDeleted() ){
            throw new ValidationException("404","User Id doesnt exists");
        }
        userDao.deleteUser(userId);
    }

}
