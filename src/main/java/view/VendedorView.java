package view;

import java.util.List;

import com.example.desafio.entity.Atuacao;
import com.example.desafio.entity.Vendedor;

public class VendedorView {

	private String nome;
	private String telefone;
	private Integer idade;
	private String cidade;
	private String estado;
	private String regiao;
	private List<String> estados;
	
	
	
	public VendedorView(Vendedor vendedor, Atuacao atuacao) {
		super();
		this.nome = vendedor.getNome();
		this.telefone = vendedor.getTelefone();
		this.idade = vendedor.getIdade();
		this.cidade = vendedor.getCidade();
		this.estado = vendedor.getEstado();
		this.regiao = vendedor.getRegiao();
		this.estados = atuacao.getEstados();
	}
	public VendedorView() {
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public List<String> getEstados() {
		return estados;
	}
	public void setEstados(List<String> estados) {
		this.estados = estados;
	}
	
}
