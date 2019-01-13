package com.sncf.xspeedit.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houhichi
 */
public class XspeedIt {

	private List<Integer> listOfBox = new ArrayList<>();
	private String chain;

	public XspeedIt() {
	}

	public void setChain(String chain) {
		this.chain = chain;
	}

	public XspeedIt(String chain) {
		super();
		this.chain = chain;
	}

	public String getChain() {
		return chain;
	}

	public List<Integer> getListOfBox() {
		return listOfBox;
	}

	public void setListOfBox(List<Integer> listOfBox) {
		this.listOfBox = listOfBox;
	}

}