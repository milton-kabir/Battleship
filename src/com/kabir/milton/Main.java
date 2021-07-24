package com.kabir.milton;

import java.util.Scanner;

public class Main {
    public static String ar[][] = new String[12][12];

    public static void print() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // write your code herez
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
        print();
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
                    if (ar[j][Integer.parseInt(inp[0].substring(1))-1] == "O"||ar[j][Integer.parseInt(inp[0].substring(1))+1] == "O"||ar[j+1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    ar[j][Integer.parseInt(inp[0].substring(1))] = "O";
                }
            } else {
                System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                continue;
            }

            print();
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
                    if (ar[j][Integer.parseInt(inp[0].substring(1))-1] == "O"||ar[j][Integer.parseInt(inp[0].substring(1))+1] == "O"||ar[j+1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    ar[j][Integer.parseInt(inp[0].substring(1))] = "O";
                }
            } else {
                System.out.println("Error! Wrong length of the Battleship! Try again:");
                continue;
            }

            print();
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
                    if (ar[j][Integer.parseInt(inp[0].substring(1))-1] == "O"||ar[j][Integer.parseInt(inp[0].substring(1))+1] == "O"||ar[j+1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    ar[j][Integer.parseInt(inp[0].substring(1))] = "O";
                }
            } else {
                System.out.println("Error! Wrong length of the Submarine! Try again:");
                continue;
            }

            print();
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
                    if (ar[j][Integer.parseInt(inp[0].substring(1))-1] == "O"||ar[j][Integer.parseInt(inp[0].substring(1))+1] == "O"||ar[j+1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    ar[j][Integer.parseInt(inp[0].substring(1))] = "O";
                }
            } else {
                System.out.println("Error! Wrong length of the Cruiser! Try again:");
                continue;
            }

            print();
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
                    if (ar[j][Integer.parseInt(inp[0].substring(1))-1] == "O"||ar[j][Integer.parseInt(inp[0].substring(1))+1] == "O"||ar[j+1][Integer.parseInt(inp[0].substring(1))] == "O") {
                        ee = 1;
                    }
                }

                if (ee == 1) {
                    System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
                    continue;
                }
                for (int j = Math.min(xx, yy); j <= Math.max(xx, yy); j++) {
                    ar[j][Integer.parseInt(inp[0].substring(1))] = "O";
                }
            } else {
                System.out.println("Error! Wrong length of the Destroyer! Try again:");
                continue;
            }

            print();
            break;
        }
    }
}
