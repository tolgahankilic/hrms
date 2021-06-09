package tolgahankilic.hrms.business.abstracts;

import java.util.List;

import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.concretes.Education;

public interface EducationService {
	Result add(Education education);

	DataResult<List<Education>> getAll();

	DataResult<List<Education>> getAllSorted(int cvId);
}
