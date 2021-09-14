package br.com.codandosimples;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.model.Categoria;
import br.com.codandosimples.model.Despesa;
import br.com.codandosimples.model.DespesaInserir;

import java.time.LocalDate;
import java.util.*;

public class Menu {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int repeticao = 1;
        while(repeticao == 1){
            System.out.println (" ------------------------------");
            System.out.println ("   menu de CRUD do Raphael     ");
            System.out.println ("                               ");
            System.out.println (" 1 - ADICIONAR NOVA DESPESA    ");
            System.out.println (" 2 - CONSULTAR TODAS DESPESAS  ");
            System.out.println (" 3 - CONSULTAR DESPESAS POR ID ");
            System.out.println (" 4 - ATUALIZAR DESPESA         ");
            System.out.println (" 5 - DELETAR DESPESA POR ID    ");
            System.out.println (" 6 - SAIR                      ");
            System.out.println (" ------------------------------");

            int menu = entrada.nextInt ();
            DespesaDAO dao = new DespesaDAO ();

            switch (menu) {
                case 1:

                    DespesaInserir despesa = new DespesaInserir ();
                    System.out.println ("adicione uma descrição: ");
                    String descricao = entrada.next ();
                    despesa.setDescricao (descricao);
                    System.out.println ("adicione uma data");
                    System.out.println ("ano:");
                    String yearInput = entrada.next ();
                    int y = Integer.parseInt (yearInput);
                    System.out.println ("mes:");
                    String monthInput = entrada.next ();
                    int m = Integer.parseInt (monthInput);
                    System.out.println ("dia:");
                    String dayInput = entrada.next ();
                    int d = Integer.parseInt (dayInput);

                    LocalDate date = LocalDate.of (y, m, d);
                    despesa.setData (date);


                    System.out.println ("adicione um valor: ");
                    float valor = entrada.nextFloat ();
                    despesa.setValor (valor);
                    System.out.println ("adicione uma categoria entre:\n" +
                            "    1 - ALIMENTACAO,\n" +
                            "    2 - EDUCACAO,\n" +
                            "    3 - SAUDE,\n" +
                            "    4 - TRANSPORTE,\n" +
                            "    5 - MORADIA,\n" +
                            "    6 - OUTROS ");
                    int cate = entrada.nextInt ();
                    switch (cate) {
                        case 1:
                            despesa.setCategoria (Categoria.ALIMENTACAO);
                            break;
                        case 2:
                            despesa.setCategoria (Categoria.EDUCACAO);
                            break;
                        case 3:
                            despesa.setCategoria (Categoria.SAUDE);
                            break;
                        case 4:
                            despesa.setCategoria (Categoria.TRANSPORTE);
                            break;
                        case 5:
                            despesa.setCategoria (Categoria.MORADIA);
                            break;
                        case 6:
                            despesa.setCategoria (Categoria.OUTROS);
                            break;
                        default:
                            System.out.println ("Número inválido");

                    }
                    dao.save (despesa);
                    System.out.println ("SALVO COM SUCESSO");
                    System.out.println ("1 - VOLTAR AO MENU | 2 - SAIR");
                    int enter1 = entrada.nextInt ();
                    if (enter1 == 2){repeticao = 2; System.out.println ("OBRIGADO POR USAR O CRUD DO RAPHAEL!");}
                    break;
                case 2:


                    List<Despesa> despesas = dao.findAll ();

                    for (Despesa consulta : despesas) {
                        System.out.println ("ID:" + consulta.getId ());
                        System.out.println ("Descricao:" + consulta.getDescricao ());
                        System.out.println ("Valor:" + consulta.getValor ());
                        System.out.println ("Data:" + consulta.getData ());
                        System.out.println ("Categoria:" + consulta.getCategoria ());
                    }
                    System.out.println ("1 - VOLTAR AO MENU | 2 - SAIR");
                    int enter2 = entrada.nextInt ();
                    if (enter2 == 2){repeticao = 2; System.out.println ("OBRIGADO POR USAR O CRUD DO RAPHAEL!");}
                    break;
                case 3:
                    System.out.println ("DIGITE O ID DA CONSULTA");
                    long id_consulta = entrada.nextInt ();
                    Optional<Despesa> despesaOptional = dao.findById (id_consulta);
                    despesaOptional.ifPresent (consulta_id -> {
                        System.out.println ("ID:" + consulta_id.getId ());
                        System.out.println ("Descricao:" + consulta_id.getDescricao ());
                        System.out.println ("Valor:" + consulta_id.getValor ());
                    });
                    System.out.println ("1 - VOLTAR AO MENU | 2 - SAIR");
                    int enter3 = entrada.nextInt ();
                    if (enter3 == 2){repeticao = 2; System.out.println ("OBRIGADO POR USAR O CRUD DO RAPHAEL!");}
                    break;
                case 4:
                    System.out.println ("DIGITE O ID PARA ATUALIZAR");
                    long id_update = entrada.nextInt ();

                    Optional<Despesa> despesa_atualizar = dao.findById (id_update);

                    Despesa update = despesa_atualizar.get ();
                    System.out.println (update.getId ());
                    System.out.println (update.getDescricao ());
                    System.out.println (update.getData ());
                    System.out.println (update.getValor ());
                    System.out.println (update.getCategoria ());

                    System.out.println ("adicione uma descrição: ");
                    String descricao1 = entrada.next ();
                    update.setDescricao (descricao1);
                    System.out.println ("adicione uma data");
                    System.out.println ("ano:");
                    String yearInput1 = entrada.next ();
                    int y1 = Integer.parseInt (yearInput1);
                    System.out.println ("mes:");
                    String monthInput1 = entrada.next ();
                    int m1 = Integer.parseInt (monthInput1);
                    System.out.println ("dia:");
                    String dayInput1 = entrada.next ();
                    int d1 = Integer.parseInt (dayInput1);

                    LocalDate date1 = LocalDate.of (y1, m1, d1);
                    update.setData (date1);


                    System.out.println ("adicione um valor: ");
                    float valor1 = entrada.nextFloat ();
                    update.setValor (valor1);
                    System.out.println ("adicione uma categoria entre:\n" +
                            "    1 - ALIMENTACAO,\n" +
                            "    2 - EDUCACAO,\n" +
                            "    3 - SAUDE,\n" +
                            "    4 - TRANSPORTE,\n" +
                            "    5 - MORADIA,\n" +
                            "    6 - OUTROS ");
                    int cate1 = entrada.nextInt ();
                    switch (cate1) {
                        case 1:
                            update.setCategoria (Categoria.ALIMENTACAO);
                            break;
                        case 2:
                            update.setCategoria (Categoria.EDUCACAO);
                            break;
                        case 3:
                            update.setCategoria (Categoria.SAUDE);
                            break;
                        case 4:
                            update.setCategoria (Categoria.TRANSPORTE);
                            break;
                        case 5:
                            update.setCategoria (Categoria.MORADIA);
                            break;
                        case 6:
                            update.setCategoria (Categoria.OUTROS);
                            break;
                        default:
                            System.out.println ("Número inválido");

                    }

                    dao.update (update);
                    System.out.println ("ATUALIZADO COM SUCESSO");
                    System.out.println ("1 - VOLTAR AO MENU | 2 - SAIR");
                    int enter4 = entrada.nextInt ();
                    if (enter4 == 2){repeticao = 2; System.out.println ("OBRIGADO POR USAR O CRUD DO RAPHAEL!");}
                    break;
                case 5:
                    System.out.println ("DIGITE O ID PARA DELETAR");

                    long id_deletar = entrada.nextInt ();
                    Optional<Despesa> despesa_deletar = dao.findById (id_deletar);

                    Despesa delete = despesa_deletar.get ();
                    System.out.println ("O ID DIGITADO FOI O: " + id_deletar);
                    System.out.println (delete.getDescricao ());
                    System.out.println ("TEM CERTEZA QUE QUER DELETAR ESSE ID?");
                    System.out.println ("1 - Sim | 2 - Não");
                    int confirm = entrada.nextInt ();
                    if (confirm == 1) {
                        dao.delete (id_deletar);
                        System.out.println ("DADO DELETADO");
                    } else {
                        System.out.println ("DADO NÃO DELETADO");
                    }
                    System.out.println ("1 - VOLTAR AO MENU | 2 - SAIR");
                    int enter5 = entrada.nextInt ();
                    if (enter5 == 2){repeticao = 2; System.out.println ("OBRIGADO POR USAR O CRUD DO RAPHAEL!");}
                    break;
                case 6:
                    System.out.println ("OBRIGADO POR USAR O CRUD DO RAPHAEL!");
                    repeticao = 2;
                    break;
            }
        }
    }
}
