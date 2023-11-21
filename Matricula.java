import java.time.LocalDate;

public class Matricula {
    
    private int id;
    private String nome;
    private String dataNascimento;
    private String email;
    private String endereco;
    private String cep;
    private String telefone;
    private String user;
    private String password;
    private String curso;
    private String observacao;
    private int ativo;

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

    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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

    private int getAtivo() {
        return ativo;
    }
    private void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
	public String toString() {
		return String.format("ID:%d\n Nome:%s\n Data de Nascimento:%s\n email:%s\n Endereço:%s\n CEP:%s\n Telefone:%s\n Usuário:%s\n Senha:%s\n Curso:%s\n Observação:%s\n", id, nome, dataNascimento, email, endereco, cep, telefone, user, password, curso, observacao);
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
