package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Client;

public class ClientRepository extends UserRepository<Client> {

    public ClientRepository(String fileName) {
        super(fileName);
        //TODO Auto-generated constructor stub
    }

    @Override
    public List<Client> getAll() {
        // TODO Auto-generated method stub
    	List<Client> clientList = new ArrayList<Client>();
		try {
			File f = new File(this.getFileName());
			if(f.exists()) {
				FileInputStream fis = new FileInputStream(f);	
				ObjectInputStream ois = new ObjectInputStream(fis);
	
				clientList = (ArrayList<Client>) ois.readObject();                

				ois.close();
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		return clientList;
    }

    @Override
    public Client get(String email) {
        List<Client> clientList = this.getAll();

        Iterator<Client> it = clientList.iterator();

		while(it.hasNext()) {
			Client c = it.next();
			if(c.getEmail().equals(email)) {
				return c;
			}
		}
		
        return null;
    }


	@Override
	public void save(Client objT) {
		List<Client> clientList = this.getAll();

		clientList.add(objT);

		try {
			FileOutputStream fos = new FileOutputStream(this.getFileName());
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(clientList);

			System.out.println("Client: "+ objT.email+ " save in Database");

			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
    
}
