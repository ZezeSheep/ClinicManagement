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
    }

    @Override
    public List<Client> getAll() {
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

			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
    
	@Override
	public void modify(String email, Client objT) {
		Client oldUser = this.get(email);

		if(oldUser != null) {
			List<Client> clientList = this.getAll();
			removeFromList(clientList, oldUser);
			clientList.add(objT);

			try {
				FileOutputStream fos = new FileOutputStream(this.getFileName());
				ObjectOutputStream oos = new ObjectOutputStream(fos);
	
				oos.writeObject(clientList);
	
				System.out.println("Client: "+ email+ " modify in Database");
	
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Client: " + email + "don't exist in Database");
		}
	}
	
	private List<Client> removeFromList(List<Client> clientList, Client client){
		for (Iterator<Client> iterator = clientList.iterator(); iterator.hasNext();){  
			Client currentClient = iterator.next();  
	      
	        if (currentClient.getEmail().equals(client.getEmail())){  
	               iterator.remove();
	        }
		}
		return clientList;
	}
	
	
}
