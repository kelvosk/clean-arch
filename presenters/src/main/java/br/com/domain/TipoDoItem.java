package br.com.domain;


import br.com.helper.GerenciaItem;
import lombok.Getter;

@Getter
public enum TipoDoItem implements GerenciaItem {


    MEDICO(3, "Médico"),
    ENFERMEIRO(3, "Enfermeiro"),
    RESPIRADOR(5, "Médico"),
    AMBULANCIA(10,"Ambulancia"),
    TOMOGRAFO(12,"Tomografo");

        @Override
        public Integer calculaPontosDoItem(Item item){
            int qtd = item.getQuantidade();
            int pontos = qtd * getValor();
            return pontos;
        }

    public Integer valor;
    public String descricao;

    TipoDoItem(Integer valor, String descricao){
        this.descricao = descricao;
        this.valor = valor;
    }

    public Integer getValor(){
        return this.valor;
    }
}
