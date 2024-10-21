package CreationalDesignPattern;

interface Phone {
    void showSpec();
}


 class Iphone implements Phone {
    @Override
    public void showSpec() {
        System.out.println("Iphone");
    }
}

 class HuaweiPhone implements Phone {
    @Override
    public void showSpec() {
        System.out.println("Huawei Phone");
    }
}

 class SamsungPhone implements Phone {
    @Override
    public void showSpec() {
        System.out.println("Samsung");
    }
}
 class PhoneFactory {
    public static Phone getPhone(String phoneType){
        if(phoneType == null){
            return null;
        }
        if(phoneType.equalsIgnoreCase("Low Price")){
            return new HuaweiPhone();
        } else if (phoneType.equalsIgnoreCase("Middle Range price")) {
            return new SamsungPhone();
        } else if (phoneType.equalsIgnoreCase("Expensive")) {
            return new Iphone();
        }
        return null;
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        PhoneFactory ob1 = new PhoneFactory();
        Phone myPhone = PhoneFactory.getPhone("Expensive");
        myPhone.showSpec();
    }
}
