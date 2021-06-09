package tolgahankilic.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.business.abstracts.JobExperienceService;
import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.core.utilities.results.SuccessDataResult;
import tolgahankilic.hrms.core.utilities.results.SuccessResult;
import tolgahankilic.hrms.dataAccess.abstracts.JobExperienceDao;
import tolgahankilic.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperienceDao;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobExperience>> getAllSorted(int cvId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "date_of_end");
		return new SuccessDataResult<List<JobExperience>>(
				this.jobExperienceDao.getJobExperienceDateOfEndByCurriculumVitaeId(cvId, sort));
	}

}
