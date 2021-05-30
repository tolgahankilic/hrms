package tolgahankilic.hrms.services.fakeMernisService;

import org.springframework.stereotype.Component;

@Component
public class FakeMernisManager {

	public boolean validate(String nationalityId) {
		if (nationalityId.length() != 11)
			return false;
		else
			return true;
	}
}
