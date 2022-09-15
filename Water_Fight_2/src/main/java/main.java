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
public class main {
    public static void main(String args[]) {
        DopFunc dF = new DopFunc();
        Players Pl = new Players();
        
        int pole_1[][] = new int[12][12];
        int ships_1[][] = new int[10][4]; //длитель, повернут, коор x, коор y
        int pole_2[][] = new int[12][12];
        int ships_2[][] = new int[10][4]; //длитель, повернут, коор x, коор y
        
        pole_1 = dF.RandomSpawnShips(pole_1);
        ships_1 = dF.ships;
        pole_2 = dF.RandomSpawnShips(pole_2);
        ships_2 = dF.ships;
        
        dF.Show(pole_1, true);
        dF.Show(pole_2, true);
        
        boolean playing = true;
        while (dF.pl_1 != 10 && dF.pl_2 != 10){
            pole_2 = Pl.Attack_1(pole_2, ships_2);
            pole_1 = Pl.Attack_2(pole_1, ships_1);
        }
    }
}













