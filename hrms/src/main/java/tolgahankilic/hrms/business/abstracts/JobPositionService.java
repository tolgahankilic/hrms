package tolgahankilic.hrms.business.abstracts;

import java.util.List;

import tolgahankilic.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
