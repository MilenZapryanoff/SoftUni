package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;

public class PictureSeedDto {
    @Expose
    private String name;
    @Expose
    private String dateAndTime;
    @Expose
    private Long car;

    public PictureSeedDto() {
    }
    //ползваме тези анотации на полетата в случай че ползваме готовия валидатор
    @Size(min = 2, max = 20)
    public String getName() {
        return name;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public Long getCar() {
        return car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void setCarId(Long car) {
        this.car = car;
    }

    public void setCar(Long car) {
        this.car = car;
    }


    //използваме този boolean в случай, че НЕ ползваме готовия валидатор а ние си павим проверката
    public boolean isValid() {
        if (this.name.length() < 2 || this.name.length() > 20) {
            return false;
        }
        return true;
    }
}
