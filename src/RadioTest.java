import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class RadioTest extends JFrame {
	
	JPanel jp1,jp2,jp3,jp4,jp5,jp6;
	JLabel jlTitle,jlText;
	ButtonGroup bg;
	JRadioButton jrdoS,jrdoM,jrdoL;
	
	JCheckBox jckSyrup,jckCream,jckChoco;
	JLabel jlTopping;
	
	JTextArea jta;
	JButton jbOk;
	
	ArrayList<String> arrayTopping=new ArrayList<String>();
	
	RadioTest(){
		setTitle("커피 주문");
		setSize(400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(7,1));
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		jp6=new JPanel();
		
		//커피 사이즈
		jlTitle=new JLabel("어떤 크기의 커피를 주문하시겠습니까?");
		jp1.add(jlTitle);
		
		bg=new ButtonGroup();
		jrdoS=new JRadioButton("Small Size");
		jrdoM=new JRadioButton("Medium Size");
		jrdoL=new JRadioButton("Large Size");
		
		jrdoS.addItemListener(new MyListener());
		jrdoM.addItemListener(new MyListener());
		jrdoL.addItemListener(new MyListener());
		
		bg.add(jrdoS);
		bg.add(jrdoM);
		bg.add(jrdoL);
		  
		jp2.add(jrdoS);
		jp2.add(jrdoM);
		jp2.add(jrdoL);
		
		jlText=new JLabel();
		jlText.setForeground(Color.RED);;
		jp3.add(jlText);
		
		//추가 토핑
		jckSyrup=new JCheckBox("시럽");
		jckCream=new JCheckBox("휘핑크림");
		jckChoco=new JCheckBox("초코");
		
		jckSyrup.addItemListener(new MyListener());
		jckCream.addItemListener(new MyListener());
		jckChoco.addItemListener(new MyListener());
		
		jp4.add(jckSyrup);
		jp4.add(jckCream);
		jp4.add(jckChoco);
		
		jlTopping=new JLabel("추가토핑: ");
		jp5.add(jlTopping);
		
		//기타 건의사항
		jta=new JTextArea(10,30);
		JScrollPane jsp=new JScrollPane(jta);
		
		//주문 확인
		jbOk=new JButton("확인");
		jbOk.addActionListener(new MyListener2());
		
		jp6.add(jbOk);
		
		add(jp1);
		add(jp2);
		add(jp3);
		add(jp4);
		add(jp5);
		add(jsp);
		add(jp6);
		
		//pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		RadioTest r=new RadioTest();
	}

	class MyListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==jrdoS) {
				jlText.setText("Small 크기가 선택되었습니다.");
			}else if(e.getSource()==jrdoM) {
				jlText.setText("Medium 크기가 선택되었습니다.");
			}else if(e.getSource()==jrdoL) {
				jlText.setText("Large 크기가 선택되었습니다.");
			}else if(e.getSource()==jckSyrup) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					//jlTopping.setText(jlTopping.getText()+"시럽 ");
					arrayTopping.add("시럽");
				}else {
					arrayTopping.remove("시럽");
				}
			}else if(e.getSource()==jckCream) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					//jlTopping.setText(jlTopping.getText()+"휘핑크림 ");
					arrayTopping.add("휘핑크림");
				}else {
					arrayTopping.remove("휘핑크림");
				}
			}else if(e.getSource()==jckChoco) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					//jlTopping.setText(jlTopping.getText()+"초코 ");
					arrayTopping.add("초코");
				}else {
					arrayTopping.remove("초코");
				}
			}
			String str="";
			for(String s:arrayTopping) {
				str+=s+" ";
			}
			jlTopping.setText("추가 토핑: "+str);
		}
	}
	class MyListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbOk) {
				int result=JOptionPane.showConfirmDialog //result가 int인 이유는 Yes나 No선택시 그 값이 정수로 바뀌기 때문
						(null,"주문하시겠습니까?","주문확인",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION) { 
				}else if(result==JOptionPane.NO_OPTION) {
				}
			}
		}
	}
}