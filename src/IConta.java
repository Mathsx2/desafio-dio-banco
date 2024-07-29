import java.time.LocalDateTime;

public interface IConta {
    void sacar(double valor);

    void depositar(double valor);

    LocalDateTime transferir(double valor, IConta contaDestino);

    void imprimirExtrato();
}
