package bo;

import beans.Fatura;
import dao.FaturaDAO;;

public class FaturaBO
{
	public static String adicionarNovaFatura(Fatura fatura)throws Exception
	{
		if(fatura.getNumeroFatura() > 999999999)
			return "Numero de caracteres excedido";
		if(fatura.getNumeroFatura() < 0 )
			return "A fatura precisa ter um número positivo";
		
		FaturaDAO dao = new FaturaDAO();
		
		if(dao.getFatura(fatura.getNumeroFatura()).getNumeroFatura()>0)
		{
			dao.fechar();
			return "Este número já existe";
		}
		
		String x = dao.criar(fatura);
		dao.fechar();
		return x;
	}
	public static Fatura pegarFatura(long numero)throws Exception
	{
		if(numero > 999999999)
			return new Fatura();
		if(numero < 0 )
			return new Fatura();
		
		FaturaDAO dao = new FaturaDAO();
		if(dao.getFatura(numero) == null)
		{
			dao.fechar();
			return new Fatura();
		}
		Fatura fatura = dao.getFatura(numero);
		
		return fatura;
	}
	
	public static String atualizarTaxa(double taxa, long numero)throws Exception
	{
		//Hipoteticamente R$100 é a maior taxa por Kw/h e R$5 a menor
		if(taxa < 5)
			return "Taxa menor que a permitida";
		if(taxa > 100)
			return "Taxa maior que a permitida";
		FaturaDAO dao = new FaturaDAO();
		int x = dao.updateTaxa(taxa, numero);
		dao.fechar();
		
		if(x > 0)
			return x + " linhas foram alteradas!";
		else
			return "Nenhuma linha foi alterada";
	}
	
	public static String deletarFatura(long numero)throws Exception
	{
		FaturaDAO dao = new FaturaDAO();
		if(dao.getFatura(numero) == null)
		{
			dao.fechar();
			return "Essa fatura não existe";
		}
		
		int x = dao.delete(numero);
		dao.fechar();
		
		if(x > 0)
			return x + " linhas foram deletadas!";
		else
			return "Nenhuma linha foi deletada";
	}
}


