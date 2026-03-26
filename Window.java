import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


public class Window {
	static mainVietaWindow VW = new mainVietaWindow();
	static mainDiscrWindow DW = new mainDiscrWindow();
	static mainABCWindow ABCW = new mainABCWindow();
//	static int isOpendEarly = 0;
	static JFrame jf = new JFrame("Квадратные уравнения");
	static JSlider Dif = new JSlider(1, 3, 2);
			
public Window() {
	Dictionary <Integer, JLabel> lab = new Hashtable<Integer, JLabel>();
	lab.put(1, new JLabel("лёгкий"));
	lab.put(2, new JLabel("средний"));
	lab.put(3, new JLabel("сложный"));
//	VW.vw.hide();
	Container container = new Container();
	container.setLayout(new GridBagLayout());
	
	
	GridBagConstraints constr = new GridBagConstraints();
	constr.fill = GridBagConstraints.HORIZONTAL; 
	
//		constr.ipady = 150;
//	Border raisedbevel = BorderFactory.createRaisedBevelBorder();
//	TitledBorder raisedbevel = BorderFactory.createTitledBorder("title");
	constr.gridx = 1;
	constr.gridy = 0;
	constr.gridheight = 1;
	constr.gridwidth = 1;
	constr.insets.bottom = 40;
	JLabel GlavnayaNadpisWindows = new JLabel("Улучши свои навыки работы с квадратными уравнениями!");
	GlavnayaNadpisWindows.setFont(new Font("LucidaSans", Font.BOLD, 15));
	GlavnayaNadpisWindows.setBorder(BorderFactory.createLineBorder(new Color(56,140,66), 2, true));
	container.add(GlavnayaNadpisWindows, constr);
	constr.insets.bottom = 0;
//		constr.ipady = 0;
	
	JButton nayABC = new JButton("Найти a,b,c");
	nayABC.setBackground(new Color(0, 255, 127));
		nayABC.addActionListener(new ABCClickActionListener());
//	constr.gridheight = 1;

	constr.gridx = 0;
	constr.gridy = 1;
container.add(nayABC, constr);
	
	JButton nayXD = new JButton("Решить через дискриминант");
	nayXD.setBackground(new Color(0, 255, 127));
		nayXD.addActionListener(new DClickActionListener());
	constr.gridx = 1;
	container.add(nayXD, constr);
	
	JButton nayXV = new JButton("Теорема Виета");
	nayXV.setBackground(new Color(0, 255, 127));
	nayXV.addActionListener(new VClickActionListener());
	constr.gridx = 2;
	container.add(nayXV, constr);
	
	constr.gridy = 2;
	constr.gridx = 1;
	constr.insets.top = 10;
	JPanel jp = new JPanel();
	jp.setBackground(new Color(0, 250, 154));
	JLabel ViberiteUrvenSlojnosti = new JLabel("выберите урвень сложности");
	ViberiteUrvenSlojnosti.setFont(new Font("LucidaSans", Font.BOLD, 19));
	ViberiteUrvenSlojnosti.setHorizontalTextPosition(SwingConstants.CENTER);
	jp.add(ViberiteUrvenSlojnosti);
	container.add(jp, constr);
	constr.insets.top = 0;
	
	constr.gridy = 3;
	constr.gridx = 1;
	constr.ipady = 20;
	Dif.setMajorTickSpacing(1);
	Dif.setPaintTicks(true);
	Dif.setLabelTable(lab);
	Dif.setPaintLabels(true);
	Dif.setBackground(new Color(0, 250, 154));
	Dif.setBorder(BorderFactory.createLineBorder(new Color(56,140,66), 2));
	container.add(Dif,constr);
	constr.ipady = 0;


	jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.setBounds(300, 100, 700, 500);

	
//	jf.setLayout(new FlowLayout());
//	jf.add(new JLabel("Улучши свои навыки работы с квадратными уравнениями!"));
//	jf.add(nayABC);
//	jf.add(nayXD);
//	jf.add(nayXV);
	jf.add(container);
	jf.getContentPane().setBackground(new Color(0, 250, 154));
	jf.setVisible(true);
	
}
//private JLabel SetFontSize(JLabel text, int size) {
//	text.setFont(new Font("LucidaSans", Font.BOLD, size));
//	return text;
//}

public class VClickActionListener implements ActionListener {
//.setFont(;
	@Override
	public void actionPerformed(ActionEvent e) {
		VW.yravn.CreateNewVietaYravn(Dif.getValue());
		JLabel x =  new JLabel(VW.yravn.getYravnenie());
		x.setFont(new Font("LucidaSans", Font.PLAIN, 25));

		VW.StrokaYravn = x;
		VW.addYravn();
		jf.setVisible(false);
		VW.vw.setVisible(true);
	}
	
}
public class DClickActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			DW.yravn.CreateNewYravn(Dif.getValue());
			JLabel x =  new JLabel(DW.yravn.getYravnenie());
			x.setFont(new Font("LucidaSans", Font.PLAIN, 25));

			DW.StrokaYravn = x;
			DW.addYravn();
			jf.setVisible(false);
			DW.dw.setVisible(true);
		}
		
	}
public class ABCClickActionListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ABCW.yravn.CreateNewABCYravn(Dif.getValue());
		JLabel x =  new JLabel(ABCW.yravn.getYravnenie());
		x.setFont(new Font("LucidaSans", Font.PLAIN, 25));

		ABCW.StrokaYravn = x;
		ABCW.addYravn();
		jf.setVisible(false);
		ABCW.ABCw.setVisible(true);
	}
}
}
