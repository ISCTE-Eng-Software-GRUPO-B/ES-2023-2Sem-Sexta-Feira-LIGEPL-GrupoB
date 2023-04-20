package com.iscte.engsoft.grupob.CalendarApp.util;

public class FileConverter {
	
	/* private String getFileExtension(String filePath) {
		int lastIndexOf = filePath.lastIndexOf(".");
		if (lastIndexOf == -1) {
			return "";
		}
		return filePath.substring(lastIndexOf);
	} */

	/* public boolean isCSV(String filePath) {
		return getFileExtension(filePath).equals(".csv");
	} */

	/* public boolean isJSON(String filePath) {
		return getFileExtension(filePath).equals(".json");
	} */

	//////////////////////////////////////////////////

	// Json to Csv CHECK
	// "[{\"Curso\":\"MCP,MCTRL,MES,MEA,MPP,MS\",\"UnidadeCurricular\":\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",\"Turno\":\"00553TP02\",\"Turma\":\"MESA1\",\"Inscritosnoturno\":\"35\",\"Diadasemana\":\"Qua\",\"Horainiciodaaula\":\"18:00:00\",\"Horafimdaaula\":\"20:00:00\",\"Datadaaula\":\"07/12/2022\",\"SalaatribuÃƒÂ­daÃƒÂaula\":\"C3.01\",\"LotaÃƒÂ§ÃƒÂ£odasala\":\"54\"},{\"Curso\":\"MCP,MCTRL,MES,MEA,MPP,MS\",\"UnidadeCurricular\":\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",\"Turno\":\"00553TP02\",\"Turma\":\"MESA1\",\"Inscritosnoturno\":\"35\",\"Diadasemana\":\"Qua\",\"HorainÃƒÂ­ciodaaula\":\"18:00:00\",\"Horafimdaaula\":\"20:00:00\",\"Datadaaula\":\"30/11/2022\",\"SalaatribuÃƒÂ­daÃƒÂaula\":\"C3.01\"},{\"Curso\":\"MCP,MCTRL,MES,MEA,MPP,MS\",\"UnidadeCurricular\":\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",\"Turno\":\"00553TP02\",\"Turma\":\"MESA1\",\"Inscritosnoturno\":\"35\",\"Diadasemana\":\"Qua\",\"HorainÃƒÂ­ciodaaula\":\"18:00:00\",\"Horafimdaaula\":\"20:00:00\",\"Datadaaula\":\"23/11/2022\",\"SalaatribuÃƒÂ­daÃƒÂaula\":\"C3.01\",\"LotaÃƒÂ§ÃƒÂ£odasala\":\"54\"},{\"Curso\":\"MCP,MCTRL,MES,MEA,MPP,MS\",\"UnidadeCurricular\":\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",\"Turno\":\"00553TP02\",\"Turma\":\"MESA1\",\"Inscritosnoturno\":\"35\",\"Diadasemana\":\"Qua\",\"HorainÃƒÂ­ciodaaula\":\"18:00:00\",\"Horafimdaaula\":\"20:00:00\",\"Datadaaula\":\"16/11/2022\",\"SalaatribuÃƒÂ­daÃƒÂaula\":\"C3.01\",\"LotaÃƒÂ§ÃƒÂ£odasala\":\"54\"},{\"Curso\":\"MCP,MCTRL,MES,MEA,MPP,MS\",\"UnidadeCurricular\":\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",\"Turno\":\"00553TP02\",\"Turma\":\"MESA1\",\"Inscritosnoturno\":\"35\",\"Diadasemana\":\"Qua\",\"Horainiciodaaula\":\"18:00:00\",\"Horafimdaaula\":\"20:00:00\",\"Datadaaula\":\"09/11/2022\",\"Salaatribui­daàaula\":\"C3.01\",\"LotaÃƒÂ§ÃƒÂ£odasala\":\"54\"},{\"Curso\":\"MCP,MCTRL,MES,MEA,MPP,MS\",\"UnidadeCurricular\":\"MétodosdePesquisaemCiênciasSociais\",\"Turno\":\"00553TP02\",\"Turma\":\"MESA1\",\"Inscritosnoturno\":\"35\",\"Diadasemana\":\"Qua\",\"HorainÃƒÂ­ciodaaula\":\"18:00:00\",\"Horafimdaaula\":\"20:00:00\",\"Datadaaula\":\"02/11/2022\",\"SalaatribuÃƒÂ­daÃƒÂaula\":\"C3.01\",\"LotaÃƒÂ§ÃƒÂ£odasala\":\"54\"},{\"Curso\":\"MCP,MCTRL,MES,MEA,MPP,MS\",\"UnidadeCurricular\":\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",\"Turno\":\"00553TP02\",\"Turma\":\"MESA1\",\"Inscritosnoturno\":\"35\",\"Diadasemana\":\"Qua\",\"HorainÃƒÂ­ciodaaula\":\"18:00:00\",\"Horafimdaaula\":\"20:00:00\",\"Datadaaula\":\"26/10/2022\",\"SalaatribuÃƒÂ­daÃƒÂaula\":\"C3.01\",\"LotaÃƒÂ§ÃƒÂ£odasala\":\"54\"}]";

	// Csv to Json
	// Curso,"Unidade Curricular",Turno,Turma,"Inscritos no turno","Dia da semana","Hora inicio da aula","Hora fim da aula","Data da aula","Sala atribuida a aula","Lotacao da sala"
	//"MCP,MCTRL,MES,MEA,MPP,MS","MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais",00553TP02,MESA1,35,Qua,18:00:00,20:00:00,07/12/2022,C3.01,54
	//"MCP,MCTRL,MES,MEA,MPP,MS","MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais",00553TP02,MESA1,35,Qua,18:00:00,20:00:00,30/11/2022,C3.01,
	//"MCP,MCTRL,MES,MEA,MPP,MS","MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais",00553TP02,MESA1,35,Qua,18:00:00,20:00:00,23/11/2022,C3.01,54
	//"MCP,MCTRL,MES,MEA,MPP,MS","MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais",00553TP02,MESA1,35,Qua,18:00:00,20:00:00,16/11/2022,C3.01,54
	//"MCP,MCTRL,MES,MEA,MPP,MS","MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais",00553TP02,MESA1,35,Qua,18:00:00,20:00:00,09/11/2022,C3.01,54
	//"MCP,MCTRL,MES,MEA,MPP,MS","MétodosdePesquisaemCiênciasSociais",00553TP02,MESA1,35,Qua,18:00:00,20:00:00,02/11/2022,C3.01,54
	//"MCP,MCTRL,MES,MEA,MPP,MS","MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais",00553TP02,MESA1,35,Qua,18:00:00,20:00:00,26/10/2022,C3.01,54
	public static void main(String[] args) {

		// System.out.print(CSVConverter.jsonToCSV("[{\"Curso\":\"MCP,MCTRL,MES,MEA,MPP,MS\",\"Unidade Curricular\":\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",\"Turno\":\"00553TP02\",\"Turma\":\"MESA1\",\"Inscritos no turno\":\"35\",\"Dia da semana\":\"Qua\",\"Hora inicio da aula\":\"18:00:00\",\"Hora fim da aula\":\"20:00:00\",\"Data da aula\":\"07/12/2022\",\"Sala atribuida a aula\":\"C3.01\",\"Lotacao da sala\":\"54\"},{\"Curso\":\"MCP,MCTRL,MES,MEA,MPP,MS\",\"Unidade Curricular\":\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",\"Turno\":\"00553TP02\",\"Turma\":\"MESA1\",\"Inscritos no turno\":\"35\",\"Dia da semana\":\"Qua\",\"Hora inicio da aula\":\"18:00:00\",\"Hora fim da aula\":\"20:00:00\",\"Data da aula\":\"30/11/2022\",\"Sala atribuida a aula\":\"C3.01\"},{\"Curso\":\"MCP,MCTRL,MES,MEA,MPP,MS\",\"Unidade Curricular\":\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",\"Turno\":\"00553TP02\",\"Turma\":\"MESA1\",\"Inscritos no turno\":\"35\",\"Dia da semana\":\"Qua\",\"Hora inicio da aula\":\"18:00:00\",\"Hora fim da aula\":\"20:00:00\",\"Data da aula\":\"23/11/2022\",\"Sala atribuida a aula\":\"C3.01\",\"Lotacao da sala\":\"54\"},{\"Curso\":\"MCP,MCTRL,MES,MEA,MPP,MS\",\"Unidade Curricular\":\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",\"Turno\":\"00553TP02\",\"Turma\":\"MESA1\",\"Inscritos no turno\":\"35\",\"Dia da semana\":\"Qua\",\"Hora inicio da aula\":\"18:00:00\",\"Hora fim da aula\":\"20:00:00\",\"Data da aula\":\"16/11/2022\",\"Sala atribuida a aula\":\"C3.01\",\"Lotacao da sala\":\"54\"},{\"Curso\":\"MCP,MCTRL,MES,MEA,MPP,MS\",\"Unidade Curricular\":\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",\"Turno\":\"00553TP02\",\"Turma\":\"MESA1\",\"Inscritos no turno\":\"35\",\"Dia da semana\":\"Qua\",\"Hora inicio da aula\":\"18:00:00\",\"Hora fim da aula\":\"20:00:00\",\"Data da aula\":\"09/11/2022\",\"Sala atribuida a aula\":\"C3.01\",\"Lotacao da sala\":\"54\"},{\"Curso\":\"MCP,MCTRL,MES,MEA,MPP,MS\",\"Unidade Curricular\":\"MétodosdePesquisaemCiênciasSociais\",\"Turno\":\"00553TP02\",\"Turma\":\"MESA1\",\"Inscritos no turno\":\"35\",\"Dia da semana\":\"Qua\",\"Hora inicio da aula\":\"18:00:00\",\"Hora fim da aula\":\"20:00:00\",\"Data da aula\":\"02/11/2022\",\"Sala atribuida a aula\":\"C3.01\",\"Lotacao da sala\":\"54\"},{\"Curso\":\"MCP,MCTRL,MES,MEA,MPP,MS\",\"Unidade Curricular\":\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",\"Turno\":\"00553TP02\",\"Turma\":\"MESA1\",\"Inscritos no turno\":\"35\",\"Dia da semana\":\"Qua\",\"Hora inicio da aula\":\"18:00:00\",\"Hora fim da aula\":\"20:00:00\",\"Data da aula\":\"26/10/2022\",\"Sala atribuida a aula\":\"C3.01\",\"Lotacao da sala\":\"54\"}]"));

		/* System.out.println(JSONConverter.csvToJSON("Curso,\"Unidade Curricular\",Turno,Turma,\"Inscritos no turno\",\"Dia da semana\",\"Hora inicio da aula\",\"Hora fim da aula\",\"Data da aula\",\"Sala atribuida a aula\",\"Lotacao da sala\"\n" +
				"\"MCP,MCTRL,MES,MEA,MPP,MS\",\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",00553TP02,MESA1,35,Qua,18:00:00,20:00:00,07/12/2022,C3.01,54\n" +
				"\"MCP,MCTRL,MES,MEA,MPP,MS\",\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",00553TP02,MESA1,35,Qua,18:00:00,20:00:00,30/11/2022,C3.01,\n" +
				"\"MCP,MCTRL,MES,MEA,MPP,MS\",\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",00553TP02,MESA1,35,Qua,18:00:00,20:00:00,23/11/2022,C3.01,54\n" +
				"\"MCP,MCTRL,MES,MEA,MPP,MS\",\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",00553TP02,MESA1,35,Qua,18:00:00,20:00:00,16/11/2022,C3.01,54\n" +
				"\"MCP,MCTRL,MES,MEA,MPP,MS\",\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",00553TP02,MESA1,35,Qua,18:00:00,20:00:00,09/11/2022,C3.01,54\n" +
				"\"MCP,MCTRL,MES,MEA,MPP,MS\",\"MétodosdePesquisaemCiênciasSociais\",00553TP02,MESA1,35,Qua,18:00:00,20:00:00,02/11/2022,C3.01,54\n" +
				"\"MCP,MCTRL,MES,MEA,MPP,MS\",\"MÃƒÂ©todosdePesquisaemCiÃƒÂªnciasSociais\",00553TP02,MESA1,35,Qua,18:00:00,20:00:00,26/10/2022,C3.01,54"));
*/
	}
}
