import java.util.Random;

public class YravnCreater {
	private static int[] abc;
	private String yravnenie;
	
	
	public static int Discr(int a, int b ,int c) {
		return (int)((b*b) + ((-4)*a*c));
	}
	public static int okrugl(float inp) {
		int x = (int)inp;
		if(((float)x+0.5) <= inp) {
			return (x+1);
		}else return x;
		
	}
private static int[] createYravnPart1(int Dificult) {
	Random random = new Random();
	int[] abc = new int[3];
	abc[0] = 0;
	abc[1] = 0;
	abc[2] = 1;
	if(Dificult == 3) {
		
//		otvet ne celiy
		if(random.nextInt(4) == (2 & 1)) {
			System.out.println(" otvet ne celiy");
			while(Discr(abc[0], abc[1],abc[2]) < 0 || abc[0] == 0 || (float)Math.sqrt(Discr(abc[0], abc[1],abc[2]))%1 == 0) {
			int a = random.nextInt(25, 100);
		if(a%2 != 0) a = -a;
		abc[0] = a;
	
		int b = random.nextInt(50, 200);
		if(b%2 == 0) b = -b;
//		yravn += b + "x ";
		abc[1] = b;
//	}else yravn += "+ " + b + "x ";
	
		int c = random.nextInt(70, 250);
		if(c%3 == 0) c = -c;
		while((b*b) + (-4*a*c) < 0 ) {
		c = random.nextInt(70, 250);
			if(c%3 == 0) c = -c;
		
		abc[2] = c;
		}
			}
//		otvet celiy
	}else {
		System.out.println(" otvet celiy");
		while(abc[0] == 0 || Discr(abc[0], abc[1],abc[2]) < 0 || (float)Math.sqrt(Discr(abc[0], abc[1],abc[2]))%1 != 0) {
			
			abc[0] = random.nextInt(15, 40);
			if(abc[0] == 0) {abc[0] = random.nextInt(25, 100);}
			if(random.nextBoolean()== true) {abc[0] = -abc[0];}
			abc[1] = random.nextInt(50,200);
			abc[2] = random.nextInt(70,250);
			if(random.nextBoolean()== true) {abc[2] = -abc[2];}
		}
	}
	}else if(Dificult == 2) {

//		otvet ne celiy
		if(random.nextInt(4) == 0) {
			System.out.println(" otvet ne celiy");
			while(Discr(abc[0], abc[1],abc[2]) < 0 || abc[0] == 0 || (float)Math.sqrt(Discr(abc[0], abc[1],abc[2]))%1 == 0) {
			int a = random.nextInt(10, 60);
		if(a%2 != 0) a = -a;
		abc[0] = a;
	
		int b = random.nextInt(10, 50);
		if(b%2 == 0) b = -b;
//		yravn += b + "x ";
		abc[1] = b;
//	}else yravn += "+ " + b + "x ";
	
		int c = random.nextInt(30, 100);
		if(c%3 == 0) c = -c;
		while((b*b) + (-4*a*c) < 0 ) {
		c = random.nextInt(30, 100);
			if(c%3 == 0) c = -c;
		
		abc[2] = c;
		}
			}
//		otvet celiy
	}else {
		System.out.println(" otvet celiy");
		while(abc[0] == 0 || Discr(abc[0], abc[1],abc[2]) < 0 || (float)Math.sqrt(Discr(abc[0], abc[1],abc[2]))%1 != 0) {
			
			abc[0] = random.nextInt(15, 40);
			if(abc[0] == 0) {abc[0] = random.nextInt(15, 40);}
			if(random.nextBoolean()== true) {abc[0] = -abc[0];}
			abc[1] = random.nextInt(15, 50);
			abc[2] = random.nextInt(15, 60);
			if(random.nextBoolean()== true) {abc[2] = -abc[2];}
	}

		}
		System.out.println(Discr(abc[0], abc[1],abc[2]));	
	
//		sdelat chtobi on sozdaval podhodiashee yravnenie, a to shas besconechno sozdayot i ne mozet podobrat
	}else if(Dificult == 1) {

			while(Discr(abc[0], abc[1],abc[2]) < 0 || (float)Math.sqrt(Discr(abc[0], abc[1],abc[2]))%1 != 0 || abc[0] == 0) {
				abc[0] = random.nextInt(20);
				if(abc[0] == 0) {abc[0] = random.nextInt(20);}
				if(random.nextBoolean()== true) {abc[0] = -abc[0];}
				abc[1] = random.nextInt(20);
				abc[2] = random.nextInt(20);
				if(random.nextBoolean()== true) {abc[2] = -abc[2];}
			}
			System.out.println(Discr(abc[0], abc[1],abc[2]));
	}
	
	
	return abc;
}

private String createYravnPart2(int[] abc2) {
	String yravn = "";
	if(abc2[0] == 1) {
		yravn += "x^2 ";
	}else if(abc[0] == -1) {
		yravn += "-x^2 ";
	}else {
	yravn += abc2[0] + "x^2 ";
	}
	if(abc[1] == 0) {
		
	}else if(abc[1] < 0) {
		yravn += "- " + Math.abs(abc[1])  + "x ";
	}else {
		yravn += "+ " + abc[1] + "x ";
	}
	if(abc[2] == 0) {
		yravn += "= 0";
	}
	else if(abc[2] < 0) yravn += "- " + Math.abs(abc2[2]) + " = 0";
	else yravn += "+ " + abc[2] + " = 0";
	return yravn;
}
public String getYravnenie() {
	return this.yravnenie;
}
public int[] getABC() {
	return this.abc;
}
public void CreateNewYravn(int Dif) {
	abc = createYravnPart1(Dif);
	yravnenie = createYravnPart2(abc);
}
public void CreateNewVietaYravn(int Dif) {
	abc = createVietaYravnPart1(Dif);
	yravnenie = createYravnPart2(abc);
}
public void CreateNewABCYravn(int Dif) {
	abc = createABCYravnPart1(Dif);
	yravnenie = createABCYravnPart2(abc);
}
private static int[] createVietaYravnPart1(int Dificult) {
	Random random = new Random();
	int[] abc = new int[3];
	abc[0] = 1;
	abc[1] = 0;
	abc[2] = 1;
	if(Dificult == 1) {
	int x1 = random.nextInt(11);
	int x2 = random.nextInt(11);
	if(x1%2==0) {x1 = -x1;}
	if(x2%2==0) {x2 = -x2;}
	abc[1] = (-(x1+x2));
	abc[2] = (x1*x2);
	}else if(Dificult == 2) {
		int x1 = random.nextInt(21);
		int x2 = random.nextInt(21);
		if(x1%2==0) {x1 = -x1;}
		if(x2%2==0) {x2 = -x2;}
		abc[1] = (-(x1+x2));
		abc[2] = (x1*x2);
	}else if(Dificult == 3) {
		int x1 = random.nextInt(31);
		int x2 = random.nextInt(31);
		if(x1%2==0) {x1 = -x1;}
		if(x2%2==0) {x2 = -x2;}
		abc[1] = (-(x1+x2));
		abc[2] = (x1*x2);
	}
	return abc;
}
private static int[] createABCYravnPart1(int Dificult) {
	Random random = new Random();
	int[] abc = new int[3];
	abc[0] = 1;
	abc[1] = 0;
	abc[2] = 1;
	if(Dificult == 1) {
		abc[0] = random.nextInt(2, 50);
		if(random.nextBoolean() == true) {abc[0] = -abc[0];}
		abc[1] = random.nextInt( 50);
		if(random.nextBoolean() == true) {abc[1] = -abc[1];}
		abc[2] = random.nextInt( 50);
		if(random.nextBoolean() == true) {abc[2] = -abc[2];}
	}else if(Dificult == 2) {
		abc[0] = random.nextInt(2, 150);
		if(random.nextBoolean() == true) {abc[0] = -abc[0];}
		abc[1] = random.nextInt( 150);
		if(random.nextBoolean() == true) {abc[1] = -abc[1];}
		abc[2] = random.nextInt( 150);
		if(random.nextBoolean() == true) {abc[2] = -abc[2];}
	}else if(Dificult == 3) {
		abc[0] = random.nextInt(2, 1000);
		if(random.nextBoolean() == true) {abc[0] = -abc[0];}
		abc[1] = random.nextInt( 1000);
		if(random.nextBoolean() == true) {abc[1] = -abc[1];}
		abc[2] = random.nextInt( 1000);
		if(random.nextBoolean() == true) {abc[2] = -abc[2];}
	}
	return abc;
}
private String createABCYravnPart2(int[] abc2) {
	String yravn = "";
	Random random = new Random();
	
		if(random.nextBoolean() == true) {
		yravn += abc2[1] + "x";
		if(random.nextBoolean() == true) {
			if(abc[0] < 0) {
				yravn += "- " + Math.abs(abc[0])  + "x^2 ";
			}else {
				yravn += "+ " + abc[0] + "x^2 ";
			}
			if(abc[2] < 0) yravn += "- " + Math.abs(abc2[2]);
			else yravn += "+ " + abc[2] ;
		}else {
			if(abc[2] < 0) yravn += "- " + Math.abs(abc2[2]);
			else yravn += "+ " + abc[2];
			if(abc[0] < 0) {
				yravn += "- " + Math.abs(abc[0])  + "x^2 ";
			}else {
				yravn += "+ " + abc[0] + "x^2 ";
			}
		}
		
		
		
		
	}else {
		yravn +=  ""  + abc2[2];
		if(random.nextBoolean() == true) {
			if(abc[1] < 0) {
				yravn += "- " + Math.abs(abc[1])  + "x ";
			}else {
				yravn += "+ " + abc[1] + "x ";
			}
			if(abc[0] < 0) {
				yravn += "- " + Math.abs(abc[0])  + "x^2 ";
			}else {
				yravn += "+ " + abc[0] + "x^2 ";
			}
		}else {
			if(abc[0] < 0) {
				yravn += "- " + Math.abs(abc[0])  + "x^2 ";
			}else {
				yravn += "+ " + abc[0] + "x^2 ";
			}
			if(abc[1] < 0) {
				yravn += "- " + Math.abs(abc[1])  + "x ";
			}else {
				yravn += "+ " + abc[1] + "x ";
			}
		}
	}
	yravn += " = 0";
	return yravn;
}
}
