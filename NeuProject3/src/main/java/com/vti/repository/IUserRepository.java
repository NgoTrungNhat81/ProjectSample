
package com.vti.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.vti.entity.User;
import com.vti.entity.UserStatus;

public interface IUserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {

	
	public User findByUserName(String name);
	
	public boolean existsByUserName(String userName);

	public boolean existsByEmail(String email);
	
	@Query("	SELECT 	status 		"
			+ "	FROM 	User 		"
			+ " WHERE 	email = :email")
	public UserStatus findStatusByEmail(String email);

//	public User findByUserName(String name);
	
	public User findByEmail(String email);

}
