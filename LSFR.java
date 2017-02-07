import java.util.*;

public class LSFR {

	private int lsfr;
	private int tapPosition;
	private int lsfrLength;
	
	public LSFR(String seed, int tapPosition) throws Exception{

		// Check if seed is null
		if ( seed == null || seed.equals("")) {
			throw new RuntimeException("Seed is null, please specify a seed as a String!");
		}

		// Check if position is valid
		if( tapPosition > seed.length() ) {
			throw new RuntimeException("Given Tap Position invalid for seed!");
		}

		// Check if seed numbers are valid
		for( int i = 0; i < seed.length(); i++ ) {
			char num = seed.charAt(i);
			if( num != '0' && num != '1' ) {
				throw new RuntimeException("Seed has invalid number at position: " + i);
			}
		}
		lsfrLength = seed.length();
		this.lsfr = Integer.parseInt(seed, 2);
		//System.out.println(this.lsfr);
		this.tapPosition = tapPosition;

	}

	public String toString() {

		return Integer.toBinaryString(lsfr);

	}

	public int getTapPosition() {

		return tapPosition;
	}

	public int nextBit() {
		lsfr = lsfr << 1;
		lsfr = lsfr | (msb ^ tapPosition);
		lsfr = lsfr | 
		System.out.println(this);
		return 0;
	}

	public static void main(String[] args) {
		try {
			LSFR lsfr = new LSFR("1010", 4);
			System.out.println(lsfr);
			lsfr.nextBit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}