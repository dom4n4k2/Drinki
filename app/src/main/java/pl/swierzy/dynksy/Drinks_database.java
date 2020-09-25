package pl.swierzy.dynksy;

public class Drinks_database {

    private Long nr;


    private String nazwa;
    private String photo;
    private String ingredient_1;
    private String ingredient_2;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getNr() {
        return nr;
    }

    public void setNr(Long nr) {
        this.nr = nr;
    }



    public String getIngredient_1() {
        return ingredient_1;
    }

    public void setIngredient_1(String ingredient_1) {
        this.ingredient_1 = ingredient_1;
    }

    public String getIngredient_2() {
        return ingredient_2;
    }

    public void setIngredient_2(String ingredient_2) {
        this.ingredient_2 = ingredient_2;
    }



}
