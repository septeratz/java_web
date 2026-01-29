package test;

import repository.EmpRepository;

public class EmpMain {

	public static void main(String[] args) {
		EmpRepository emprepo = new EmpRepository();
		emprepo.copy();
		emprepo.updateName();

	}

}
