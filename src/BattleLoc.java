
public abstract class BattleLoc extends Location{
    protected Obstacle obstacle;
    String item;
    BattleLoc(Player player, String name, Obstacle obstacle, String item) {
        super(player);
        this.name = name;
        this.obstacle = obstacle; 
        this.item = item;
    } 

    @Override
    public boolean getLocation(){
        int obsCount = obstacle.obstacleCount();
        System.out.println("You are in " + this.getName());
        System.out.println("Be ceariful there are " + obsCount + " " + obstacle.getName() + " in " +  this.getName());
        System.out.println("<F>Fight or <R>Run");
        String selCase = scan.nextLine();
        selCase = selCase.toUpperCase();

        if (selCase.equals("F")) {
            if (combat(obsCount) && obstacle.getHealthy() == 0){
              System.out.println("Congratulations! You cleared all the monsters in the " + this.getName());
              if(this.item.equals("Firewood 🪵") && player.getInv().isFirewood() == false){
                System.out.println("You get a " + this.item);
                player.getInv().setFirewood(true);
              }else if (this.item.equals("Food 🥩") && player.getInv().isFood() == false){
                System.out.println("You get a " + this.item);
                player.getInv().setFood(true);
              }else if(this.item.equals("Water 🌊") && player.getInv().isWater() == false){
                System.out.println("You get a " + this.item);
                player.getInv().setWater(true);
              }
            return true;
        }else if(obstacle.getHealthy() > 0 && player.getHealthy() > 0){
                return true;
            }else{
                return false;
            }
            
        }
        return true;

    }
    public boolean combat(int obsCount){
        for(int i = 0; i < obsCount; i++){
            int defObsHealth = obstacle.getHealthy();
            playerStats();
            enemyStats();
        
        while(obstacle.getHealthy() > 0 && player.getHealthy() > 0){
            String selCase2 = selCase2();
            if (selCase2.equals("H")) {
                System.out.println("⚔️ ⚔️ ⚔️");
                obstacle.setHealthy(obstacle.getHealthy()-player.totalDamage());
                afterHit();
                if(obstacle.getHealthy() > 0){
                System.out.println(obstacle.getHit());
                player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
                afterHit();    
                }
            }else if (selCase2.equals("R")){
                return true;
            }else{
                break;
            }
            
        }
            if(obstacle.getHealthy() <= 0 && player.getHealthy() > 0){
                System.out.println("You kill the " + obstacle.getName());
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("You earn " + obstacle.getAward() + " Money\t New Money : " + player.getMoney());
                if (i == obsCount -1){
                    obstacle.setHealthy(0);
                }else{
                    obstacle.setHealthy(defObsHealth);
                }
                
            }else{
                return false;
            }
        }
        return true;
    }

    public void playerStats(){
        System.out.println("Character : " + player.getcName() + "\tHelathy ❤️ : " + player.getHealthy() + 
        "\tDamage 💪 : " + player.totalDamage() + "\tMoney 💵 : " + player.getMoney() + "\tWeapon 🔫 : " + player.getInv().getwName() + "\tArmor 🛡️ : " + player.getInv().getArmor());
    }
    public void enemyStats(){
        System.out.println("Enemy 👹 : " + obstacle.getName() + "\tHelatht ❤️ : " + obstacle.getHealthy() + "\tDamage 💪 : " + obstacle.getDamage() + "\tAward 🏆 : " + obstacle.getAward());
    }

    public void afterHit(){
        System.out.println("Your Health : " +  player.getHealthy());
        System.out.println(obstacle.getName() + " Health : " + obstacle.getHealthy());

    }public String selCase2(){
        System.out.println("<H>Hit or <R>Run :");
            String selCase2 = scan.nextLine();
            selCase2 = selCase2.toUpperCase();
            return selCase2;

    }

}
