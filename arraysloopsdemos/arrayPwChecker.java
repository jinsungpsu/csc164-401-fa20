import java.util.Scanner;

/*

Input validation
Password check
3 tries and then locked out
multiple possible passwords in an array!
stored in first spot of array: password
second spot: admin override backdoor password: “covidSucks”
third spot: emergency shutdown keyword: “911”

 */
public class Driver {


    public static void main(String[] args) {
        String[] pwList = {"password", "covidSucks", "911"};
        int pwTries = 0;
        final int MAX_PW_ATTEMPTS = 3;
        Scanner input = new Scanner(System.in);


        while(pwTries < MAX_PW_ATTEMPTS) {
            String userInputPw = input.next();

            if (userInputPw.equals(pwList[0])) {
                System.out.println("Successful login!");
                pwTries = 99;
            } else if (userInputPw.equals(pwList[1])) {
                System.out.println("Admin login");
                pwTries = 99;
            } else if (userInputPw.equals(pwList[2])) {
                System.out.println("Emergency exit");
                System.exit(1);
            }

            pwTries++;
        }
    }
}
