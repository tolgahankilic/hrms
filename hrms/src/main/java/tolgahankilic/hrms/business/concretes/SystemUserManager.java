package tolgahankilic.hrms.business.concretes;

import org.springframework.stereotype.Service;

import tolgahankilic.hrms.business.abstracts.SystemUserService;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.core.utilities.results.SuccessResult;

@Service
public class SystemUserManager implements SystemUserService {

	@Override
	public Result confirm() {
		return new SuccessResult("System user confirmed");
	}

}
