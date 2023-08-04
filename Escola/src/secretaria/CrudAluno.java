package secretaria;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CrudAluno {

	private ArrayList<Aluno> listaAlunos;

	public CrudAluno() {
		listaAlunos = new ArrayList<Aluno>();
	}

	public void createAluno() {

		int id = 0;

		while (id == 0) {

			String identificador = JOptionPane.showInputDialog("Digite o número Id do Aluno(a): ");

			try {
				id = Integer.parseInt(identificador);
				JOptionPane.showMessageDialog(null, "Id válido!");

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, " Digite um número válido!");
			}

		}

		String nome = "";

		while (nome.isBlank() || temNummeros(nome)) {
			nome = JOptionPane.showInputDialog("Digite o nome do Aluno(a): ");
			int nomeMinimo = 6;
			
			if(nome.length() >= nomeMinimo ) {

			if (nome.isBlank()) {
				JOptionPane.showMessageDialog(null, " Digite um Nome válido!");

			} else if (temNummeros(nome)) {
				JOptionPane.showMessageDialog(null, " Digite um Nome sem números!");

			} else {
				JOptionPane.showMessageDialog(null, "Nome válido!");

			}
			
			} else { 
				JOptionPane.showMessageDialog(null, "Digite um Nome com no mínimo 6 caracteres!!");
				nome = "";
			}
		}

		String sobreNome = "";

		while (sobreNome.isBlank() || temNummeros(sobreNome)) {

			sobreNome = JOptionPane.showInputDialog("Digite o Sobrenome: ");

			if (sobreNome.isBlank()) {
				JOptionPane.showMessageDialog(null, "Digite um Sobrenome válido!");

			} else if (temNummeros(sobreNome)) {
				JOptionPane.showMessageDialog(null, "Digite um Sobrenome sem números!");
			} else {
				JOptionPane.showMessageDialog(null, "Sobrenome Válido!");
			}

	   }
	

	int idade = 0;

	while(idade==0 || idade > 23)
	{

		String entradaIdade = JOptionPane.showInputDialog("Digite a idade do Aluno(a): ");

		try {
			int confirmaIdade = Integer.parseInt(entradaIdade);

			if (confirmaIdade > 23 || confirmaIdade < 11) {
				JOptionPane.showMessageDialog(null, "Idade do Aluno(a) está acima 23 ou abaixo de 11 Digite corretamente",
						entradaIdade, idade);
				idade = 0;

			} else if (confirmaIdade < 23 || confirmaIdade >= 11) {
				idade = confirmaIdade;
				JOptionPane.showMessageDialog(null, "Idade válida!");

			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite uma idade válida");
		}
	}

	String matriculaAluno = "";

	int matricula = 0;

	int digitos = 5;

	String avancar = "";

	while(matriculaAluno.isBlank()||avancar.equals(""))
	{

		do {
			matriculaAluno = JOptionPane
					.showInputDialog("Insira a matricula do aluno de no mínimo " + digitos + " digitos: ");

		} while (matriculaAluno.length() != digitos);

		try {
			matricula = Integer.parseInt(matriculaAluno);

			if (matricula == 0) {
				avancar = "";
				JOptionPane.showMessageDialog(null, "Digite a matricula diferente de " + matricula);

			} else {
				JOptionPane.showMessageDialog(null, "Matrícula válida!");
				avancar = "avançar";
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite uma matrícula válida!");
			avancar = "";
		}

	}

	String turma = "";

	String nomeProfessor = "";

	while(turma.isBlank())
	{

		turma = JOptionPane.showInputDialog("Digite A ou B para indicar a turma do Aluno(a): ");

		if (turma.equalsIgnoreCase("A")) {
			nomeProfessor = "Sandro";

		} else if (turma.equalsIgnoreCase("B")) {
			nomeProfessor = "Douglas";

		} else {
			JOptionPane.showMessageDialog(null, "Digite uma turma válida!");
			turma = "";

		}

	}

	String turno = "";

	while(turno.isBlank())
	{

		turno = JOptionPane.showInputDialog("Digite o turno do Aluno(a), Vespertino ou Matutino: ");

		if (turno.equalsIgnoreCase("Matutino")) {
			JOptionPane.showMessageDialog(null, "Turno válido!");

		} else if (turno.equalsIgnoreCase("Vespertino")) {
			JOptionPane.showMessageDialog(null, "Turno válido!");

		} else {
			JOptionPane.showMessageDialog(null, "Turno inválido!");
			turno = "";
		}

	}

	String nomeDaMae = "";

	while(nomeDaMae.isBlank())
	{

		nomeDaMae = JOptionPane.showInputDialog("Digite o Nome completo da Mãe do Aluno(a): ");

		if (nomeDaMae.isBlank()) {
			JOptionPane.showMessageDialog(null, "Digite um Nome!");

		} else if (temNummeros(nomeDaMae)) {
			JOptionPane.showMessageDialog(null, "Digite um Nome válido!");

		} else {
			JOptionPane.showMessageDialog(null, "Nome da Mãe válido!");

		}

	}

	Aluno pessoa = new Aluno(id, nome, sobreNome, idade, matricula, turma, nomeProfessor, turno, nomeDaMae);

	listaAlunos.add(pessoa);

	mostrarListaDeAlunos(listaAlunos);

	}

	public void mostrarListaDeAlunos(ArrayList<Aluno> listaAlunos) {

		StringBuilder dadosAluno = new StringBuilder("Cadastro do Aluno(a) ano de 2023:\n ");

		for (Aluno alunoPessoa : listaAlunos) {
			dadosAluno.append("------------Dados------------\n")
					.append("Id: ").append(alunoPessoa.getId() + "\n")
					.append("Nome: ").append(alunoPessoa.getNome() + "\n")
					.append("Sobrenome: ").append(alunoPessoa.getSobreNome() + "\n")
					.append("Idade: ").append(alunoPessoa.getIdade() + "\n")
					.append("Matrícula: ").append(alunoPessoa.getMatricula() + "\n")
					.append("Turma: 2º").append(alunoPessoa.getTurma() + "\n")
					.append("Nome do Professor: ").append(alunoPessoa.getNomeProfessor() + "\n")
					.append("Turno: ").append(alunoPessoa.getTurno() + "\n")
					.append("Nome da Mãe: ").append(alunoPessoa.getNomeDaMae() + "\n")
					.append("-----------------------------\n");
		}

		JOptionPane.showMessageDialog(null, dadosAluno.toString());

	}

	public void readAluno() {

		StringBuilder dadosAluno = new StringBuilder("Aluno(a) cadastrado:\n ");

		StringBuilder dadosAlunos = new StringBuilder("Lista dos Alunos cadastrados:\n ");

		int escolhaFeita = -1;

		if (listaAlunos.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Não há Alunos nesta lista!");

		} else {

			while (true) {

				try {
					String qualAFormaDePesquisa = JOptionPane.showInputDialog("1-Pesquisar por Nome do Aluno(a).\n"
							+ "2-Mostrar todos os Alunos.\n" + "0-Encerrar pesquisa.");

					escolhaFeita = Integer.parseInt(qualAFormaDePesquisa);

					if (escolhaFeita < 0 || escolhaFeita > 2) {
						JOptionPane.showMessageDialog(null, "Digite um número válido!");

					} else {
						break;

					}

				} catch (NumberFormatException resposta) {

					JOptionPane.showMessageDialog(null, "Digite um número correspondente a opção!");
				}
			}

			switch (escolhaFeita) {
			case 1:
				String nomePesquisado = JOptionPane.showInputDialog("Digite o Nome do Aluno(a):\n ");
				for (Aluno pesquisaAluno : listaAlunos) {
					if (pesquisaAluno.getNome().equalsIgnoreCase(nomePesquisado)) {
						  dadosAluno.append("------------Dados------------\n")
									.append("Id: ").append(pesquisaAluno.getId() + "\n")
									.append("Nome: ").append(pesquisaAluno.getNome() + "\n")
									.append("Sobrenome: ").append(pesquisaAluno.getSobreNome() + "\n")
									.append("Idade: ").append(pesquisaAluno.getIdade() + "\n")
									.append("Matrícula: ").append(pesquisaAluno.getMatricula() + "\n")
									.append("Turma: 2º").append(pesquisaAluno.getTurma() + "\n")
									.append("Nome do Professor: ").append(pesquisaAluno.getNomeProfessor() + "\n")
									.append("Turno: ").append(pesquisaAluno.getTurno() + "\n")
									.append("Nome da Mãe: ").append(pesquisaAluno.getNomeDaMae() + "\n")
									.append("-----------------------------\n");
					}

				}

				JOptionPane.showMessageDialog(null, dadosAluno.toString());
				break;

			case 2:
				for (Aluno registroAlunos : listaAlunos) {
						dadosAlunos.append("------------Dados------------\n")
									.append("Id: ").append(registroAlunos.getId() + "\n")
									.append("Nome: ").append(registroAlunos.getNome() + "\n")
									.append("Sobrenome: ").append(registroAlunos.getSobreNome() + "\n")
									.append("Idade: ").append(registroAlunos.getIdade() + "\n")
									.append("Matrícula: ").append(registroAlunos.getMatricula() + "\n")
									.append("Turma: 2º").append(registroAlunos.getTurma() + "\n")
									.append("Nome do Professor: ").append(registroAlunos.getNomeProfessor() + "\n")
									.append("Turno: ").append(registroAlunos.getTurno() + "\n")
									.append("Nome da Mãe: ").append(registroAlunos.getNomeDaMae() + "\n")
									.append("-----------------------------\n");
				}

				JOptionPane.showMessageDialog(null, dadosAlunos.toString());
				break;

			case 0: {
				JOptionPane.showMessageDialog(null, "Saindo da Pesquisa...");
			}
			}
		}
	}

	public void updateAluno() {

		if (listaAlunos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há Alunos nesta lista!");

		} else {

			String alunoPesquisado = JOptionPane.showInputDialog(null,
					"Pesquise o nome do aluno(a) para atualizar o cadastro: \n");

			StringBuilder infoAluno = new StringBuilder("Informações do Aluno(a):\n" + alunoPesquisado + "\n");

			Aluno alunoParaAtualizar = null;

			for (Aluno alunoCadastrado : listaAlunos) {
				if (alunoCadastrado.getNome().equalsIgnoreCase(alunoPesquisado)) {
						   infoAluno.append("------------Dados------------\n")
									.append("Id: ").append(alunoCadastrado.getId() + "\n")
									.append("Nome: ").append(alunoCadastrado.getNome() + "\n")
									.append("Sobrenome: ").append(alunoCadastrado.getSobreNome() + "\n")
									.append("Idade: ").append(alunoCadastrado.getIdade() + "\n")
									.append("Matrícula: ").append(alunoCadastrado.getMatricula() + "\n")
									.append("Turma: 2º").append(alunoCadastrado.getTurma() + "\n")
									.append("Nome do Professor: ").append(alunoCadastrado.getNomeProfessor() + "\n")
									.append("Turno: ").append(alunoCadastrado.getTurno() + "\n")
									.append("Nome da Mãe: ").append(alunoCadastrado.getNomeDaMae() + "\n")
									.append("-----------------------------\n");

					JOptionPane.showMessageDialog(null, infoAluno.toString());

					alunoParaAtualizar = alunoCadastrado;
					break;
				}
			}

			if (alunoParaAtualizar != null) {

				int idNovo = 0;

				while (idNovo == 0) {

					String identificador = JOptionPane.showInputDialog("Digite o Número Id do Aluno(a): ");

					try {
						idNovo = Integer.parseInt(identificador);
						JOptionPane.showMessageDialog(null, "Id válido!");

					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, " Digite um número válido!");
					}

				}

				String nomeNovo = "";
				int nomeNovoMinimo = 6;

				while (nomeNovo.isBlank() || temNummeros(nomeNovo)) {

					nomeNovo = JOptionPane.showInputDialog("Digite o Nome do Aluno(a): ");
					
					if(nomeNovo.length() >= nomeNovoMinimo) {

					if (nomeNovo.isBlank()) {
						JOptionPane.showMessageDialog(null, " Digite um Nome válido!");

					} else if (temNummeros(nomeNovo)) {
						JOptionPane.showMessageDialog(null, " Digite um Nome sem números!");

					} else {
						JOptionPane.showMessageDialog(null, "Nome válido!");

					}
					} else {
						JOptionPane.showMessageDialog(null, "Digite um Nome com no mínimo 6 caracteres!!");
						nomeNovo = "";
						
					}
				}
				
				
				String sobreNomeNovo = "";
				int sobreNomeNovoMinimo = 6;

				while (sobreNomeNovo.isBlank() || temNummeros(sobreNomeNovo)) {

					sobreNomeNovo = JOptionPane.showInputDialog("Digite o Sobrenome do Aluno(a): ");
					
					if(sobreNomeNovo.length() >= sobreNomeNovoMinimo) {

					if (sobreNomeNovo.isBlank()) {
						JOptionPane.showMessageDialog(null, " Digite um Nome válido!");

					} else if (temNummeros(sobreNomeNovo)) {
						JOptionPane.showMessageDialog(null, " Digite um Nome sem números!");

					} else {
						JOptionPane.showMessageDialog(null, "Nome válido!");

					}
					} else {
						JOptionPane.showMessageDialog(null, "Digite um Nome com no mínimo 6 caracteres!!");
						sobreNomeNovo = "";
						
					}
				}

				
				int idadeNova = 0;

				while (idadeNova == 0 || idadeNova > 23) {

					String entradaIdade = JOptionPane.showInputDialog("Digite a idade do Aluno(a): ");

					try {
						int confirmaIdade = Integer.parseInt(entradaIdade);

						if (confirmaIdade > 23 || confirmaIdade < 11) {
							JOptionPane.showMessageDialog(null,
									"Idade do Aluno está acima 23 ou abaixo de 11 Digite corretamente");
							idadeNova = 0;

						} else if (confirmaIdade < 23 || confirmaIdade >= 11) {
							idadeNova = confirmaIdade;
							JOptionPane.showMessageDialog(null, "Idade válida!");

						}

					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Digite uma idade válida");
					}
				}

				String matriculaAlunoNova = "";

				int matriculaNova = 0;

				int digitos = 5;

				String avancar = "";

				while (matriculaAlunoNova.isBlank() || avancar.equals("")) {

					do {
						matriculaAlunoNova = JOptionPane
								.showInputDialog("Insira a matricula do Aluno(a) de no mínimo " + digitos + " digitos: ");

					} while (matriculaAlunoNova.length() != digitos);

					try {
						matriculaNova = Integer.parseInt(matriculaAlunoNova);

						if (matriculaNova == 0) {
							avancar = "";
							JOptionPane.showMessageDialog(null, "Digite a matricula diferente de " + matriculaNova);

						} else {
							JOptionPane.showMessageDialog(null, "Matrícula válida!");
							avancar = "avançar";
						}

					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Digite uma matrícula válida!");
						avancar = "";
					}

				}

				String turmaNova = "";

				String nomeProfessorNovo = "";

				while (turmaNova.isBlank()) {

					turmaNova = JOptionPane.showInputDialog("Digite A ou B para indicar a turma do Aluno(a): ");

					if (turmaNova.equalsIgnoreCase("A")) {
						nomeProfessorNovo = "Sandro";

					} else if (turmaNova.equalsIgnoreCase("B")) {
						nomeProfessorNovo = "Douglas";

					} else {
						JOptionPane.showMessageDialog(null, "Digite uma turma válida!");
						turmaNova = "";

					}

				}

				String turnoNovo = "";

				while (turnoNovo.isBlank()) {

					turnoNovo = JOptionPane.showInputDialog("Digite o turno do Aluno(a), Matutino ou Vesopertino: ");

					if (turnoNovo.equalsIgnoreCase("Matutino")) {
						JOptionPane.showMessageDialog(null, "Turno válido!");

					} else if (turnoNovo.equalsIgnoreCase("Vespertino")) {
						JOptionPane.showMessageDialog(null, "Turno válido!");

					} else {
						JOptionPane.showMessageDialog(null, "Turno inválido!");
						turnoNovo = "";
					}

				}

				String nomeDaMaeNovo = "";
				int nomeDaMaeNovoMinimo = 6;

				while (nomeDaMaeNovo.isBlank()) {

					nomeDaMaeNovo = JOptionPane.showInputDialog("Digite o Nome completo da Mãe do Aluno(a): ");
					
					if(nomeDaMaeNovo.length() >= nomeDaMaeNovoMinimo) {
					if (nomeDaMaeNovo.isBlank()) {
						JOptionPane.showMessageDialog(null, "Digite um Nome!");

					} else if (temNummeros(nomeDaMaeNovo)) {
						JOptionPane.showMessageDialog(null, "Digite um Nome válido!");

					} else {
						JOptionPane.showMessageDialog(null, "Nome da Mãe válido!");

					}
					} else {
						JOptionPane.showMessageDialog(null, "Digite um Nome com no mínimo 6 caracteres!!");
					}

					alunoParaAtualizar.setId(idNovo);
					alunoParaAtualizar.setNome(nomeNovo);
					alunoParaAtualizar.setSobreNome(sobreNomeNovo);
					alunoParaAtualizar.setIdade(idadeNova);
					alunoParaAtualizar.setMatricula(matriculaNova);
					alunoParaAtualizar.setTurma(turmaNova);
					alunoParaAtualizar.setTurno(turnoNovo);
					alunoParaAtualizar.setNomeProfessor(nomeProfessorNovo);
					alunoParaAtualizar.setNomeDaMae(nomeDaMaeNovo);

				}

				StringBuilder alunoNovo = new StringBuilder(
						"Informações atualizadas do \n Aluno(a):\n" + alunoPesquisado + "\n");

				for (Aluno alunoAtual : listaAlunos) {
						alunoNovo.append("------------Dados------------\n")
								  .append("Id: ").append(alunoAtual.getId() + "\n")
								  .append("Nome: ").append(alunoAtual.getNome() + "\n")
								  .append("Sobrenome: ").append(alunoAtual.getSobreNome() + "\n")
								  .append("Idade: ").append(alunoAtual.getIdade() + "\n")
								  .append("Matrícula: ").append(alunoAtual.getMatricula() + "\n")
								  .append("Turma: 2º").append(alunoAtual.getTurma() + "\n")
								  .append("Nome do Professor: ").append(alunoAtual.getNomeProfessor() + "\n")
								  .append("Turno: ").append(alunoAtual.getTurno() + "\n")
								  .append("Nome da Mãe: ").append(alunoAtual.getNomeDaMae() + "\n")
								  .append("-----------------------------\n");
				}

				JOptionPane.showMessageDialog(null, "Cadastro ANTIGO " + "\n" + infoAluno.toString() + "\n"
						+ "Cadastro NOVO " + "\n" + alunoNovo.toString());

			} else {

				JOptionPane.showMessageDialog(null,
						"Aluno(a) " + alunoPesquisado + " NÃO está Cadastrado! \n" + "Verifique a lista de Alunos!");

			}
		}
	}

	public void deleteAluno() {

		StringBuilder alunoAdeletar = new StringBuilder("Informações do Aluno(a)\n a ser deletado:\n");

		StringBuilder listaDeletado = new StringBuilder("Informações da lista\natual:\n");

		String pesquisaDeletar = "";

		if (listaAlunos.isEmpty()) {

			JOptionPane.showMessageDialog(null, "Não há Alunos nesta lista!");

		} else {

			while (pesquisaDeletar.isBlank() || temNummeros(pesquisaDeletar)) {

				pesquisaDeletar = JOptionPane.showInputDialog(null, "Digite o nome do Aluno(a) a ser deletado:\n");

				if (pesquisaDeletar.isBlank()) {
					JOptionPane.showMessageDialog(null, "Digite um Nome!");

				} else if (temNummeros(pesquisaDeletar)) {

					JOptionPane.showMessageDialog(null, "Digite um Nome sem números!");

				} else {

					JOptionPane.showMessageDialog(null, "Nome válido!");
				}
			}

		Aluno alunoParaDeletar = null;

		for (Aluno deletaAluno : listaAlunos) {
			if (deletaAluno.getNome().equalsIgnoreCase(pesquisaDeletar)) {
					alunoAdeletar.append("------------Dados------------\n")
								  .append("Id: ").append(deletaAluno.getId() + "\n")
								  .append("Nome: ").append(deletaAluno.getNome() + "\n")
								  .append("Sobrenome: ").append(deletaAluno.getSobreNome() + "\n")
								  .append("Idade: ").append(deletaAluno.getIdade() + "\n")
								  .append("Matrícula: ").append(deletaAluno.getMatricula() + "\n")
								  .append("Turma: 2º").append(deletaAluno.getTurma() + "\n")
								  .append("Nome do Professor: ").append(deletaAluno.getNomeProfessor() + "\n")
								  .append("Turno: ").append(deletaAluno.getTurno() + "\n")
								  .append("Nome da Mãe: ").append(deletaAluno.getNomeDaMae() + "\n")
								  .append("-----------------------------\n");

				JOptionPane.showMessageDialog(null, alunoAdeletar.toString());

				alunoParaDeletar = deletaAluno;
				break;
			}
			}

			if (alunoParaDeletar != null) {
				listaAlunos.remove(alunoParaDeletar);

				for (Aluno listaSemAlunoDeletado : listaAlunos) {
					listaDeletado.append("------------Dados------------\n").append("Nome: ")
							.append(listaSemAlunoDeletado.getNome());

					JOptionPane.showMessageDialog(null, listaDeletado.toString());
				}
			} else {

				JOptionPane.showMessageDialog(null, "O Aluno(a) não está na lista!");
			}
		}

	}

	private boolean temNummeros(String texto) {
		return texto.matches(".*\\d.*");
	}
}
