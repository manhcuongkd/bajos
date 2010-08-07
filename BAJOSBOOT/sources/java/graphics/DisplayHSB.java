package java.graphics;

import java.util.Vector;

public class DisplayHSB extends Display 
{
	public static float hue;
	public static float saturation;
	public static float brightness;	
	
    public DisplayHSB()
    {    	
    	super();
    	System.out.println ("DisplayHSB() ...");
    	//Standard Vordergrundfarbe: schwarz
    	DisplayHSB.hue=255;
    	DisplayHSB.saturation=0;
    	DisplayHSB.brightness=0;
    } 
	
	public void drawPoint(Point p)
    {
    	//mit HSB
		System.out.println ("DisplayHSB.drawPoint()");
		System.platform.drawPointHSB(p);
    }

	public void clearDisplay()
    {
		System.out.println ("DisplayHSB.clearDisplay ...");
		System.platform.clearZBuffer();
    	super.clearDisplay();
    }
	
    public void drawLine(Point pa, Point pe)
    {
    	//nach dem DDA-Alg.
    	System.out.println ("DisplayHSB.drawLine()");
    	System.platform.drawLineHSB(pa, pe);
    }
       
	
	public static void setHSBColor(float hue, float saturation, float brightness)	
	{
		System.out.println ("DisplayHSB.setHSBColor()");
		DisplayHSB.hue=hue;
		DisplayHSB.saturation=saturation;
		DisplayHSB.brightness=brightness;						
	}
	
	public void triangleFill(Point p0, Point p1, Point p2)
	{
		// to do: sort points !!!
		// assume: points are sorted by rising y

		System.out.println ("DisplayHSB.triangleFill()");
		System.platform.drawTriangleFill(p0, p1, p2);
	}
	
	public void drawPolyline(Polyline pl)						
	{
		System.out.println (pl.size());
		for (int i=0;i < pl.size(); i++) 
		{
			System.out.println (i);
			System.out.println ((i+1)%pl.size());
			drawLine(pl.pointAt(i),pl.pointAt((i+1)%pl.size()));
		}
	}
	
	public void scanFill(Polyline pl)
	{	//dda
		Line 	l;
		Vector 	al	=  new Vector();
		Vector	loi	=  new Vector();
		Point	a	=  new Point();
		Point	b	=  new Point(); 
		
		for (int i=0; i < pl.size();i++)
			if ((int)pl.pointAt(i).y != (int)pl.pointAt((i+1)%pl.size()).y)
				if (pl.pointAt(i).y > pl.pointAt((i+1)%pl.size()).y)
					al.addElement(new Line(pl.pointAt(i),pl.pointAt((i+1)%pl.size())));
			else			// eintragen der lines in Vektor, richtig rum
				al.addElement(new Line(pl.pointAt((i+1)%pl.size()),pl.pointAt(i)));
		// Parallelen zur y-Achse weglassen
		for (int j=0; j < al.size();j++)
			for (int i=1; i < al.size(); i++)	// sortieren der Lines nach y-Gr?e
				if (((Line)al.elementAt(i-1)).anf.y < ((Line)al.elementAt(i)).anf.y) 
				{
					l=(Line)al.elementAt(i-1); 
					al.remove(i-1);
					al.set(i,l);
				}
		int y=(int)((Line)al.elementAt(0)).anf.y;
		for (int i=0;i< al.size(); i++)
			if (y==(int)((Line)al.elementAt(i)).anf.y)
				loi.addElement((Line)al.elementAt(i));
			else break;  // da sie geordnet sind !!
		if ((loi.size() %2)!=0)
			 System.out.println("hier stimmt was nicht");
		while (loi.size() !=0)
		{
			int	[] xs= new int[loi.size()];
			float	[] hs= new float[loi.size()];
			float	[] ss= new float[loi.size()];
			float	[] bs= new float[loi.size()];
			for(int i=0; i< loi.size();i++)
				if (((int)((Line)loi.elementAt(i)).anf.y)==((int)((Line)loi.elementAt(i)).end.y))
				{
					xs[i]=(int)((Line)loi.elementAt(i)).anf.x;
					hs[i]=(float)((Line)loi.elementAt(i)).anf.h;
					ss[i]=(float)((Line)loi.elementAt(i)).anf.s;
					bs[i]=(float)((Line)loi.elementAt(i)).anf.b;
				}
				else
				{
					xs[i]=	(int)(((float)y-((Line)loi.elementAt(i)).anf.y)*
						(((Line)loi.elementAt(i)).end.x-((Line)loi.elementAt(i)).anf.x)/
						(((Line)loi.elementAt(i)).end.y-((Line)loi.elementAt(i)).anf.y)+
						((Line)loi.elementAt(i)).anf.x);
					hs[i]=	(((float)y-((Line)loi.elementAt(i)).anf.y)*
						((float)((Line)loi.elementAt(i)).end.h-((Line)loi.elementAt(i)).anf.h)/
						(((Line)loi.elementAt(i)).end.y-((Line)loi.elementAt(i)).anf.y)+
						((Line)loi.elementAt(i)).anf.h);
					ss[i]=	(((float)y-((Line)loi.elementAt(i)).anf.y)*
						((float)((Line)loi.elementAt(i)).end.s-((Line)loi.elementAt(i)).anf.s)/
						(((Line)loi.elementAt(i)).end.y-((Line)loi.elementAt(i)).anf.y)+
						((Line)loi.elementAt(i)).anf.s);
					bs[i]=	(((float)y-((Line)loi.elementAt(i)).anf.y)*
						((float)((Line)loi.elementAt(i)).end.b-((Line)loi.elementAt(i)).anf.b)/
						(((Line)loi.elementAt(i)).end.y-((Line)loi.elementAt(i)).anf.y)+
						((Line)loi.elementAt(i)).anf.b);
				}
			float help;	// zum merken
			for (int j=1;j<loi.size();j++)		//2004
				for(int i=1; i< loi.size();i++)		// sortieren
					if (xs[i]<xs[i-1])
					{
						help=(float)xs[i];	xs[i]=xs[i-1];	xs[i-1]=(int)help;
						help=hs[i];		hs[i]=hs[i-1];	hs[i-1]=help;
						help=ss[i];		ss[i]=ss[i-1];	ss[i-1]=help;
						help=bs[i];		bs[i]=bs[i-1];	bs[i-1]=help;
					}
			for (int i=1; i< xs.length;i+=2)
			{
				a.setPoint(xs[i-1],y);
				a.HSBColor(hs[i-1],ss[i-1],bs[i-1]);
				b.setPoint(xs[i],y);
				b.HSBColor(hs[i],ss[i],bs[i]);
				drawLine(a,b);
			}
			y-=1;		// weiter hoch
			for (int i=0; i < loi.size();i++)
				if ((int)((Line)loi.elementAt(i)).end.y ==y) 
				{
					loi.remove(i);i--;if ( i < 0) i=-1;
				}// entfernen uninteressanter lines
				if (y >= yMax)
					System.out.println("hier stimmt was nicht");
				for (int i=0; i < al.size();i++)	// hinzufgen interessanter lines
					if ((int)((Line)al.elementAt(i)).anf.y == y)
					{
						loi.addElement((Line)al.elementAt(i)/*!!*/);
						al.remove(i);i--;if (i < 0) i=-1;
					} // aufessen
			//else break;  // hier muss irgend was in der Reihenfolgen aufsteigend absteigend 
			//in al nicht stimmen
			//!! entfernen
			//!! hinzufgen
			//!! wegsortieren
			//System.exit(-4);
		}
	}
}
