package tolgahankilic.hrms.core.utilities.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.core.utilities.results.ErrorResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.core.utilities.results.SuccessResult;
import tolgahankilic.hrms.services.fakeEmailService.FakeEmailManager;

@Service
public class EmailAdapter implements EmailService {

	@Autowired
	FakeEmailManager fakeEmailManager;

	@Override
	public Result validate(String email) {
		if(!this.fakeEmailManager.validate(email).isSuccess()) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
}
