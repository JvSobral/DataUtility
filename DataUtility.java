package Util;


import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;


public class DataUtility {

        
        
        private static final String padraoDeData = "dd/MM/yyyy";
        private static final SimpleDateFormat sdf = new SimpleDateFormat(padraoDeData);
        
        public static boolean isDataMaiorQueHoje(Date dataInformada) {

            return dataInformada.after(new Date());
           
        }
        
        public static boolean isDataMenorQueHoje( Date dataInformada) {
            
            return dataInformada.before(new Date());
        }

        public static boolean isHoje(Date dataInformada) {
            LocalDate hojeEmlocalDate = LocalDate.now();
            LocalDate dataTransformada = transformarEmLocalDate(dataInformada);

            return dataTransformada.equals(hojeEmlocalDate);
        }
        
        public static String formatarDataNoPadrao(Date dataInformada){
            return sdf.format(dataInformada);
        }
        
        public static LocalDate transformarEmLocalDate(Date dataInformdada){
            return dataInformdada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        
        public static int calcularIdade(Date dataNascimento){
            LocalDate hoje = LocalDate.now();
            
            LocalDate dataNascimentoLocalDate = transformarEmLocalDate(dataNascimento);
            
            return Period.between(dataNascimentoLocalDate, hoje).getYears();
        }
        public static  Date tranformarStringEmDate(String dataInformada){

            Date dataParseada = null;

            try {
                dataParseada = sdf.parse(dataInformada);
            } catch (ParseException e) {
                System.out.println(e);
            }
            return dataParseada;
        }

        public static java.sql.Date transformarDateUtilEmSqlDate(Date dataInformada){
            return new java.sql.Date(dataInformada.getTime());
        }


    }
    


