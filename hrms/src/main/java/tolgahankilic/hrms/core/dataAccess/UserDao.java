package tolgahankilic.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import tolgahankilic.hrms.core.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User getByEmail(String email);
}
