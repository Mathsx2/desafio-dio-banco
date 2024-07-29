import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        Cliente matheus = new Cliente();
        matheus.setNome("Matheus");

        Conta cc = new ContaCorrente(matheus);
        Conta poupanca = new ContaPoupanca(matheus);

        cc.depositar(100);
        LocalDateTime dataTransferencia = cc.transferir(25, poupanca);
        

        cc.imprimirExtrato();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Transferência realizada em: " + dataTransferencia.format(formatter));
        poupanca.imprimirExtrato();
        
        Banco banco = new Banco();
        banco.setNome("Meu Banco");
        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        banco.listarContas();

    }

}