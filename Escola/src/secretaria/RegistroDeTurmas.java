package secretaria;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RegistroDeTurmas {

	ArrayList<Aluno> listaAlunos = new ArrayList<>();

	public static void main(String[] args) {

		CrudAluno aluno = new CrudAluno();

		JOptionPane.showMessageDialog(null, "Olá, Seja muito bem vindo ao Sistema Escolar!");

		String opcaoDeAcao = "Iniciar";

		while (opcaoDeAcao.equals("Iniciar") || opcaoDeAcao.equals("Reiniciar")) {

			int numeroDeAcao = -1;

			while (true) {

				try {
					opcaoDeAcao = JOptionPane.showInputDialog(null, "MENU DE OPERAÇÕES\n" + "\n" +
									"Digite a opção desejada: \n" + "\n" 
									+ "1-Cadastrar novo Aluno(a).\n"
									+ "2-Visualizar Alunos cadastados.\n" 
									+ "3-Atualizar cadastro de Aluno(a).\n"
									+ "4-Deletar Aluno cadastrado.\n" 
									+ "0-Sair do Programa.");
					
					numeroDeAcao = Integer.parseInt(opcaoDeAcao);

					if (numeroDeAcao > 4 || numeroDeAcao < 0) {
						JOptionPane.showMessageDialog(null, "Digite um número válido");

					} else {
						break;

					}

				} catch (NumberFormatException numero) {
					JOptionPane.showMessageDialog(null, "Digite uma opção válida!!");

				}
			}

			switch (numeroDeAcao) {
			case 1:
				String confirmaCreate = JOptionPane.showInputDialog("Deseja realmente continuar? \nS ou N");
				
				if(confirmaCreate.equalsIgnoreCase("S") ) {
					aluno.createAluno();
				
				} else {
					JOptionPane.showMessageDialog(null, "Voltando ao MENU...");
					}
				
				break;
				
			case 2:
				String confirmaRead = JOptionPane.showInputDialog("Deseja realmente continuar? \nS ou N");
				
				if(confirmaRead.equalsIgnoreCase("S") ) {
				aluno.readAluno();
				
				} else {
					JOptionPane.showMessageDialog(null, "Voltando ao MENU...");
					}
				
				break;
				
			case 3:
				String confirmaUpdate = JOptionPane.showInputDialog("Deseja realmente continuar? \nS ou N");
				
				if(confirmaUpdate.equalsIgnoreCase("S") ) {			
				aluno.updateAluno();
				
				} else {
				JOptionPane.showMessageDialog(null, "Voltando ao MENU...");
					}
			
				break;
				
			case 4:
				String confirmaDelete = JOptionPane.showInputDialog("Deseja realmente continuar? \nS ou N");
				
				if(confirmaDelete.equalsIgnoreCase("S") ) {
				aluno.deleteAluno();
				
				} else {
					JOptionPane.showMessageDialog(null, "Voltando ao MENU...");
						}
				
				break;
				
			case 0:
				JOptionPane.showMessageDialog(null, "Operação Finalizada!");
				break;

			}

			int refazerOperacao = JOptionPane.showConfirmDialog(null, "Deseja refazer uma das Operaçôes? ",
					"Confirmação", JOptionPane.YES_NO_OPTION);

			if (refazerOperacao == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Voltando ao Menu de Operações!");
				opcaoDeAcao = "Reiniciar";

			} else {
				opcaoDeAcao = "Sair do Programa!";

			}
		}
	}
}


