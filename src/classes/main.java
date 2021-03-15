package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Calendar.Builder;

public class main {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(1, "Pessoa1", "Rua1");
		Pessoa p2 = new Pessoa(2, "Pessoa2", "Rua2");
		Pessoa p3 = new Pessoa(3, "Pessoa3", "Rua3");
		Pessoa p4 = new Pessoa(4, "Pessoa4", "Rua4");
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 1999);
		c1.set(Calendar.MONTH, 6);
		c1.set(Calendar.DAY_OF_MONTH, 23);
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.YEAR, 1987);
		c2.set(Calendar.MONTH, 12);
		c2.set(Calendar.DAY_OF_MONTH, 10);
		PessoaFisica pf1 = new PessoaFisica(p1.getId(), p1.getNome(), p1.getEndereco(), 111, c1, "Masculino");
		PessoaFisica pf2 = new PessoaFisica(p2.getId(), p2.getNome(), p2.getEndereco(), 222, c2, "Masculino");
		PessoaJuridica pj3 = new PessoaJuridica(p3.getId(), p3.getNome(), p3.getEndereco(), 2222, "Feminino");
		PessoaJuridica pj4 = new PessoaJuridica(p4.getId(), p4.getNome(), p4.getEndereco(), 2222, "Feminino");
	
		ContaEspecial ce_pf1 = new ContaEspecial(pf1, 1, 100.00, 200.00);
		ContaPoupanca cp_pj3 = new ContaPoupanca(pj3, 3, 300.00, 0.3);
		ContaEspecial ce_pf2 = new ContaEspecial(pf2, 2, 200.00, 400.00);
		ContaPoupanca cp_pj4 = new ContaPoupanca(pj4, 4, 400.00, 0.4);
		
		System.out.println("Olá "+ ce_pf1.getCliente().getNome() + ", antes de sacar, você tinha " + ce_pf1.getSaldo() );
		ce_pf1.sacar(43.00);
		System.out.println("E agora é " + ce_pf1.getSaldo());
		
		System.out.println("------------------------------------------------");
		
		System.out.println("Olá "+ cp_pj3.getCliente().getNome() + ", antes de sacar, você tinha " + cp_pj3.getSaldo() );
		cp_pj3.sacar(70.00);
		System.out.println("E agora é " + cp_pj3.getSaldo());
		
		System.out.println("Olá " + cp_pj3.getCliente().getNome() + ", antes de depositar, você tinha " + cp_pj3.getSaldo() );
		cp_pj3.depositar(30.00);
		System.out.println("E agora é " + cp_pj3.getSaldo());
		
		System.out.println("remetente " + cp_pj3.getCliente().getNome() + " - " + cp_pj3.getSaldo() + " destino " + cp_pj4.getCliente().getNome() + " - " + cp_pj4.getSaldo());
		ce_pf1.transferir(30.00, cp_pj3, cp_pj4);
		System.out.println("remetente " + cp_pj3.getCliente().getNome() + " - " + cp_pj3.getSaldo() + " destino " + cp_pj4.getCliente().getNome() + " - " + cp_pj4.getSaldo());
		
		System.out.println(ce_pf1.getCliente().getNome() + " - idade: " + pf1.getIdade());
	
		ArrayList<Conta> listaConta = new ArrayList<Conta>();
		
		listaConta.add(ce_pf1);
		listaConta.add(ce_pf2);
		listaConta.add(cp_pj3);
		listaConta.add(cp_pj4);
		
		double saldoSomado = 0.00;
		for(Conta c: listaConta) {
			System.out.println("Nome: "+c.getCliente().getNome() + " - Saldo: " + c.getSaldo());
			saldoSomado += c.getSaldo();
		}
		
		System.out.println("Saldo somado: " + saldoSomado);
	}

}
