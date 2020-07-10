package com.frewen.designpattern.memento;

/**
 * 使命召唤游戏
 */
public class CallOfDutyGame {
    private int mCheckPoint = 1;
    private int mLifeValue = 100;
    //武器
    private String mWeapon = "沙漠之鹰";

    public void playGame() {
        System.out.println("玩游戏：第 " + mCheckPoint + " 关,奋勇杀敌中。。。");
        mLifeValue -= 10;
        System.out.println("进度升级啦！！！");
        mCheckPoint++;
        System.out.println("到达 第 " + mCheckPoint + " 关");
        System.out.println("生命值还剩:" + mLifeValue);
    }

    public void quitGame() {
        System.out.println("=================退出游戏中=================");
        System.out.println("存档游戏进度： " + this.toString());
        System.out.println("=================退出游戏完成=================");
    }

    @Override
    public String toString() {
        return "CallOfDutyGame{" +
                "闯关进度=" + mCheckPoint +
                ", 剩余生命值=" + mLifeValue +
                ", 武器='" + mWeapon + '\'' +
                '}';
    }

    /**
     * 创建备忘录
     *
     * @return
     */
    public Memeto createMemeto() {
        Memeto memeto = new Memeto();
        memeto.mCheckPoint = mCheckPoint;
        memeto.mLifeValue = mLifeValue;
        memeto.mWeapon = mWeapon;
        System.out.println("游戏存档中。。。游戏进度："+this.toString());
        return memeto;
    }

    /**
     * 恢复备忘录数据
     *
     * @param memeto
     */
    public void restoreMemeto(Memeto memeto) {
        this.mCheckPoint = memeto.mCheckPoint;
        this.mLifeValue = memeto.mLifeValue;
        this.mWeapon = memeto.mWeapon;
        System.out.println("恢复游戏存档中。。。游戏进度："+this.toString());
    }
}
