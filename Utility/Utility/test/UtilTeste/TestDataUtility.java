package UtilTeste;

import Util.DataUtility;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestDataUtility {
    
    @Test
    public void testarSeDataEMaiorQueHoje(){
        
        Date dataMaior = DataUtility.tranformarStringEmDate("19/10/2025");
        Date dataMenor = DataUtility.tranformarStringEmDate("19/10/2023");
        
        assertTrue(DataUtility.isDataMaiorQueHoje(dataMaior));
        assertFalse(DataUtility.isDataMaiorQueHoje(dataMenor));
        
    }

    @Test
    public void testDataMenorQueHoje() {
        Date dataMaiorQueHoje = DataUtility.tranformarStringEmDate("19/12/2024");
        Date dataMenorQueHoje = DataUtility.tranformarStringEmDate("19/12/2011");

        assertFalse(DataUtility.isDataMenorQueHoje(dataMaiorQueHoje));
        assertTrue(DataUtility.isDataMenorQueHoje(dataMenorQueHoje));
    }

    @Test
    public void testHoje() {
        Date hoje = new Date();
        assertEquals(true, DataUtility.isHoje(hoje));
    }

    @Test
    public void testFormatarDataNoPadrao() {
        Date hoje = new Date();

        assertEquals("20/12/2023", DataUtility.formatarDataNoPadrao(hoje));
    }

    @Test
    public void testTranformarDateEmLocalDate(){
        LocalDate hojeEmlocalDate = LocalDate.now();
        Date hojeEmDate = new Date();

        assertEquals(hojeEmlocalDate, DataUtility.transformarEmLocalDate(hojeEmDate));
    }

    @Test
    public void testCalcularIdade() {
        Date dataNascimentoJoao = DataUtility.tranformarStringEmDate("19/10/2001");

        assertEquals(22, DataUtility.calcularIdade(dataNascimentoJoao));

        Date dataNascimentoGaby = DataUtility.tranformarStringEmDate("19/12/2003");

        assertEquals(20, DataUtility.calcularIdade(dataNascimentoGaby));
    }

    @Test
    public void testTransformarStringEmDate() {
        LocalDate data = LocalDate.of(2001, Month.OCTOBER, 19);

        assertEquals(data, DataUtility.transformarEmLocalDate(DataUtility.tranformarStringEmDate("19/10/2001")));
    }

    @Test
    public void testTransformarDateUtilEmSql() {
        java.sql.Date dateSql = new java.sql.Date(2001, 10, 19);
        assertEquals(dateSql, DataUtility.transformarDateUtilEmSqlDate(new Date(2001, 10, 19)));
    }
    
    
    
}
