package test;

import model.entity.Customer;
import repository.CustomerRepository;

public class CustMain {

	public static void main(String[] args) {
		
        CustomerRepository repo = new CustomerRepository();
        
        // INSERT
        Customer c1 = new Customer("연아", "VIP");
        repo.insert(c1);

        // READ
        Customer find = repo.findById(c1.getCustId());
        System.out.println(find.getCustName());

        // UPDATE
        repo.updateName(c1.getCustId(), "재석");

        // DELETE
        repo.delete(c1.getCustId());
	}

}
