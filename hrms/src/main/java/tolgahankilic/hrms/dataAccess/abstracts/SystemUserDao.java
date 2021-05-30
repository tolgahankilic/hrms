package tolgahankilic.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import tolgahankilic.hrms.entities.concretes.SystemUser;

public interface SystemUserDao extends JpaRepository<SystemUser, Integer> {

}
