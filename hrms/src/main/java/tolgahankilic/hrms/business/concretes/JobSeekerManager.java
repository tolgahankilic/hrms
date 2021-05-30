package tolgahankilic.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.business.abstracts.AuthService;
import tolgahankilic.hrms.business.abstracts.JobSeekerService;
import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.ErrorResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.core.utilities.results.SuccessDataResult;
import tolgahankilic.hrms.core.utilities.results.SuccessResult;
import tolgahankilic.hrms.dataAccess.abstracts.JobSeekerDao;
import tolgahankilic.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private AuthService authService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, AuthService authService) {
		this.jobSeekerDao = jobSeekerDao;
		this.authService = authService;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		var result = this.authService.checkEmail(jobSeeker.getUser().getEmail());
		if (result.isSuccess()) {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Job seeker added.");
		}
		return new ErrorResult(result.getMessage());
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Job seekers listed.");
	}

}
