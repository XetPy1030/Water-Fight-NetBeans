public class DopFunc {
    public int[][] CheckPole(int pole[][], int ships[][]){
        int ss, x, y;
        
        for(int z = 0; z <= 0; z++){
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
        int wc1 = 1;
        int wc2 = 1;
        
        while(wc1 < 5){//длительнотсь
            while(wc2 >= wc1){
                System.out.println(wc1 + " " + wc2);
                wc2--;
            }
            wc1++;
        }
        return pole;
    }
}







