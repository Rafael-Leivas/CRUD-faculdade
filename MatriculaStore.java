import java.util.ArrayList;
import java.util.List;

public class MatriculaStore {

    private static int incremento = 0;
    private static List<Matricula> matriculas = new ArrayList<>();

    public static void inserir(Matricula matricula) {
        matricula.setId(++incremento);
        matriculas.add(matricula);
    }

    public static void editar(Matricula matricula) {
        int i = matriculas.indexOf(matricula);
		if (i >= 0) {
			matriculas.set(i, matricula);
		}
    }

    public static void remover(Matricula matricula) {
        matriculas.remove(matricula);
    }

    public static List<Matricula> listar() {
        return matriculas;
    }
    
}
