class MoneyFormat 
{
	public static void main(String[] args) 
	{
		System.out.println(digitUppercase(14000090.23));
		
	}
	private static final String UNIT[] ={"��","ǧ","��","ʰ","��","ǧ","��","ʰ","��","ǧ","��","ʰ","��","ǧ","��","ʰ","Ԫ","��","��"};
     private static final String NUM[]={"��","Ҽ","��","��","��","��","½","��","��","��"};
	 private static final double MAX_VALUE=9999999999999.99;
	 public static String digitUppercase(double money){
	    if(money<0 || money>  MAX_VALUE)
			return "�����Ƿ�!";
		long money1=Math.round(money*100);//�������뵽��
		if(money1==0)
			return "��Ԫ��";
		String strMoney=String.valueOf(money1);
		int numIndex=0;  //����ѡ������ֵ
		int unitIndex = UNIT.length-strMoney.length();//����ѡ���λ
		boolean isZero=false;//�жϵ�ǰ�Ƿ�Ϊ��
		String result="";
		for(;numIndex<strMoney.length(); numIndex++, unitIndex++){
		      char num=strMoney.charAt(numIndex);
			  if(num=='0'){
			  isZero=true;
			  if(UNIT[unitIndex]=="��"|| UNIT[unitIndex]=="��" ||
                  UNIT[unitIndex]=="Ԫ"){
				  result=result+ UNIT[unitIndex]; //���뵥λ�ڣ���Ԫ
					   isZero=false;
				  }
			  }else{
			  if(isZero){
			  result=result+"��";
			  isZero=false;
			  }
			  result=result+NUM[Integer.parseInt(String.valueOf(num))]+ UNIT[unitIndex];
			  }//else
		}
	 
	 //���ǽǷֽ�β�ͼӡ�������
	 if(!result.endsWith("��")&&!result.endsWith("��")){
	       result=result+"��";}
		   result=result.replaceAll("����","��");
		   return result;
	 }

}
