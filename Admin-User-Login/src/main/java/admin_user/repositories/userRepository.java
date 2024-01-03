package admin_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import admin_user.model.User;

public interface userRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
