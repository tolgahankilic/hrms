package tolgahankilic.hrms.business.concretes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tolgahankilic.hrms.business.abstracts.CurriculumVitaeService;
import tolgahankilic.hrms.core.helpers.CloudinaryService;
import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.core.utilities.results.SuccessDataResult;
import tolgahankilic.hrms.core.utilities.results.SuccessResult;
import tolgahankilic.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import tolgahankilic.hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;
	private CloudinaryService cloudinaryService;

	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, CloudinaryService cloudinaryService) {
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult();
	}

	@Override
	public DataResult<CurriculumVitae> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.getByJobSeekerId(jobSeekerId));
	}

	@Override
	public Result uploadPicture(int cvId, MultipartFile file) throws IOException {
		var result = this.cloudinaryService.addPicture(file);
		var url = result.getData().get("url");

		CurriculumVitae ref = this.curriculumVitaeDao.getOne(cvId);
		ref.setPictureUrl(url.toString());
		this.curriculumVitaeDao.save(ref);

		return new SuccessResult();
	}

}
