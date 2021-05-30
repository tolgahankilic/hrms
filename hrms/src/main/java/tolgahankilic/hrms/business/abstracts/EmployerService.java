package tolgahankilic.hrms.business.abstracts;

import java.util.List;

import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.concretes.Employer;

public interface EmployerService {
	Result add(Employer employer);

	DataResult<List<Employer>> getAll();
}
