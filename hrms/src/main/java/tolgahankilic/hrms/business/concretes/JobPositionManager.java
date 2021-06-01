package tolgahankilic.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.business.abstracts.JobPositionService;
import tolgahankilic.hrms.core.utilities.business.BusinessRules;
import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.ErrorResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.core.utilities.results.SuccessDataResult;
import tolgahankilic.hrms.core.utilities.results.SuccessResult;
import tolgahankilic.hrms.dataAccess.abstracts.JobPositionDao;
import tolgahankilic.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Job positions listed");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		Result result = BusinessRules.run(checkDepartment(jobPosition.getPositionName()));

		if (result != null) {
			return result;
		}

		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Job position added");
	}

	private Result checkDepartment(String name) {

		var result = this.jobPositionDao.getByPositionName(name);

		if (result != null) {
			return new ErrorResult("Job position already added");
		}
		return new SuccessResult();
	}
}
