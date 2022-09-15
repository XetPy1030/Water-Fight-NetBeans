import java.util.Scanner;

public class Players {
    private DopFunc df = new DopFunc();
    Scanner in = new Scanner(System.in);
    public int pl_1 = 0;
    public int pl_2 = 0;
    boolean played;
    
    private String a;
    
    public int[][] Attack_1(int pole[][], int ships[][]){
        played = true;
        System.out.print("\n\nИгрок 1 ходит\n");
        df.Show(pole, false);
        while(played){
            in = new Scanner(System.in);
            System.out.print("Введите координату для стрельбы\n");
            a = in.nextLine();
            if (df.CheckAttack(pole, df.ConvertCoor(a)[0], df.ConvertCoor(a)[1])){
                pole = df.Attack(pole, ships, df.ConvertCoor(a)[0], df.ConvertCoor(a)[1], 1);
                played = false;
            }
            in = null;
        }
        return pole;
    }
    public int[][] Attack_2(int pole[][], int ships[][]){
        played = true;
        System.out.print("\n\nИгрок 2 ходит\n");
        df.Show(pole, false);
        while(played){
            in = new Scanner(System.in);
            System.out.print("Введите координату для стрельбы\n");
            a = in.nextLine();
            if (df.CheckAttack(pole, df.ConvertCoor(a)[0], df.ConvertCoor(a)[1])){
                pole = df.Attack(pole, ships, df.ConvertCoor(a)[0], df.ConvertCoor(a)[1], 2);
                played = false;
            }
            in = null;
        }
        return pole;
    }
}
