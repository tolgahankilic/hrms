package tolgahankilic.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.business.abstracts.AuthService;
import tolgahankilic.hrms.business.abstracts.EmployerService;
import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.ErrorResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.core.utilities.results.SuccessDataResult;
import tolgahankilic.hrms.core.utilities.results.SuccessResult;
import tolgahankilic.hrms.dataAccess.abstracts.EmployerDao;
import tolgahankilic.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private AuthService authService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, AuthService authService) {
		this.employerDao = employerDao;
		this.authService = authService;
	}

	@Override
	public Result add(Employer employer) {
		var result = this.authService.checkEmail(employer.getUser().getEmail());
		if (result.isSuccess()) {
			this.employerDao.save(employer);
			return new SuccessResult("Employer added.");
		}
		return new ErrorResult(result.getMessage());
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers listed.");
	}

}
