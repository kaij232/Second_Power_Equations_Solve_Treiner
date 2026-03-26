import java.util.regex.Pattern;
//import java.util.regex.PatternSyntaxException;

public class WorkWithResults {
private static int GetN_1(String res1) {
	int result = 0;
	
	return result;
}
public static int Discr(int a, int b, int c) {
	return ((b*b)+(-4*a*c));
}

//prevrashaet stroku otveta polzovatela v int
public static int ConvertUserResToInt(String userRes) {
	try {
		return Integer.parseInt(userRes);
		
	}catch(NumberFormatException e) {
		
		try{
			return (Integer.parseInt(userRes.split(Pattern.quote("+"))[0]) + (int)Math.sqrt(Integer.parseInt(userRes.split(Pattern.quote("+sqrt("))[1].split(Pattern.quote(")"))[0])));
		
		}catch(NumberFormatException e1) {
		
			try {
//				if(userRes[0] == Pattern.quote("-")) {
				if(userRes.split(Pattern.quote("-"))[0] == "") {
					return (-Integer.parseInt(userRes.split(Pattern.quote("-"))[1].split(Pattern.quote("-"))[0]) - (int)Math.sqrt(Integer.parseInt(userRes.split(Pattern.quote("-sqrt("))[1].split(Pattern.quote(")"))[0])));
				}else{
				return (Integer.parseInt(userRes.split(Pattern.quote("-"))[0]) - (int)Math.sqrt(Integer.parseInt(userRes.split(Pattern.quote("-sqrt("))[1].split(Pattern.quote(")"))[0])));
				}
//				}
			}catch(NumberFormatException e3) {
				
				return 987654321;
			}catch(ArrayIndexOutOfBoundsException e4) {
			return 987654321;	
			}
		}
	}
}

//proveriaet est li koren
public static boolean SQRTisReal(int a, int b, int c) {
	if((Math.sqrt(Discr(a,b,c)))%1 == 0) {
		return false;
	}else return true;
}
//  otveta so znakom +
public static String GetRes1(int a,int b,int c, boolean reQT) {
	String res = "";
	if(reQT == false) {
		res = "" + (-b + Math.sqrt(Discr(a,b,c)));
		return res;
	}else {
		res = "" + (-b) + "+sqrt(" + Discr(a,b,c) + ")";
		return res;
	}

}
//poluchit otvet chisitel 1 drobi int
public static int GetRes1_1(int a, int b, int c) {
	int res = 0;
//	if(mainVietaWindow.getSwitchResButtonType(0) == "Целое"){
//	res += -b + Math.sqrt(Discr(a,b,c));}
//	else {
		res +=(-b + Math.sqrt(Discr(a,b,c)))/(a*2);
//	}
	return res;
}

//poluchit otvet chisitel 2 drobi int
public static int GetRes1_2(int a, int b, int c) {
	int res = 0;
//	if(mainVietaWindow.getSwitchResButtonType(1) == "Целое"){
//		res += -b - Math.sqrt(Discr(a,b,c));}
//		else {
			res +=(-b - Math.sqrt(Discr(a,b,c)))/(a*2);
//		}
	return res;
}

// proverka res1
private static boolean check1Res(int a, int b, int c,boolean reQT,  String UsRes) {
		if(GetRes1(a,b,c ,reQT) == UsRes) return true;
		else return false;
	}
// chislitel otveta so znakom -
public static String GetRes2(int a,int b,int c, boolean reQT) {
	String res = "";
	if(reQT == false) {
		res = "" + (-b - Math.sqrt(Discr(a,b,c)));
		return res;
	}else {
		res = "" + (-b) + "-sqrt(" + Discr(a,b,c) + ")";
		return res;
	}
	
}
public static String GetRes3(int a) {
	return ""+(2*a);
}
public static String GetRes4(int a) {
	return ""+(2*a);
}
}
