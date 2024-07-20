import java.util.Scanner;

public class provaFinal {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        double[] salario = new double[5];

        for (int i = 0; i < salario.length; i++) {
            System.out.println("Digite um valor de salário bruto: ");
            salario[i] = sc.nextDouble();
        }

        int contador = 1;
        for (double salarios : salario){

            System.out.println("Salario nº" + contador);
            System.out.printf("Salario bruto: R$%.2f\n", salarios);
            System.out.printf("Quanto pagou ao INSS: R$%.2f\n", calculoInss(salarios));
            System.out.printf("Quanto pagou de IR: R$%.2f\n", calculoIr(salarios));
            System.out.printf("Salário líquido: R$%.2f\n", calculoSalarioLiquido(salarios));
            System.out.println();

            contador++;
        }

        sc.close();
    }

    public static double calculoInss (double salarioBruto){

        double descontoInss =
                (salarioBruto <= 1212.00) ? salarioBruto*0.075 :
                (salarioBruto > 1212.01 && salarioBruto < 2427.35) ? salarioBruto*0.09 :
                (salarioBruto > 2427.36 && salarioBruto < 3641.03) ? salarioBruto*0.12 :
                (salarioBruto > 3641.04) ? salarioBruto * 0.14 :
                0.0;

        return descontoInss;
    }

    public static double calculoIr (double salarioBruto) {

        double descontoIr =
                (salarioBruto <= 1903.98) ? 0.0 :
                (salarioBruto > 1903.99 && salarioBruto < 2826.65) ? salarioBruto * 0.075 :
                (salarioBruto > 2826.66 && salarioBruto < 3751.05) ? salarioBruto * 0.15 :
                (salarioBruto > 3751.06 && salarioBruto < 4664.68) ? salarioBruto * 0.225 :
                (salarioBruto > 4664.68) ? salarioBruto * 0.275 :
                0.0;

        return descontoIr;
    }

    public static double calculoSalarioLiquido (double salarioBruto) {
        return salarioBruto - calculoInss((salarioBruto)) - calculoIr(salarioBruto);
    }
}

