package JavaStudy.Jan_31.YSH.Quiz03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HangMain {
   public static void main(String[] args) {

      try {
         boolean flag=true;
         boolean flag2=true;
         String line; //txt파일에서 한줄씩읽어올때 쓰기위한 변수
         int randomNum; // 랜덤하게 인덱스를 가져오기위한 변수

         BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Jan_31\\YSH\\Quiz03\\word.txt"));
         randomNum=(int)(Math.random()*5);
         int num=0;
         System.out.println("지금 부터 행맨 게임을 시작합니다.");
         for(;;){
            int alphNum=0; // 단어의 각 알파벳 중비워놓을 첫번째 인덱스 저장위한 변수
            int alphNum2=0;// 단어의 각 알파벳 중비워놓을 첫번째 인덱스 저장위한 변수
            String answer=""; //첫번째알파벳을 입력받기위한변수
            String answer2="";//두번째알파벳을 입력받기위한변수
            String ansYN;
            Scanner sc=new Scanner(System.in); //첫번째 대답받기
            Scanner sc2=new Scanner(System.in);//두번째 대답받기
            Scanner yn=new Scanner(System.in);// y/n 대답받기
            int temp=0; // 랜덤 인덱스 1,2 큰거 앞에 큰거 뒤로 보내기위한 변수
            if(flag==true){
               while((line=in.readLine())!=null){ //랜덤하게 뽑은 randomNum 과 num과 일치하면 해당 문자열을 뽑는다.
                  if(num==randomNum){
                     System.out.println(line);
//                     System.out.println(num);
                     break;
                  }
                  num++;
               }
               // line 에 랜덤하게 5개의 문자중 1개의 라인이 들어가있음
               alphNum=(int)(Math.random()*line.length()); //첫번째비워지는 인덱스
//               System.out.println(alphNum);
               for(;;){   //비워지는 자릿수가 같으면 한자리밖에 못지워지기떄문에 다른 값을 갖게하기위한 반복문
                  alphNum2=(int)(Math.random()*line.length()); //두번쨰 비워지는인덱스
                  if(alphNum==alphNum2){
                     continue;
                  }else
                     break;
               }
               if(alphNum>alphNum2) {  //alphNum 크기순으로 바꾸기
                  temp=alphNum2;
                  alphNum2=alphNum;
                  alphNum=temp;
               }
//               System.out.println(alphNum);
//               System.out.println(alphNum2);

               int s=0;
               for(;;s++){  // 2번기회주기위해 두번 반복
                  if((s>1)&&(flag2==true)){
                     System.out.println("두번기회가끝났습니다.");
                     System.out.println("Next? Y/N");
                     ansYN=yn.nextLine();
                     if(ansYN.charAt(0)=='Y'){
                        System.out.println("새로운 영단어배열시작!");
                        break;
                     }else if(ansYN.charAt(0)=='N'){
                        //  System.out.println("게임을 종료합니다.");
                        flag=false;
                        break;
                     }
                  }else if(flag2==false) {   // 두번째 단어맞췄을시에 여기로 걸리게 이프문걸어줌
                     System.out.println("Next? Y/N");
                     ansYN=yn.nextLine();
                     if(ansYN.charAt(0)=='Y'){
                        System.out.println("새로운 영단어배열시작!");
                        flag2=true;
                        break;
                     }else if(ansYN.charAt(0)=='N'){
                        // System.out.println("게임을 종료합니다.");
                        flag=false;
                        break;
                     }
                  }
                  for(int i=0;i<line.length();i++){
                     if((i==alphNum)||(i==alphNum2)){
                        System.out.print("-");    //비워지는칸표시
                     }else
                        System.out.print(line.charAt(i));
                  }
                  System.out.println();
                  System.out.print(">>");
                  answer=sc.nextLine(); //첫번째 빈칸의 알파벳 입력
                  if(answer.charAt(0)==line.charAt(alphNum)){
                     System.out.println("첫번째 알파벳을 맞췄습니다.");
                     for(int j=0;j<2;j++){
                        for(int i=0;i<line.length();i++){  //첫번째 단어는맞춰서 원래대로 출력하고 두번쨰만 가려서 나옴
                           if(i==alphNum2){
                              System.out.print("-");
                           }else
                              System.out.print(line.charAt(i));
                        }
                        System.out.println();
                        System.out.print(">>");
                        answer2=sc2.nextLine();
                        if(answer2.charAt(0)==line.charAt(alphNum2)){ //두번째 답도 맞췄을경우
                           System.out.println("두번째 알파벳도 맞췄습니다.");
                           flag2=false;
                           break;
                        }
                        else
                           System.out.println("틀렸습니다.");
                     }
                     if(answer2.charAt(0)!=line.charAt(alphNum2)){ //두번기회끝나고 못맞췄을경우에
                        System.out.println("Next? Y/N");
                        ansYN=yn.nextLine();
                        if(ansYN.charAt(0)=='Y'){
                           System.out.println("새로운 영단어배열시작!");
                           break;
                        }else if(ansYN.charAt(0)=='N'){
                           flag=false;
                           break;
                        }
                     }
                  }else if((answer.charAt(0)==line.charAt(alphNum))&&(answer2.charAt(0)==line.charAt(alphNum2))){
                     System.out.println("두 글자 다 맞췄습니다.");
                     System.out.println("Next? Y/N");
                     ansYN=yn.nextLine();
                     if(ansYN.charAt(0)=='Y'){
                        flag=true;
                        break;
                     }else if(ansYN.charAt(0)=='N'){
                        System.out.println("게임을 종료합니다.");
                        flag=false;
                        break;
                     }
                  }else{
                     System.out.println("틀렸습니다.");
                     continue;
                  }

               }
            }else if(flag==false){
               System.out.println("게임을 종료합니다.");
               break;
            }

         }
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}