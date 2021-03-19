package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class Menu {

	Scanner input = new Scanner(System.in);
	PessoaFisica pf = new PessoaFisica();
	PessoaJuridica pj = new PessoaJuridica();
	ContaPoupanca cp = new ContaPoupanca();
	ContaEspecial ce = new ContaEspecial();

	ArrayList<Conta> listaConta = new ArrayList<Conta>();
	
	public Menu(ArrayList<Conta> listaConta) {
		this.listaConta = listaConta;
	}
	
	public void menuEnum() throws ValorInvalidoException {
		System.out.println("1) Abrir Nova Conta\r\n" + 
				"2) Selecionar Conta\r\n" + 
				"3) Cadastrar Cliente\r\n" + 
				"4) Relatórios\r\n" + 
				"5) Sair\r\n");
		int escolhaEnumMenu = input.nextInt();
		
		switch(escolhaEnumMenu) {
			case 1: {
				criarNovoCliente();
			}case 2:{
//				selecionarConta();
			}
		}
	}
	
	public void criarNovoCliente() throws ValorInvalidoException {
		System.out.println("1 - Pessoa Física ou 2 - Jurídica?");
		int ehFisicaOuJuridica = input.nextInt();
		
		try {
			if(ehFisicaOuJuridica == 1) {
				criarPessoaFisica();
			} else if(ehFisicaOuJuridica == 2) {
				criarPessoaJuridica();
			}else {
				throw new ValorInvalidoException();
			}
		}catch(ValorInvalidoException vie) {
			criarNovoCliente();
		}
		
	}
	
	public void criarPessoaFisica() {
		try {
			pf.setId(inputId());
			pf.setNome(inputNome());
			pf.setCpf(inputCpf());
			pf.setDtNascimento(inputDtNasc());
			pf.setEndereco(inputEndereco());
			pf.setGenero(inputGenero());
			
			abrirNovaConta();
		} catch (Exception e) {
			System.out.println("asdff" + e);
		}
	}
	
	private void abrirNovaConta() {
		System.out.println("1 - Conta Poupança ou 2 - Especial?");
		int ehPoupancaOuCorrente = input.nextInt();
		
		try {
			if(ehPoupancaOuCorrente == 1) {
				criarContaPoupanca();
			} else if(ehPoupancaOuCorrente == 2) {
				criarContaEspecial();
			}else {
				throw new ValorInvalidoException();
			}
		}catch(ValorInvalidoException vie) {
			abrirNovaConta();
		}
	}

	private void criarContaPoupanca() {

		try {
			System.out.println("Qual taxa de correção?");
			double txCorrecao = input.nextDouble();
			
			cp.setTxCorrecao(txCorrecao);
			
			if(pj == null && pf != null) {
				cp.setCliente(pf);
			}else if(pj != null && pf == null) {
				cp.setCliente(pj);
			}
			
			listaConta.add(cp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			criarContaPoupanca();
		}
		
	}

	private void criarContaEspecial() {
		
		try {
			System.out.println("Qual Limite?");
			double limite = input.nextDouble();
			
			ce.setLimite(limite);
			
			if(pj == null && pf != null) {
				ce.setCliente(pf);
			}else if(pj != null && pf == null) {
				ce.setCliente(pj);
			}
			
			listaConta.add(ce);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			criarContaEspecial();
		}
		
	}

	public int inputCpf() {
		try {
			System.out.println("Cpf?");
			int cpf = input.nextInt();
			return cpf;
		} catch (Exception e) {
			return inputCpf();
		}
	}
	
	public int inputId() {
		try {
			int id = -1;
			for(Conta lp : listaConta) {
				int aux = lp.getCliente().getId();
				if(aux > id) {
					id = aux;
				}
			}
			return id + 1;
		} catch (Exception e) {
			System.out.println("asdf"+ e.getMessage());
			return inputId();
		}
	}
	
	public String inputNome() {
		try {
			System.out.println("Nome?");
			String nome = input.nextLine();
			return nome;
		} catch (Exception e) {
			System.out.println("asdf"+ e.getMessage());
			return inputNome();
		}
	}
	
	public Calendar inputDtNasc() {
		try {
			Calendar c = Calendar.getInstance();
			System.out.println("Ano de nascimento?");
			int ano = input.nextInt();
			System.out.println("Mês de nascimento?");
			int mes = input.nextInt();
			System.out.println("Dia de nascimento?");
			int dia = input.nextInt();
			c.set(Calendar.YEAR, ano);
			c.set(Calendar.MONTH, mes);
			c.set(Calendar.DAY_OF_MONTH, dia);
			return c;
		} catch (Exception e) {
			return inputDtNasc();
		}
	}
	
	public String inputEndereco() {
		try {
			System.out.println("Endereço?");
			String endereco = input.nextLine();
			return endereco;
		} catch (Exception e) {
			return inputEndereco();
		}
	}
	
	public String inputGenero() {
		try {
			System.out.println("Gênero?");
			String genero = input.nextLine();
			return genero;
		} catch (Exception e) {
			return inputGenero();
		}
	}
	
	public void criarPessoaJuridica() {
		try {
			pj.setId(inputId());
			pj.setNome(inputNome());
			pj.setEndereco(inputEndereco());
			pj.setAtividade(inputAtividade());
			pj.setCnpj(inputCnpj());
		} catch (Exception e) {
			System.out.println("asdff" + e);
		}
	}
	
	public int inputCnpj() {
		try {
			System.out.println("Atividade?");
			int cnpj = input.nextInt();
			return cnpj;
		} catch (Exception e) {
			return inputCnpj();
		}
	}
	
	public String inputAtividade() {
		try {
			System.out.println("Atividade?");
			String atividade = input.nextLine();
			return atividade;
		} catch (Exception e) {
			return inputGenero();
		}
	}
		
}
