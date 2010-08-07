package java.lang;

/**
 * An immutable string of characters.
 */


public final class String
{
  // NOTE: The state of this class is mapped to
private char[] characters; // let it private
// never use characters.length better length()

public String(String str)
  {
      characters = new char[str.length()];
  for (int i=0; i<str.length(); i++)	
  characters[i]=str.charAt(i); 
  }

	public String(char[] c) {
		int len = c.length;
    characters = new char[len];
    System.arraycopy (c, 0, characters, 0, len);
	}

  /**
   * Create a String from a character array.
   * @param c the character array
   * @param off the offset - usually 0
   * @param len the length of the String - must not be greater than c.length
   **/
  public String (char[] c, int off, int len)
  {
		if (off < 0 || off > c.length || len < 0 || len > c.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
    characters = new char[len];
    System.arraycopy (c, off, characters, 0, len);
  }

  /**
   * Return the length of the String in characters
   * @return the length of the String
   **/
public native int nativeStringLength();

	public int length() {
		int length = nativeStringLength();
		return (length != 0xffff) ? length : characters.length;
	}

  /**
   * Return the character at the given index
   * @return the characters at the given index
   **/
 
 public native char nativeCharAt(int index);

  public char charAt(int index) {
		char c = nativeCharAt(index); 
		return (c != 0) ? c : characters[index];
	}

  /**
   * Converts the String into an array of characters
   * @return the character Array
   **/
  public char[] toCharArray()
  {
    int len = length()-1;
    char[] ca = new char[len+1];
for (;len >=0; --len) ca[len]=charAt(len);
    return ca;
  }

  /**
   * Converts an Object to a String
   * @return the String that represents the object
   **/
  public static String valueOf (Object aObj)
  {
    return aObj.toString();
  }
 public static String valueOf (int n)
  {
    return new Integer(n).toString();
  }
  /**
   * Returns itself.
   * @return the String itself
   */
  public String toString()
  {
    return this;
  }

	private boolean compare(char[] other, int offset, int len, int myoffset) {
		for (int i = offset ; i < len ; ++i) {
			if (characters[i + myoffset] != other[i])
				return false;
		}
		return true;
	}

	private boolean compareNoCase(char[] other, int offset, int len, int myoffset) {
		for (int i = offset ; i < len ; ++i) {
			int my = i + myoffset;
			if (characters[my] != other[i] && Character.toLowerCase(characters[my ]) != Character.toLowerCase(other[i]) && Character.toUpperCase(characters[my]) != Character.toUpperCase(other[i]))
				return false;
		}
		return true;
	}
  
  /**
   * Compares the String with an Object
   * @return true if the String is equal to the object, false otherwise
   **/
  public boolean equals(Object other) {
		if (other == null || ! (other instanceof String)) {
			return false;
		}

		String os = (String)other;
		int len = length();
		return (os.length() == len) ? compare(os.characters, 0, len, 0) : false;
	}

	public boolean contentEquals(StringBuffer sb) {
		int len = length();
		return (sb.length() == len) ? compare(sb.getChars(), 0, len, 0) : false;
	}

	public boolean equalsIgnoreCase(String os) {
		int len = length();
		return (os.length() == len) ? compareNoCase(os.characters, 0, len, 0) : false;
	}

	public boolean regionMatches(int toffset, String other, int ooffset, int len) {
		return regionMatches (false, toffset, other, ooffset, len);
	}

	public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
		int mylen = length();
		if (toffset < 0 || ooffset < 0 || toffset + len > mylen || ooffset + len > other.length())
			return false;
		return ignoreCase ? compareNoCase(other.characters, ooffset, len, toffset - ooffset) : compare(other.characters, ooffset, len, toffset - ooffset);
	}

	public boolean startsWith(String prefix, int toffset) {
		int len = length();
		int plen = prefix.length();
		return (toffset >= 0 && toffset <= len && plen <= len) ? compare(prefix.characters, 0, plen, toffset) : false;
	}

	public boolean startsWith(String prefix) {
		int plen = prefix.length();
		return (plen <= length()) ? compare(prefix.characters, 0, plen, 0) : false;
	}

	public boolean endsWith(String suffix) {
		int slen = suffix.length();
		int len = length();
		return (slen <= len) ? compare(suffix.characters, 0, slen, len - slen) : false; 
	}

	public int indexOf(int ch) {
		return indexOf(ch, 0);
	}

	public int indexOf(int ch, int fromIndex) {
		int len = length();
		fromIndex = fromIndex < 0 ? 0 : (fromIndex > len ? len : fromIndex);
		for (int i = fromIndex ; i < len ; ++i) {
			if (characters[i] == ch) return i;
		}
		return -1;
	}

	public int lastIndexOf(int ch) {
		return lastIndexOf(ch, length() - 1);
	}

	public int lastIndexOf(int ch, int fromIndex) {
		int len = length();
		fromIndex = fromIndex < 0 ? -1 : (fromIndex >= len ? len - 1 : fromIndex);
		for (int i = fromIndex ; i >= 0 ; --i) {
			if (characters[i] == ch) return i;
		}
		return -1;
	}

	public String substring(int beginIndex) {
		return new String(characters, beginIndex, length() - beginIndex);
	}

	public String substring(int beginIndex, int endIndex) {
		return new String(characters, beginIndex, endIndex - beginIndex);
	}

	public String concat(String str) {
		int olen = str.length();
		if (olen  == 0)
			return this;
		int len = length();
		if (len == 0)
			return str;

		char[] newStr = new char[olen + len];
		System.arraycopy (toCharArray(), 0, newStr, 0, len);
		System.arraycopy (str.toCharArray(), 0, newStr, len, olen);
		return new String(newStr);
	}

}

