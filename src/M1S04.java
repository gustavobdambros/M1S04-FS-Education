import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M1S04 {

    // ArrayList para cursos
    private static List<String> cursos = new ArrayList<>();

    // ArrayList para professores
    private static List<String> professores = new ArrayList<>();

    // Array para lista de cursos concluídos
    private static List<String> cursosConcluidos = new ArrayList<>();

    // Função para adicionar cursos na lista de cursos
    private static void adicionarCurso(Scanner scanner, List<String> cursos) {
        System.out.print("Digite o nome do curso: ");
        String curso = scanner.next();
        cursos.add(curso);
        System.out.println("O curso " + curso + " foi adicionado na lista de cursos.\n");
    }

    // Função para adicionar professores na lista de professores
    private static void adicionarProfessores(Scanner scanner, List<String> professores) {
        System.out.print("Digite o nome do(a) professor(a): ");
        String professor = scanner.next();
        professores.add(professor);
        System.out.println("O(a) professor(a) " + professor + " foi adicionado(a) na lista de professores.\n");
    }

    // Função para listar os cursos
    private static void listarCursos(List<String> cursos) {
        System.out.println("\nLista de cursos: ");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println(i + " - " + cursos.get(i));
        }
    }

    // Função para listar os professores
    private static void listarProfessores(List<String> professores) {
        System.out.println("\nLista de professores: ");
        for (int i = 0; i < professores.size(); i++) {
            System.out.println(i + " - " + professores.get(i));
        }
    }

    // Função para listar e escolher um índice para retornar
    private static int listarPegarIndice(Scanner scanner, List<String> lista) {
        System.out.println("\nLista: ");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + " - " + lista.get(i));
        }

        System.out.print("\nDigite o índice desejado: ");
        return scanner.nextInt();
    }

    // Função para verificar se o índice é valido para remoção de item
    private static void removerItem(List<String> lista, int indice) {
        if (indice >= 0 && indice < lista.size()) {
            lista.remove(indice);
            System.out.println("O item no índice " + indice + " foi removido.\n");
        } else {
            System.out.println("Índice inválido! Tente novamente.\n");
        }
    }

    // Função para remover um item da lista com parâmetro de listarPegarIndice
    private static int removerItemLista(List<String> lista, Scanner scanner) {
        int indice = listarPegarIndice(scanner, lista);

        if (indice >= 0 && indice < lista.size()) {
            removerItem(lista, indice);
        } else {
            System.out.println("Índice inválido! Tente novamente.\n");
        }

        return indice;
    }

    // Função para marcar um curso como concluído
    private static void marcarComoConcluido(List<String> lista, List<String> listaConcluidos, Scanner scanner) {
        // Aqui, listaConcluidos é passado como parâmetro também devido a necessidade manipulá-la
        System.out.println("Que curso você deseja marcar como concluído?");

        int indice = listarPegarIndice(scanner, lista);

        if (indice >= 0 && indice < lista.size()) {
            String item = lista.get(indice);
            listaConcluidos.add(item);
            removerItem(lista, indice);
            System.out.println("O item "+ item + " foi marcado como concluído e removido da lista original.\n");
        } else {
            System.out.println("Operação cancelada ou índice inválido.\n");
        }
    }

    // Função para listar cursos concluídos
    private static void listarConcluidos(List<String> cursosConcluidos) {
        System.out.println("\nLista de cursos concluídos: ");
        for (int i = 0; i < cursosConcluidos.size(); i++) {
            System.out.println(i + " - " + cursosConcluidos.get(i));
        }
    }

    // Função para exibição do menu principal para o usuário
    private static void menu(Scanner scanner, List<String> cursos, List<String> professores) {
        do {
            System.out.println("\nQue função você deseja executar?\n1. Listar\n2. Adicionar\n3. Remover\n4. Marcar curso como Concluído\n5. Listar concluídos\n0. Sair");
            System.out.print("Minha escolha: ");
            byte opcao = scanner.nextByte();

            switch (opcao) {
                case 1:
                    System.out.println("Qual lista você deseja listar? 1. Cursos | 2. Professores | 3. Ambas");
                    System.out.print("Minha escolha: ");
                    byte opcaoListar = scanner.nextByte();

                    if (opcaoListar == 1) {
                        listarCursos(cursos);
                        break;
                    } else if (opcaoListar == 2) {
                        listarProfessores(professores);
                        break;
                    } else if (opcaoListar == 3) {
                        listarCursos(cursos);
                        listarProfessores(professores);
                        break;
                    } else {
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                    }

                case 2:
                    System.out.println("O que você gostaria de adicionar? 1. Cursos | 2. Professores");
                    System.out.print("Minha escolha: ");
                    byte opcaoAdicionar = scanner.nextByte();

                    if (opcaoAdicionar == 1) {
                        adicionarCurso(scanner, cursos);
                        break;
                    } else if (opcaoAdicionar == 2) {
                        adicionarProfessores(scanner, professores);
                        break;
                    } else {
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                    }
                case 3:
                    System.out.println("De qual lista você deseja remover um item? 1. Cursos | 2. Professores");
                    System.out.print("Minha escolha: ");
                    byte opcaoRemover = scanner.nextByte();

                    if (opcaoRemover == 1) {
                        removerItemLista(cursos, scanner);
                    } else if (opcaoRemover == 2) {
                        removerItemLista(professores, scanner);
                    } else {
                        System.out.println("Opção inválida! Tente novamente.");
                    }
                    break;
                case 4:
                    marcarComoConcluido(cursos, cursosConcluidos, scanner);
                    break;
                case 5:
                    listarConcluidos(cursosConcluidos);
                    break;
                case 0:
                    System.out.print("Você saiu!\n");
                    listarCursos(cursos);
                    listarProfessores(professores);
                    listarConcluidos(cursosConcluidos);
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
                    break;
            }
        } while (true);
    }

    // Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------Lista de cursos/professores----------------");

        // Chamada do menu
        menu(scanner, cursos, professores);
    }
}
// ------------------------------------------------------------------------------------------------------------------------
// OBS: Para a remoção de um item das listas, foi utilizado "List<String> lista" como parâmetro nas funções, pois abrange
// um aspecto genérico, dando a possibilidade de poder utilizar o mesmo código para iterar com várias listas.
// ------------------------------------------------------------------------------------------------------------------------

