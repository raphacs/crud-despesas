package br.com.codandosimples;

import br.com.codandosimples.dao.DespesaDAO;

public class RemoverDespesa {
    public static void main(String[] args) {
        DespesaDAO dao = new DespesaDAO ();
        dao.delete (3L);
    }

}
