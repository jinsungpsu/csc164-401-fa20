public class Driver {
    public static void main(String[] args) {

        App thing = new App();

        thing.pw = "password";

        thing.maxTries = 3;

        thing.login("passwordToTry");
        thing.login("passwordToTry");
        thing.login("passwordToTry");
        thing.login("passwordToTry");
        thing.login("passwordToTry");


    }
}

class App {
    String pw;
    int maxTries;
    int tries = 0;

    void login(String pwTry) {
        if (tries < maxTries) {
            if (pwTry.equals(pw)) {
                System.out.println("logged in");
            } else {
                System.out.println("incorrect pw");
                tries++;
            }
        } else {
            System.out.println("max tries exceeded");
        }
    }
}
