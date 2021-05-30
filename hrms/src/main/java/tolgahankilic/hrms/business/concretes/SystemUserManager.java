package tolgahankilic.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.business.abstracts.AuthService;
import tolgahankilic.hrms.business.abstracts.SystemUserService;
import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.ErrorResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.core.utilities.results.SuccessDataResult;
import tolgahankilic.hrms.core.utilities.results.SuccessResult;
import tolgahankilic.hrms.dataAccess.abstracts.SystemUserDao;
import tolgahankilic.hrms.entities.concretes.SystemUser;

@Service
public class SystemUserManager implements SystemUserService {

	SystemUserDao systemUserDao;
	AuthService authService;
	
	@Autowired
	public SystemUserManager(SystemUserDao systemUserDao, AuthService authService)
	{
		this.systemUserDao = systemUserDao;
		this.authService = authService;
	}
	

	
	@Override
	public Result add(SystemUser systemUser) {
		var result = this.authService.checkEmail(systemUser.getUser().getEmail());
		if (result.isSuccess()) {
			this.systemUserDao.save(systemUser);
			return new SuccessResult("System user added.");
		}
		return new ErrorResult(result.getMessage());
		
	}



	@Override
	public DataResult<List<SystemUser>> getAll() {
		return new SuccessDataResult<List<SystemUser>>(this.systemUserDao.findAll(),"System users listed.");
	}

}
