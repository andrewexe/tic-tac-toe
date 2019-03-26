package andrew.games;
public abstract class Piece {

	private String type;
	
	public Piece(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public boolean equals(Object a) {
		Piece b = (Piece)a;
		if(getType().equals(b.getType())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return type;
	}
}
