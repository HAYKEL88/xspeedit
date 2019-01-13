package com.sncf.xspeedit;

import com.sncf.xspeedit.exception.TechnicalException;
import com.sncf.xspeedit.model.XspeedIt;
import com.sncf.xspeedit.service.XspeeditService;

/**
 * @author houhichi
 *
 */
public class XspeedMain {

	public static void main(String[] args) {

		String dataIn = "163841689525773";
		XspeedIt xspeedIt = new XspeedIt(dataIn);
		XspeeditService service = new XspeeditService();
		service.setXspeedit(xspeedIt);

		try {
			service.execute();
			System.out.println("Articles      :" + dataIn);
			System.out.println("Robot optimisé:" + service.getFinalChain());
		} catch (TechnicalException e) {
			System.out.println(
					"Tecgnical error.\nCode : " + e.getCode() + "\nDescription : " + e.getMessage());
		}
		;

	}

}