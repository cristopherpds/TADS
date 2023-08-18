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



        int number = 0;
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                if(matriz[i][j] == 50){
                    number = matriz[i][j];
                    System.out.println("O numero " + number + " esta na linha " + i + " e na coluna " + j);
                }
            }
        }
        
    }
}
