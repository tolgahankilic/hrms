package tolgahankilic.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import tolgahankilic.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	JobSeeker getByNationalityId(String nationalityId);
}
