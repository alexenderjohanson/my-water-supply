package com.backyard.watershortage.model;

import java.util.Comparator;

public class AffectedAreaSort implements Comparator<AffectedArea>{

	@Override
	public int compare(AffectedArea lhs, AffectedArea rhs) {
		return lhs.tamanName.compareToIgnoreCase(rhs.tamanName);
	}

}
