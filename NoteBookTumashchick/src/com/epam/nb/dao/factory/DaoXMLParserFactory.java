package com.epam.nb.dao.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.epam.nb.dao.ParserDao;
import com.epam.nb.dao.impl.xml.impl.DOMNoteBookParser;
import com.epam.nb.dao.impl.xml.impl.SAXNoteBookParser;
import com.epam.nb.dao.impl.xml.impl.STAXNoteBookParser;

public class DaoXMLParserFactory {
	
	// create singleton of the DaoFactory class
		private static final DaoXMLParserFactory daoXMLFactory = new DaoXMLParserFactory();

		// link to source property file - sourcetype.properties
		private final String linkToSoursetype = "sourcetype";
		private final String daoXMLParserProperty = "XMLParser.type";
		private XMLParserSourceType daoXMLParserType;

		private Map<XMLParserSourceType, ParserDao> dao = new HashMap<>();

		// DaoFactory constructor
		private DaoXMLParserFactory() {

			// get SourceType from sourcetype.properties for the DaoFactory()
			ResourceBundle rb = ResourceBundle.getBundle(linkToSoursetype);
			daoXMLParserType = XMLParserSourceType.valueOf(rb.getString(daoXMLParserProperty));

			dao.put(XMLParserSourceType.SAX, new SAXNoteBookParser());
			dao.put(XMLParserSourceType.STAX, new STAXNoteBookParser());
			dao.put(XMLParserSourceType.DOM, new DOMNoteBookParser());
			
		}

		public static DaoXMLParserFactory getInstance() {
			return daoXMLFactory;
		}

		public ParserDao getDao() {
			return dao.get(daoXMLParserType);
		}
	
	
	
	
	

}
