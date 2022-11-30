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

import model.Secretary;

public class SecretaryRepository extends UserRepository<Secretary> {

    public SecretaryRepository(String fileName) {
        super(fileName);
    }

    @Override
    public List<Secretary> getAll() {
        List<Secretary> secretaryList = new ArrayList<Secretary>();
		try {
			File f = new File(this.getFileName());
			if(f.exists()) {
				FileInputStream fis = new FileInputStream(f);	
				ObjectInputStream ois = new ObjectInputStream(fis);
	
				secretaryList = (ArrayList<Secretary>) ois.readObject();                

				ois.close();
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		return secretaryList;
    }

	@Override
	public Secretary get(String email) {
		List<Secretary> secretaryList = this.getAll();

        Iterator<Secretary> it = secretaryList.iterator();

		while(it.hasNext()) {
			Secretary s = it.next();
			if(s.getEmail().equals(email)) {
				return s;
			}
		}
		return null;
	}

	@Override
	public void save(Secretary objT) {
		List<Secretary> secretaryList = this.getAll();

		secretaryList.add(objT);

		try {
			FileOutputStream fos = new FileOutputStream(this.getFileName());
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(secretaryList);

			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modify(String email, Secretary objT) {
		Secretary oldUser = this.get(email);

		if(oldUser != null) {
			List<Secretary> secretaryList = this.getAll();
			secretaryList.remove(oldUser);
			secretaryList.add(objT);

			try {
				FileOutputStream fos = new FileOutputStream(this.getFileName());
				ObjectOutputStream oos = new ObjectOutputStream(fos);
	
				oos.writeObject(secretaryList);
	
				System.out.println("Secretary: "+ email+ " modify in Database");
	
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Secretary: " + email + "don't exist in Database");
		}
	}
    
}
