package br.com.codandosimples;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.model.Categoria;
import br.com.codandosimples.model.Despesa;

import java.time.LocalDate;
import java.util.Optional;

public class AtualizarDespesas {
    public static void main(String[] args) {
        DespesaDAO dao = new DespesaDAO();
        Optional<Despesa> despesaOptional = dao.findById(3L);

        Despesa despesa = despesaOptional.get();
        System.out.println(despesa.getId());
        System.out.println(despesa.getDescricao ());
        System.out.println(despesa.getData ());
        System.out.println(despesa.getValor ());
        System.out.println(despesa.getCategoria ());

        despesa.setDescricao ("gasto com dentista");
        despesa.setData (LocalDate.of (2021,6,14));
        despesa.setValor (250);
        despesa.setCategoria (Categoria.SAUDE);

        dao.update(despesa);
    }

}
