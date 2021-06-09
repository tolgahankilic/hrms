package tolgahankilic.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {
	Result add(CurriculumVitae curriculumVitae);
	
	DataResult<CurriculumVitae> getByJobSeekerId(int jobSeekerId);
	
	Result uploadPicture(int cvId, MultipartFile file) throws IOException;
}
