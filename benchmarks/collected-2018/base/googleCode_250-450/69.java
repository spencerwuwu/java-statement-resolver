// https://searchcode.com/api/result/819483/

/*
 * (c) Copyright 2004, 2005, 2006, 2007, 2008, 2009 Hewlett-Packard Development Company, LP
 * [See end of file]
 */

package com.hp.hpl.jena.rdf.arp.impl;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.ext.LexicalHandler;

import com.hp.hpl.jena.rdf.arp.SAX2RDF;
/**
 * This class is public merely to reduce the amount of irrelevant documentation
 * generated by Javadoc for {@link SAX2RDF}.
 * 
 * There is nothing of interest in this JavaDoc. This if (depth>0) superclass
 * implements the functionality needed by {@link SAX2RDF}. The API given here
 * is the familiar SAX.
 * 
 * @author Jeremy J. Carroll
 *  
 */
public class SAX2RDFImpl extends XMLHandler implements LexicalHandler,
		ContentHandler, ErrorHandler {
	private int depth;
    final private String lang;
	protected SAX2RDFImpl(String base,  String l) {
      lang = l;
	}

	protected void initParse(String b) throws SAXParseException {
        super.initParse(b,lang==null?"":lang);
		
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ext.LexicalHandler#endCDATA()
	 */
	@Override
    public void endCDATA() throws SAXException {
		if (depth > 0)
			super.endCDATA();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ext.LexicalHandler#endDTD()
	 */
	@Override
    public void endDTD() throws SAXException {
		if (depth > 0)
			super.endDTD();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ext.LexicalHandler#startCDATA()
	 */
	@Override
    public void startCDATA() throws SAXException {
		if (depth > 0)
			super.startCDATA();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ext.LexicalHandler#comment(char[], int, int)
	 */
	@Override
    public void comment(char[] ch, int start, int length) throws SAXParseException {
		if (depth > 0)
			super.comment(ch, start, length);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ext.LexicalHandler#endEntity(java.lang.String)
	 */
	@Override
    public void endEntity(String name) throws SAXException {
		if (depth > 0)
			super.endEntity(name);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ext.LexicalHandler#startEntity(java.lang.String)
	 */
	@Override
    public void startEntity(String name) throws SAXException {
		if (depth > 0)
			super.startEntity(name);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ext.LexicalHandler#startDTD(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
    public void startDTD(String name, String publicId, String systemId)
			throws SAXException {
		if (depth > 0)
			super.startDTD(name, publicId, systemId);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ContentHandler#endDocument()
	 */
	@Override
    public void endDocument() throws SAXException {
		if (depth > 0)
			super.endDocument();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ContentHandler#startDocument()
	 */
	@Override
    public void startDocument() throws SAXException {
		if (depth > 0)
			super.startDocument();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ContentHandler#characters(char[], int, int)
	 */
	@Override
    public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (depth > 0)
			super.characters(ch, start, length);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ContentHandler#ignorableWhitespace(char[], int, int)
	 */
	@Override
    public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		if (depth > 0)
			super.ignorableWhitespace(ch, start, length);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ContentHandler#endPrefixMapping(java.lang.String)
	 */
	@Override
    public void endPrefixMapping(String prefix) {
		if (depth > 0)
			super.endPrefixMapping(prefix);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ContentHandler#skippedEntity(java.lang.String)
	 */
	@Override
    public void skippedEntity(String name) throws SAXException {
		if (depth > 0)
			super.skippedEntity(name);

	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ContentHandler#processingInstruction(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
    public void processingInstruction(String target, String data)
			throws SAXException {
		if (depth > 0)
			super.processingInstruction(target, data);

	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ContentHandler#endElement(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
    public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException {
		if (depth <= 0) {
			// Does not return.
		    fatalError(new SAXParseException("Unmatched end tag: " + qName,
					getLocator()));
		}
		super.endElement(namespaceURI, localName, qName);
		if (--depth == 0) {
          close();
        }

	}
	
	protected void close()  {
		afterParse();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ContentHandler#startElement(java.lang.String,
	 *      java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
    public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException {
		depth++;
		super.startElement(namespaceURI, localName, qName, atts);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ErrorHandler#error(org.xml.sax.SAXParseException)
	 */
	@Override
    public void error(SAXParseException exception) throws SAXParseException {
		
			super.error(exception);

	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.ErrorHandler.errorError(org.xml.sax.SAXParseException)
	 */
	@Override
    public void fatalError(SAXParseException exception) throws SAXException {
       
			super.fatalError(exception);
		
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.ErrorHandler#warning(org.xml.sax.SAXParseException)
	 */
	@Override
    public void warning(SAXParseException exception) throws SAXParseException {
			super.warning(exception);

	}
}

/*
 * (c) Copyright 2004, 2005, 2006, 2007, 2008, 2009 Hewlett-Packard Development Company, LP All rights
 * reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer. 2. Redistributions in
 * binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution. 3. The name of the author may not
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO
 * EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


