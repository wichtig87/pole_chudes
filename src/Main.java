import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String maskedWord = "javalove";

    public static void initialMessage(){
        System.out.println("**********");
        System.out.println("Вас приветствует игра 'Поле Чудес'\n Угадайте слово!");
        System.out.println("**********");

    }

    public static String replaceChars(String mainWord, String maskedWord, char toReplace) {
        char[] charsWord = mainWord.toCharArray();
        char[] maskedWordChars = maskedWord.toCharArray();

        for (int i = 0; i < charsWord.length; i++){

            if(charsWord[i] == toReplace)

                maskedWordChars[i] = toReplace;

        }

        return String.valueOf(maskedWordChars);

    }

    public static void main(String[] args) throws IOException {
        String wordToDisplay = "-".repeat(maskedWord.length());
        Scanner sc = new Scanner(System.in);
        char letter;
        int count = 0;

        initialMessage();

        while (wordToDisplay.contains("-")){
            System.out.println("Введите букву:");
            letter = sc.next().charAt(0);
            if (maskedWord.indexOf(letter)>=0) {
                System.out.println("Есть такая буква!");
                wordToDisplay = replaceChars(maskedWord, wordToDisplay, letter);
                System.out.println(wordToDisplay);

            }else{
                System.out.println("Промах, поробуй еще раз");
                System.out.println(wordToDisplay);
            }
            count++;


        }

        System.out.println("Ты выиграл! \n Количество попыток:" + count);


    }
}