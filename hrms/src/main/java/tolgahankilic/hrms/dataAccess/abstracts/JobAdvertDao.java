package tolgahankilic.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import tolgahankilic.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	List<JobAdvert> getByStatusTrue();
	List<JobAdvert> getByApplicationDeadlineLessThanEqual(LocalDate date);
	List<JobAdvert> getByStatusTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	List<JobAdvert> getByStatusTrueAndEmployer_CompanyName(String companyName);
	List<JobAdvert> getByEmployerId(int id);
	JobAdvert getById(int id);
	
	@Transactional
    @Modifying
    @Query("Update JobAdvert set isActive = false where id =:jobAdvertId")
    void deactiveJobAdvert(int jobAdvertId);
}
