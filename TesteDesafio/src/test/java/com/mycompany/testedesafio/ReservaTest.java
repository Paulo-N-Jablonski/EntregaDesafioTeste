/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.testedesafio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author senac TDS
 */
public class ReservaTest {
    
    @Test
    public void testReservaSucesso(){
        
        Reserva reserva = new Reserva("Cachoeirinha", "Sertãozinho", "11/12/2026", 6, 0,"Reservado");
        
        // Sucesso
        Assertions.assertEquals("Cachoeirinha", reserva.origem);
        Assertions.assertEquals("Sertãozinho", reserva.destino);
        Assertions.assertEquals("11/12/2026", reserva.data);
        Assertions.assertEquals(6, reserva.numeroPassageirosMaximo);
        Assertions.assertEquals(0, reserva.numeroPassageirosAtuais);
        Assertions.assertEquals("Reservado", reserva.status);
    }
    
    @Test
    public void testReservaFalha(){
        
        Reserva reserva = new Reserva("Cachoeirinha", "Sertãozinho", "11/12/2026", 6, 0,"Reservado");
        
        // Falha
        Assertions.assertEquals("Cachoeirinha", "Salvador-Bahia");
        Assertions.assertEquals("Sertãozinho", "Florianopolis");
        Assertions.assertEquals("11/12/2026", "11/12/2022");
        Assertions.assertEquals(6, 15);
        Assertions.assertEquals(150, reserva.numeroPassageirosMaximo);
        Assertions.assertEquals(10, reserva.numeroPassageirosAtuais);
        Assertions.assertEquals("Cancelado", reserva.status);
    }
    
    @Test
    public void testDisponibilidadeAssentosSucesso(){
        
        Reserva reserva = new Reserva("Cachoeirinha", "Sertãozinho", "11/12/2026", 6, 0,"Reservado");
        
        // Sucesso
        Assertions.assertEquals(true, reserva.disponibilidadeAssentos(1));
    }
    
    @Test
    public void testDisponibilidadeAssentosFalha(){
        
        Reserva reserva = new Reserva("Cachoeirinha", "Sertãozinho", "11/12/2026", 6, 0,"Reservado");
        
        // Falha
        Assertions.assertEquals(true, reserva.disponibilidadeAssentos(7));
    }
    
    @Test
    public void testCancelamentoReservaSucesso(){
        
        Reserva reserva = new Reserva("Cachoeirinha", "Sertãozinho", "11/12/2026", 6, 4,"Reservado");
        
        // Sucesso
        Assertions.assertEquals(true, reserva.cancelamentoReserva(3));
    }
    
    @Test
    public void testCancelamentoReservaFalha(){
        
        Reserva reserva = new Reserva("Cachoeirinha", "Sertãozinho", "11/12/2026", 6, 4,"Reservado");
        
        // Falha "0"
        Assertions.assertEquals(true, reserva.cancelamentoReserva(0));
        // Falha cancelamento excessivo
        Assertions.assertEquals(true, reserva.cancelamentoReserva(5));
    }
    
    @Test
    public void testConfirmarChechInSucesso(){
        
        Reserva reserva = new Reserva("Cachoeirinha", "Sertãozinho", "11/12/2026", 6, 4, "Reservado");
        
        // Sucesso
        Assertions.assertEquals(true, reserva.confirmarCheckIn());
    }
    
    @Test
    public void testConfirmarChechInFalha(){
        
        Reserva reserva = new Reserva("Cachoeirinha", "Sertãozinho", "11/12/2026", 6, 4, "Cancelado");
        
        // Sucesso
        Assertions.assertEquals(true, reserva.confirmarCheckIn());
    }
}
