package JavaStudy.Fab_19.YSH;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ThreadByMisile extends JFrame implements Runnable{
	JLabel misile;
	JLabel monster;
//	boolean flag=true;
	public ThreadByMisile(JLabel misile,JLabel monster){
		this.misile=misile;
		this.monster=monster;
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
		//		boolean flag=true;
		int n=350;
		while(true) {
			if(n!=10)//엔터를 누르고 미사일이 올라가고있는 코드  
			{ 	
				if(Ssam(monster,misile)==true) {
					try {
						Thread.sleep(30);
						misile.setLocation(215,350);
						break;
					}catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				misile.setLocation(215, n);
				n-=10;

				System.out.println("미사일 x:"+misile.getX()+"미사일y:"+misile.getY());
				try {
					Thread.sleep(300);
				}catch (InterruptedException e) {
					// TODO: handle exception
					return;
				}
			}



			else if(n==10) { //맨위까지 미사일이올라갔을때의 경우 
				misile.setLocation(215, 350);
				System.out.println("미사일 x:"+misile.getX()+"미사일y:"+misile.getY());
				System.out.println("미사일 끝까지도착이요~");
				break;

			}
		}
	}
}



