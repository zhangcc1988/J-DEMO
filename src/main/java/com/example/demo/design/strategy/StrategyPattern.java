package com.example.demo.design.strategy;


/**
 * 策略模式
 *
 * 定义一组算法，将每个算法封装起来，并且是他们之间可以相互转换
 */
public class StrategyPattern {

    public static void main(String[] args) {
        Zombie normalZombie = new NormalZombie();
        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();

        //********************* 加入策略 ***************************

        normalZombie.setAttackable(new HeadButtAttack());
        normalZombie.setMoveable(new JumpMove());
        normalZombie.move();
        normalZombie.attack();

    }
}

// *************************** 策略接口 实现 ***************************//

interface Moveable{
    void move();
}

interface Attackable{
    void attack();
}

class StepByStepMove implements Moveable{
    @Override
    public void move() {
        System.out.println("一步一步移动。。");
    }
}

class JumpMove implements Moveable{
    @Override
    public void move() {
        System.out.println("跳跃移动。。");
    }
}

class BiteAttack implements Attackable{
    @Override
    public void attack() {
        System.out.println("咬。。");
    }
}

class HeadButtAttack implements Attackable{
    @Override
    public void attack() {
        System.out.println("头槌攻击。。");
    }
}

// ************************ 抽象类 ******************************//

abstract class Zombie{

    Moveable moveable;
    Attackable attackable;

    abstract void display();
    abstract void move();
    abstract void attack();

    public Zombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    public Attackable getAttackable() {
        return attackable;
    }

    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
    }
}

// ************************* 具体实现 *****************************//

class NormalZombie extends Zombie{

    public NormalZombie() {
        super(new StepByStepMove(),new BiteAttack());
    }

    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    void display() {
        System.out.println("我是小僵尸。。");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}



