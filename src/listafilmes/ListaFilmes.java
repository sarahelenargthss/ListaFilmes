package listafilmes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaFilmes {

    private static Filme inicio;
    private static Filme termino;

    public static void main(String[] args) {
        Filme novo;
        int opcao;
        Filme atual;
        do {
            System.out.println("");
            System.out.println("Selecione o número da opção desejada:");
            System.out.println("1. Inserir filme no início da lista;");
            System.out.println("2. Inserir filme no fim da lista;");
            System.out.println("3. Buscar filme;");
            System.out.println("4. Remover filme específico da lista;");
            System.out.println("5. Remover primeiro filme da lista;");
            System.out.println("6. Remover último filme da lista;");
            System.out.println("7. Ver lista de forma crescente;");
            System.out.println("8. Ver lista de forma decrescente;");
            System.out.println("9. Sair.");
            System.out.println("");

            opcao = pedeOpcao();
            System.out.println("");
            switch (opcao) {
                case 1:
                    novo = pedeFilme();
                    novo.setProximo(inicio);
                    inicio = novo;
                    if (termino == null) {
                        termino = novo;
                    }
                    System.out.println("Filme adicionado!");
                    break;
                case 2:
                    novo = pedeFilme();
                    novo.setProximo(null);
                    termino.setProximo(novo);
                    termino = novo;
                    if (inicio == null) {
                        inicio = novo;
                    }
                    System.out.println("Filme adicionado!");
                    break;
                case 3:
                    novo = pedeFilme();
                    atual = inicio;
                    boolean achado = false;
                    while (atual != null) {
                        if (atual.getTitulo().equals(novo.getTitulo())) {
                            System.out.println("Título: " + atual.getTitulo());
                            achado = true;
                            break;
                        }
                        if (atual == termino) {
                            atual = termino;
                        }
                        atual = atual.getProximo();
                    }
                    if (!achado) {
                        System.out.println("Filme não encontrado!");
                    }
                    break;
                case 4:
                    novo = pedeFilme();
                    atual = inicio;
                    achado = false;
                    if (novo == inicio) {
                        inicio = inicio.getProximo();
                        if (inicio == null) {
                            termino = null;
                        }
                        achado = true;
                    } else {
                        while (atual != null) {
                            if (atual.getProximo().getTitulo().equals(novo.getTitulo())) {
                                atual.setProximo(atual.getProximo().getProximo());
                                achado = true;
                                break;
                            }
                            if (atual == termino) {
                                atual = termino;
                            }
                            atual = atual.getProximo();
                        }
                    }
                    if (achado) {
                        System.out.println("Filme removido!");
                    } else {
                        System.out.println("Filme não encontrado!");
                    }
                    break;

                case 5:
                    if (inicio != null) {
                        inicio = inicio.getProximo();
                        System.out.println("Filme removido!");
                    } else {
                        System.out.println("Não há filmes na lista!");
                    }
                    if (inicio == null) {
                        termino = null;
                    }
                    break;
                case 6:
                    if (inicio == termino) {
                        inicio = null;
                        termino = null;
                    } else {
                        atual = termino;
                        if (atual.getProximo() != null) {
                            while (true) {
                                if (atual.getProximo().getProximo() == null) {
                                    atual.setProximo(null);
                                    break;
                                }
                                atual = atual.getProximo();
                            }
                        } else {

                        }
                    }
                    System.out.println("Filme removido!");
                    break;
                case 7:
                    if (inicio == null) {
                        System.out.println("Não há filmes na lista!");
                    } else {
                        atual = inicio;
                        while (true) {
                            System.out.println("- " + atual.getTitulo());
                            if (atual.getProximo() == null) {
                                break;
                            }
                            atual = atual.getProximo();
                        }
                    }
                    break;
                case 8:
                    if (inicio == null) {
                        System.out.println("Não há filmes na lista!");
                    } else {
                        atual = termino;
                        Filme percorre;
                        while (true) {
                            System.out.println("- " + atual.getTitulo());
                            percorre = inicio;
                            achado = false;
                            while (atual != inicio) {
                                if (percorre.getProximo() == atual) {
                                    atual = percorre;
                                    achado = true;
                                    break;
                                }
                                percorre = percorre.getProximo();
                            }
                            if (!achado) {
                                break;
                            }
                        }
                    }
                    break;
            }
        } while (opcao != 9);
    }

    private static int pedeOpcao() {
        Scanner leia = new Scanner(System.in);
        int opcao = 0;
        try {
            opcao = leia.nextInt();
            if (opcao < 1 || opcao > 9) {
                System.out.println("Opção inválida!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida!");
        }
        return opcao;
    }

    private static Filme pedeFilme() {
        Scanner leia = new Scanner(System.in);
        Filme retorno = new Filme();
        retorno.setProximo(null);
        do {
            System.out.println("Digite o título do filme:");
            retorno.setTitulo(leia.nextLine().trim());
            if (retorno.getTitulo().equals("")) {
                System.out.println("Esse título não é válido!");
            }
        } while (retorno.getTitulo().equals(""));
        return retorno;
    }

}
