package devops.numbers;

public class NumberWords {
	
	String gap[] = {"ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninty","hundread"};
	String num[] = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","ninteen","twenty"};
	String Arr[] = {"ten","hundred","thousand","lakh","carore","arab","kharab"};

	public String toWords( int number ) {
		String result = "" ;
		if(number > 0) {
			
			result = solver(number);
		} else if(number == 0){
			result = "zero";
		} else {
			result = "Number is -ve or 0";
		}
		return result.trim() ;
	}
	
	public static int getCount(int mynum) {
	    int count = 0;
	    while(mynum > 0) {
	        count++;
	        mynum /= 10;
	    }
	    return count;
	}
	public String solver(int mynum) {
	    int count = getCount(mynum);
	    String answer = "";
	    int multiplier = 1,div = 1,remainder;
	    for(int j = 0 ; j <(count - 1) ; j++) {
	        multiplier *=10;
	    }
	    int tmp;
	    if(count == 1 || (mynum > 0 && mynum < 20)) {
	            answer +=(num[mynum - 1]);
	    }
	    else if(count == 2) {
	        while(div > 0) {

	            div = (mynum)/ (multiplier);
	            remainder = mynum % multiplier;

	            if(div >  0) {
	                answer +=gap[div - 1] ;
	                answer+=" ";
	            }
	            if(remainder > 0) {
	                answer +=num[remainder - 1];
	            }
	            div /= 10;
	        }
	    }
	    else {
	        int l_count = count;
	        while(multiplier > 0) {

	            div = (mynum)/ (multiplier);
	            remainder = mynum % multiplier;

	            if(l_count > 4) {
	                if(l_count % 2 == 1) {
	                	if(div > 0) {
	                		answer +=" "+gap[div - 1];
	                		multiplier = multiplier / 10;
	                		if(remainder/multiplier > 0)
	                			answer +=" "+num[ (remainder / multiplier) - 1];
	                		remainder %= multiplier ;
	                		l_count -= 1;
	                		answer +=" "+Arr[l_count - 2];
	                	}
	                }
	                else {
	                    if(div > 0) {
	                    	answer +=" "+num[div - 1];
	                    	tmp =l_count  - 1;
	                    	answer +=" "+Arr[tmp - 2];
	                    }
	                }
	            }
	            else if(l_count > 2) {
	              if(div > 0) {
	                answer +=" "+num[div - 1];
	                answer +=" "+Arr[l_count  - 2];
	              } 
	            }
	            else if(l_count == 2 && mynum > 20) {
	                if(div > 0) {
	                	answer +=" " +gap[div - 1];
	                }
	            }

	            else if(l_count == 1 || (mynum >0 && mynum <=20)) {
	               if(mynum >  0) {
	            	   answer +=" "+num[mynum - 1];
	            	   multiplier = 0;
	               }
	            }
	            mynum = remainder;
	            multiplier /= 10;
	            l_count--;
	        }
	    }
	   // System.out.print("output ="+answer);
	    return answer;
	}

}
