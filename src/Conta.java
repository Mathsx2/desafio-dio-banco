import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
    private static List<String> clientes = new ArrayList<>();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
        clientes.add(cliente.getNome());
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public LocalDateTime transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
        return LocalDateTime.now();
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}