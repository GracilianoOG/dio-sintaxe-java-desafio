import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numero;
        String agencia;
        String nomeCliente;
        double saldo;

        System.out.println("Por favor, digite o nome do cliente: ");
        nomeCliente = scanner.nextLine();

        System.out.println("Por favor, digite a agência: ");
        agencia = scanner.next();

        System.out.println("Por favor, digite o número da conta: ");
        numero = scanner.nextInt();

        System.out.println("Por favor, digite o saldo da conta: ");
        saldo = scanner.nextDouble();

        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numero + " e seu saldo R$ " + saldo + " já está disponível para saque");

        scanner.close();
    }
}
