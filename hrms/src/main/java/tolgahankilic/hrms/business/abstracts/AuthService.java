package tolgahankilic.hrms.business.abstracts;

import tolgahankilic.hrms.core.utilities.results.Result;

public interface AuthService {
	Result checkEmail(String email);

	Result checkIdentityNumber(String nationalityId);

	Result checkEmailAndIdentityNumber(String email, String nationalityId);
}
