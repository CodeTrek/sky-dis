package oss.jcg.disviz.math;


public class DegMinSecsConversion
{

	public static void toDecimal(String degMinSec, float lat[], float lon[])
	{
		String degString;
		String minuteString;
		String secondString;
		char[] degLat = new char[2];
		char[] minuteLat = new char[2];
		char[] secondLat = new char[2];
		char[] degLon = new char[3];
		char[] minuteLon = new char[2];
		char[] secondLon = new char[2];
		
		int degIntLat = 0;
		int minuteIntLat = 0;
		int secondIntLat = 0;
		int degIntLon = 0;
		int minuteIntLon = 0;
		int secondIntLon = 0;
		int signLat = 1;
		int signLon = 1;

		if (degMinSec.charAt(3) == 'M')
		{
			// no seconds involved. Only degrees and minutes

			// Longitude Degrees value less than 100?

			if (degMinSec.length() < 16)
			{
				degLat[0] = degMinSec.charAt(5);
				degLat[1] = degMinSec.charAt(6);
				degString = String.valueOf(degLat);
				degIntLat = Integer.parseInt(degString);

				if (degMinSec.charAt(9) == 'S')
					signLat  = -1;

				minuteLat[0] = degMinSec.charAt(7);
				minuteLat[1] = degMinSec.charAt(8);
				minuteString = String.valueOf(minuteLat);
				minuteIntLat = Integer.parseInt(minuteString);

				degLon[0] = '0';
				degLon[1] = degMinSec.charAt(10);
				degLon[2] = degMinSec.charAt(11);
				degString = String.valueOf(degLon);
				degIntLon = Integer.parseInt(degString);

				if (degMinSec.charAt(14) == 'W')
					signLon  = -1;

				minuteLon[0] = degMinSec.charAt(12);
				minuteLon[1] = degMinSec.charAt(13);
				minuteString = String.valueOf(minuteLon);
				minuteIntLon = Integer.parseInt(minuteString);

			}
			else if (degMinSec.length() < 17)
			{
				// Longitude Degrees value over 100.

				degLat[0] = degMinSec.charAt(5);
				degLat[1] = degMinSec.charAt(6);
				degString = String.valueOf(degLat);
				degIntLat = Integer.parseInt(degString);

				if (degMinSec.charAt(9) == 'S')
					signLat  = -1;

				minuteLat[0] = degMinSec.charAt(7);
				minuteLat[1] = degMinSec.charAt(8);
				minuteString = String.valueOf(minuteLat);
				minuteIntLat = Integer.parseInt(minuteString);

				degLon[0] = degMinSec.charAt(10);
				degLon[1] = degMinSec.charAt(11);
				degLon[2] = degMinSec.charAt(12);
				degString = String.valueOf(degLon);
				degIntLon = Integer.parseInt(degString);

				if (degMinSec.charAt(15) == 'W')
					signLon  = -1;

				minuteLon[0] = degMinSec.charAt(13);
				minuteLon[1] = degMinSec.charAt(14);
				minuteString = String.valueOf(minuteLon);
				minuteIntLon = Integer.parseInt(minuteString);
			}
		}
		if (degMinSec.charAt(3) == 'S')
		{
			// degrees, minutes and seconds

			// Longitude Degrees value less than 100?

			if (degMinSec.length() < 20)
			{
				degLat[0] = degMinSec.charAt(5);
				degLat[1] = degMinSec.charAt(6);
				degString = String.valueOf(degLat);
				degIntLat = Integer.parseInt(degString);

				if (degMinSec.charAt(11) == 'S')
					signLat  = -1;

				minuteLat[0] = degMinSec.charAt(7);
				minuteLat[1] = degMinSec.charAt(8);
				minuteString = String.valueOf(minuteLat);
				minuteIntLat = Integer.parseInt(minuteString);

				secondLat[0] = degMinSec.charAt(9);
				secondLat[1] = degMinSec.charAt(10);
				secondString = String.valueOf(secondLat);
				secondIntLat = Integer.parseInt(secondString);

				degLon[0] = '0';
				degLon[1] = degMinSec.charAt(12);
				degLon[2] = degMinSec.charAt(13);
				degString = String.valueOf(degLon);
				degIntLon = Integer.parseInt(degString);

				if (degMinSec.charAt(18) == 'W')
					signLon  = -1;

				minuteLon[0] = degMinSec.charAt(14);
				minuteLon[1] = degMinSec.charAt(15);
				minuteString = String.valueOf(minuteLon);
				minuteIntLon = Integer.parseInt(minuteString);

				secondLon[0] = degMinSec.charAt(16);
				secondLon[1] = degMinSec.charAt(17);
				secondString = String.valueOf(secondLon);
				secondIntLon = Integer.parseInt(secondString);
			}
			else if (degMinSec.length() < 21)
			{
				// Longitude Degrees value over 100.

				degLat[0] = degMinSec.charAt(5);
				degLat[1] = degMinSec.charAt(6);
				degString = String.valueOf(degLat);
				degIntLat = Integer.parseInt(degString);

				if (degMinSec.charAt(11) == 'S')
					signLat  = -1;

				minuteLat[0] = degMinSec.charAt(7);
				minuteLat[1] = degMinSec.charAt(8);
				minuteString = String.valueOf(minuteLat);
				minuteIntLat = Integer.parseInt(minuteString);

				secondLat[0] = degMinSec.charAt(9);
				secondLat[1] = degMinSec.charAt(10);
				secondString = String.valueOf(secondLat);
				secondIntLat = Integer.parseInt(secondString);

				degLon[0] = degMinSec.charAt(12);
				degLon[1] = degMinSec.charAt(13);
				degLon[2] = degMinSec.charAt(14);
				degString = String.valueOf(degLon);
				degIntLon = Integer.parseInt(degString);

				if (degMinSec.charAt(19) == 'W')
					signLon  = -1;

				minuteLon[0] = degMinSec.charAt(15);
				minuteLon[1] = degMinSec.charAt(16);
				minuteString = String.valueOf(minuteLon);
				minuteIntLon = Integer.parseInt(minuteString);

				secondLon[0] = degMinSec.charAt(17);
				secondLon[1] = degMinSec.charAt(18);
				secondString = String.valueOf(secondLon);
				secondIntLon = Integer.parseInt(secondString);
			}

		}

		lat[0] = (float) (signLat*((double)degIntLat + (double)minuteIntLat/60. + (double)secondIntLat/6000.));
		lon[0] = (float) (signLon*((double)degIntLon + (double)minuteIntLon/60. + (double)secondIntLon/6000.));

		int intLat = (int)(lat[0]*10000.);
		lat[0] = intLat*(float)0.0001;
	  int intLon = (int)(lon[0]*10000.);
		lon[0] = intLon*(float)0.0001;
		
		return;
	}
//	
//	public static void main(String[] args)
//	{
//
//		// command line input: One line from string of lats and lons in ACO table. 9/18/08. PM
//		
//		
//		Scanner keyboard = new Scanner (System.in);
//
//		String degMinSec;
//		Geodetic degDecimal;
//
//		while (true)
//		{
//			// Use Ctrl-C to quit
//			System.out.println("Enter string of Lats and Lons in Deg Min Secs from ACO table: ");
//			degMinSec = keyboard.nextLine();
//			
//			if (degMinSec.length() < 1)
//				continue;
//			
//			String latLon[] = degMinSec.split(";");
//
//			float lat = 0;
//			float lon = 0;
//			
//			for (int i = 0; i < latLon.length; i++)
//			{
//				toDecimal(latLon[i], lat, lon);
//				
//				System.out.println("  Lat         Lon: ");
//				System.out.println(lat + "     " + lon);
//				System.out.println();
//			}
//		}
//	}
}
