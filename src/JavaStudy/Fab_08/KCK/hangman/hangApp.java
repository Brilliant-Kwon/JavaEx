package JavaStudy.Fab_08.KCK.hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class hangApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("지금부터 행맨 게임을 시작합니다.");
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Jan_31\\hangman\\words.txt"));
                int ran = (int) Math.round(Math.random() * 17);//문자 선택 랜덤값
                String word = null;
                for (int i = 0; i < ran; i++) {
                    word = br.readLine();//ran 번째 단어를 word 에 저장
                }
                char[] word_copy = new char[word.length()];//word를 배열 word_copy에 복사하기위해 배열 선언 (빈칸넣기위함)
                //빈칸 인덱스 랜덤값 지정
                int ran_word1 = (int) Math.round(Math.random() * (word.length() - 1));
                int ran_word2;
                while (true) {//빈칸 중복 제거
                    ran_word2 = (int) Math.round(Math.random() * (word.length() - 1));
                    if (ran_word1 != ran_word2) {
                        break;
                    }
                }
                for (int i = 0; i < word.length(); i++) {//단어 복사 및 빈칸만들기
                    if (i == ran_word1 || i == ran_word2) {
                        word_copy[i] = '_';
                    } else {
                        word_copy[i] = word.charAt(i);
                    }
//                System.out.print(word_copy[i]);
                }
                int life = 5;
                int go = 0;
                while (life > 0) {//빈칸 맞추기 반복
                    System.out.println(word_copy);
                    System.out.print("(목숨 : " + life + ") 알파벳 입력>>");
                    String ans = sc.nextLine();
                    if (ans.charAt(0) == word.charAt(ran_word1)) {//일치하면
                        word_copy[ran_word1] = ans.charAt(0);
                        go++;
                    } else if (ans.charAt(0) == word.charAt(ran_word2)) {//일치하면
                        word_copy[ran_word2] = ans.charAt(0);
                        go++;
                    } else//틀리면
                        life--;//목숨감소
                    if(go==2)//정답 2개 다 맞추면
                        break;
                }
//                while (life > 0) {//2번째 빈칸 맞추기 반복
//                    System.out.println(word_copy);
//                    System.out.print("2번째 빈칸 (목숨 : " + life + ") >>");
//                    String ans = sc.nextLine();
//                    if (ans.charAt(0) == word.charAt(ran_word2)) {//일치하면
//                        word_copy[ran_word2] = ans.charAt(0);
//                        break;
//                    } else//틀리면
//                        life--;//목숨감소
//                }

                if (life == 0) {
                    System.out.println("5번 실패 하였습니다.");
                    System.out.println("정답 : " + word);
                } else if(go==2) {
                    System.out.println("모두 다 맞히셨습니다.");
                    System.out.println("정답 : " + word);
                }

                System.out.println("\n------------------------------");
                String con;
                while (true) {
                    System.out.print("다시 하기? Y/N >>");
                    con = sc.nextLine();
                    if (con.equals("Y") || con.equals("N"))
                        break;
                    else
                        System.out.println("이외의 문자를 입력하였습니다. 다시 입력하세요.");
                }
                if (con.equals("N")) {
                    System.out.println("프로그램 종료.");
                    break;
                }

            } catch (FileNotFoundException e) {
                System.out.println("파일이 없습니다.");
            } catch (IOException e) {
                System.out.println("Error : " + e.getMessage());
            }
        }

    }
}
