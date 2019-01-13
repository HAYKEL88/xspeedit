package com.sncf.xspeedit.service;

import java.util.Collections;
import com.sncf.xspeedit.exception.TechnicalException;
import com.sncf.xspeedit.model.XspeedIt;

/**
 * 
 * @author houhichi
 *
 */
public class XspeeditService {

	private static final int LIMIT_SPACE = 10;
	private static final String DELIMITER = "/";
	private XspeedIt xspeedit;
	private String finalChain = "";
	private int count = 0;

	public void execute() throws TechnicalException {

		if (this.xspeedit.getChain().length() == 0) {
			throw new TechnicalException("EmptyData", "Input data is empty");
		}

		for (char sizeChar : this.xspeedit.getChain().toCharArray()) {
			String size = String.valueOf(sizeChar);
			try {
				this.xspeedit.getListOfBox().add(Integer.valueOf(size));
			} catch (NumberFormatException e) {
				throw new TechnicalException("WrongData", "Only numbers are accepted");
			}
		}

		optimize();

	}

	private void optimize() {

		if (this.xspeedit.getListOfBox().size() > 0) {

			int valueMax = Collections.max(this.xspeedit.getListOfBox());
			this.finalChain += Integer.toString(valueMax);
			this.xspeedit.getListOfBox().remove(this.xspeedit.getListOfBox().indexOf(valueMax));
			int spaceAvailable = LIMIT_SPACE - valueMax;
			String nextBoxs = getMaxValuesInRange(spaceAvailable);
			this.finalChain += nextBoxs + DELIMITER;
			count++;
			optimize();
		}

	}

	private String getMaxValuesInRange(int spaceAvailable) {

		String result = "";
		int maxValueInRange = 0;

		for (Integer item : this.xspeedit.getListOfBox()) {

			if (item > maxValueInRange && item <= spaceAvailable) {
				maxValueInRange = item;
			}
		}

		if (maxValueInRange != 0) {
			this.xspeedit.getListOfBox().remove(this.xspeedit.getListOfBox().indexOf(maxValueInRange));
			int currentSpaceAvailable = spaceAvailable - maxValueInRange;
			result += String.valueOf(maxValueInRange);
			if (currentSpaceAvailable > 0) {
				result += getMaxValuesInRange(currentSpaceAvailable);
			}
		}

		return result;

	}

	public XspeedIt getXspeedit() {
		return xspeedit;
	}

	public void setXspeedit(XspeedIt xspeedit) {
		this.xspeedit = xspeedit;
	}

	public String getFinalChain() {
		return finalChain;
	}

}