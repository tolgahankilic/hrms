package tolgahankilic.hrms.core.helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.ErrorDataResult;
import tolgahankilic.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryService {

	Cloudinary cloudinary;

	public CloudinaryManager() {
		cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "tolgahankilic", "api_key", "167851841815397",
				"api_secret", "2CYSWoL1HCZ01FLoTfDgAvlQT1M"));
	}

	@Override
	public DataResult<Map> addPicture(MultipartFile multipartFile) throws IOException {
		Map<String, Object> options = new HashMap<>();
		var allowedFormats = Arrays.asList("png", "jpg", "jpeg");
		options.put("allowed_formats", allowedFormats);
		File file = convertToFile(multipartFile);
		Map uploader = null;
		try {
			uploader = cloudinary.uploader().upload(file, options);
		} catch (Exception e) {
			return new ErrorDataResult<>(e.getMessage());
		}
		return new SuccessDataResult<>(uploader);
	}

	private File convertToFile(MultipartFile multipartFile) throws IOException {
		File file = new File("C:\\Users\\kilic\\git\\hrms\\hrms\\Pictures\\" + multipartFile.getOriginalFilename());
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(multipartFile.getBytes());
		stream.close();
		return file;
	}

}
