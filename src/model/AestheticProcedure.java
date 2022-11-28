package model;

import java.util.List;

public class AestheticProcedure extends Procedure {
	
	private List<String> preTreatmentPhotosBase64;

    public List<String> getPreTreatmentPhotosBase64() {
		return preTreatmentPhotosBase64;
	}

	public void setPreTreatmentPhotosBase64(List<String> preTreatmentPhotosBase64) {
		this.preTreatmentPhotosBase64 = preTreatmentPhotosBase64;
	}

	public AestheticProcedure(int id) {
        super(id);
    }
    
}
