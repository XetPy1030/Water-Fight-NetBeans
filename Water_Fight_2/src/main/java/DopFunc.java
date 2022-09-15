
import java.util.Random;

public class DopFunc {
    public int ships[][] = new int[10][4];
    public int pl_1 = 0;
    public int pl_2 = 0;
    
    public int[][] CheckPole(int pole[][], int ships[][]){
        int ss, x, y;
        
        for(int z = 0; z <= 9; z++){
            ss = 0;
            x = ships[z][2];
            y = ships[z][3];
            
            for(int c = 0; c <= ships[z][0]; c++){
                if(ships[z][1] == 0){
                    if(pole[x + c][y] == 3){
                        ss++;
                    }
                }
                else {
                    if(pole[x][y + c] == 3){
                        ss++;
                    }
                }
            }
            if(ss == ships[z][0]){
                if(ships[z][1] == 0){
                    for(int sg = -1; sg <= 1; sg++){
                        for(int sd = -1; sd <= ships[z][0]; sd++){
                            pole[x + sd][y + sg] = 1;
                        }
                    }
                    for(int sg = 0; sg <= ships[z][0] - 1; sg++){
                        pole[x + sg][y] = 3;
                    }
                }
                else{
                    for(int sg = -1; sg <= ships[z][0]; sg++){
                        for(int sd = -1; sd <= 1; sd++){
                            pole[x + sd][y + sg] = 1;
                        }
                    }
                    for(int sg = 0; sg <= ships[z][0] - 1; sg++){
                        pole[x][y + sg] = 3;
                    }
                }
            }
        }
        return pole;
    }
    
    public int[][] PoleWillFull(int aa[][]){
        for(int y = 0; y <= 11; y++){
            for(int yy = 0; yy <= 11; yy++){
                aa[y][yy] = 0;
            }
        }
        return aa;
    }
    
    public void Show(int pole[][], boolean admin){
        String char_admin[] = new String[]{"00 ", "## ", "<> ", ">< "};
        String char_noadmin[] = new String[]{"00 ", "## ", "00 ", ">< "};
        System.out.print("   AA BB CC DD EE FF GG HH II JJ\n");
        for (int y = 1; y <= 10; y++){
            if (y < 10){
                System.out.print("0" +  y + " ");
            } else{
                System.out.print(y + " ");
            }
            for (int yy = 1; yy <= 10; yy++){
                if(admin){
                    System.out.print(char_admin[pole[yy][y]]);
                } else{
                    System.out.print(char_noadmin[pole[yy][y]]);
                }
            }
            System.out.println();
        }
    }
    
    public boolean CheckSpawnShip(int pole[][], int durationShip, boolean rotate, int x, int y){
        int zx = 0;
        boolean tx;
        if (rotate){
            tx = (y + durationShip) <= 11;
        } else {
            tx = (x + durationShip) <= 11;
        }
        if (tx){
            for (int zz = -1; zz < durationShip + 1; zz++){
                for (int zv = -1; zv <= 1; zv++){
                    if (rotate){
                        if (pole[x + zv][y + zz] != 2){
                            zx++;
                        }
                    } else{
                        if (pole[x + zz][y + zv] != 2){
                            zx++;
                        }
                    }
                }
            }
        }
        return tx && (zx == (durationShip + 2)*3);
    }
    
    public int[][] SpawnShip(int pole[][], int durationShip, boolean rotate, int x, int y){
        for (int zz = 0; zz < durationShip; zz++){
            if (rotate){
                pole[x][y + zz] = 2;
            } else{
                pole[x + zz][y] = 2;
            }
        }
        return pole;
    }
    
    public int[][] RandomSpawnShips(int pole[][]){
        pole = PoleWillFull(pole);
        Random rand = new Random();
        int s[] = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        int i = 0;
        
        int x, y, rotat;
        while(i < 10){
            x = (int) Math.ceil(Math.random() * 10.0);
            y = (int) Math.ceil(Math.random() * 10.0);
            rotat = (int) Math.round(Math.random());
            if (CheckSpawnShip(pole, s[i], rotat==1, x, y)){
                this.ships[i][0] = s[i];
                this.ships[i][1] = rotat;
                this.ships[i][2] = x;
                this.ships[i][3] = y;
                pole = SpawnShip(pole, s[i], rotat==1, x, y);
                i++;
            }
        }
        return pole;
    }
    
    public boolean CheckAttack(int pole[][], int at_x, int at_y){
        if (pole[at_x][at_y] == 1 || pole[at_x][at_y] == 4){
            return false;
        }
        return true;
    }
    
    public int[][] Attack(int pole[][], int[][] ships, int at_x, int at_y, int pl){
        if (pole[at_x][at_y] == 0){
            System.out.println("Промах!");
            pole[at_x][at_y] = 1;
        } else{
            pole[at_x][at_y] = 3;
            if (CheckPole(pole, ships) == pole){
                System.out.println("Попал!");
            } else{
                System.out.println("Убил!");
                pole = CheckPole(pole, ships);
                if (pl == 1){
                    pl_1++;
                } else if(pl == 2){
                    pl_2++;
                }
            }
        }
        Show(pole, false);
        return pole;
    }
    
    public int[] ConvertCoor(String a){
        int b[] = new int[2];
        String ab[] = a.split(" ");
        b[1] = Integer.parseInt(ab[1]);
        String sd = ab[0];
        if ("AA".equals(sd)){
            b[0] = 1;
        } else if("BB".equals(sd)){
            b[0] = 2;
        } else if("CC".equals(sd)){
            b[0] = 3;
        } else if("DD".equals(sd)){
            b[0] = 4;
        } else if("EE".equals(sd)){
            b[0] = 5;
        } else if("FF".equals(sd)){
            b[0] = 6;
        } else if("GG".equals(sd)){
            b[0] = 7;
        } else if("HH".equals(sd)){
            b[0] = 8;
        } else if("II".equals(sd)){
            b[0] = 9;
        } else if("JJ".equals(sd)){
            b[0] = 10;
        }
        return b;
    }
}







