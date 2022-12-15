package com.tarento.vehiclemanagement.user.data;

import com.tarento.vehiclemanagement.user.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

@Repository
@ControllerAdvice
public interface UserDao extends JpaRepository<User, Long> {

    public List<User> findByuserName(String userName);

    public List<User> findByaadharNum(long aadharNum);

    @Modifying
    @Transactional
    @Query(value = "update user set deleted=1 where user_id=?", nativeQuery = true)
    public void deleteUser(long userId);
}
