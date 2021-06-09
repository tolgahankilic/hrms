package tolgahankilic.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import tolgahankilic.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {
	CurriculumVitae getByJobSeekerId(int id);
}
