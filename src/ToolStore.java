 public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean getLocation(){
        System.out.println("Balance: " + player.getMoney());
        System.out.println("1. Weapons:");
        System.out.println("2. Armors:");
        System.out.println("3. Exit:");
        System.out.println("Your choisess:");
        int selTool = scan.nextInt(); 
        int selItemId;

        switch(selTool){
            case 1:
            selItemId = weaponMenu();
            buyWeopen(selItemId);
            break;
            case 2:
            selItemId = armorMenu();
            buyArmor(selItemId);

            break;
        }

        return true;
    }

    public int weaponMenu(){
        System.out.println(" 1. Item : Pistol 🔫\tDamage : 2\tPrice : 25");
        System.out.println(" 2. Item : Sword 🗡️\tDamage : 3\tPrice : 35");
        System.out.println(" 3. Item : Ax 🪓\tDamage : 7\tPrice : 45"); 
        System.out.println(" 4. Exit");
        System.out.println("Select the Weopen:");
        int selWeopenId = scan.nextInt();
        return selWeopenId; 
       }


    public void buyWeopen(int itemId){
        int damage = 0, price = 0;
        String wName = null;
       
            switch (itemId) {
                case 1:
                damage = 2;
                price = 25;
                wName = "Pistol 🔫";
                break;

                case 2:
                damage = 3;
                price = 35;
                wName = "Sword 🗡️";
                break;

                case 3:
                damage = 7;
                price = 45;
                wName = "Ax 🪓";
                break; 
                default:
                System.out.println("Invalit choicess");
                
                break;
            }
            if (player.getMoney() >= price) {
                player.getInv().setDamage(damage);
                player.getInv().setwName(wName);
                player.setMoney(player.getMoney()-price);
                System.out.println("You buy a " + wName + " new damage: " + player.totalDamage());
                System.out.println("Remaining balance: " + player.getMoney());
            } else {
                while(true){
                System.out.println("Insufficient balance!!!");  
                if (weaponMenu() == 4)
                break;
                }   
            } 
    }
        public int armorMenu(){
        System.out.println(" 1. Item : Light 🛡️\tBlocking : 1\tPrice : 15");
        System.out.println(" 2. Item : Medium 🛡️🛡️\tBlocking :3\tPrice : 25");
        System.out.println(" 3. Item : Heavt 🛡️🛡️🛡️\tBlocking : 5\tPrice : 40"); 
        System.out.println(" 4. Exit");
        System.out.println("Select the Armor:");
        int selArmorId = scan.nextInt();
        return selArmorId; 
            }

    public void buyArmor(int itemId){
    int blocking = 0, price = 0;
    String aName = null;
   
        switch (itemId) {
        case 1:
        blocking = 1;
        price = 15;
        aName = "Light 🛡️";
        break;
                
        case 2:
        blocking = 3;
        price = 25;
        aName = "Medium 🛡️🛡️";
        break;
                
        case 3:
        blocking = 5;
        price = 40;
        aName = "Heavt 🛡️🛡️🛡️";
        break; 
        default:
        System.out.println("Invalit choicess");

        break;
                }
                if (player.getMoney() >= price) {

                    player.getInv().setArmor(player.getInv().getArmor()+blocking);
                    player.getInv().setaName(aName); 
                    player.setMoney(player.getMoney()-price);
        System.out.println("You buy a " + aName + " New Armor: +" + blocking + " Update Armor: " + player.getInv().getArmor());
        System.out.println("Remaining balance: " + player.getMoney());
                } else {
        while(true){
        System.out.println("Insufficient balance!!!");  
        if (armorMenu() == 4)
        break;
                        }   
                    } 
            }

        }




