/**
 * @author: liuxl
 * @date: 2018-10-24 14:30
 * @description:
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("main started...");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}