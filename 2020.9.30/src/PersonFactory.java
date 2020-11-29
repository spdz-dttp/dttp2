public class PersonFactory {
	public static Person getPerson(Integer type) {
		Person person = null;
		if(type==2) {
			person = new Kid();
		}
		else if(type==4){
			person = new Student();
		}
		else if(type==3){
			person = new Older();
		}
		else if(type==1){
			person = new Normal();
		}
		else {
			person = new ChoiceFile();
		}
		return person;
	}
}
