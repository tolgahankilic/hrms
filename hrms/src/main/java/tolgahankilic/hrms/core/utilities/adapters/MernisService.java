package tolgahankilic.hrms.core.utilities.adapters;

import tolgahankilic.hrms.core.utilities.results.Result;

public interface MernisService {
	public Result validate(String nationalityId, int birthYear);
}
