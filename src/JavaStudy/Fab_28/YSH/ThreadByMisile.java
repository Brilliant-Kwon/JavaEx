package JavaStudy.Fab_28.YSH;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ThreadByMisile extends JFrame implements Runnable{
   JLabel misile;
   JLabel monster;
//   boolean flag=true;
   public ThreadByMisile(JLabel misile,JLabel monster){
      this.misile=misile;
      this.monster=monster;
   }
   public boolean Ssam(JLabel monster,JLabel misile) { // 몬스터와 미사일이 만났을때의 경우 
	      if((((misile.getX()>=monster.getX())&&(misile.getX()<=monster.getX()+70))
	         &&((misile.getY()>=monster.getY())&&(misile.getY()<=monster.getY()+70)))
	      || (((misile.getX()+20>=monster.getX())&&(misile.getX()+20<=monster.getX()+70))
	         &&((misile.getY()+50>=monster.getY())&&(misile.getY()+50<=monster.getY()+70)))) {
	    	  
	    	  return true;
	      }
	 
	      else
	         return false;
	   }
   @Override
   public void run() {
      // TODO Auto-generated method stub
      //      boolean flag=true;
      int n=350;
      while(true) {
         if(n!=20)//엔터를 누르고 미사일이 올라가고있는 코드  
         {  
        	if(Ssam(monster,misile)==true) {     //미사일에 맞았을경우 몬스터는 visible 값을 false로준다 
        		monster.setVisible(false);   
        		misile.setLocation(215, 350);//미사일은 원위치 
        		try {
        			Thread.sleep(1000);
        		}catch (InterruptedException e) {
					// TODO: handle exception
        			return;
        		}
        		break;    //그러고선 탈출 
        	}
            misile.setLocation(215, n);  //위의조건에 걸리지않았을때는 그냥 미사일이 위로 쭉올라간다.
            n-=10;

            System.out.println("미사일 x:"+misile.getX()+"미사일y:"+misile.getY());
            try {
               Thread.sleep(100);
            }catch (InterruptedException e) {
               // TODO: handle exception
               return;
            }
         }
         else if(n==20) { //맨위까지 미사일이올라갔을때의 경우 
            misile.setLocation(215, 350);
            System.out.println("미사일 x:"+misile.getX()+"미사일y:"+misile.getY());
            System.out.println("미사일 끝까지도착이요~");
            break;

         }
      }
   }
}

