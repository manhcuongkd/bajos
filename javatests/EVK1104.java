/*
* FHW-Berlin, Fachbereich Berufsakademie, Fachrichtung Informatik
* See the file "license.terms" for information on usage and redistribution of this file.
*/


public class EVK1104			{
	public static void main(String [] args)		{
	char c;
	int n=0;
for (n=0; n < 20; n++)
    System.out.println("a "+n+" b");

	// not q!!!
	System.out.println("currentTimeMillis Test, type any key -> e for end");
	while ((c=System.in.read())!='e') System.out.println(System.currentTimeMillis());
	System.out.println("currentTimeMillis Test in a \"for loop\"");
	for (c=0; c < 4; c++)	System.out.println(System.currentTimeMillis());
}
}


