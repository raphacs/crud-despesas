package br.com.codandosimples;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.model.Categoria;
import br.com.codandosimples.model.Despesa;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
    DespesaDAO dao = new DespesaDAO();
        Despesa despesa = new Despesa();
        despesa.setDescricao("Feira");
        despesa.setCategoria(Categoria.ALIMENTACAO);
        despesa.setValor(80);
        despesa.setData(LocalDate.of(2021,4,12));
Despesa despesaInserida = dao.save(despesa);
        System.out.println("Foi inserido a despesa com o id: "+ despesa.getId());
    }
}
