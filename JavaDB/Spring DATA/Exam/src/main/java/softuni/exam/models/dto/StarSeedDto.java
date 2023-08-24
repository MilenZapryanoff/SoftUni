package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import softuni.exam.models.entity.enums.StarType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class StarSeedDto {
    @Expose
    private String description;
    @Expose
    private Double lightYears;
    @Expose
    private String name;
    @Expose
    private StarType starType;
    @Expose
    private Long constellation;

    public StarSeedDto() {
    }

    @NotNull
    @Size(min = 6)
    public String getDescription() {
        return description;
    }

    @NotNull
    @Positive
    public Double getLightYears() {
        return lightYears;
    }

    @NotNull
    @Size(min = 2, max = 30)
    public String getName() {
        return name;
    }

    @NotNull
    public StarType getStarType() {
        return starType;
    }

    @NotNull
    public Long getConstellation() {
        return constellation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStarType(StarType starType) {
        this.starType = starType;
    }

    public void setConstellation(Long constellation) {
        this.constellation = constellation;
    }
}
