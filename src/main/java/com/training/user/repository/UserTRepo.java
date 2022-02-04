package com.training.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.user.model.UserT;

public interface UserTRepo extends JpaRepository<UserT, Long>{
	
    @Query("from sys_user_t WHERE user_id=?1 and status = 1")
    public UserT findByUserId(Integer userId);

}
