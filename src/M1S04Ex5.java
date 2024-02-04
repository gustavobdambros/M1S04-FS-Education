public class M1S04Ex5 {

    // Classe curso
    public class Curso {

        // Atributos
        public String nome;
        public String descricao;
        public String professores;
        public int cargaHoraria;

        // Métodos
        public void progresso(int progresso) {
            System.out.println("O progresso atual é: " + progresso);
        }

        public void notas(String notas) {
            System.out.println("Imprimindo as notas do curso: " + notas);
        }

        public void participacao(int participacao) {
            System.out.println("A participação do curso é de: " + participacao);
        }

    }

    // Classe professor
    public class Professor {

        // Atributos
        String nome;
        byte idade;
        char sexo;
        String especialidade;

        // Métodos
        public void ensinar() {
            System.out.println("Ensinando matérias...");
        }

        public void escrever() {
            System.out.println("Escrevendo no quadro...");
        }

        public void apagar() {
            System.out.println("Apagando...");
        }
    }
}

