package tolgahankilic.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.business.abstracts.AuthService;
import tolgahankilic.hrms.core.utilities.adapters.EmailService;
import tolgahankilic.hrms.core.utilities.adapters.MernisService;
import tolgahankilic.hrms.core.utilities.results.ErrorResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.core.utilities.results.SuccessResult;
import tolgahankilic.hrms.dataAccess.abstracts.UserDao;

@Service
public class AuthManager implements AuthService {

	UserDao userDao;
	MernisService mernisService;
	EmailService emailService;

	@Autowired
	public AuthManager(EmailService emailService, MernisService mernisService, UserDao userDao) {
		this.emailService = emailService;
		this.mernisService = mernisService;
		this.userDao = userDao;
	}

	@Override
	public Result checkEmail(String email) {
		if (!this.emailService.validate(email)) {
			return new ErrorResult("Invalid email address.");
		}

		if (!this.userDao.findByEmail(email).isEmpty()) {
			return new ErrorResult("Email address already exists");
		}

		return new SuccessResult();

	}

	@Override
	public Result checkIdentityNumber(String nationalityId) {
		if (!this.mernisService.validate(nationalityId)) {
			return new ErrorResult("Nationality number must be 11 characters");
		}

		return new SuccessResult();

	}

	@Override
	public Result checkEmailAndIdentityNumber(String email, String nationalityId) {
		if (!(this.checkEmail(email).isSuccess() || !(this.checkIdentityNumber(nationalityId)).isSuccess())) {
			return new ErrorResult("Email or nationality number is invalid");
		}
		return new SuccessResult();
	}
}
