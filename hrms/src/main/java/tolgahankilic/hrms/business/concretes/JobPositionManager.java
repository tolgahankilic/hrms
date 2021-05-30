package tolgahankilic.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.business.abstracts.JobPositionService;
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
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Listed data");
    }

    @Override
    public DataResult<JobPosition> getByPositionName(String positionName) {
    	return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByPositionName(positionName));
    }

    @Override
    public Result add(JobPosition position) {
        if (getByPositionName(position.getPositionName()).getData() != null){
            return new ErrorResult(position.getPositionName() + "Positions cannot repeat");
        }
        this.jobPositionDao.save(position);
        return new SuccessResult("Added position");
    }
}
