package Services.interfaces;

import java.util.List;

import model.AestheticProcedure;
import model.RoutineProcedure;
import model.SurgicalProcedure;

public interface IProcedureService {
	
	public List<AestheticProcedure> getAllAestheticProcedures();
	
	public List<RoutineProcedure> getAllRoutineProcedures();
	
	public List<SurgicalProcedure> getAllSurgicalProcedures();
	
	public void createAestheticProcedure(AestheticProcedure aestheticProcedure);
	
	public void createRoutineProcedure(RoutineProcedure routineProcedure);

	public void createSurgicalProcedure(SurgicalProcedure surgicalProcedure);

}
