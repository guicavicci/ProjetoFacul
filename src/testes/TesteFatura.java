package testes;

import javax.swing.JOptionPane;

import beans.Fatura;
import bo.FaturaBO;
import dao.FaturaDAO;

public class TesteFatura
{
	public static void main(String[] args)
	{
		FaturaDAO dao = null;
	    try
	    {
	    	dao = new FaturaDAO();
	        do
	        {
	        	char op =JOptionPane.showInputDialog
	             	("Escolha uma opção:\n "
	                 	+ "<G> - Criar fatura\n "
	                 	+ "<R> - Remover fatura\n "
	                 	+ "<A> - Atualizar taxa de fatura\n "
	                 	+ "<P> - Pesquisar fatura").toUpperCase().charAt(0);
	        	
	            if (op=='G')
	            {
	            	//o valor é a taxa vezes o consumo
	            	FaturaBO.adicionarNovaFatura
	            	(new Fatura
	            		(
	            		Long.parseLong(JOptionPane.showInputDialog("Insira o numero da fautra")),
	            		Double.parseDouble(JOptionPane.showInputDialog("Insira o consumo em Kw/h")),
	            		JOptionPane.showInputDialog("Insira a data de vencimento (dd/mm/yyyy)"),
	            		JOptionPane.showInputDialog("Insira o tipo de pagamento"),
	            		Double.parseDouble(JOptionPane.showInputDialog("Insira a taxa por kw/h"))
	            		)
	            	);
	            }
	            else if (op=='P')
	            {
	                FaturaBO.pegarFatura(Long.parseLong(JOptionPane.showInputDialog("Insira o numero da fatura a ser pesquisada")));
	            }
	            else if (op=='R')
	            {
	                FaturaBO.deletarFatura(Long.parseLong(JOptionPane.showInputDialog("Insira o numero da fatura a ser deletada")));
	            }
	            else if (op=='A')
	            {
	                FaturaBO.atualizarTaxa(Double.parseDouble(JOptionPane.showInputDialog("Insira a taxa")),
	                		Long.parseLong("Insira o numero de fatura que a taxa vai ser atualizada"));
	            }
	            else
	            {
	            	System.out.println("Opção inválida!!!");
	            }
	        }
	        while(JOptionPane.showConfirmDialog
	                 	(null, "Continuar?", "ProdutoDAO",
	                 	JOptionPane.YES_NO_OPTION,
	                 	JOptionPane.QUESTION_MESSAGE)==0);
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    finally
	    {
	    	try
	    	{
	    		dao.fechar();
	        }
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	        }
	    }
	}
}


