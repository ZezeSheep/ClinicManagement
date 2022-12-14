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

import model.RoutineProcedure;

public class RoutineProcedureRepository extends ProcedureRepository<RoutineProcedure>{

    public RoutineProcedureRepository(String fileName) {
        super(fileName);
    }

    @Override
    public List<RoutineProcedure> getAll() {
        List<RoutineProcedure> routineProcedureList = new ArrayList<RoutineProcedure>();
		try {
			File f = new File(this.getFileName());
			if(f.exists()) {
				FileInputStream fis = new FileInputStream(f);	
				ObjectInputStream ois = new ObjectInputStream(fis);
	
				routineProcedureList = (ArrayList<RoutineProcedure>) ois.readObject();                

				ois.close();
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		return routineProcedureList;
    }

	@Override
	public RoutineProcedure get(UUID id) {
		List<RoutineProcedure> routineProcedureList = this.getAll();

        Iterator<RoutineProcedure> it = routineProcedureList.iterator();

		while(it.hasNext()) {
			RoutineProcedure rP = it.next();
			if(rP.getId().compareTo(id) == 0) {
				return rP;
			}
		}

        return null;
	}

	@Override
	public void save(RoutineProcedure objT) {
		List<RoutineProcedure> routineProcedureList = this.getAll();

		routineProcedureList.add(objT);

		try {
			FileOutputStream fos = new FileOutputStream(this.getFileName());
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(routineProcedureList);

			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modify(UUID id, RoutineProcedure objT) {
		RoutineProcedure oldProcedure = this.get(id);
		if(oldProcedure != null) {
			List<RoutineProcedure> routineProcedureList = this.getAll();
			routineProcedureList.remove(oldProcedure);
			routineProcedureList.add(objT);

			try {
				FileOutputStream fos = new FileOutputStream(this.getFileName());
				ObjectOutputStream oos = new ObjectOutputStream(fos);
	
				oos.writeObject(routineProcedureList);
	
				System.out.println("Routine Procedure: "+ objT.getId()+ " modify in Database");
	
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Routine Procedure: "+ objT.getId()+ " don't exist in Database");
		}
	}

}
