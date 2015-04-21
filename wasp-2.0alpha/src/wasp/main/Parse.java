/*
 * Copyright 2006, 2007 Yuk Wah Wong.
 * 
 * This file is part of the WASP distribution.
 *
 * WASP is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * WASP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with WASP; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package wasp.main;

import wasp.data.Node;

/**
 * Parses produced by either parsers or generators.
 * 
 * @author ywwong
 *
 */
public class Parse implements Comparable {

	/** The string representation of this parse. */
	public String str;
	/** The score of this parse. */
	public double score;
	/** The comment accompanying this parse. */
	public String comment;
	
	public Parse(String str, double score) {
		this.str = str;
		this.score = score;
		comment = null;
	}
	
	protected Parse(double score) {
		this(null, score);
	}
	
	/**
	 * Parses with higher scores are ranked higher.  This ordering is <i>not</i> consistent with equals
	 * because distinct parses with equal scores should not be treated as equal.
	 */
	public int compareTo(Object o) {
		if (score > ((Parse) o).score)
			return -1;
		else if (score < ((Parse) o).score)
			return 1;
		else
			return 0;
	}

	/**
	 * Returns the tree representation of this parse.
	 * 
	 * @return the tree representation of this parse.
	 */
	public Node toTree() {
		return null;
	}
	
	/**
	 * Returns the string representation of this parse.  For parsing, the string returned is a meaning
	 * representation.  For generation, the string returned is an NL sentence.
	 * 
	 * @return the string representation of this parse.
	 */
	public String toStr() {
		return str;
	}
	
}
