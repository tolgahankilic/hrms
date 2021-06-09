package tolgahankilic.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import tolgahankilic.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {
	List<JobExperience> getJobExperienceDateOfEndByCurriculumVitaeId(int id, Sort sort);
}
