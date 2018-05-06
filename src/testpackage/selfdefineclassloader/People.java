package testpackage.selfdefineclassloader;

public class People {
    //该类写在记事本里，在用javac命令行编译成class文件，放在d盘根目录下,注意写的时候不要带包名，否则需要设置相应的路径
    private String name;

    public People() {}

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "I am a people, my name is " + name;
    }

}

