package Services;

import java.util.List;

import Services.interfaces.IProcedureService;
import model.AestheticProcedure;
import model.Constants;
import model.RoutineProcedure;
import model.SurgicalProcedure;
import repository.AestheticProcedureRepository;
import repository.RoutineProcedureRepository;
import repository.SurgicalProcedureRepository;

public class ProcedureService implements IProcedureService{
	private AestheticProcedureRepository aestheticProcedureRepository;
	private RoutineProcedureRepository routineProcedureRepository;
	private SurgicalProcedureRepository surgicalProcedureRepository;

	public ProcedureService() {
		aestheticProcedureRepository = new AestheticProcedureRepository(Constants.AESTHETIC_PROCEDURE_DB_FILE_NAME);
		routineProcedureRepository = new RoutineProcedureRepository(Constants.ROUTINE_PROCEDURE_DB_FILE_NAME);
		surgicalProcedureRepository = new SurgicalProcedureRepository(Constants.SURGICAL_PROCEDURE_DB_FILE_NAME);
	}
	
	public List<AestheticProcedure> getAllAestheticProcedures() {
		return aestheticProcedureRepository.getAll();
	}
	
	public List<RoutineProcedure> getAllRoutineProcedureRepositories() {
		return routineProcedureRepository.getAll();
	}
	
	public List<SurgicalProcedure> getAllSurgicalProcedureRepositories() {
		return surgicalProcedureRepository.getAll();
	}
	
	public void createAestheticProcedure(AestheticProcedure aestheticProcedure) {
		
	}
	
	public void createRoutineProcedure(RoutineProcedure routineProcedure) {
		
	}

	public void createSurgicalProcedure(SurgicalProcedure surgicalProcedure) {
	
	}
}
