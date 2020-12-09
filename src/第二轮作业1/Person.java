package 第二轮作业1;

abstract  class Person  {   
    public String name;  //姓名
    public String sex;  //性别
    public int age;   // 年龄
    


    public Person(String name,String sex,int age) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    //get，set方法
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void FriedChickenRestaurant();//抽象类中的抽象方法

}