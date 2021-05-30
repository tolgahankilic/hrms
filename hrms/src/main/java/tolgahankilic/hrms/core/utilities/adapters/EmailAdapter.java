package tolgahankilic.hrms.core.utilities.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tolgahankilic.hrms.services.fakeEmailService.FakeEmailManager;

@Service
public class EmailAdapter implements EmailService {

	@Autowired
	FakeEmailManager fakeEmailManager;

	@Override
	public boolean validate(String email) {
		return this.fakeEmailManager.validate(email);
	}
}
