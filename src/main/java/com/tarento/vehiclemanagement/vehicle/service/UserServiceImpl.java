package com.tarento.vehiclemanagement.vehicle.service;

import antlr.StringUtils;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.BreakIterator;
import com.tarento.vehiclemanagement.vehicle.data.UserDao;
import com.tarento.vehiclemanagement.vehicle.dto.User;
import org.apache.commons.text.CaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;


@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user) {

        Long aadharNum = user.getAadharNum();
        List<User> aadharNameList = getUserByAadhar(aadharNum);
        if(aadharNameList.size()>0){
            return aadharNameList.get(0);
        }

        String userName=user.getUserName();
//        List usernameList=getUserByName(userName);
//        if (usernameList.size()>0){
//            return "User already exist";
//        }
        Pattern regex = Pattern.compile("[{$&+,:;=\\?@#|/'<>.^*()%!-_]}");
        if (regex.matcher(userName).find()) {
                return user;
//            return "Name cannot have special characters";
        }
////        String camelCase = CaseUtils.toCamelCase(userName, true,' ');
//        user.setUserName(camelCase);
        String titleCase = UCharacter.toTitleCase(userName, BreakIterator.getTitleInstance());
        user.setUserName(titleCase);
        userDao.save(user);
        return user;
    }

    @Override
    public Optional<User> getUser(long userId) {
        return userDao.findById(userId);
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
