package com.mbeck.vt.roster.scraper.model;

public enum EligibilityClass {
	FR,
	R_FR,
	SO,
	R_SO,
	JR,
	R_JR,
	SR,
	R_SR;
	
	public static EligibilityClass fromInt(int classNumber) {
		switch (classNumber) {
			case 1: return FR;
			case 2: return R_FR;
			case 3: return SO;
			case 4: return R_SO;
			case 5: return JR;
			case 6: return R_JR;
			case 7: return SR;
			case 8: return R_SR;
			default: throw new IllegalArgumentException();
		}
	}
}
