public class Day2 {
	public int romanToInt(String s) {
        int num=0;
       String[] roman=s.split("");
        for(int i=0; i<roman.length; i++){
        	if (roman[i].equals("I") || roman[i].equals("i")) {
        		 num += 1;
            } else if (roman[i].equals("V") || roman[i].equals("v")) {
            	num += 5;
            	if(i>0) {
            	if(roman[i-1].equals("I") || roman[i-1].equals("i")) {
        			num-=2;
            		}
        		}
            } else if (roman[i].equals("X") || roman[i].equals("x")) {
                num += 10;
                if(i>0) {
                if(roman[i-1].equals("I") || roman[i-1].equals("i")) {
        			num-=2;
                	}
        		}
            } else if (roman[i].equals("L") || roman[i].equals("l")) {
                num += 50;
                if(i>0) {
                if(roman[i-1].equals("X") || roman[i-1].equals("x")) {
        			num-=20;
                	}
        		}
            } else if (roman[i].equals("C") || roman[i].equals("c")) {
                num += 100;
                if(i>0) {
                if(roman[i-1].equals("X") || roman[i-1].equals("x")) {
        			num-=20;
        			}
                }
            } else if (roman[i].equals("D") || roman[i].equals("d")) {
                num += 500;
                if(i>0) {
                if(roman[i-1].equals("C") || roman[i-1].equals("C")) {
        			num-=200;
        			}
                }
            } else if (roman[i].equals("M") || roman[i].equals("m")) {
                num += 1000;
                if(i>0) {
                if(roman[i-1].equals("C") || roman[i-1].equals("c")) {
        			num-=200;
        		}
                }
            } else {
                num += 0;
            }
        }
        return num;
    }
	public static void main(String[] args) {
		Day2 day2 = new Day2();
		int num = day2.romanToInt("xl");
		System.out.println(num);
		

	}

}