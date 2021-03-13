import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.flushAll();

        Scanner sc = null;
        try {
            sc = new Scanner(new File("NYSE_20210301.csv"));
            while (sc.hasNext())  //returns a boolean value
            {
                String[] temp = sc.next().split(",");
                jedis.set(temp[0], temp[1]);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]) {
                case "create":
                    if (jedis.exists(input[1])) {
                        System.out.println("false\n");
                    } else {
                        jedis.set(input[1], input[2]);
                        System.out.println("true\n");
                    }
                    break;
                case "fetch":
                    if (jedis.exists(input[1])) {
                        System.out.println("true");
                        System.out.println(jedis.get(input[1]) + "\n");
                    } else {
                        System.out.println("false\n");
                    }
                    break;
                case "update":
                    if (jedis.exists(input[1])) {
                        System.out.println("true\n");
                        jedis.set(input[1], input[2]);
                    } else {
                        System.out.println("false\n");
                    }
                    break;
                case "delete":
                    if (jedis.exists(input[1])) {
                        System.out.println("true\n");
                        jedis.del(input[1]);
                    } else {
                        System.out.println("false\n");
                    }
                    break;
            }
        }
    }
}
