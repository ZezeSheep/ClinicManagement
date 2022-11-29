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

import model.AestheticProcedure;

public class AestheticProcedureRepository extends ProcedureRepository<AestheticProcedure> {

    public AestheticProcedureRepository(String fileName) {
        super(fileName);
    }

    @Override
    public List<AestheticProcedure> getAll() {
    	List<AestheticProcedure> aestheticProcedureList = new ArrayList<AestheticProcedure>();
		try {
			File f = new File(this.getFileName());
			if(f.exists()) {
				FileInputStream fis = new FileInputStream(f);	
				ObjectInputStream ois = new ObjectInputStream(fis);
	
				aestheticProcedureList = (ArrayList<AestheticProcedure>) ois.readObject();                

				ois.close();
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		return aestheticProcedureList;
    }

	@Override
	public AestheticProcedure get(UUID id) {
		List<AestheticProcedure> aestheticProcedureList = this.getAll();

        Iterator<AestheticProcedure> it = aestheticProcedureList.iterator();

		while(it.hasNext()) {
			AestheticProcedure aP = it.next();
			if(aP.getId().compareTo(id) == 0) {
				return aP;
			}
		}

        return null;
	}

	@Override
	public void save(AestheticProcedure objT) {
		List<AestheticProcedure> aestheticProcedureList = this.getAll();

		aestheticProcedureList.add(objT);

		try {
			FileOutputStream fos = new FileOutputStream(this.getFileName());
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(aestheticProcedureList);

			System.out.println("Aesthetic Procedure: "+ objT.getId()+ " save in Database");

			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modify(UUID id, AestheticProcedure objT) {
		AestheticProcedure oldProcedure = this.get(id);
		if(oldProcedure != null) {
			List<AestheticProcedure> aestheticProcedureList = this.getAll();
			aestheticProcedureList.remove(oldProcedure);
			aestheticProcedureList.add(objT);

			try {
				FileOutputStream fos = new FileOutputStream(this.getFileName());
				ObjectOutputStream oos = new ObjectOutputStream(fos);
	
				oos.writeObject(aestheticProcedureList);
	
				System.out.println("Aesthetic Procedure: "+ objT.getId()+ " modify in Database");
	
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Aesthetic Procedure: "+ objT.getId()+ " don't exist in Database");
		}
	}
    
}
