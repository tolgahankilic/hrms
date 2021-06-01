package tolgahankilic.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.business.abstracts.JobAdvertService;
import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.ErrorDataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.core.utilities.results.SuccessDataResult;
import tolgahankilic.hrms.core.utilities.results.SuccessResult;
import tolgahankilic.hrms.dataAccess.abstracts.JobAdvertDao;
import tolgahankilic.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		//jobAdvert.getCreatedDate().equals(LocalDate.now());
		jobAdvert.setCreatedDate(LocalDate.now());
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Job advert added");
	}

	@Override
	public DataResult<List<JobAdvert>> getByStatusTrue() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByStatusTrue());
	}

	@Override
	public DataResult<List<JobAdvert>> getByApplicationDeadlineLessThanEqual(LocalDate date) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByApplicationDeadlineLessThanEqual(date));
	}

	@Override
	public DataResult<List<JobAdvert>> getByStatusTrueAndApplicationDeadlineLessThanEqual(LocalDate date) {
		return new SuccessDataResult<List<JobAdvert>>(
				this.jobAdvertDao.getByStatusTrueAndApplicationDeadlineLessThanEqual(date));
	}

	@Override
	public DataResult<List<JobAdvert>> getByStatusTrueAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvert>>(
				this.jobAdvertDao.getByStatusTrueAndEmployer_CompanyName(companyName));
	}

	@Override
	public DataResult<List<JobAdvert>> getByEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployerId(id));
	}

	@Override
	public DataResult<JobAdvert> changeStatus(int employerId, int advertId, boolean status) {

		List<JobAdvert> adverts = this.jobAdvertDao.getByEmployerId(employerId);

		for (JobAdvert jobAdvert : adverts) {
			if (advertId == jobAdvert.getId()) {
				jobAdvert.setStatus(status);
				this.jobAdvertDao.save(jobAdvert);
				return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getById(advertId));
			}
		}

		return new ErrorDataResult<JobAdvert>();
	}

}
