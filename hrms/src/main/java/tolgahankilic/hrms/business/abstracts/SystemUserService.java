package tolgahankilic.hrms.business.abstracts;

import java.util.List;

import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.concretes.SystemUser;

public interface SystemUserService {
	Result add(SystemUser systemUser);

	DataResult<List<SystemUser>> getAll();
}
