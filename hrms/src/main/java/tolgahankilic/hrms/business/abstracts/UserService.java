package tolgahankilic.hrms.business.abstracts;

import java.util.List;

import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();
}
