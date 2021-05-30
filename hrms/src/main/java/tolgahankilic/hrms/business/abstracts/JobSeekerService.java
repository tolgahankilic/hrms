package tolgahankilic.hrms.business.abstracts;

import java.util.List;

import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	Result add(JobSeeker jobSeeker);

	DataResult<List<JobSeeker>> getAll();
}
