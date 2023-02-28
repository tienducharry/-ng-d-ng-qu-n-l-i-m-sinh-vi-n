import java.lang.Math;
import java.util.Scanner;

public class GradeStudent {
    int weight;
    int score;
    int shifted;
    int shiftPoint;
    int total;
    int sumWeight = 0;
    double weighted;
    double midWeighted;
    double finalWeighted;
    double homeWeighted;
    Scanner sc = new Scanner(System.in);
    public static void main(String[] agrs){
        GradeStudent myObj = new GradeStudent();
        myObj.begin();
        myObj.midTerm();
        myObj.finalTerm();
        myObj.homeWork();
        myObj.report();
    }




    public void begin(){    //ham begin gioi thieu so ve ung dung
        System.out.println("This program reads exam/homework scores \nand reports your overall course grade.\n");
    }

    public double term() {      //ham term de tinh toan diem thi
        System.out.print("Weight (0-100)? ");
        weight = sc.nextInt();
        sumWeight = sumWeight + weight;
        System.out.print("Score earned? ");
        score = sc.nextInt();

        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        shifted = sc.nextInt();
        if (shifted == 1) {  //Neu duoc cong diem thi hien thi nhap diem cong
            System.out.print("Shift amount? ");
            shiftPoint = sc.nextInt();
        } else {
            shiftPoint = 0;
        }
        total = score + shiftPoint;
        if (total > 100) total = 100;   // dam bao diem sau cong k qua 100
        System.out.println("Total points = " + total + " / 100");
        weighted = (double) Math.round(((double)total * (double)weight / 100)*10)/10;
        if (weighted > weight) weighted = weight;
        System.out.println("Weighted score = " + weighted + " /" + weight);
        System.out.println();
        return weighted;
    }

    public void midTerm(){  //ham tinh toan diem thi giua ky
        System.out.println("Midterm:");
        midWeighted = term();   //goi ham term de tra ve diem giua ky
    }

    public void finalTerm(){    //ham tinh toan diem thi cuoi ky
        System.out.println("Final:");
        finalWeighted = term();     //goi ham term de tra ve diem cuoi ky
    }

    public void homeWork(){     //ham tinh toan diem bai tap ve nha
        System.out.println("Homework:");
        int homeWeight = 100 - sumWeight; //dam bao tong 3 trong so bang 100
        System.out.println("Weight (0-100)? " + homeWeight);
        System.out.print("Number of assignments? ");
        int asmNum = sc.nextInt();
        int[][] asmScore = new int[asmNum][2];  //tao 2D array theo so bai ASM de luu diem asm
        for (int i = 0; i < asmNum; i++) {
            System.out.print("Assignment " + (i+1) + " score and max? ");
            for (int j = 0; j < 2 ; j++) {
                asmScore[i][j] = sc.nextInt();  //ghi gia tri cho cac phan tu tuong ung trong 2D array
            }
        }
        System.out.print("How many sections did you attend? ");
        int sects = sc.nextInt();
        int attend = sects * 5;
        if (attend > 30) attend = 30; // dam bao attend k vuot qua 30
        System.out.println("Section points = " + attend + " / 30");
        int asmPoint = 0;
        int asmMax = 0;
        for (int i = 0; i < asmNum; i++) {
            asmPoint = asmPoint + asmScore[i][0];   //tinh tong diem cac bai ASM
            asmMax = asmMax + asmScore[i][1];   //tinh tong diem toi da cua cac bai ASM
        }
        if (asmPoint > 150) asmPoint = 150; // tong diem ASM k vuot qua 150
        int totalPoint = asmPoint + attend; //tong diem dat duoc
        int totalMax = asmMax + 30; //tong diem toi da cua tat ca cac bai tap ve nha
        System.out.println("Total points = " + totalPoint + " / " + totalMax);
        homeWeighted = Math.round((((double) totalPoint / (double)totalMax) * homeWeight)*10)/10;
        System.out.println("Weighted score = " + homeWeighted + " / " + homeWeight);
    }

    public void report(){   //ham report de hien thi ket qua GPA va thong bao nhan xer
        double overallP = midWeighted + finalWeighted + homeWeighted;
        System.out.println("Overall percentage = " + overallP);
        double GPA;
        if (overallP == 100) {GPA = 4.0;} else if (overallP >= 85) {GPA = 3.0;} else if (overallP >= 75) { GPA = 2.0;} else if (overallP >= 60) { GPA = 1.0;} else {GPA = 0.0;}
        System.out.println("Your grade will be at least: " + GPA);
        if (GPA == 4.0) {
            System.out.println("CONGRATS!! You were perfectly complete this course...");
        } else if (GPA == 3.0) {
            System.out.println("Great work!! But you can be better. Try more next time.");
        } else if (GPA == 2.0) {
            System.out.println("You have been completed but it is not really good. Try harder.");
        } else if (GPA == 1.0) {
            System.out.println("Did you work hard? This result is so bad. Hope you can be harder.");
        } else if (GPA == 0.0) {
            System.out.println("What a bad! This exactly how the word \"BAD\" was defined");
        }
    }
}

