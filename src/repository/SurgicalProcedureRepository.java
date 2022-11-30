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
import java.util.UUID;

import model.SurgicalProcedure;

public class SurgicalProcedureRepository extends ProcedureRepository<SurgicalProcedure>{

    public SurgicalProcedureRepository(String fileName) {
        super(fileName);
    }

    @Override
    public List<SurgicalProcedure> getAll() {
        List<SurgicalProcedure> surgicalProcedureList = new ArrayList<SurgicalProcedure>();
		try {
			File f = new File(this.getFileName());
			if(f.exists()) {
				FileInputStream fis = new FileInputStream(f);	
				ObjectInputStream ois = new ObjectInputStream(fis);
	
				surgicalProcedureList = (ArrayList<SurgicalProcedure>) ois.readObject();                

				ois.close();
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		return surgicalProcedureList;
    }

	@Override
	public SurgicalProcedure get(UUID id) {
		List<SurgicalProcedure> surgicalProcedureList = this.getAll();

        Iterator<SurgicalProcedure> it = surgicalProcedureList.iterator();

		while(it.hasNext()) {
			SurgicalProcedure sP = it.next();
			if(sP.getId().compareTo(id) == 0) {
				return sP;
			}
		}
		return null;
	}

	@Override
	public void save(SurgicalProcedure objT) {
		List<SurgicalProcedure> surgicalProcedureList = this.getAll();

		surgicalProcedureList.add(objT);

		try {
			FileOutputStream fos = new FileOutputStream(this.getFileName());
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(surgicalProcedureList);

			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modify(UUID id, SurgicalProcedure objT) {
		SurgicalProcedure oldProcedure = this.get(id);
		if(oldProcedure != null) {
			List<SurgicalProcedure> surgicalProcedureList = this.getAll();
			surgicalProcedureList.remove(oldProcedure);
			surgicalProcedureList.add(objT);

			try {
				FileOutputStream fos = new FileOutputStream(this.getFileName());
				ObjectOutputStream oos = new ObjectOutputStream(fos);
	
				oos.writeObject(surgicalProcedureList);
	
				System.out.println("Surgical Procedure: "+ objT.getId()+ " modify in Database");
	
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Surgical Procedure: "+ objT.getId()+ " don't exist in Database");
		}
	}
    
}
