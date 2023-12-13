package com.mycompany.testedesafio;

public class Reserva {

    String origem;
    String destino;
    String data;
    int numeroPassageirosMaximo;
    int numeroPassageirosAtuais;
    String status;

    public Reserva(String origem, String destino, String data, int numeroPassageirosMaximo, int numeroPassageirosAtuais, String status) {
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.numeroPassageirosMaximo = numeroPassageirosMaximo;
        this.numeroPassageirosAtuais = numeroPassageirosAtuais;
        this.status = status;
    }

    public Reserva() {
    }
    
    public boolean disponibilidadeAssentos(int numeroPassageiros){
        
        this.numeroPassageirosAtuais = this.numeroPassageirosAtuais + numeroPassageiros;
        
        if(getNumeroPassageirosAtuais() < getNumeroPassageirosMaximo()){
            int quantidadeDisponivel = this.numeroPassageirosMaximo - this.numeroPassageirosAtuais;
            System.out.println("A quantidade de assentos disponível é " + quantidadeDisponivel);
            return true;
        } else {
            System.out.println("Estamos com o máximo de número de passageiros");
            this.numeroPassageirosAtuais = this.numeroPassageirosAtuais - numeroPassageiros;
            return false;
        }
    }
    
    public boolean cancelamentoReserva(int numeroPassageiros){
        
        this.numeroPassageirosAtuais = this.numeroPassageirosAtuais - numeroPassageiros;
        
        if(numeroPassageiros < 0){
            System.out.println("Houve um erro no cancelamento, você tentou cancelar '0' passageiros");
            return false;
        } else if(getNumeroPassageirosAtuais() <= 0) {
            System.out.println("Houve um erro no cancelamento, você cancelou passageiros demais e número de passageiros atuais ficou negativo");
            this.numeroPassageirosAtuais = this.numeroPassageirosAtuais + numeroPassageiros;
            return false;
        } else {
            this.numeroPassageirosAtuais = this.numeroPassageirosAtuais -  numeroPassageiros;
            setStatus("Cancelado");
            return true;
        }
    }
    
    public boolean confirmarCheckIn(){
        
        if("Cancelado".equals(getStatus())){
            System.out.println("Essa reserva já foi cancelada, tente novamente realizando outra reserva");
            return false;
        } else {
            System.out.println("Reserva realizada com sucesso!");
            setStatus("Confirmado");
            return true;
        }
    }

    public int getNumeroPassageirosMaximo() {
        return numeroPassageirosMaximo;
    }

    public int getNumeroPassageirosAtuais() {
        return numeroPassageirosAtuais;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
