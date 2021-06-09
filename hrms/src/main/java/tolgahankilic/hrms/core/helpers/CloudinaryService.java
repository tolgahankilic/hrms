package tolgahankilic.hrms.core.helpers;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import tolgahankilic.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {
	DataResult<Map> addPicture(MultipartFile file) throws IOException;
}
