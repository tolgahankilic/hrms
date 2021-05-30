package tolgahankilic.hrms.business.abstracts;

import java.util.List;

import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
    DataResult<JobPosition> getByPositionName(String positionName);
    Result add(JobPosition position);
}
