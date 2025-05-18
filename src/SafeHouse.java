public class SafeHouse extends NormalLoc{

        public SafeHouse(Player player) {
            super(player, "Safe House");
        }



        @Override
        public boolean getLocation(){
        player.setHealthy(player.getrHealthy());
        System.out.println("You are in Safe House.");
        System.out.println("Your heath is full...");
        return true;
    }

}
    


