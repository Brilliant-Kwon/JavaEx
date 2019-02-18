package JavaStudy.Fab_17.KHS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class calc  implements ActionListener
{	
	JFrame frame;     //JFrame ���� ����   
	JTextField textfieldNorth; 
	JTextField textField;
	JPanel panel1;  //Border 
	JPanel panelNorth;  //Border 
	GridLayout grid;
	JButton JBu;
	String[] strGrid={"7","8","9","/","4","5","6","*","1","2","3","-" ,"0","C","+","=" };
	
	private String first="";  		// ���� ����
	private String result=""; 		// �����  "=" ���
	ArrayList<Integer> ee=new ArrayList<Integer>();  		// ���� �������� �ޱ�.
	ArrayList<String> store=new ArrayList<String>();  		// ������ �������� ����.

	
	public calc(){
		
		frame=new JFrame("����");
		panel1=new JPanel();
		panelNorth=new JPanel();
		textField=new JTextField("0"); 			// �ʱⰪ �ƹ��͵� �Ⱥ��̰�
		textfieldNorth=new JTextField(""); 		// �����ڸ� ���̴� �ؽ�Ʈ 
	}// ������ calc()
		

	public void gui(){
		
		textField.setHorizontalAlignment(JTextField.RIGHT);   // ��������
		textField.setEditable(false); 		// �ؽ�Ʈ�ʵ�â�� �ؽ�Ʈ�������ϰ� ���
		
		textfieldNorth.setHorizontalAlignment(JTextField.RIGHT);  // ��������
		textfieldNorth.setEditable(false); 	// �ؽ�Ʈ�ʵ�â�� �ؽ�Ʈ�������ϰ� ���
		
		panelNorth.setLayout(new BorderLayout());    		// ���̾ƿ� ����.
		panelNorth.add(BorderLayout.CENTER,textField);
		
		panel1.setLayout(new GridLayout(4,4,8,8));  		// �׸��� ���̾ƿ� �Ӽ�����
		panel1.setBackground(new Color( 222,232,244));  // �гλ���
	

		for(int i=0; i<strGrid.length; i++){
			JBu=new JButton(strGrid[i]);  				// ��ư ���� 
			JBu.addActionListener(this);	 			// �� ��ư���� ������ ���̱�
			JBu.setBackground(new Color( 241,244,249));    // ��ư ����ֱ�
			panel1.add(JBu); 							// �гο� ������ ��ư�� ���̱�
		}
		
	
		frame.add(BorderLayout.NORTH,panelNorth); 
		frame.add(BorderLayout.CENTER,panel1); 		 // �ؽ�Ʈ�ʵ� ���ʿ�
		
		frame.setResizable(false);                                  //â ũ�� ���� ���ϰ� ���´�.
		frame.setSize(220,310);                                    //frame �� ũ��  
		frame.setVisible(true);                                   //frame�� ȭ�鿡 ��Ÿ������ ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //X��ư Ȱ��ȭ 
	}//gui()
	
	
	public void actionPerformed(ActionEvent e){
		String str=e.getActionCommand();  		// ���ڿ��� �̺�Ʈ�ҷ���
		String read;				// �ؽ�Ʈ�ʵ忡 �ִ� �ؽ�Ʈ �б�뵵
		
		try{	
			//�����ȣ�� �ƴ� �����̸� true �̴�.
			if(str!="/" && str!= "*"&& str!= "-"&& str!= "+"&& str!= "C"&& str!= "="){	
				textField.setText(first);  		// 0������� ���ڴ����ϱ����� �ʿ�.
				textField.getText();  			// ���� ���
				textfieldNorth.setText("");		// ������ �ؽ�Ʈ �ʱ�ȭ
				textfieldNorth.getText(); 		// ���
				
				read=textField.getText();  		// �ؽ�Ʈ�� �ִ°� �ҷ���.
				first=read+str;
				textField.setText(first);		// ���� ����
				textField.getText(); 			// ���� ���
			}// if
			
			
			
			//�����ȣ�� �������� true.
			if(str=="/" || str== "*"|| str== "-"|| str== "+"|| str== "="){
				textfieldNorth.setText(str); 				 // ������ ��ȣ ����
				textfieldNorth.getText();  					// ������ ��ȣ ���
				
				ee.add(Integer.parseInt(first));  // �����Ϸ��� �� �ϳ��� ArrayList�� ����
				first="";						// �ٽ� �����ϵ��� �ʱ�ȭ
				
				store.add(str); 			   // ������ ArrayList�� ����		
			}// if
			
			
			
			//�����ȣ "=" ����� ��������.
			if(str=="="){		
				int sum=0;
				sum=ee.get(0); 		// ���� ���۰��� �ް� ���� , 1(+2)(+3)(+4)=result �ʱⰪ�� �˸� 3���� "()" �������ָ� �ȴ�. 
				
				for(int a=0,h=1; a<ee.size(); a++,h++){   // ArrayList ũ�⸸ŭ �ݺ�
					int ve=store.size(); 				// ������ ���� Ƚ�� ����
					if(ve>0){							// ������ ���� ��� ����Ҷ����� �ݺ�.
						ve--;			
						//if�� �Ǵ� switch������ ����.
						if(store.get(a)=="+"){			// ������ + �϶�
							sum=sum+ee.get(h);  			// (+2) �ι�° ���ڿ� ����
						}else if(store.get(a)=="-"){	// �Ʒ����� �ݺ�..	
							sum=sum-ee.get(h);	
						}else if(store.get(a)=="*"){
							sum=sum*ee.get(h);
						}else if(store.get(a)=="/"){
							try{				
								sum=sum/ee.get(h);
							}catch(Exception exc){		// �������� 0���� ������ ���ܹ߻��Ѵ�.
								sum=0;  //�����߻��� 0���� ���.
							}
						}			
					}// if
				}// for
				result=sum+"";						//�� �����
				textField.setText(result);  		// ����� ����
				textField.getText(); 				// ������	
			}// if
			
			//��� �� �ʱ�ȭ ��Ű�� �ٽ� ����.
			if(str=="C"){
				first="";
				textField.setText("0"); 			 // �ؽ�Ʈâ ���� ����� 0���
				textField.getText();  			
				textfieldNorth.setText(""); 	// ������ �ؽ�Ʈâ �ʱ�ȭ
				textfieldNorth.getText(); 
				ee.clear();  					// ��� ��ҵ� ����
				store.clear();  				// ��� ��ҵ� ����
			}
			
		}catch(Exception ex){
			textField.setText("Error �ٽ��Է� CŬ��.");  // �ؽ�Ʈâ ���� ���� �����
			textField.getText(); 
		}
	
	}// actionPerformed()
	

	public static void main(String[] args) 
	{
		calc cal=new calc();
		cal.gui();
	}// main()
}// class