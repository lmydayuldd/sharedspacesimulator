package uk.org.catapult.ts.cav.microsimulator.pedestrian.catpedsim.configuration.path;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Xml Crossing (entrance/exit).
 * 
 * @author Ecaterina McCormick, ecaterina.mccormick@ts.catapult.org.uk
 * 
 *         Copyright � <2016> TRANSPORT SYSTEMS CATAPULT
 * 
 *         Permission is hereby granted, free of charge, to any person obtaining
 *         a copy of this software and associated documentation files (the
 *         "Software"), to deal in the Software without restriction, including
 *         without limitation the rights to use, copy, modify, merge, publish,
 *         distribute, sublicense, and/or sell copies of the Software, and to
 *         permit persons to whom the Software is furnished to do so, subject to
 *         the following conditions:
 * 
 *         The above copyright notice and this permission notice shall be
 *         included in all copies or substantial portions of the Software. Users
 *         of the Software shall acknowledge Transport Systems Catapult as the
 *         source of the Software in any publication that refers to it.
 * 
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *         EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *         MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *         NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *         BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 *         ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *         CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *         SOFTWARE.
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crossing")
public class XmlCrossing {

	/** Entrance id. */
	@XmlAttribute(name = "id")
	private int crossingId = 0;

	/** Points defining the crossing. */
	@XmlElement(type = XmlVertex.class, name = "vertex")
	private final LinkedList<XmlVertex> listOfCoordinates = new LinkedList<XmlVertex>();

	/**
	 * Constructor.
	 */
	public XmlCrossing() {

	}
}
