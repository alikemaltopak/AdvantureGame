import java.util.Random;

public class Obstacle {
    private String name, hit;
    private int damage,award,healthy,maxNnumber;

    public Obstacle(String name, String hit, int award, int damage, int healthy, int maxNnumber) {
        this.name = name;
        this.hit = hit;
        this.award = award;
        this.damage = damage;
        this.healthy = healthy;
        this.maxNnumber = maxNnumber;
    }

    public int obstacleCount(){
        Random r = new Random();
        return r.nextInt(this.maxNnumber) + 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMaxNnumber() {
        return maxNnumber;
    }

    public void setMaxNnumber(int maxNnumber) {
        this.maxNnumber = maxNnumber;
    }

}
