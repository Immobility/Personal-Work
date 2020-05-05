public class F5
{
	public static void main(String[] args)
	{
		boolean found = false;
		for (i = 1, i <= n; i++) 
		{
			int counter = 0;
			for (j = 1; j <= n; j++) 
			{
				if (x[i][j] == 0)
				counter++;
			}
			
			if (counter == n && found == false) 
			{
				printf(“First all­zero row is: %d”, i);
				found = true;
			}
		}
	}
}