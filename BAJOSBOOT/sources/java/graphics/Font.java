package java.graphics;

public class Font 
{
	int color, bgColor;
	int windowX1, windowX2, windowY1, windowY2;
	byte fontIndex, fixedFont, autoLineFeed;
		
    public Font()
    {
    	System.out.println ("Font()");
    	setDefaults();
    	setValues();
    }  
    
    public void setDefaults()
    {
    	System.out.println ("Font.setDefaults()");
    	color = 0x000000;
    	bgColor = 0xffffff;  
    	windowX1=0;
    	windowX2=Display.xMax-1;
    	windowY1=0;
    	windowY2=Display.yMax-1;
    	fontIndex=(byte)0;
    	fixedFont=(byte)0;
    	autoLineFeed=(byte)1;
    }
    
    public void setValues()
    {
    	System.out.println ("Font.setValues()");
    	System.platform.setFont(fontIndex);
    	System.platform.setFontWindow(windowX1, windowY1, windowX2, windowY2);
    	System.platform.setFontAutoLineFeed(autoLineFeed);
    	System.platform.setFontFixedFont(fixedFont);    	
    	System.platform.setFontCursor(windowX1, windowY1);
    	System.platform.setFontColor(color, bgColor);
    }

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getBgColor() {
		return bgColor;
	}

	public void setBgColor(int bgColor) {
		this.bgColor = bgColor;
	}

	public int getWindowX1() {
		return windowX1;
	}

	public void setWindowX1(int windowX1) {
		this.windowX1 = windowX1;
	}

	public int getWindowX2() {
		return windowX2;
	}

	public void setWindowX2(int windowX2) {
		this.windowX2 = windowX2;
	}

	public int getWindowY1() {
		return windowY1;
	}

	public void setWindowY1(int windowY1) {
		this.windowY1 = windowY1;
	}

	public int getWindowY2() {
		return windowY2;
	}

	public void setWindowY2(int windowY2) {
		this.windowY2 = windowY2;
	}

	public byte getFontIndex() {
		return fontIndex;
	}

	public void setFontIndex(byte fontIndex) {
		this.fontIndex = fontIndex;
	}

	public byte getFixedFont() {
		return fixedFont;
	}

	public void setFixedFont(byte fixedFont) {
		this.fixedFont = fixedFont;
	}

	public byte getAutoLineFeed() {
		return autoLineFeed;
	}

	public void setAutoLineFeed(byte autoLineFeed) {
		this.autoLineFeed = autoLineFeed;
	}
	
	public void setCursor(int x, int y)
	{
		System.out.println ("Font.setCursor()");
		System.platform.setFontCursor(x, y);
	}
	
	public int drawCharAt(int x, int y, char c, int fgcolor, int bkcolor)
	{
		System.out.println ("Font.drawCharAt()");
		return System.platform.drawCharAt(x, y, c, fgcolor, bkcolor);
	}
	
	public int drawChar(char c)
	{
		System.out.println ("Font.drawChar()");
		return System.platform.drawChar(c);
	}
	
	public int getCharWidth(char c)
    {
		System.out.println ("Font.getCharWidth()");
		return System.platform.getCharWidth(c);
    }
    
	public int drawStringAt(int x, int y, String s, int fgcolor, int bkcolor)
	{
		System.out.println ("Font.drawStringAt()");
		setCursor(x, y);
		System.platform.setFontColor(fgcolor, bkcolor);
		int with=0;
		for (int i=0; i<s.length();i++)
		{
			with+=drawChar(s.charAt(i));
		}
		return with;
	}
	
    public int getStringWidth(String s)
    {
    	System.out.println ("Font.getStringWidth()");
    	int with=0;
		for (int i=0; i<s.length();i++)
		{
			with+=getCharWidth(s.charAt(i));
		}
		return with;
    }
    
    public int drawString(String s)
	{
    	System.out.println ("Font.drawString()");
    	int with=0;
		for (int i=0; i<s.length();i++)
		{
			with+=drawChar(s.charAt(i));
		}
		return with;
	}
}
