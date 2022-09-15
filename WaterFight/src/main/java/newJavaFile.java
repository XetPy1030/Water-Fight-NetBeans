
import java.util.Scanner;

/*
1 корабль — ряд из 4 клеток
2 корабля — ряд из 3 клеток
3 корабля — ряд из 2 клеток
4 корабля — ряд из 1 клетка

0 - пусто
1 - удар есть но пусто
2 - стоит корабль
3 - стоит удареный корабль
 */
public class newJavaFile {
    public static int[][] ProverkaUbitLiKorabl(int pofle1[][], int korablis[][], String korablis1[]){
        int xyx, yxy;
        int ss;
        
        for(int z = 0; z <= 9; z++){
            xyx = ConvertCoor(korablis1[z], "x");
            yxy = ConvertCoor(korablis1[z], "y");
            ss = 0;
            
            for(int c = 0; c <= korablis[z][0]; c++){
                if(korablis[z][1] == 0){
                    if(pofle1[yxy][xyx + c] == 3){
                        ss++;
                    }
                }
                else {
                    if(pofle1[yxy + c][xyx] == 3){
                        ss++;
                    }
                }
            }
            if(ss == korablis[z][0]){
                if(korablis[z][1] == 0){
                    for(int sg = yxy - 1; sg <= yxy + 1; sg++){
                        for(int sd = xyx - 1; sd <= korablis[z][0] + xyx; sd++){
                            pofle1[sg][sd] = 1;
                        }
                    }
                    for(int sg = xyx; sg <= korablis[z][0] + xyx - 1; sg++){
                        pofle1[yxy][sg] = 3;
                    }
                }
                else{
                    for(int sg = yxy - 1; sg <= korablis[z][0] + xyx - 1; sg++){
                        for(int sd = xyx - 1; sd <= xyx + 1; sd++){
                            pofle1[sg][sd] = 1;
                        }
                    }
                    for(int sg = yxy; sg <= korablis[z][0] + yxy - 1; sg++){
                        pofle1[sg][xyx] = 3;
                    }
                }
            }
        }
        return pofle1;
    }
    
    public static boolean ProverkaSpawnKorabl(int pole1[][], int korablInt, boolean KorablAngle, String coordinat){
        int yy = 0;
        int y = ConvertCoor(coordinat, "y");
        int x = ConvertCoor(coordinat, "x");
        int[][] pokle = new int[12][12];
        if (KorablAngle){
            for(int sg = y - 1; sg <= korablInt + x - 1; sg++){
                for(int sd = x - 1; sd <= x + 1; sd++){
                    if(pole1[sg][sd] != 2){
                        yy++;
                    }
                }
            }
        }
        else {
            for(int sg = y - 1; sg <= y + 1; sg++){
                for(int sd = x - 1; sd <= korablInt + x; sd++){
                    if(pole1[sg][sd] != 2){
                        yy++;
                    }
                }
            }
        }
        return yy == ((korablInt + 2)*3);
    }
    
    public static void Pokaz(int polle[][], boolean admin){
        if (!admin){
            System.out.print("   AA BB CC DD EE FF GG HH II JJ\n");
            for (int y = 1; y <= 10; y++){
                if (y < 10){
                    System.out.print("0" +  y + " ");
                } else{
                    System.out.print(y + " ");
                }
                for (int yy = 1; yy <= 10; yy++){
                    if(polle[y][yy] == 0){
                        System.out.print("00 ");
                    }
                    else if (polle[y][yy] == 1){
                        System.out.print("## ");
                    }
                    else if (polle[y][yy] == 2){
                        System.out.print("00 ");
                    }
                    else if (polle[y][yy] == 3){
                        System.out.print(">< ");
                    }
                }
                System.out.println();
            }
        }
        else {
            System.out.print("   AA BB CC DD EE FF GG HH II JJ\n");
            for (int y = 1; y <= 10; y++){
                if (y < 10){
                    System.out.print("0" +  y + " ");
                } else{
                    System.out.print(y + " ");
                }
                for (int yy = 1; yy <= 10; yy++){
                    if(polle[y][yy] == 0){
                        System.out.print("00 ");
                    }
                    else if (polle[y][yy] == 1){
                        System.out.print("## ");
                    }
                    else if (polle[y][yy] == 2){
                        System.out.print("<> ");
                    }
                    else if (polle[y][yy] == 3){
                        System.out.print(">< ");
                    }
                }
                System.out.println();
            }
        }
    }
    
    public static int[][] PoleWillFull(int aa[][], int bb){
        for(int y = 0; y <= 11; y++){
            for(int yy = 0; yy <= 11; yy++){
                aa[y][yy] = bb;
            }
        }
        return aa;
    }
    
    public static int ConvertCoor(String xc, String CoorKakaya){
        // e.g. xc = «АА 01»
        if ("x".equals(CoorKakaya)){
            int CoorX;
            String h = xc.split(" ")[0];
            if ("AA".equals(h)){
                CoorX = 1;
            }
            else if ("BB".equals(h)){
                CoorX = 2;
            }
            else if ("CC".equals(h)){
                CoorX = 3;
            }
            else if ("DD".equals(h)){
                CoorX = 4;
            }
            else if ("EE".equals(h)){
                CoorX = 5;
            }
            else if ("FF".equals(h)){
                CoorX = 6;
            }
            else if ("GG".equals(h)){
                CoorX = 7;
            }
            else if ("HH".equals(h)){
                CoorX = 8;
            }
            else if ("II".equals(h)){
                CoorX = 9;
            }
            else{
                CoorX = 10;
            }
            return CoorX;
        }
        else if ("y".equals(CoorKakaya)){
            int CoorY;
            CoorY = Integer.parseInt (xc.split(" ")[1]);
            return CoorY;
        }
        return 0;
    }
    
    public static int[][] SpawnKorabl(int pole1[][], int korablInt, boolean KorablAngle, String coordinat){
        int x = ConvertCoor(coordinat, "y");
        int y = ConvertCoor(coordinat, "x");
        if (KorablAngle){
            for (int zz = 0; zz < korablInt; zz++){
                pole1[x + zz][y] = 3;
            }
        }
        else {
            for (int zz = 0; zz < korablInt; zz++){
                pole1[x][y + zz] = 3;
            }
        }
        return pole1; 
    }
    
    public static void main(String[] args) {
        int korabli_1[][] = new int[10][2];     int korabli_2[][] = new int[10][2];     int korabla[][] = new int[10][2];
        String korabli_11[] = new String[10];   String korabli_22[] = new String[10];   String korablaa[] = new String [10];
        int pole_1[][] = new int[12][12];       int pole_2[][] = new int[12][12];       int pola[][] = new int[12][12];
        pole_1 = PoleWillFull(pole_1, 0);       pole_2 = PoleWillFull(pole_2, 0);       pola = PoleWillFull(pola, 0);
        
        Scanner in = new Scanner(System.in);
        String per;int sd;int sdf = 0;
        
        int whilechar1 = 1;
        int whilechar2 = 4;
        
        System.out.println("Игрок 1");
        while(whilechar1 < 5){//длительнотсь
            while(whilechar2 >= whilechar1){//колво
                System.out.println(whilechar1 + " " + whilechar2);
                /*in = new Scanner(System.in);
                System.out.println("Введите координату: " + z + " - палубного корабля(к примеру: \"HH 06\")");
                per = in.nextLine();
                System.out.println("Повернуть вертикально корабль?(0 - нет, 1 - да)");
                sd = in.nextInt();
                if (ProverkaSpawnKorabl(pola, z, (sd == 1), per)){
                    sdf++;
                    pola = SpawnKorabl(pola, z, (sd == 1), per);korabla[sdf][0] = z;korabla[sdf][1] = sd;korablaa[sdf] = per;
                    Pokaz(pola, true);
                }
                else {
                    s--;
                    System.out.println("Ошибка, походу у тебя корабли соприкосаются");
                }
                in = null;*/
                whilechar2++;
            }
            whilechar1++;
        }
        pole_1 = pola;
        korabli_1 = korabla;
        korabli_11 = korablaa;
        
        Pokaz(pole_1, true);
        Pokaz(ProverkaUbitLiKorabl(pole_1, korabli_1, korabli_11), true);
        
        //pole_1 = SpawnKorabl(pole_1, 4, true, "ББ 02");korabli_1[0][0] = 4;korabli_1[0][1] = 1;korabli_11[0] = "ББ 02";
        //Pokaz(pole_1, true);
        //pole_1 = ProverkaUbitLiKorabl(pole_1, korabli_1, korabli_11);
    }
}






