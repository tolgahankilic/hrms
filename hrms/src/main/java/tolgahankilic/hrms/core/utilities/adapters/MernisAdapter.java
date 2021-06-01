package tolgahankilic.hrms.core.utilities.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.core.utilities.results.ErrorResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.core.utilities.results.SuccessResult;
import tolgahankilic.hrms.services.fakeMernisService.FakeMernisManager;

@Service
public class MernisAdapter implements MernisService {

	@Autowired
	FakeMernisManager fakeMernisManager;

	@Override
	public Result validate(String nationalityId, int birthYear) {
		if (nationalityId.length() == 11 && birthYear > 1900) {
			return new SuccessResult();
		}
		else {
			return new ErrorResult();
		}
	}
}
