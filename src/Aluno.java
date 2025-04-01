
public class Aluno implements Comparable {
	private String nome;
	private String matricula;
	public Aluno(String nome) {
		this.nome = nome;
		matricula="000000";
	}
	public Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}	
	@Override
	public String toString() {
		return nome;
		
	}	
	@Override
	public boolean equals(Object o) {
		Aluno a=(Aluno)o;
		return this.matricula.equals(a.matricula);
	}
	@Override 
	public int compareTo(Object O) {
		Aluno a=(Aluno)O;
		return this.nome.compareTo(a.nome); 
	}
}
