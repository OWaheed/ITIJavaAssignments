package day5.Smile;

public class TitanicPassenger {
    private String pclass, survived, name, sex, sibsp, parch, ticket, cabin, embarked, boat, body, home_dist;
    private float age ,fare;

    public String getPclass() {
        return pclass;
    }

    public void setPclass(String pclass) {
        this.pclass = pclass;
    }

    public String getSurvived() {
        return survived;
    }

    public void setSurvived(String survived) {
        this.survived = survived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSibsp() {
        return sibsp;
    }

    public void setSibsp(String sibsp) {
        this.sibsp = sibsp;
    }

    public String getParch() {
        return parch;
    }

    public void setParch(String parch) {
        this.parch = parch;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }

    public String getBoat() {
        return boat;
    }

    public void setBoat(String boat) {
        this.boat = boat;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHome_dist() {
        return home_dist;
    }

    public void setHome_dist(String home_dist) {
        this.home_dist = home_dist;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "TitanicPassenger{" +
                "pclass='" + pclass + '\'' +
                ",\n survived='" + survived + '\'' +
                ",\n name='" + name + '\'' +
                ",\n sex='" + sex + '\'' +
                ",\n age=" + age +
                ",\n sibsp='" + sibsp + '\'' +
                ",\n parch='" + parch + '\'' +
                ",\n ticket='" + ticket + '\'' +
                ",\n fare=" + fare +
                ",\n cabin='" + cabin + '\'' +
                ",\n embarked='" + embarked + '\'' +
                ",\n boat='" + boat + '\'' +
                ",\n body='" + body + '\'' +
                ",\n home_dist='" + home_dist + '\'' +
                '}' +
                "\n\n";
    }
}
