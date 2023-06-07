public class Day7 {
	public static String timeConversion(String s) {
	    // Write your code here
	    String time[] = s.split(":");
	     int hours = Integer.parseInt(time[0]);
	    String minutes = time[1];
	    String seconds = time[2].substring(0, 2);
	    String ampm = time[2].substring(2);
	    String format="";
	        if (ampm.equals("AM")) {
	            if(hours==12){
	                format="00:"+minutes+":"+seconds;
	            }else{
	            	String hrs = (hours<10)?"0":"";
	                format=hrs+hours+":"+minutes+":"+seconds;
	            }//nested
	        }else if (ampm.equals("PM")){
	        	hours +=(hours==12)?0:12;
	            format=hours+":"+minutes+":"+seconds;
	        }else{
	            format=hours+":"+minutes+":"+seconds;
	        }
	    return format;
	    }

	public static void main(String[] args) {
		Day7 day7 = new Day7();
		String time = "06:40:03AM";
		String result=day7.timeConversion(time);
		System.out.println(result);
	}

}
