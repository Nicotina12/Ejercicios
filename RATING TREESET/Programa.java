package recuperatorio2doParcial;

public class Programa implements Comparable<Programa> {
	private int numeroDeCanal;
	private String programa;
	private double rating;
		
		public Programa(int numeroDeCanal, String programa, double rating) {
			this.numeroDeCanal = numeroDeCanal;
			this.programa = programa;
			this.rating = rating;
			
		}
	

	public int getNumeroDeCanal() {
			return numeroDeCanal;
		}


		public void setNumeroDeCanal(int numeroDeCanal) {
			this.numeroDeCanal = numeroDeCanal;
		}


		public String getPrograma() {
			return programa;
		}


		public void setPrograma(String programa) {
			this.programa = programa;
		}


		public double getRating() {
			return rating;
		}


		public void setRating(double rating) {
			this.rating = rating;
		}
		
		@Override
		public String toString() {
			return "Programa [numCanal=" + numeroDeCanal + ", Programa=" + programa + ", rating=" + rating + "]";
		}

	@Override
	public int compareTo(Programa p) {
		return Double.compare(this.getRating(), p.getRating());
	}

}
