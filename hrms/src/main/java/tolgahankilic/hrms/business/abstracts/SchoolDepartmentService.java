package tolgahankilic.hrms.business.abstracts;

import java.util.List;

import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.concretes.SchoolDepartment;

public interface SchoolDepartmentService {
	Result add(SchoolDepartment schoolDepartment);

	DataResult<List<SchoolDepartment>> getAll();
}
