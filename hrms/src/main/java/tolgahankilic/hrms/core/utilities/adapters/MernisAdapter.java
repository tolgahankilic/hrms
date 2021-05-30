package tolgahankilic.hrms.core.utilities.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.services.fakeMernisService.FakeMernisManager;

@Service
public class MernisAdapter implements MernisService {

	@Autowired
	FakeMernisManager fakeMernisManager;

	@Override
	public boolean validate(String nationalityId) {
		return this.fakeMernisManager.validate(nationalityId);
	}
}
