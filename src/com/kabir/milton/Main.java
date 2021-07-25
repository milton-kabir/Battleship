//package battleship;

 package com.kabir.milton;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String ar[][] = new String[12][12];
    public static String br[][] = new String[12][12];
    public static String cr[][] = new String[12][12];
    public static String dr[][] = new String[12][12];

    public static void printa() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printb() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(br[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printc() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(cr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printd() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(dr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println("Player 1, place your ships on the game field");
        for (int i = 0; i < 12; i++) {
            ar[i][0] = "";
            for (int j = 0; j < 12; j++) {
                ar[i][j] = "~";
            }
        }
        ar[0][0] = " ";
        int x = 'A';
        for (int i = 1; i < 11; i++) {
            ar[0][i] = Integer.toString(i);
            char y = (char) (x);
            ar[i][0] = Character.toString(y);
            x++;
        }
        printa();
//        br=ar;
        for (int i = 0; i < 12; i++) {
            br[i][0] = "";
            for (int j = 0; j < 12; j++) {
                br[i][j] = "~";
            }
        }
        br[0][0] = " ";
        x = 'A';
        for (int i = 1; i < 11; i++) {
            br[0][i] = Integer.toString(i);
            char y = (char) (x);
            br[i][0] = Character.toString(y);
            x++;
        }
        Map<String, String> arc = new HashMap<String, String>();
        Map<String, String> btt = new HashMap<String, String>();
        Map<String, String> sub = new HashMap<String, String>();
        Map<String, String> cru = new HashMap<String, String>();
        Map<String, String> des = new HashMap<String, String>();

        Map<String, String> mp = new HashMap<String, String>();
        mp.put("arc", "1");
        mp.put("btt", "1");
        mp.put("sub", "1");
        mp.put("cru", "1");
        mp.put("des", "1");


        Scanner sc = new Scanner(System.in);
        int ck = 0;
        while (true) {
            if (ck == 1) {
                break;
            }
            System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
            String inp[] = sc.nextLine().split(" ");
            String s1 = inp[0].substring(0, 1);
            String s2 = inp[1].substring(0, 1);
            if (s1.equals(s2)) {
                int xx = Integer.parseInt(inp[0].substring(1));
                int yy = Integer.parseInt(inp[1].substring(1));
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 5) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                int ee = 0;
                for (int i = 0; i < 11; i++) {
                    if (ar[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            if (ar[i - 1][j] == "O" || ar[i + 1][j] == "O" || ar[i][j + 1] == "O") {
                                ee = 1;
                            }
                        }
                    }
                }
                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int i = 0; i < 11; i++) {
                    if (ar[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            ar[i][j] = "O";
                            arc.put(s1 + Integer.toString(j), "O");
                        }
                    }
                }
            } else if (Integer.parseInt(inp[0].substring(1)) == Integer.parseInt(inp[1].substring(1))) {
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
                int xx = c1 - 'A' + 1;
                int yy = c2 - 'A' + 1;
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 5) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                int ee = 0;
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    if (ar[j][Integer.parseInt(inp[0].substring(1)) - 1] == "O" || ar[j][Integer.parseInt(inp[0].substring(1)) + 1] == "O" || ar[j + 1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    ar[j][Integer.parseInt(inp[0].substring(1))] = "O";
                    int ab = j + 'A' - 1;
                    char ch = (char) (ab);
                    String aa = Character.toString(ch);
                    String bb = inp[0].substring(1);
                    arc.put(aa + bb, "O");
                }
            } else {
                System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                continue;
            }

            printa();
            break;
        }

        ck = 0;
        while (true) {
            if (ck == 1) {
                break;
            }
            System.out.println("Enter the coordinates of the Battleship (4 cells):");
            String inp[] = sc.nextLine().split(" ");
            String s1 = inp[0].substring(0, 1);
            String s2 = inp[1].substring(0, 1);
            if (s1.equals(s2)) {
                int xx = Integer.parseInt(inp[0].substring(1));
                int yy = Integer.parseInt(inp[1].substring(1));
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 4) {
                    System.out.println("Error! Wrong length of the Battleship! Try again:");
                    continue;
                }
                int ee = 0;
                for (int i = 0; i < 11; i++) {
                    if (ar[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            if (ar[i - 1][j] == "O" || ar[i + 1][j] == "O" || ar[i][j + 1] == "O") {
                                ee = 1;
                            }
                        }
                    }
                }
                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int i = 0; i < 11; i++) {
                    if (ar[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            ar[i][j] = "O";
                            btt.put(s1 + Integer.toString(j), "O");
                        }
                    }
                }

            } else if (Integer.parseInt(inp[0].substring(1)) == Integer.parseInt(inp[1].substring(1))) {
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
                int xx = c1 - 'A' + 1;
                int yy = c2 - 'A' + 1;
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 4) {
                    System.out.println("Error! Wrong length of the Battleship! Try again:");
                    continue;
                }
                int ee = 0;
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    if (ar[j][Integer.parseInt(inp[0].substring(1)) - 1] == "O" || ar[j][Integer.parseInt(inp[0].substring(1)) + 1] == "O" || ar[j + 1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    ar[j][Integer.parseInt(inp[0].substring(1))] = "O";
                    int ab = j + 'A' - 1;
                    char ch = (char) (ab);
                    String aa = Character.toString(ch);
                    String bb = inp[0].substring(1);
                    btt.put(aa + bb, "O");
                }
            } else {
                System.out.println("Error! Wrong length of the Battleship! Try again:");
                continue;
            }

            printa();
            break;
        }
        ck = 0;
        while (true) {
            if (ck == 1) {
                break;
            }
            System.out.println("Enter the coordinates of the Submarine (3 cells):");
            String inp[] = sc.nextLine().split(" ");
            String s1 = inp[0].substring(0, 1);
            String s2 = inp[1].substring(0, 1);
            if (s1.equals(s2)) {
                int xx = Integer.parseInt(inp[0].substring(1));
                int yy = Integer.parseInt(inp[1].substring(1));
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 3) {
                    System.out.println("Error! Wrong length of the Submarine! Try again:");
                    continue;
                }
                int ee = 0;
                for (int i = 0; i < 11; i++) {
                    if (ar[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            if (ar[i - 1][j] == "O" || ar[i + 1][j] == "O" || ar[i][j + 1] == "O") {
                                ee = 1;
                            }
                        }
                    }
                }
                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int i = 0; i < 11; i++) {
                    if (ar[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            ar[i][j] = "O";
                            sub.put(s1 + Integer.toString(j), "O");
                        }
                    }
                }

            } else if (Integer.parseInt(inp[0].substring(1)) == Integer.parseInt(inp[1].substring(1))) {
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
                int xx = c1 - 'A' + 1;
                int yy = c2 - 'A' + 1;
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 3) {
                    System.out.println("Error! Wrong length of the Submarine! Try again:");
                    continue;
                }

                int ee = 0;
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    if (ar[j][Integer.parseInt(inp[0].substring(1)) - 1] == "O" || ar[j][Integer.parseInt(inp[0].substring(1)) + 1] == "O" || ar[j + 1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    ar[j][Integer.parseInt(inp[0].substring(1))] = "O";
                    int ab = j + 'A' - 1;
                    char ch = (char) (ab);
                    String aa = Character.toString(ch);
                    String bb = inp[0].substring(1);
                    sub.put(aa + bb, "O");
                }
            } else {
                System.out.println("Error! Wrong length of the Submarine! Try again:");
                continue;
            }

            printa();
            break;
        }
        ck = 0;
        while (true) {
            if (ck == 1) {
                break;
            }
            System.out.println("Enter the coordinates of the Cruiser (3 cells):");
            String inp[] = sc.nextLine().split(" ");
            String s1 = inp[0].substring(0, 1);
            String s2 = inp[1].substring(0, 1);
            if (s1.equals(s2)) {
                int xx = Integer.parseInt(inp[0].substring(1));
                int yy = Integer.parseInt(inp[1].substring(1));
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 3) {
                    System.out.println("Error! Wrong length of the Cruiser! Try again:");
                    continue;
                }
                int ee = 0;
                for (int i = 0; i < 11; i++) {
                    if (ar[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            if (ar[i - 1][j] == "O" || ar[i + 1][j] == "O" || ar[i][j + 1] == "O") {
                                ee = 1;
                            }
                        }
                    }
                }
                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }

                for (int i = 0; i < 11; i++) {
                    if (ar[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            ar[i][j] = "O";
                            cru.put(s1 + Integer.toString(j), "O");
                        }
                    }
                }

            } else if (Integer.parseInt(inp[0].substring(1)) == Integer.parseInt(inp[1].substring(1))) {
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
                int xx = c1 - 'A' + 1;
                int yy = c2 - 'A' + 1;
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 3) {
                    System.out.println("Error! Wrong length of the Cruiser! Try again:");
                    continue;
                }
                int ee = 0;
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    if (ar[j][Integer.parseInt(inp[0].substring(1)) - 1] == "O" || ar[j][Integer.parseInt(inp[0].substring(1)) + 1] == "O" || ar[j + 1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    ar[j][Integer.parseInt(inp[0].substring(1))] = "O";
                    int ab = j + 'A' - 1;
                    char ch = (char) (ab);
                    String aa = Character.toString(ch);
                    String bb = inp[0].substring(1);
                    cru.put(aa + bb, "O");
                }
            } else {
                System.out.println("Error! Wrong length of the Cruiser! Try again:");
                continue;
            }

            printa();
            break;
        }
        ck = 0;
        while (true) {
            if (ck == 1) {
                break;
            }
            System.out.println("Enter the coordinates of the Destroyer (2 cells):");
            String inp[] = sc.nextLine().split(" ");
            String s1 = inp[0].substring(0, 1);
            String s2 = inp[1].substring(0, 1);
            if (s1.equals(s2)) {
                int xx = Integer.parseInt(inp[0].substring(1));
                int yy = Integer.parseInt(inp[1].substring(1));
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 2) {
                    System.out.println("Error! Wrong length of the Destroyer! Try again:");
                    continue;
                }
                int ee = 0;
                for (int i = 0; i < 11; i++) {
                    if (ar[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            if (ar[i - 1][j] == "O" || ar[i + 1][j] == "O" || ar[i][j + 1] == "O") {
                                ee = 1;
                            }
                        }
                    }
                }
                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }

                for (int i = 0; i < 11; i++) {
                    if (ar[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            ar[i][j] = "O";
                            des.put(s1 + Integer.toString(j), "O");
                        }
                    }
                }

            } else if (Integer.parseInt(inp[0].substring(1)) == Integer.parseInt(inp[1].substring(1))) {
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
                int xx = c1 - 'A' + 1;
                int yy = c2 - 'A' + 1;
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 2) {
                    System.out.println("Error! Wrong length of the Destroyer! Try again:");
                    continue;
                }
                int ee = 0;
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    if (ar[j][Integer.parseInt(inp[0].substring(1)) - 1] == "O" || ar[j][Integer.parseInt(inp[0].substring(1)) + 1] == "O" || ar[j + 1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    ar[j][Integer.parseInt(inp[0].substring(1))] = "O";
                    int ab = j + 'A' - 1;
                    char ch = (char) (ab);
                    String aa = Character.toString(ch);
                    String bb = inp[0].substring(1);
                    des.put(aa + bb, "O");
                }
            } else {
                System.out.println("Error! Wrong length of the Destroyer! Try again:");
                continue;
            }

            printa();
            break;
        }


        //Player 2 Input
        System.out.println("Press Enter and pass the move to another player");
        promptEnterKey();
        System.out.println("Player 2, place your ships to the game field");
        for (int i = 0; i < 12; i++) {
            cr[i][0] = "";
            for (int j = 0; j < 12; j++) {
                cr[i][j] = "~";
            }
        }
        cr[0][0] = " ";
        x = 'A';
        for (int i = 1; i < 11; i++) {
            cr[0][i] = Integer.toString(i);
            char y = (char) (x);
            cr[i][0] = Character.toString(y);
            x++;
        }
        printc();
//        br=ar;
        for (int i = 0; i < 12; i++) {
            dr[i][0] = "";
            for (int j = 0; j < 12; j++) {
                dr[i][j] = "~";
            }
        }
        dr[0][0] = " ";
        x = 'A';
        for (int i = 1; i < 11; i++) {
            dr[0][i] = Integer.toString(i);
            char y = (char) (x);
            dr[i][0] = Character.toString(y);
            x++;
        }
        Map<String, String> arc2 = new HashMap<String, String>();
        Map<String, String> btt2 = new HashMap<String, String>();
        Map<String, String> sub2 = new HashMap<String, String>();
        Map<String, String> cru2 = new HashMap<String, String>();
        Map<String, String> des2 = new HashMap<String, String>();

        Map<String, String> mp2 = new HashMap<String, String>();
        mp2.put("arc2", "1");
        mp2.put("btt2", "1");
        mp2.put("sub2", "1");
        mp2.put("cru2", "1");
        mp2.put("des2", "1");


        int ck2 = 0;
        while (true) {
            if (ck2 == 1) {
                break;
            }
            System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
            String inp[] = sc.nextLine().split(" ");
            String s1 = inp[0].substring(0, 1);
            String s2 = inp[1].substring(0, 1);
            if (s1.equals(s2)) {
                int xx = Integer.parseInt(inp[0].substring(1));
                int yy = Integer.parseInt(inp[1].substring(1));
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 5) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                int ee = 0;
                for (int i = 0; i < 11; i++) {
                    if (cr[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            if (cr[i - 1][j] == "O" || cr[i + 1][j] == "O" || cr[i][j + 1] == "O") {
                                ee = 1;
                            }
                        }
                    }
                }
                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int i = 0; i < 11; i++) {
                    if (cr[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            cr[i][j] = "O";
                            arc2.put(s1 + Integer.toString(j), "O");
                        }
                    }
                }
            } else if (Integer.parseInt(inp[0].substring(1)) == Integer.parseInt(inp[1].substring(1))) {
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
                int xx = c1 - 'A' + 1;
                int yy = c2 - 'A' + 1;
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 5) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                int ee = 0;
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    if (cr[j][Integer.parseInt(inp[0].substring(1)) - 1] == "O" || cr[j][Integer.parseInt(inp[0].substring(1)) + 1] == "O" || cr[j + 1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    cr[j][Integer.parseInt(inp[0].substring(1))] = "O";
                    int ab = j + 'A' - 1;
                    char ch = (char) (ab);
                    String aa = Character.toString(ch);
                    String bb = inp[0].substring(1);
                    arc2.put(aa + bb, "O");
                }
            } else {
                System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                continue;
            }

            printc();
            break;
        }

        ck2 = 0;
        while (true) {
            if (ck2 == 1) {
                break;
            }
            System.out.println("Enter the coordinates of the Battleship (4 cells):");
            String inp[] = sc.nextLine().split(" ");
            String s1 = inp[0].substring(0, 1);
            String s2 = inp[1].substring(0, 1);
            if (s1.equals(s2)) {
                int xx = Integer.parseInt(inp[0].substring(1));
                int yy = Integer.parseInt(inp[1].substring(1));
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 4) {
                    System.out.println("Error! Wrong length of the Battleship! Try again:");
                    continue;
                }
                int ee = 0;
                for (int i = 0; i < 11; i++) {
                    if (cr[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            if (cr[i - 1][j] == "O" || cr[i + 1][j] == "O" || cr[i][j + 1] == "O") {
                                ee = 1;
                            }
                        }
                    }
                }
                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int i = 0; i < 11; i++) {
                    if (cr[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            cr[i][j] = "O";
                            btt2.put(s1 + Integer.toString(j), "O");
                        }
                    }
                }

            } else if (Integer.parseInt(inp[0].substring(1)) == Integer.parseInt(inp[1].substring(1))) {
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
                int xx = c1 - 'A' + 1;
                int yy = c2 - 'A' + 1;
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 4) {
                    System.out.println("Error! Wrong length of the Battleship! Try again:");
                    continue;
                }
                int ee = 0;
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    if (cr[j][Integer.parseInt(inp[0].substring(1)) - 1] == "O" || cr[j][Integer.parseInt(inp[0].substring(1)) + 1] == "O" || cr[j + 1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    cr[j][Integer.parseInt(inp[0].substring(1))] = "O";
                    int ab = j + 'A' - 1;
                    char ch = (char) (ab);
                    String aa = Character.toString(ch);
                    String bb = inp[0].substring(1);
                    btt2.put(aa + bb, "O");
                }
            } else {
                System.out.println("Error! Wrong length of the Battleship! Try again:");
                continue;
            }

            printc();
            break;
        }
        ck2 = 0;
        while (true) {
            if (ck2 == 1) {
                break;
            }
            System.out.println("Enter the coordinates of the submarine (3 cells):");
            String inp[] = sc.nextLine().split(" ");
            String s1 = inp[0].substring(0, 1);
            String s2 = inp[1].substring(0, 1);
            if (s1.equals(s2)) {
                int xx = Integer.parseInt(inp[0].substring(1));
                int yy = Integer.parseInt(inp[1].substring(1));
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 3) {
                    System.out.println("Error! Wrong length of the submarine! Try again:");
                    continue;
                }
                int ee = 0;
                for (int i = 0; i < 11; i++) {
                    if (cr[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            if (cr[i - 1][j] == "O" || cr[i + 1][j] == "O" || cr[i][j + 1] == "O") {
                                ee = 1;
                            }
                        }
                    }
                }
                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int i = 0; i < 11; i++) {
                    if (cr[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            cr[i][j] = "O";
                            sub2.put(s1 + Integer.toString(j), "O");
                        }
                    }
                }

            } else if (Integer.parseInt(inp[0].substring(1)) == Integer.parseInt(inp[1].substring(1))) {
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
                int xx = c1 - 'A' + 1;
                int yy = c2 - 'A' + 1;
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 3) {
                    System.out.println("Error! Wrong length of the submarine! Try again:");
                    continue;
                }

                int ee = 0;
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    if (cr[j][Integer.parseInt(inp[0].substring(1)) - 1] == "O" || cr[j][Integer.parseInt(inp[0].substring(1)) + 1] == "O" || cr[j + 1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    cr[j][Integer.parseInt(inp[0].substring(1))] = "O";
                    int ab = j + 'A' - 1;
                    char ch = (char) (ab);
                    String aa = Character.toString(ch);
                    String bb = inp[0].substring(1);
                    sub2.put(aa + bb, "O");
                }
            } else {
                System.out.println("Error! Wrong length of the submarine! Try again:");
                continue;
            }

            printc();
            break;
        }
        ck2 = 0;
        while (true) {
            if (ck2 == 1) {
                break;
            }
            System.out.println("Enter the coordinates of the Cruiser (3 cells):");
            String inp[] = sc.nextLine().split(" ");
            String s1 = inp[0].substring(0, 1);
            String s2 = inp[1].substring(0, 1);
            if (s1.equals(s2)) {
                int xx = Integer.parseInt(inp[0].substring(1));
                int yy = Integer.parseInt(inp[1].substring(1));
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 3) {
                    System.out.println("Error! Wrong length of the Cruiser! Try again:");
                    continue;
                }
                int ee = 0;
                for (int i = 0; i < 11; i++) {
                    if (cr[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            if (cr[i - 1][j] == "O" || cr[i + 1][j] == "O" || cr[i][j + 1] == "O") {
                                ee = 1;
                            }
                        }
                    }
                }
                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }

                for (int i = 0; i < 11; i++) {
                    if (cr[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            cr[i][j] = "O";
                            cru2.put(s1 + Integer.toString(j), "O");
                        }
                    }
                }

            } else if (Integer.parseInt(inp[0].substring(1)) == Integer.parseInt(inp[1].substring(1))) {
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
                int xx = c1 - 'A' + 1;
                int yy = c2 - 'A' + 1;
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 3) {
                    System.out.println("Error! Wrong length of the Cruiser! Try again:");
                    continue;
                }
                int ee = 0;
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    if (cr[j][Integer.parseInt(inp[0].substring(1)) - 1] == "O" || cr[j][Integer.parseInt(inp[0].substring(1)) + 1] == "O" || cr[j + 1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    cr[j][Integer.parseInt(inp[0].substring(1))] = "O";
                    int ab = j + 'A' - 1;
                    char ch = (char) (ab);
                    String aa = Character.toString(ch);
                    String bb = inp[0].substring(1);
                    cru2.put(aa + bb, "O");
                }
            } else {
                System.out.println("Error! Wrong length of the Cruiser! Try again:");
                continue;
            }

            printc();
            break;
        }
        ck2 = 0;
        while (true) {
            if (ck2 == 1) {
                break;
            }
            System.out.println("Enter the coordinates of the Destroyer (2 cells):");
            String inp[] = sc.nextLine().split(" ");
            String s1 = inp[0].substring(0, 1);
            String s2 = inp[1].substring(0, 1);
            if (s1.equals(s2)) {
                int xx = Integer.parseInt(inp[0].substring(1));
                int yy = Integer.parseInt(inp[1].substring(1));
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 2) {
                    System.out.println("Error! Wrong length of the Destroyer! Try again:");
                    continue;
                }
                int ee = 0;
                for (int i = 0; i < 11; i++) {
                    if (cr[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            if (cr[i - 1][j] == "O" || cr[i + 1][j] == "O" || cr[i][j + 1] == "O") {
                                ee = 1;
                            }
                        }
                    }
                }
                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }

                for (int i = 0; i < 11; i++) {
                    if (cr[i][0].equals(s1)) {
                        for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                            cr[i][j] = "O";
                            des2.put(s1 + Integer.toString(j), "O");
                        }
                    }
                }

            } else if (Integer.parseInt(inp[0].substring(1)) == Integer.parseInt(inp[1].substring(1))) {
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
                int xx = c1 - 'A' + 1;
                int yy = c2 - 'A' + 1;
                int dd = Math.abs(yy - xx);
                if (dd + 1 != 2) {
                    System.out.println("Error! Wrong length of the Destroyer! Try again:");
                    continue;
                }
                int ee = 0;
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    if (cr[j][Integer.parseInt(inp[0].substring(1)) - 1] == "O" || cr[j][Integer.parseInt(inp[0].substring(1)) + 1] == "O" || cr[j + 1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    cr[j][Integer.parseInt(inp[0].substring(1))] = "O";
                    int ab = j + 'A' - 1;
                    char ch = (char) (ab);
                    String aa = Character.toString(ch);
                    String bb = inp[0].substring(1);
                    des2.put(aa + bb, "O");
                }
            } else {
                System.out.println("Error! Wrong length of the Destroyer! Try again:");
                continue;
            }

            printc();
            break;
        }


//        System.out.println(arc);
//        System.out.println(btt);
//        System.out.println(sub);
//        System.out.println(cru);
//        System.out.println(des);

        //Game Starts

        int trn = 1;
        while (true) {
            System.out.println("Press Enter and pass the move to another player");
            promptEnterKey();

            if (trn == 1) {
                trn = 2;
                printd();
                for (int i = 0; i < 23; i++) {
                    System.out.print("-");
                }
                System.out.println();
                printa();
                //HEREE

                System.out.println("Player 1, it's your turn:");
                String inp[] = sc.nextLine().split(" ");
                String s1 = inp[0].substring(0, 1);
                String s2 = inp[0].substring(1);
                int e1 = 0, e2 = 0, ee = 1;
                for (int i = 1; i < 11; i++) {
                    if (cr[i][0].equals(s1)) {
                        e1 = 1;
                    }
                    if (cr[0][i].equals(s2)) {
                        e2 = 1;
                    }
                }
                if (e1 == 0 || e2 == 0) {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                    continue;
                }

                for (int i = 1; i < 11; i++) {
                    if (cr[i][0].equals(s1)) {
                        for (int j = 1; j < 11; j++) {
                            if (cr[0][j].equals(s2)) {
                                if (cr[i][j] == "O") {
                                    cr[i][j] = "X";
                                    dr[i][j] = "X";
                                    ee = 0;
                                }

                            }
                        }
                    }
                }
                if (ee == 0) {
                    arc2.remove(inp[0]);
                    btt2.remove(inp[0]);
                    sub2.remove(inp[0]);
                    cru2.remove(inp[0]);
                    des2.remove(inp[0]);
                    if (arc2.size() == 0) {
                        if (mp2.containsKey("arc")) {
                            mp2.remove("arc");
                            if (mp2.size() == 0) {
                                System.out.println("Player 1 won. Congratulations!");
                                break;
                            }
                            System.out.println("You sank a ship! Specify a new target:");

                            continue;
                        }

                    }
                    if (btt2.size() == 0) {
                        if (mp2.containsKey("btt")) {
                            mp2.remove("btt");
                            if (mp2.size() == 0) {
                                System.out.println("Player 1 won. Congratulations!");
                                break;
                            }
                            System.out.println("You sank a ship! Specify a new target:");

                            continue;
                        }

                    }
                    if (sub2.size() == 0) {
                        if (mp2.containsKey("sub")) {
                            mp2.remove("sub");
                            if (mp2.size() == 0) {
                                System.out.println("Player 1 won. Congratulations!");
                                break;
                            }
                            System.out.println("You sank a ship! Specify a new target:");

                            continue;
                        }
                    }
                    if (cru2.size() == 0) {
                        if (mp2.containsKey("cru")) {
                            mp2.remove("cru");
                            if (mp2.size() == 0) {
                                System.out.println("Player 1 won. Congratulations!");
                                break;
                            }
                            System.out.println("You sank a ship! Specify a new target:");

                            continue;
                        }

                    }

                    if (des2.size() == 0) {
                        if (mp2.containsKey("des")) {
                            mp2.remove("des");
                            if (mp2.size() == 0) {
                                System.out.println("Player 1 won. Congratulations!");
                                break;
                            }
                            System.out.println("You sank a ship! Specify a new target:");
                            continue;
                        }

                    }

                    System.out.println("You hit a ship!");
                } else {
                    for (int i = 1; i < 11; i++) {
                        if (cr[i][0].equals(s1)) {
                            for (int j = 1; j < 11; j++) {
                                if (cr[0][j].equals(s2)) {
                                    if (cr[i][j] != "X" && dr[i][j] != "X") {
                                        cr[i][j] = "M";
                                        dr[i][j] = "M";
                                    }
                                }
                            }
                        }
                    }

                    System.out.println("You missed!");
                }


                //HERE

            } else {

                trn = 1;
                printb();
                for (int i = 0; i < 23; i++) {
                    System.out.print("-");
                }
                System.out.println();
                printc();
                //Here

                System.out.println("Player 2, it's your turn:");
                String inp[] = sc.nextLine().split(" ");
                String s1 = inp[0].substring(0, 1);
                String s2 = inp[0].substring(1);
                int e1 = 0, e2 = 0, ee = 1;
                for (int i = 1; i < 11; i++) {
                    if (ar[i][0].equals(s1)) {
                        e1 = 1;
                    }
                    if (ar[0][i].equals(s2)) {
                        e2 = 1;
                    }
                }
                if (e1 == 0 || e2 == 0) {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                    continue;
                }

                for (int i = 1; i < 11; i++) {
                    if (ar[i][0].equals(s1)) {
                        for (int j = 1; j < 11; j++) {
                            if (ar[0][j].equals(s2)) {
                                if (ar[i][j] == "O") {
                                    ar[i][j] = "X";
                                    br[i][j] = "X";
                                    ee = 0;
                                }

                            }
                        }
                    }
                }
                if (ee == 0) {
                    arc.remove(inp[0]);
                    btt.remove(inp[0]);
                    sub.remove(inp[0]);
                    cru.remove(inp[0]);
                    des.remove(inp[0]);
                    if (arc.size() == 0) {
                        if (mp.containsKey("arc")) {
                            mp.remove("arc");
                            if (mp.size() == 0) {
                                System.out.println("Player 2 won. Congratulations!");
                                break;
                            }
                            System.out.println("You sank a ship! Specify a new target:");

                            continue;
                        }

                    }
                    if (btt.size() == 0) {
                        if (mp.containsKey("btt")) {
                            mp.remove("btt");
                            if (mp.size() == 0) {
                                System.out.println("Player 2 won. Congratulations!");
                                break;
                            }
                            System.out.println("You sank a ship! Specify a new target:");

                            continue;
                        }

                    }
                    if (sub.size() == 0) {
                        if (mp.containsKey("sub")) {
                            mp.remove("sub");
                            if (mp.size() == 0) {
                                System.out.println("Player 2 won. Congratulations!");
                                break;
                            }
                            System.out.println("You sank a ship! Specify a new target:");

                            continue;
                        }
                    }
                    if (cru.size() == 0) {
                        if (mp.containsKey("cru")) {
                            mp.remove("cru");
                            if (mp.size() == 0) {
                                System.out.println("Player 2 won. Congratulations!");
                                break;
                            }
                            System.out.println("You sank a ship! Specify a new target:");

                            continue;
                        }

                    }

                    if (des.size() == 0) {
                        if (mp.containsKey("des")) {
                            mp.remove("des");
                            if (mp.size() == 0) {
                                System.out.println("Player 2 won. Congratulations!");
                                break;
                            }
                            System.out.println("You sank a ship! Specify a new target:");
                            continue;
                        }

                    }

                    System.out.println("You hit a ship!");
                } else {
                    for (int i = 1; i < 11; i++) {
                        if (ar[i][0].equals(s1)) {
                            for (int j = 1; j < 11; j++) {
                                if (ar[0][j].equals(s2)) {
                                    if (ar[i][j] != "X" && br[i][j] != "X") {
                                        ar[i][j] = "M";
                                        br[i][j] = "M";
                                    }
                                }
                            }
                        }
                    }

                    System.out.println("You missed! Try again:");
                }
//                }
                //here

            }
        }
    }
}
