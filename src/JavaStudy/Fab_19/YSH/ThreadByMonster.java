package JavaStudy.Fab_19.YSH;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ThreadByMonster extends JFrame implements Runnable{
	boolean flag=true;
	JLabel monster;
	JLabel misile;
	
	public ThreadByMonster(JLabel monster,JLabel misile){
		this.monster=monster;
		this.misile=misile;
	}
	public boolean Ssam(JLabel monster,JLabel misile) { // 두물체가 겹치면 
		if(((monster.getX()<=misile.getX())&&(misile.getX()<=monster.getX()+70)
				&&(monster.getY()<=misile.getY())&&(misile.getY()<=monster.getY()+70))
				||((monster.getX()<=misile.getX()+20)&&(misile.getX()+20<=monster.getX()+70)
						&&((monster.getY()<=misile.getY()+70)&&(misile.getY()+70<=monster.getY()+70))
						||((monster.getX()<=misile.getX())&&(misile.getX()<=monster.getX()+70))
								&&(monster.getY()<=misile.getY()+70)&&(misile.getY()+70<=monster.getY()+70))
								||((monster.getX()<=misile.getX()+20)&&(misile.getX()+20<=monster.getX()+70)
										&&(monster.getY()<=misile.getY())&&(misile.getY()<=monster.getY()+70))){
			return true;					
		}
		else 
			return false;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int n=0;
		while(true) { //x 좌표값이 0~420까지 몬스터가 왔다갔다 하게 만들었음.
			if((flag==true)) 
			{	
				if(Ssam(monster,misile)==true) {
					n=0;
					try {
						Thread.sleep(50);
					}catch (Exception e) {
						// TODO: handle exception
					}
					monster.setLocation(n,monster.getY());
				}
				monster.setLocation(n, monster.getY());
				n+=10;   //=>진행방향 오른쪽 
				if(n==420) {
					flag=false;
				}
				try {
					Thread.sleep(500);
				}catch (InterruptedException e) {
					// TODO: handle exception
					return;
				}


			}

			else if(flag==false) 
			{

				monster.setLocation(n, monster.getY());
				n-=10;  //<==진행방향이 왼쪽 
				if(n==0) {
					flag=true;
				}
				//					System.out.println(n);
				try {
					Thread.sleep(500);
				}catch (InterruptedException e) {
					// TODO: handle exception
					return;
				}


			}

		}
	}


}


