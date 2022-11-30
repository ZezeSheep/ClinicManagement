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

import model.User;

public class LoginRepository extends UserRepository<User>{

	public LoginRepository(String fileName) {
		super(fileName);
	}
	
	@Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		try {
			File f = new File(this.getFileName());
			if(f.exists()) {
				FileInputStream fis = new FileInputStream(f);	
				ObjectInputStream ois = new ObjectInputStream(fis);
	
				userList = (ArrayList<User>) ois.readObject();

				ois.close();
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		} 
		return userList;
    }

    @Override
    public User get(String email) {
        List<User> userList = this.getAll();

		Iterator<User> it = userList.iterator();

		while(it.hasNext()) {
			User u = it.next();
			if(u.getEmail().equals(email)) {
				return u;
			}
		}
		
        return null;
    }


	@Override
	public void save(User objT) {
		List<User> userList = this.getAll();

		userList.add(objT);

		try {
			FileOutputStream fos = new FileOutputStream(this.getFileName());
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(userList);

			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(String email, User objT) {
		User oldUser = this.get(email);

		if(oldUser != null) {
			List<User> userList = this.getAll();
			userList.remove(oldUser);
			userList.add(objT);

			try {
				FileOutputStream fos = new FileOutputStream(this.getFileName());
				ObjectOutputStream oos = new ObjectOutputStream(fos);
	
				oos.writeObject(userList);
	
				System.out.println("User: "+ email+ " modify in Database");
	
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("User: " + email + "don't exist in Database");
		}
	}
}
