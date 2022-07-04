package Utilitario;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {

	//definindo valores que vai apresentar R$0.00 no caso valor inicial
	static NumberFormat formatandoValores = new DecimalFormat("R$ #, ##0.00");

	// passando o valor de double para String
	public static String doubleToString(Double valor) {
		return formatandoValores.format(valor);
	}

}

