package com.tarento.vehiclemanagement.vehicle.service;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.BreakIterator;
import com.tarento.vehiclemanagement.vehicle.data.UserDao;
import com.tarento.vehiclemanagement.vehicle.dto.User;
//import org.apache.commons.text.CaseUtils;
import com.tarento.vehiclemanagement.vehicle.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;


//@Scope("prototype")
@Component
//@Configuration
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override

    public User addUser(User user) {

        Long aadharNum = user.getAadharNum();
        List<User> aadharNameList = getUserByAadhar(aadharNum);
        String userName=user.getUserName();
        Pattern regex = Pattern.compile("[{$&+,:;=\\?@#|/'<>.^*()%!-_}]");
        String titleCase = UCharacter.toTitleCase(userName, BreakIterator.getTitleInstance());
        user.setUserName(titleCase);
        if(aadharNameList.size()>0){
            throw new ValidationException("ERR001","This aadhar num exists");
        }
        else if (regex.matcher(userName).find()) {
            throw new ValidationException("400","Special Characters not allowed.");
        }
//        List usernameList=getUserByName(userName);
//        if (usernameList.size()>0){
//            return "User already exist";
//        }
        userDao.save(user);
        return user;
    }

    @Override
    public User getUser(long userId) {
        Optional<User> idlist = userDao.findById(userId);
        return idlist.get();
    }

    @Override
    public List<User> getUserByName(String userName) {
        return userDao.findByuserName(userName);
    }

    @Override
    public List<User> getUserByAadhar(Long aadharNum) {
        return userDao.findByaadharNum(aadharNum);
    }

    @Override
    public long deleteUser(long userId) {
         userDao.deleteById(userId);
        return userId;
    }

    @Override
    public int updateUser(User user, int userId) {
        userDao.save(user);
        return 1;
    }
}
