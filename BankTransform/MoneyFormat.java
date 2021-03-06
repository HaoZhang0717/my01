class MoneyFormat 
{
	public static void main(String[] args) 
	{
		System.out.println(digitUppercase(14000090.23));
		
	}
	private static final String UNIT[] ={"万","千","佰","拾","亿","千","佰","拾","万","千","佰","拾","万","千","佰","拾","元","角","分"};
     private static final String NUM[]={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	 private static final double MAX_VALUE=9999999999999.99;
	 public static String digitUppercase(double money){
	    if(money<0 || money>  MAX_VALUE)
			return "参数非法!";
		long money1=Math.round(money*100);//四舍五入到分
		if(money1==0)
			return "零元整";
		String strMoney=String.valueOf(money1);
		int numIndex=0;  //用于选择金额数值
		int unitIndex = UNIT.length-strMoney.length();//用于选择金额单位
		boolean isZero=false;//判断当前是否为零
		String result="";
		for(;numIndex<strMoney.length(); numIndex++, unitIndex++){
		      char num=strMoney.charAt(numIndex);
			  if(num=='0'){
			  isZero=true;
			  if(UNIT[unitIndex]=="亿"|| UNIT[unitIndex]=="万" ||
                  UNIT[unitIndex]=="元"){
				  result=result+ UNIT[unitIndex]; //补齐单位亿，万，元
					   isZero=false;
				  }
			  }else{
			  if(isZero){
			  result=result+"零";
			  isZero=false;
			  }
			  result=result+NUM[Integer.parseInt(String.valueOf(num))]+ UNIT[unitIndex];
			  }//else
		}
	 
	 //不是角分结尾就加“整”字
	 if(!result.endsWith("角")&&!result.endsWith("分")){
	       result=result+"整";}
		   result=result.replaceAll("亿万","亿");
		   return result;
	 }

}

