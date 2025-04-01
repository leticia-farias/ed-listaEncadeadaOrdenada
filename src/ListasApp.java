
public class ListasApp {

	public static void main(String[] args) {
		ListacomArrayOrdenada minhaLista=new ListacomArrayOrdenada();
		
		minhaLista.print();
		minhaLista.add(new Aluno("Jesus"));
		minhaLista.add(new Aluno("josé"));
		minhaLista.add(new Aluno("João"));
		minhaLista.add(new Aluno("Pedro"));
		minhaLista.add(new Aluno("Judas"));
		
		minhaLista.sort();
		minhaLista.print();
	}

}
