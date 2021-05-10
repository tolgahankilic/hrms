package tolgahankilic.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.business.abstracts.JobPositionService;
import tolgahankilic.hrms.dataAccess.abstracts.JobPositionDao;
import tolgahankilic.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public List<JobPosition> getAll() {
		return this.jobPositionDao.findAll();
	}
}
