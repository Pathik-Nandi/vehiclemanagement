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
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;


@Component
@Primary
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private EntityManager entityManager;


    @Override

    public User addUser(User user) {

        Long aadharNum = user.getAadharNum();
        List<User> aadharNameList = getUserByAadhar(aadharNum);
        String userName = user.getUserName();
        String titleCase = UCharacter.toTitleCase(userName, BreakIterator.getTitleInstance());
        user.setUserName(titleCase);
        if (aadharNameList.size() > 0) {
            throw new CustomException("ERR001", "This aadhar num exists");
        }
        else

        userDao.save(user);
        return user;
    }

    @Override
    public User getUserById(long userId) {
        Optional<User> idlist = Optional.ofNullable(userDao.findById(userId).orElseThrow(() -> new CustomException("404", "USER ID not found.")));
        return idlist.get();
    }


    @Override
    public List<User> getUserByName(String userName) {
        List<User> userList=userDao.findByuserName(userName);
        if(userList.isEmpty() || userList.get(0).isDeleted() == true){
            throw new ValidationException("404","User name does't exist");
        }
        return userDao.findByuserName(userName);
   }

   @Override
   public List<User> getUserByAadhar(Long aadharNum) {
        List<User> aadharList =  userDao.findByaadharNum(aadharNum);
        if(aadharList.isEmpty()){
            throw new ValidationException("404","Aadhar num doesnt exists");
        }
       return userDao.findByaadharNum(aadharNum);
    }


    @Override
    public long deleteUser(long userId) {
        userDao.deleteById(userId);
        return userId;
    }

    @Override
    public User updateUser(User user,Long aadharNum) {
        List<User> aadharList =  userDao.findByaadharNum(aadharNum);
        if(aadharList.isEmpty()){
            throw new ValidationException("404","Aadhar num doesnt exists");
        }
        userDao.save(user);
        return user;
    }

    public Iterable<User> findAll(boolean isDeleted){
        Session session = entityManager.unwrap(Session.class);
        Filter filter = (Filter) session.enableFilter("deletedProductFilter");
        filter.setParameter("isDeleted", isDeleted);
        Iterable<User> user =  userDao.findAll();
        session.disableFilter("deletedProductFilter");
        return user;
    }
}

