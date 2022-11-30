import java.util.Scanner;
// я не понял как сделать так ( 1+1 = 2) а при (1+1+1) выдавал throws Exception вот но я все равно очень старался это сделать
public class Calculator {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] deistvia = {"+", "-", "/", "*"};
        String[] ecranDeistvia = {"\\+", "-", "/", "\\*"};
        Scanner ad = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String res = ad.nextLine();
        int deistviaIndex=-1;
        for (int i = 0; i < deistvia.length; i++) {
            if(res.contains(deistvia[i])){
                deistviaIndex = i;
                break;
            }
        }
        if(deistviaIndex==-1){
            System.out.println("throws Exception");
            return;
        }
        String[] data = res.split(ecranDeistvia[deistviaIndex]);
        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int a,b;
            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            }else{
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            if ( a >10 || b >10) {
                System.out.println("throws Exception");
                return;
            }
            int result;
            switch (deistvia[deistviaIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }
            if(isRoman){
                System.out.println(converter.intToRoman(result));
            }
            else{
                System.out.println(result);
            }
        }else{
            System.out.println("throws Exception");
        }


    }
}