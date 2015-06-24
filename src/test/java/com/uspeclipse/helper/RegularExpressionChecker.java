package com.uspeclipse.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionChecker {
	private Pattern pattern;
	private Matcher matcher;
 
	//private static final String EMAIL_PATTERN = 
	//	"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	//	+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	
	public RegularExpressionChecker(String PatternName) {
		if(PatternName.equals("EMAIL"))
			pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
	}
 
	/**
	 * Validate hex with regular expression
	 * 
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public boolean validate(final String hex) {
 
		matcher = pattern.matcher(hex);
		return matcher.matches();
 
	}
	
	
	
}
