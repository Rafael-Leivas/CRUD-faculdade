public class TodoApp {
    
    public static void main(String[] args) {
        
        Matricula matricula = new Matricula(); // Criando um objeto Matricula

        matricula.setId(1);
        matricula.setNome("João da Silva");
        matricula.setDataNascimento("19/04/1990");
        matricula.setEmail("joao@example.com");
        matricula.setEndereco("Rua Exemplo, 123");
        matricula.setCep("12345678"); 
        matricula.setTelefone("123456789");
        matricula.setUser("joao123");
        matricula.setPassword("senha123");
        matricula.setCurso("Ciência da Computação");
        matricula.setObservacao("Aluno regular");

        System.out.println(matricula.toString());
    }
}
