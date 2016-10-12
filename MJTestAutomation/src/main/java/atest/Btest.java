package atest;

public class Btest
{


	public static void main(final String[] args)
	{
		final String t = "a;b;c";
		final String[] strA = t.split(";");

		for (int i = 0; i < strA.length; i++)
		{
			System.out.println(strA[i]);
		}
		System.out.println("Last:" + strA[strA.length - 1]);

	}
}
