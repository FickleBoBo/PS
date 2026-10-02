package day_05.BOJ_B4_5543;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int burgerA = Integer.parseInt(br.readLine());
        int burgerB = Integer.parseInt(br.readLine());
        int burgerC = Integer.parseInt(br.readLine());

        int cola = Integer.parseInt(br.readLine());
        int cider = Integer.parseInt(br.readLine());

        int cheapBurger = Math.min(burgerA, Math.min(burgerB, burgerC));
        int cheapDrink = Math.min(cola, cider);

        System.out.println(cheapBurger + cheapDrink - 50);
    }
}
