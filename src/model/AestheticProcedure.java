package model;

import java.util.List;
import java.util.UUID;

public class AestheticProcedure extends Procedure {
	
	private List<String> preTreatmentPhotosBase64;

    public List<String> getPreTreatmentPhotosBase64() {
		return preTreatmentPhotosBase64;
	}

	public void setPreTreatmentPhotosBase64(List<String> preTreatmentPhotosBase64) {
		this.preTreatmentPhotosBase64 = preTreatmentPhotosBase64;
	}

	public AestheticProcedure(UUID id) {
        super(id);
    }

}
