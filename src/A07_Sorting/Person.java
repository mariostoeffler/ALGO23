package A07_Sorting;

public class Person {
	
	private final String nachname;
	
	private final String vorname;

	public Person(String vorname, String nachname) {
		this.nachname = nachname;
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	/**
	 * Vergleicht zwei Personen miteinander
	 * @return <0, wenn a<b || =0, wenn a=b || >0, wenn a>b
	 */
	public int compareTo(Person p) {
		int lastNameComparison = this.nachname.compareTo(p.nachname);
		if (lastNameComparison != 0) {
			return lastNameComparison;
		}
		return this.vorname.compareTo(p.vorname);
	}}
