package com.tarento.vehiclemanagement.user.service;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.BreakIterator;
import com.tarento.vehiclemanagement.user.data.UserDao;
import com.tarento.vehiclemanagement.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public interface UserService {
    public User addUser(User user) throws ValidationException;

    public User getUserById(long userId);

    public List<User> getUserByName(String userName);

    public List<User> getUserByAadhar(Long aadharNum);

    public long deleteUser(long userId);

    public int updateUser(User user, int userId);
}

//    //@Scope("prototype")
//    @Component
//            //@Configuration
//    class UserServiceImpl implements UserService {
//
//        @Autowired
//        private UserDao userDao;
//
//
//        @Override
//
//        public User addUser(User user) {
//
//            Long aadharNum = user.getAadharNum();
//            List<User> aadharNameList = getUserByAadhar(aadharNum);
//            String userName = user.getUserName();
//            Pattern regex = Pattern.compile("[{$&+,:;=\\?@#|/'<>.^*()%!-_}]");
//            String titleCase = UCharacter.toTitleCase(userName, BreakIterator.getTitleInstance());
//            user.setUserName(titleCase);
//            if (aadharNameList.size() > 0) {
////                throw new com.tarento.vehiclemanagement.vehicle.exception.ValidationException("ERR001","This aadhar num exists");
//                throw new com.tarento.vehiclemanagement.exception.ValidationException("ERR001", "This aadhar num exists");
//            } else if (regex.matcher(userName).find()) {
//                throw new com.tarento.vehiclemanagement.exception.ValidationException("400", "Special Characters not allowed.");
////                throw new com.tarento.vehiclemanagement.vehicle.exception.ValidationException("400","Special Characters not allowed.");
//            }
//            //        List usernameList=getUserByName(userName);
//            //        if (usernameList.size()>0){
//            //            return "User already exist";
//            //        }
//            userDao.save(user);
//            return user;
//        }
//
//        @Override
//        public User getUserById(long userId) {
//            Optional<User> idlist = userDao.findById(userId);
//            return idlist.get();
//        }
//
//
//        @Override
//        public List<User> getUserByName(String userName) {
//            return userDao.findByuserName(userName);
//        }
//
//        @Override
//        public List<User> getUserByAadhar(Long aadharNum) {
//            return userDao.findByaadharNum(aadharNum);
//        }
//
//        @Override
//        public long deleteUser(long userId) {
//            userDao.deleteById(userId);
//            return userId;
//        }
//
//        @Override
//        public int updateUser(User user, int userId) {
//            userDao.save(user);
//            return 1;
//        }
//    }

