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

import model.Dentist;

public class DentistRepository extends UserRepository<Dentist> {

    public DentistRepository(String fileName) {
        super(fileName);
        //TODO Auto-generated constructor stub
    }

    @Override
    public List<Dentist> getAll() {
        ArrayList<Dentist> dentistList = new ArrayList<Dentist>();
		try {
			File f = new File(this.getFileName());
			if(f.exists()) {
				FileInputStream fis = new FileInputStream(f);	
				ObjectInputStream ois = new ObjectInputStream(fis);
	
				dentistList = (ArrayList<Dentist>) ois.readObject();

				ois.close();
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		} 
		return dentistList;
    }

	@Override
	public Dentist get(String email) {
		List<Dentist> dentistList = this.getAll();

		Iterator<Dentist> it = dentistList.iterator();

		while(it.hasNext()) {
			Dentist d = it.next();
			if(d.getEmail().equals(email)) {
				return d;
			}
		}
		
        return null;
	}

	@Override
	public void save(Dentist objT) {
        List<Dentist> dentistList = this.getAll();

		dentistList.add(objT);

		try {
			FileOutputStream fos = new FileOutputStream(this.getFileName());
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(dentistList);

			System.out.println("Dentist: "+ objT.email+ " save in Database");

			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(String email, Dentist objT) {
		Dentist oldUser = this.get(email);

		if(oldUser != null) {
			List<Dentist> dentistList = this.getAll();
			dentistList.remove(oldUser);
			dentistList.add(objT);

			try {
				FileOutputStream fos = new FileOutputStream(this.getFileName());
				ObjectOutputStream oos = new ObjectOutputStream(fos);
	
				oos.writeObject(dentistList);
	
				System.out.println("Dentist: "+ email+ " modify in Database");
	
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Dentist: " + email + "don't exist in Database");
		}
	}
    
}
