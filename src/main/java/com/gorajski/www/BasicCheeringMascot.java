package com.gorajski.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
//import java.util.Scanner;

public class BasicCheeringMascot {
    public static void main(String[] args) {
        String cheer = callOutCheer();
        while (!Objects.equals(cheer, "GAME OVER")) {
            String response = mascotSignFor(cheer);
            display(response);
            cheer = callOutCheer();
        }
    }

    private static String callOutCheer() {
        System.out.println("Please shout your cheer:");
//        return new Scanner(System.in).next();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            return br.readLine();
        }catch(IOException ioe){
            return "d'oh!";
        }

    }

    private static void display(String response) {
        System.out.println(response);
    }

    private static String mascotSignFor(String input) {
        Map<String, String> cheerTable = new HashMap<>();
        cheerTable.put("RED HOT", "H-O-T!");
        cheerTable.put("DO IT AGAIN", "Go, Fight, Win");
        cheerTable.put("2 BITS", "Holler!");
        cheerTable.put("STOMP YOUR FEET", "STOMP!");

        return (cheerTable.getOrDefault(input, "Go Team!"));
    }

}
