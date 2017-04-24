package kino.model;


public class Godziny {

		
	    private String nazwa;
	    private String dzien;
	   

		public Godziny(){}
	    
	    public Godziny(String nazwa, String dzien) {
			super();
			this.nazwa = nazwa;
			this.dzien = dzien;
		}

		public String getNazwa() {
			return nazwa;
		}

		public void setNazwa(String nazwa) {
			this.nazwa = nazwa;
		}

		public String getDzien() {
			return dzien;
		}

		public void setDzien(String dzien) {
			this.dzien = dzien;
		}

		

	
}
