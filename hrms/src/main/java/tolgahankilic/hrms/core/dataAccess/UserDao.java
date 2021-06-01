package tolgahankilic.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tolgahankilic.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	List<User> findByEmail(String email);
}
