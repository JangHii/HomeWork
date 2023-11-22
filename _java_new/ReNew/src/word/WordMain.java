package word;

import java.util.Scanner;

public class WordMain {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        WordManager wm = new WordManager();

        int menu = -1;

        do {
            wm.menuprint();
            menu = scan.nextInt();

            try {
                switch (menu) {
                    case 1:
                        wm.wordadd(scan);
                        break;
                    case 2:
                        wm.wordSearch(scan);
                        break;
                    case 3:
                        wm.wordSub(scan);
                        break;
                    case 4:
                        wm.wordPrint();
                        break;
                    case 5:
                        wm.filePrint();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }
            } catch (Exception e) {
                System.out.println("파일출력 error");
                e.printStackTrace();
            }
        } while (menu != 6);  
        System.out.println("단어장 종료");

        scan.close();
    }
}