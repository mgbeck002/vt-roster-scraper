package com.mbeck.vt.roster.scraper.utils;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import com.mbeck.vt.roster.scraper.model.EligibilityClass;
import com.mbeck.vt.roster.scraper.model.Player;
import com.mbeck.vt.roster.scraper.model.Position;

public class NodeToPlayerConverter {
	private static final String CLASS = "class";
	private static final String NUMBER_CLASS = "number";
	private static final String NAME_CLASS = "nameshow";
	private static final String NAME_TAG = "a";
	private static final String SUPPLEMENTAL_TAG = "sup";
	private static final String EXPERIENCE_CLASS = "exp";
	private static final String POSITION_CLASS = "position";
	private static final String HEIGHT_CLASS = "height";
	private static final String WEIGHT_CLASS = "weight";
	private static final String ELIGIBILITY_CLASS = "classes";
	private static final String HOMETOWN_CLASS = "hometown";
	private static final String HOMETOWN_SEPARATOR = ", ";
	private static final String HIGHSCHOOL_CLASS = "highschool";
	
	private NodeToPlayerConverter() {
	}
	
	public static Player convertNodeToPlayer(Node node) {
		Player p = new Player();
		for (Node n : node.childNodes()) {
			String columnClass = n.attr(CLASS);
			if (NUMBER_CLASS.equalsIgnoreCase(columnClass)) {
				p.setNumber(pullIntFromStringField(n));
			} else if (NAME_CLASS.equalsIgnoreCase(columnClass)) {
				if (n.childNodes().size() >= 1) {
					Node child = n.childNode(0);
					if (child instanceof Element && NAME_TAG.equalsIgnoreCase(((Element)child).tag().getName())){
						p.setName(pullStringField(child));
					} else {
						p.setName(pullStringField(n));
					}
					if(n.childNodes().size() > 1) {
						for (Node sub : n.childNodes()) {
							if (sub instanceof Element && SUPPLEMENTAL_TAG.equalsIgnoreCase(((Element)sub).tag().getName())) {
//								System.out.println("Additional info " + pullStringField(sub) + " for player " + p.getName());
							}
 						}
					}
				}
			} else if (EXPERIENCE_CLASS.equalsIgnoreCase(columnClass)) {
				Integer value = pullIntFromStringField(n);
				p.setVarsityLetters(value == null ? 0 : value);
			} else if (POSITION_CLASS.equalsIgnoreCase(columnClass)) {
				String value = pullStringField(n);
				if (value != null) {
					p.setPosition(Position.valueOf(value));
				}
			} else if (HEIGHT_CLASS.equalsIgnoreCase(columnClass)) {
				p.setHeight(pullIntFromStringField(n));
			} else if (WEIGHT_CLASS.equalsIgnoreCase(columnClass)) {
				p.setWeight(pullIntFromStringField(n));
			} else if (ELIGIBILITY_CLASS.equalsIgnoreCase(columnClass)) {
				p.setEligibilityClass(EligibilityClass.fromInt(pullIntFromStringField(n)));
			} else if (HOMETOWN_CLASS.equalsIgnoreCase(columnClass)) {
				String wholeValue = pullStringField(n);
				p.setHometown(wholeValue.split(HOMETOWN_SEPARATOR)[0]);
				p.setHomeState(wholeValue.split(HOMETOWN_SEPARATOR)[1]);
			} else if (HIGHSCHOOL_CLASS.equalsIgnoreCase(columnClass)) {
				p.setHighSchool(pullStringField(n));
			}
		}
		return p;
	}

	private static Integer pullIntFromStringField(Node n) {
		Integer value = null;
		try {
			value = Integer.parseInt(pullStringField(n));
		} catch (NumberFormatException e) {
		}
		return value;
	}
	
	private static String pullStringField(Node n) {
		if (n.childNodes() == null || n.childNodes().isEmpty()) {
			 return null;
		}
		return ((TextNode) n.childNode(0)).getWholeText();
	}
}
