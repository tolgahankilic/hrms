package tolgahankilic.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	DataResult<List<JobAdvert>> getAll();
	Result add(JobAdvert jobAdvert);
	DataResult<JobAdvert> changeStatus(int employerId,int advertId, boolean status);
	
	DataResult<List<JobAdvert>> getByStatusTrue();
	DataResult<List<JobAdvert>> getByApplicationDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAdvert>> getByStatusTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAdvert>> getByStatusTrueAndEmployer_CompanyName(String companyName);
	DataResult<List<JobAdvert>> getByEmployerId(int id);
}
