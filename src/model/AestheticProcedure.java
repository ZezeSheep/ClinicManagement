package model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class AestheticProcedure extends Procedure implements Serializable {
	
	private List<String> preTreatmentPhotosBase64;
	
	private static final long serialVersionUID = 7100179587555243994L;
	
	public AestheticProcedure() {
        super(UUID.randomUUID());
    }

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
