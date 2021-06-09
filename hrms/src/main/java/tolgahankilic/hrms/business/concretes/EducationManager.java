package tolgahankilic.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.business.abstracts.EducationService;
import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.core.utilities.results.SuccessDataResult;
import tolgahankilic.hrms.core.utilities.results.SuccessResult;
import tolgahankilic.hrms.dataAccess.abstracts.EducationDao;
import tolgahankilic.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {

	EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll());
	}

	@Override
	public DataResult<List<Education>> getAllSorted(int cvId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "graduation_date");
		return new SuccessDataResult<List<Education>>(
				this.educationDao.getEducationGraduationDateByCurriculumVitaeId(cvId, sort));
	}

}
