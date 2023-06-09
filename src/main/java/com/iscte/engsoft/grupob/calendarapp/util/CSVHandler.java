package com.iscte.engsoft.grupob.calendarapp.util;

import java.io.*;

import java.util.List;
import java.util.ArrayList;

/**
 *  Classe utilitária para o parsing de CSV
 *  Inspirado na class CSV de Jay Sridhar
 *  */
public class CSVHandler {
	private static final int NUMMARK = 10;
	private static final char DQUOTE = '"';
	private static final char CRETURN = '\r';
	private static final char LFEED = '\n';
	private static final char COMMENT = '#';

	private boolean stripMultipleNewlines;

	/**
	 * What should be used as the separator character?
	 */
	private char separator;
	private ArrayList<String> fields;
	private boolean eofSeen;
	private Reader in;

	public static Reader stripBom(String string){
		return new StringReader(string);
	}

	public CSVHandler(boolean stripMultipleNewlines, char separator, Reader input) {
		this.stripMultipleNewlines = stripMultipleNewlines;
		this.separator = separator;
		this.fields = new ArrayList<>();
		this.eofSeen = false;
		this.in = new BufferedReader(input);
	}

	public CSVHandler(boolean stripMultipleNewlines, char separator, String in) {
		this.stripMultipleNewlines = stripMultipleNewlines;
		this.separator = separator;
		this.fields = new ArrayList<>();
		this.eofSeen = false;
		this.in = stripBom(in);
	}

	public boolean hasNext() throws java.io.IOException {
		if (eofSeen)
			return false;
		fields.clear();
		eofSeen = split(in, fields);
		if (eofSeen)
			return !fields.isEmpty();
		else
			return true;
	}

	public List<String> next() {
		return fields;
	}

	// Returns true if EOF seen.
	private static boolean discardLinefeed(Reader in, boolean stripMultiple) throws java.io.IOException {
		if (stripMultiple) {
			in.mark(NUMMARK);
			int value = in.read();
			while (value != -1) {
				char c = (char) value;
				if (c != CRETURN && c != LFEED) {
					in.reset();
					return false;
				} else {
					in.mark(NUMMARK);
					value = in.read();
				}
			}
			return true;
		} else {
			in.mark(NUMMARK);
			int value = in.read();
			if (value == -1)
				return true;
			else if ((char) value != LFEED)
				in.reset();
			return false;
		}
	}

	private boolean skipComment(Reader in) throws java.io.IOException {
		/* Discard line. */
		int value;
		while ((value = in.read()) != -1) {
			char c = (char) value;
			if (c == CRETURN)
				return discardLinefeed(in, stripMultipleNewlines);
		}
		return true;
	}

	// Returns true when EOF has been seen.
	private boolean split(Reader in, ArrayList<String> fields) throws java.io.IOException {
		StringBuilder sbuf = new StringBuilder();
		int value;
		while ((value = in.read()) != -1) {
			char c = (char) value;
			switch (c) {
			case CRETURN:
				if (sbuf.length() > 0) {
					fields.add(sbuf.toString());
					sbuf.delete(0, sbuf.length());
				}
				return discardLinefeed(in, stripMultipleNewlines);

			case LFEED:
				if (sbuf.length() > 0) {
					fields.add(sbuf.toString());
					sbuf.delete(0, sbuf.length());
				}
				if (stripMultipleNewlines)
					return discardLinefeed(in, stripMultipleNewlines);
				else
					return false;

			case DQUOTE: {
				// Processing double-quoted string ..
				while ((value = in.read()) != -1) {
					c = (char) value;
					if (c == DQUOTE) {
						// Saw another double-quote. Check if
						// another char can be read.
						in.mark(NUMMARK);
						if ((value = in.read()) == -1) {
							// Nope, found EOF; means End of
							// field, End of record and End of
							// File
							if (sbuf.length() > 0) {
								fields.add(sbuf.toString());
								sbuf.delete(0, sbuf.length());
							}
							return true;
						} else if ((c = (char) value) == DQUOTE) {
							// Found a second double-quote
							// character. Means the double-quote
							// is included.
							sbuf.append(DQUOTE);
						} else if (c == CRETURN) {
							// Found End of line. Means End of
							// field, and End of record.
							if (sbuf.length() > 0) {
								fields.add(sbuf.toString());
								sbuf.delete(0, sbuf.length());
							}
							// Read and discard a line-feed if we
							// can indeed do so.
							return discardLinefeed(in, stripMultipleNewlines);
						} else if (c == LFEED) {
							// Found end of line. Means End of
							// field, and End of record.
							if (sbuf.length() > 0) {
								fields.add(sbuf.toString());
								sbuf.delete(0, sbuf.length());
							}
							// No need to check further. At this
							// point, we have not yet hit EOF, so
							// we return false.
							if (stripMultipleNewlines)
								return discardLinefeed(in, stripMultipleNewlines);
							else
								return false;
						} else {

							in.reset();
							break;
						}
					} else {
						// Not a double-quote, so no special meaning.
						sbuf.append(c);
					}
				}
				// Hit EOF, and did not see the terminating double-quote.
				if (value == -1) {
					// We ignore this error, and just add whatever
					// left as the next field.
					if (sbuf.length() > 0) {
						fields.add(sbuf.toString());
						sbuf.delete(0, sbuf.length());
					}
					return true;
				}
			}
				break;

			default:
				if (c == separator) {
					fields.add(sbuf.toString());
					sbuf.delete(0, sbuf.length());
				} else {
					/*
					 * A comment line is a line starting with '#' with optional whitespace at the
					 * start.
					 */
					if (c == COMMENT && fields.isEmpty() && sbuf.toString().trim().isEmpty()) {
						boolean eof = skipComment(in);
						if (eof)
							return eof;
						else
							sbuf.delete(0, sbuf.length());
						/* Continue with next line if not eof. */
					} else
						sbuf.append(c);
				}
			}
		}
		if (sbuf.length() > 0) {
			fields.add(sbuf.toString());
			sbuf.delete(0, sbuf.length());
		}
		return true;
	}
}