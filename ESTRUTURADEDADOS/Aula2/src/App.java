import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] matriz = new int[10][10];

        int sum = 0;
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                matriz[i][j] = (int) (Math.random() * 100);
                sum += matriz[i][j];
            }
        }
        System.out.println("A soma dos elementos na matriz e: " + sum);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um numero: ");
        int num = scanner.nextInt();
        boolean encontrado = false;
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                if(matriz[i][j] == num){
                    System.out.println("O numero " + num + " esta na linha " + i + " e na coluna " + j);
                    encontrado = true;
                }
            }
        }
        if(!encontrado){
            System.out.println("O numero " + num + " nao esta na matriz");
        }
    }
}
