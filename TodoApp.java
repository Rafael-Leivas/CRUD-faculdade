import java.util.List;

public class TodoApp {
    
    public static void main(String[] args) {
        
        Matricula matricula = new Matricula(); // Criando um objeto Matricula

        matricula.setNome("João da Silva");
        matricula.setDataNascimento("19/04/1990");
        matricula.setEmail("joao@example.com");
        matricula.setEndereco("Rua da Perdição, 123");
        matricula.setCep("12345678"); 
        matricula.setTelefone("123456789");
        matricula.setUser("joao123");
        matricula.setPassword("senha123");
        matricula.setCurso("ADS");
        matricula.setObservacao("Sou bom de mais");

        MatriculaStore.inserir(matricula);

        matricula.setNome("FILIPINHO");
        matricula.setDataNascimento("19/04/1990");
        matricula.setEmail("FILIPINHO@example.com");
        matricula.setEndereco("Rua da Perdição, 123");
        matricula.setCep("12345678"); 
        matricula.setTelefone("123456789");
        matricula.setUser("joao123");
        matricula.setPassword("senha123");
        matricula.setCurso("ADS");
        matricula.setObservacao("Sou bom de mais");

        MatriculaStore.inserir(matricula);

        List<Matricula> matriculas = MatriculaStore.listar();
for (Matricula m : matriculas) {
    System.out.println(m.toString());
}



        //System.out.println(matricula.toString());
    }
}
