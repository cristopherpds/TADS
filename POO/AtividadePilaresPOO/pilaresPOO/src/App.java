import Pessoa.Aluno;
import Pessoa.Professor;

public class App {
    public static void main(String[] args) throws Exception {
        Professor professor = new Professor("João Silva", 40, 5000.0);
        Aluno aluno1 = new Aluno("Maria Souza", 20, 8.5);
        Aluno aluno2 = new Aluno("Pedro Santos", 21, 7.0);

        professor.setSalario(5500.0);
        aluno1.setNota(9.0);
        aluno2.setNota(6.5);

        System.out.println(professor.obterNomeFormatado() + " Nome " + professor.getNome() + " Idade " + professor.getIdade() + " Salario " + professor.getSalario());
        System.out.println(aluno1.obterNomeFormatado() + " tem nota " + aluno1.getNota());
        System.out.println(aluno2.obterNomeFormatado() + " tem nota " + aluno2.getNota());

    }
}
