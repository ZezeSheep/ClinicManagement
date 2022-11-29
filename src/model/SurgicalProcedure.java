package model;

import java.util.UUID;

public class SurgicalProcedure extends Procedure {
	
	private String xRayBase64;
	private String StringtomographyBase64;
	private int recommendedRestDays;

    public SurgicalProcedure(UUID id) {
        super(id);
    }

	public String getxRayBase64() {
		return xRayBase64;
	}

	public void setxRayBase64(String xRayBase64) {
		this.xRayBase64 = xRayBase64;
	}

	public String getStringtomographyBase64() {
		return StringtomographyBase64;
	}

	public void setStringtomographyBase64(String stringtomographyBase64) {
		StringtomographyBase64 = stringtomographyBase64;
	}

	public int getRecommendedRestDays() {
		return recommendedRestDays;
	}

	public void setRecommendedRestDays(int recommendedRestDays) {
		this.recommendedRestDays = recommendedRestDays;
	}
}
