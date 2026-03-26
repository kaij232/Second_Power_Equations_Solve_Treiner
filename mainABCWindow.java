import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class mainABCWindow {
	
	YravnCreater yravn = new YravnCreater();
	JLabel StrokaYravn;
	static int schot = 0;
	static int resheno = 0;
	static int oshibok = 0;
	JButton Podtv = new JButton("Проверить");
	JButton GoBackButt = new JButton("Вернуться");
	static JButton[]  SwitchRes = new JButton[2];
	JTextField otvA = new JTextField();
	JTextField otvB = new JTextField();
	JTextField otvC = new JTextField();
	JLabel nekorOtv = new JLabel("Ответ дан некорректно");
	JLabel nepravOtv = new JLabel("Ответ неверный");
	JLabel oshib = new JLabel("");
	JLabel resh = new JLabel();
	JLabel schotJL = new JLabel();
	
	public static JFrame ABCw = new JFrame("Решение квадратных уравнений через теорему Виета");
	GridBagConstraints constr = new GridBagConstraints(); 
	Container container = new Container();
	
	
	
	
public mainABCWindow() {
	
	oshib.setText("" + oshibok);
	
	constr.fill = GridBagConstraints.HORIZONTAL;
	container.setLayout(new GridBagLayout());
	
	Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	
//	knopka vozvrata
	constr.gridx = 0;
	constr.gridy = 0;
	constr.insets = new Insets(0,10,50,50);
	GoBackButt.addActionListener(new BackActionListener());
	GoBackButt.setBackground(new Color(72, 201, 176));
	container.add(GoBackButt, constr);
	
//	Schot
//	constr.insets = null;
	constr.insets = new Insets(40,70,0,0);
//	constr.insets = new Insets(40,0,0,0);
	constr.gridwidth = 1;
	constr.gridx = 1;
	constr.gridy = 0;
	schotJL = new JLabel("Счёт: " + schot);
	schotJL.setFont(new Font("LucidaSans", Font.BOLD, 16));
	schotJL.setHorizontalTextPosition(SwingConstants.CENTER);
	container.add(schotJL, constr);
	
	constr.insets.set(0, 0, 0, 0);
	constr.gridx = 0;
	constr.gridy = 1;
	container.add(new JLabel("."), constr);
	
////	Yravnenie
//	constr.gridheight = 1;
//	constr.gridx = 1;
//	constr.gridy = 2;
//	container.add(StrokaYravn,constr);
	
	//	vivedenie nepravilnogo otveta
	nepravOtv.setFont(new Font("LucidaSans", Font.BOLD, 14));
	nepravOtv.setVisible(false);
	nekorOtv.setVisible(false);
	constr.gridy = 3;
	constr.gridx = 1;
	container.add(nekorOtv,constr);
	container.add(nepravOtv,constr);
	
//	otveti polzovatela
	constr.gridy = 4;
	constr.gridx = 0;
	container.add(new JLabel("A = "),constr);
	constr.insets.set(0, 0, 0, 0);
	
	
	constr.insets.set(0, 30, 0, 0);
	constr.gridx = 0;
	otvA.setBorder(raisedbevel);
	container.add(otvA,constr);
	constr.insets.set(0, 0, 0, 0);
	
	constr.gridx = 1;
	container.add(new JLabel("B = "),constr);
	constr.insets.set(0, 0, 0, 0);
	
	constr.gridx = 1;
	otvB.setBorder(raisedbevel);
	constr.insets.set(0, 30, 0, 0);
	container.add(otvB,constr);  
	constr.insets.set(0, 0, 0, 0);
	
	constr.gridx = 3;
	container.add(new JLabel("C = "),constr);
	constr.insets.set(0, 0, 0, 0);
	
	constr.gridx = 4;
	constr.insets.set(0, 0, 0, 0);
	otvC.setBorder(raisedbevel);
	container.add(otvC,constr); 
	constr.insets.set(0, 0, 0, 0);
	

	
	
//	stroka informazii
	constr.insets.set(10, 0, 0, 0);
constr.gridx = 0;
constr.gridy = 7;
container.add(new JLabel("Решено: "),constr);

resh = new JLabel("" + resheno);
resh.setFont(new Font("LucidaSans", Font.BOLD, 16));
resh.setHorizontalTextPosition(SwingConstants.CENTER);
resh.setBorder(raisedbevel);
constr.gridx = 1;
container.add(resh, constr);

constr.gridx = 3;
container.add(new JLabel(".       ."), constr);

constr.gridx = 4;
container.add(new JLabel("Ошибок: "), constr);


oshib.setBorder(raisedbevel);
oshib.setFont(new Font("LucidaSans", Font.BOLD, 16));
oshib.setHorizontalTextPosition(SwingConstants.CENTER);
constr.gridx = 5;
container.add(oshib,constr);

Podtv.addActionListener(new PClickListener());
Podtv.setBackground(new Color(72, 201, 176));
constr.gridx = 6;
container.add(Podtv,constr);

constr.insets.set(0, 0, 0, 0);

	
	ABCw.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	ABCw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ABCw.setBounds(300, 100, 700, 500);
	ABCw.getContentPane().setBackground(new Color(0, 250, 154));
	ABCw.add(container);
}

//Yravnenie
public void addYravn() {
constr.gridheight = 1;
constr.gridx = 1;
constr.gridy = 2;
container.add(StrokaYravn,constr);
}
public static String getSwitchResButtonType(int i) {
	return SwitchRes[i].getText();
}
class PClickListener implements ActionListener{
	//Proverka podstanokoy
	
private boolean CheckReses() {
	if(WorkWithResults.ConvertUserResToInt(otvA.getText()) == yravn.getABC()[0] && WorkWithResults.ConvertUserResToInt(otvB.getText()) == yravn.getABC()[1] && WorkWithResults.ConvertUserResToInt(otvC.getText()) == yravn.getABC()[2]) {
		return true;
	}else return false;
}
@Override
	public void actionPerformed(ActionEvent e) {
			int a = yravn.getABC()[0];
			int b = yravn.getABC()[1];
			int c = yravn.getABC()[2];
			if (CheckReses() == false) {
				
				nepravOtv.setVisible(true);
				
				oshibok++;
				oshib.setText("" + oshibok);
				
				schot--;
				schotJL.setText("Счёт: " + schot);
				}else {
				nepravOtv.setVisible(false);
				
				resheno ++;
				resh.setText("" + resheno);
				
				schot += Window.Dif.getValue();
				schotJL.setText("Счёт: " + schot);
				
				otvA.setText(null);
				otvB.setText(null);
				otvC.setText(null);

				
				yravn.CreateNewVietaYravn(Window.Dif.getValue());
				StrokaYravn.setText("" + yravn.getYravnenie());
				
			}
			
			
			}

}
class BackActionListener implements ActionListener {
	@Override
public void actionPerformed(ActionEvent e) {
//		yravn = null;
		
		schot--;
		schotJL.setText("Счёт: " + schot);
		
		otvA.setText(null);
		otvB.setText(null);
		otvC.setText(null);
//		otv2_2User.setText(null);
//		otv1_UserCeloe.setText(null);
//		otv2_UserCeloe.setText(null);
		
		StrokaYravn.setVisible(false);
		StrokaYravn = new JLabel("");
	Window.jf.setVisible(true);
	mainABCWindow.ABCw.hide();
	
}
}

public int Discr(int a, int b, int c) {
	return (int)((a*a)-(4*a*c));
	}
	
	}
////	proverka otveta
//private boolean checkResX(int a, int b, int c, int resNumber) {
//	
//		if(SwitchRes[0].getText() == "Целое" && SwitchRes[1].getText() == "Целое") {
//			
//	if(resNumber == 1) {
//		
//			if(YravnCreater.Discr(a, b, c) == 0) {
//				if(( ((int)WorkWithResults.GetRes1_1(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_1User.getText()))
//						&& (int)WorkWithResults.GetRes1_2(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_1User.getText())))) &&
//						((int)WorkWithResults.GetRes1_1(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_2User.getText()))
//						&& (int)WorkWithResults.GetRes1_2(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_2User.getText()))) &&
//						(2*a == SocrZnam(Integer.parseInt(otv2_1User.getText()),(int)WorkWithResults.ConvertUserResToInt(otv1_1User.getText()) ) || 2*a == SocrZnam(Integer.parseInt(otv2_2User.getText()), (int)WorkWithResults.ConvertUserResToInt(otv1_2User.getText())))) {
//					return true;
//				}else return false;
//			}else {
//		
//			if(((int)WorkWithResults.GetRes1_1(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_1User.getText())) &&
//					(int)WorkWithResults.GetRes1_2(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_2User.getText()))) || 
//					((int)WorkWithResults.GetRes1_1(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_2User.getText())) &&
//					(int)WorkWithResults.GetRes1_2(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_1User.getText())))) {
////					if(WorkWithResults.GetRes1_2(a,b,c) != WorkWithResults.ConvertUserResToInt(otv1_2User.getText())) {
////						return false;
////						
////					}else return true;
//					return true;
//			}else return false;
//			}
////	}else if(resNumber == 2) {
////		if(WorkWithResults.GetRes1_2(a,b,c) == WorkWithResults.ConvertUserResToInt(otv1_2User.getText())) {
//////			if(WorkWithResults.GetRes1_1(a,b,c) != WorkWithResults.ConvertUserResToInt(otv1_1User.getText())) {
//////				return false;
//////				
//////			}else return true;
////			return true;
//////			razobratsy s otvetmi, a to oni opyat wsegdaa nevernie
////	}else return false;
//			
//			
//	}else if(resNumber == 3 || resNumber == 4) {
//			if(2*a != SocrZnam(Integer.parseInt(otv2_1User.getText()), (int)WorkWithResults.ConvertUserResToInt(otv1_1User.getText())) || 2*a != SocrZnam(Integer.parseInt(otv2_2User.getText()), (int)WorkWithResults.ConvertUserResToInt(otv1_2User.getText()))) {
//				return false;
//			}else return true;
//			
//	}else return false;
//
//			
//	}
//		else if(SwitchRes[0].getText() == "Целое" && SwitchRes[1].getText() != "Целое") {
//			if(resNumber == 1) {
//				
//				if(YravnCreater.Discr(a, b, c) == 0) {
//					if( (((int)WorkWithResults.GetRes1_1(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_1User.getText()))
//							&& (int)WorkWithResults.GetRes1_2(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_1User.getText())))&&
//							(int)WorkWithResults.GetRes1_1(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv2_UserCeloe.getText())
//							&& (int)WorkWithResults.GetRes1_2(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv2_UserCeloe.getText())) &&
//							(2*a == SocrZnam(Integer.parseInt(otv2_1User.getText()), (int)WorkWithResults.ConvertUserResToInt(otv1_1User.getText())))) {
//						return true;
//					}else return false;
//					
//				}else {
//			
//				if(((int)WorkWithResults.GetRes1_1(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_1User.getText())) &&
//						(int)WorkWithResults.GetRes1_2(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv2_UserCeloe.getText())) || 
//						((int)WorkWithResults.GetRes1_2(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_1User.getText())) &&
//						(int)WorkWithResults.GetRes1_1(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv2_UserCeloe.getText()))) {
//
//						return true;
//				}else return false;
//				}
//			}else if(resNumber == 3 || resNumber == 4) {
//				if(2*a != SocrZnam(Integer.parseInt(otv2_1User.getText()), (int)WorkWithResults.ConvertUserResToInt(otv1_1User.getText()))) {
//					return false;
//				}else return true;
//				
//		}else return false;
//	}else if(SwitchRes[0].getText() != "Целое" && SwitchRes[1].getText() == "Целое") {
//		
//if(resNumber == 1) {
//	
//		if(YravnCreater.Discr(a, b, c) == 0) {
//			if(( ((int)WorkWithResults.GetRes1_1(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv1_UserCeloe.getText())
//					&& (int)WorkWithResults.GetRes1_2(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv1_UserCeloe.getText()))) &&
//					((int)WorkWithResults.GetRes1_1(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_2User.getText())))
//					&& (int)WorkWithResults.GetRes1_2(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_2User.getText())) &&
//					( 2*a == SocrZnam(Integer.parseInt(otv2_2User.getText()), (int)WorkWithResults.ConvertUserResToInt(otv1_2User.getText())))) {
//				return true;
//			}else return false;
//		}else {
//	
//		if(((int)WorkWithResults.GetRes1_1(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv1_UserCeloe.getText()) &&
//				(int)WorkWithResults.GetRes1_2(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_2User.getText()))) || 
//				((int)WorkWithResults.GetRes1_1(a,b,c) == SocrChisl((int)WorkWithResults.ConvertUserResToInt(otv1_2User.getText())) &&
//				(int)WorkWithResults.GetRes1_2(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv1_UserCeloe.getText()))) {
//
//				return true;
//		}else return false;
//		
//		}}else if(resNumber == 3 || resNumber == 4) {
//			if(2*a != SocrZnam(Integer.parseInt(otv2_2User.getText()), (int)WorkWithResults.ConvertUserResToInt(otv1_2User.getText()))) {
//				return false;
//			}else return true;
//			
//	}else return false;
//	
//	}else if(SwitchRes[0].getText() != "Целое" && SwitchRes[1].getText() != "Целое") {
//		if(resNumber == 1) {
//			
//			if(YravnCreater.Discr(a, b, c) == 0) {
//				if(( ((int)WorkWithResults.GetRes1_1(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv1_UserCeloe.getText())
//						&& (int)WorkWithResults.GetRes1_2(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv1_UserCeloe.getText()))) &&
//						((int)WorkWithResults.GetRes1_1(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv2_UserCeloe.getText())
//						&& (int)WorkWithResults.GetRes1_2(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv2_UserCeloe.getText())) 
//						) {
//					return true;
//				}else return false;
//			}else {
//		
//			if(((int)WorkWithResults.GetRes1_1(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv1_UserCeloe.getText()) &&
//					(int)WorkWithResults.GetRes1_2(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv2_UserCeloe.getText())) || 
//					((int)WorkWithResults.GetRes1_1(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv2_UserCeloe.getText()) &&
//					(int)WorkWithResults.GetRes1_2(a,b,c) == (int)WorkWithResults.ConvertUserResToInt(otv1_UserCeloe.getText()))) {
//
//					return true;
//			}else return false;
//			}
//		}else return true;
//			
//			
//	}else return false;
//}	
	
	

//public boolean CheckRes1() {
//	int a = yravn.getABC()[0];
//	int b = yravn.getABC()[1];
//	int c = yravn.getABC()[2];
//
//	if(SwitchRes[0].getText() == "Целое") {
//		int res = (WorkWithResults.ConvertUserResToInt(otv1_1User.getText())/WorkWithResults.ConvertUserResToInt(otv2_1User.getText()));
////		if(((a*res*res) + (b * res) + c) == 0) {
////			&& WorkWithResults.ConvertUserResToInt(otv1_1User.getText()) == SocrChisl(WorkWithResults.ConvertUserResToInt(otv1_1User.getText())) && WorkWithResults.ConvertUserResToInt(otv2_1User.getText()) == SocrZnam(WorkWithResults.ConvertUserResToInt(otv2_1User.getText()), WorkWithResults.ConvertUserResToInt(otv1_1User.getText()))) {
//		if((res == WorkWithResults.GetRes1_1(a, b, c)) ||
//				(res == WorkWithResults.GetRes1_2(a, b, c))) {
//			return true;
//			
//	}else return false;
//	}else {
//		int res = WorkWithResults.ConvertUserResToInt(otv1_UserCeloe.getText());
//		if(((a*res*res) + (b*res) + c) == 0) {
//			return true;
//		}else return false;
//	}
//
//}
//public boolean CheckRes2() {
//	int a = yravn.getABC()[0];
//	int b = yravn.getABC()[1];
//	int c = yravn.getABC()[2];
//
//	if(SwitchRes[1].getText() == "Целое") {
//		int res = (WorkWithResults.ConvertUserResToInt(otv1_2User.getText())/WorkWithResults.ConvertUserResToInt(otv2_2User.getText()));
////		if(((a*res*res) + (b * res) + c) == 0) {
//		if((res == WorkWithResults.GetRes1_1(a, b, c)) ||
//				(res == WorkWithResults.GetRes1_2(a, b, c))) {
//			return true;
//			
//	}else return false;
//	}else {
//		int res = WorkWithResults.ConvertUserResToInt(otv2_UserCeloe.getText());
//		if(((a*res*res) + (b*res) + c) == 0) {
//			return true;
//		}else return false;
//	}
//
//}
//
////Sokratit Chislitel
//public int SocrChisl(int chisl) {
//	int znam = Integer.parseInt(WorkWithResults.GetRes4(yravn.getABC()[0]));
//	if(znam<0 && chisl < 0) {
//		znam*= -1;
//		chisl*= -1;
//	}
//	while(chisl % 2 ==0 && znam%2 == 0) {
//		chisl /= 2;
//		znam /= 2;
//		System.out.println("socr2 : " + chisl);
//	}
//	while(chisl % 3 ==0 && znam%3 == 0) {
//		chisl /= 3;
//		znam /= 3;
//		System.out.println("socr3: " + chisl);
//	}
//	while(chisl % 5 ==0 && znam%5 == 0) {
//		chisl /= 5;
//		znam /= 5;
//		System.out.println("socr5: " + chisl);
//	}
//	while(chisl % 7 ==0 && znam%7 == 0) {
//		chisl /= 7;
//		znam /= 7;
//		System.out.println("socr7: " + chisl);
//	}
//	return chisl;
//}
//public int SocrZnam(int znam, int chisl) {
//	if(znam<0 && chisl < 0) {
//		znam*= -1;
//		chisl*= -1;
//	}
//	while(chisl % 2 ==0 && znam%2 == 0) {
//		chisl /= 2;
//		znam /= 2;
//	}
//	while(chisl % 3 ==0 && znam%3 == 0) {
//		chisl /= 3;
//		znam /= 3;
//	}
//	while(chisl % 5 ==0 && znam%5 == 0) {
//		chisl /= 5;
//		znam /= 5;
//	}
//	while(chisl % 7 ==0 && znam%7 == 0) {
//		chisl /= 7;
//		znam /= 7;
//	}
//	return znam;
//}
//
////proverka dla drobnogo otveta
//public boolean CheckDrobRes(int chisl, int chislCorr, int znam, int znamCorr) {
//	if((float)(chisl/znam) == (float)(chislCorr/znamCorr)) {
//		return true;
//	}else return false;
//	
//}
////proverka dla celogo otveta
//public boolean CheckCelRes(int resUser,int resCorr) {
//	if(resUser == resCorr) {
//		return true;
//	}else {
//		return false;
//	}
//}
////proverka, esli oba otveta celie
//public boolean CheckBothDrebsRes(int chisl1, int chislCorr1, int znam1, int znamCorr1,int chisl2, int chislCorr2, int znam2, int znamCorr2) {
//		if((CheckDrobRes(chisl1,chislCorr1,znam1,znamCorr1) == true ) && (CheckDrobRes(chisl2,chislCorr2,znam2,znamCorr2) == true)) {
//			return true;
//		}else {
//			return false;
//		
//	}
//}
//public boolean CheckOneCelOneDrobRes(int chisl, int chislCorr, int znam, int znamCorr, int resUser,int resCorr) {
//	if((CheckCelRes(resUser, resCorr) == true) && (CheckDrobRes(chisl,chislCorr,znam,znamCorr) == true) ) {
//		return true;
//	}else {
//		return false;
//	}
//}
//public boolean CheckBothCelRes(int resUser1,int resCorr1,int resUser2,int resCorr2) {
//	if((CheckCelRes(resUser1,resCorr1) == true) || (CheckCelRes(resUser2, resCorr2) == true)) {
//		return true;
//	}else {
//		return false;
//	}
//}

//	perepisat proverky chtob smotrela na vsu drob a ne tolko na chislitel
 // teper nado sobrat iz napisanih metodow
//	a potom dodelat knopki smeni otveta



//knopka na glavnuy

		
//	class SwitchResClickListener0 implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			if(SwitchRes[0].getText() == "Целое") {
//				SwitchRes[0].setText("Дробное");
//				otv1_1User.setVisible(false);
//				otv2_1User.setVisible(false);
//				otv1_UserCeloe.setVisible(true);
//			}
//			else {
//				SwitchRes[0].setText("Целое");
//				otv1_1User.setVisible(true);
//				otv2_1User.setVisible(true);
//				otv1_UserCeloe.setVisible(false);
//		
//		}
//	}
//	}
//	class SwitchResClickListener1 implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			if(SwitchRes[1].getText() == "Целое") {
//				SwitchRes[1].setText("Дробное");
//				otv1_2User.setVisible(false);
//				otv2_2User.setVisible(false);
//				otv2_UserCeloe.setVisible(true);
//			}
//			else {
//				SwitchRes[1].setText("Целое");
//				otv1_2User.setVisible(true);
//				otv2_2User.setVisible(true);
//				otv2_UserCeloe.setVisible(false);
//			}
//			
//		}
//		
//	}
	

//	(a*((-b)+Math.sqrt((b*b)+(-4*a*c)))/(2*a)*((-b)+Math.sqrt((b*b)+(-4*a*c)))/(2*a))+(b*((-b)+Math.sqrt((b*b)+(-4*a*c)))/(2*a))+c


