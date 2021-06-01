package tolgahankilic.hrms.business.abstracts;

import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.core.entities.concretes.User;

public interface UserService {
	DataResult<User> getByEmail(String email);
	Result add(User user); 
}
