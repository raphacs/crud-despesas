package br.com.codandosimples;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.model.Categoria;
import br.com.codandosimples.model.Despesa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
    DespesaDAO dao = new DespesaDAO();

//    List<Despesa> despesas = dao.findAll();
//
//    for(Despesa despesa: despesas){
//        System.out.println("ID:"+ despesa.getId());
//        System.out.println("Descricao:"+ despesa.getDescricao());
//        System.out.println("Valor:"+ despesa.getValor());
//
//    }

//        Optional<Despesa> despesaOptional = dao.findById(2L);
//        despesaOptional.ifPresent(despesa -> {
//            System.out.println ("ID:" + despesa.getId ());
//            System.out.println ("Descricao:" + despesa.getDescricao ());
//            System.out.println ("Valor:" + despesa.getValor ());
//        });

//        List<Despesa> despesas = dao.findByCategoria (Categoria.TRANSPORTE);
//            for(Despesa despesa: despesas){
//                System.out.println("ID:"+ despesa.getId());
//                System.out.println("CATEGORIA:"+ despesa.getCategoria ());
//                System.out.println("Descricao:"+ despesa.getDescricao());
//                System.out.println("Valor:"+ despesa.getValor());
//
//            }

    }
}
