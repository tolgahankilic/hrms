package tolgahankilic.hrms.core.utilities.business;

import tolgahankilic.hrms.core.utilities.results.Result;

public class BusinessRules {
	public static Result run(Result... logics) {

		for (var logic : logics) {
			if (!logic.isSuccess()) {
				return logic;
			}
		}
		return null;
	}
}
