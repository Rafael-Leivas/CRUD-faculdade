import java.time.LocalDate;

public class Matricula {
    
    private int id;
    private String nome;
    private int anosCompletos;
    private String email;
    private String endereco;
    private String cep;
    private String telefone;
    private String usuario;
    private String senha;
    private String curso;
    private String observacao;
    private boolean ativo;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnosCompletos() {
        return anosCompletos;
    }
    public void setAnosCompletos(int anosCompletos) {
        this.anosCompletos = anosCompletos;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo= ativo;
    }

    @Override
	public String toString() {
		return String.format("ID:%d\n Nome:%s\n Seu ano:%d\n email:%s\n Endereço:%s\n CEP:%s\n Telefone:%s\n Usuário:%s\n Senha:%s\n Curso:%s\n Observação:%s\n Ativo:", id, nome, anosCompletos, email, endereco, cep, telefone, usuario, senha, curso, observacao, ativo);
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		Matricula tarefa = (Matricula) obj;
		return id == tarefa.id;
	}

}
