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
        
        int pole_1[][] = new int[12][12];
        int ships_1[][] = new int[10][4]; //длитель, повернут, коор x, коор y
        pole_1 = dF.PoleWillFull(pole_1);
        pole_1 = dF.SpawnShip(pole_1, 4, false, 2, 3); ships_1[0][0] = 4; ships_1[0][1] = 0; ships_1[0][2] = 2; ships_1[0][3] = 3;
        pole_1 = dF.CheckPole(pole_1, ships_1);
        dF.Show(pole_1, true);
        dF.RandomSpawnShips(pole_1);
    }
}













