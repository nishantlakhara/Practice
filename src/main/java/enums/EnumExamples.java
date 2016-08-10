package enums;

public class EnumExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExpirationTime et = ExpirationTime.EXPIRATION_TIME_8;
		
		
		ExpirationTime[] et1 = ExpirationTime.values();
		for(int i=1 ; i<et1.length-1 ; i++) {
			System.out.println(et1[i].value);
		}

	}
	
	public enum ExpirationTime {
		EXPIRATION_TIME_0(0 , 0),
		EXPIRATION_TIME_1(1 , 1),
		EXPIRATION_TIME_2(2 , 2),
		EXPIRATION_TIME_3(3 , 3),
		EXPIRATION_TIME_4(7 , 4),
		EXPIRATION_TIME_5(15 , 5),
		EXPIRATION_TIME_6(30 , 6),
		EXPIRATION_TIME_7(60 , 7),
		EXPIRATION_TIME_8(-1 , 8);
		
		private int value;
		private int status;

        private ExpirationTime(int value , int status) {
                this.value = value;
                this.status = status;
        }
    }

}
