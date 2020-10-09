import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    /**
     * 将动物信息（种类，性别，年龄）保存在集合中（可以先保存一部分，再添加新的；也可以后面录入。在这里要不同的动物可能会有不同的属性）
     * 在控制台输入指令，系统可以对动物信息进行基本的增加、删除、修改、查询、对年龄进行排序然后输出
     * 像C语言题库里面的那种菜单式的系统，如输入1进行...操作，输入2进行...操作
     * 考察内容：面向对象，泛型，异常，集合
     */
    private static final int INVALID = -1;
    private static final int ADD = 1;
    private static final int DELETE = 2;
    private static final int ALTER = 3;
    private static final int SEARCH = 4;
    private static final int ORDER_BY_AGE = 5;
    private static final int EXIT = 6;

    public static void main(String[] args) {
        ArrayList<Animal> list = new ArrayList<>();
        //预存数据
        list.add(new Cat(10, new Sex("雄"), "白猫"));
        list.add(new Cat(13, new Sex("雌"), "黑猫"));
        list.add(new Dog(9, new Sex("雌"), "黄狗"));
        list.add(new Fish(15, new Sex("雄"), "金鱼"));
        list.add(new Dog(5, new Sex("雌"), "柴犬"));
        list.add(new Fish(2, new Sex("雌"), "鲤鱼"));

        int isAlter = -1;
        int cmd = 0;
        while (cmd != EXIT) {
            Scanner scanner = new Scanner(System.in);
            if (isAlter == -1) {
                System.out.println("\n输入序号进行操作：1. 增加\t2. 删除\t3. 修改\t4. 查询\t5. 对年龄排序并输出\t6. 退出");
                try {
                    cmd = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("非法输入！请重新输入");
                    cmd = INVALID;
                    continue;
                }
            } else {
                cmd = ADD;
            }
            switch (cmd) {
                case ADD:
                    System.out.println("请输入物种(猫、狗、鱼)、年龄、性别(雌、雄)、详细种类描述 (以回车分割)");
                    String type;
                    try {
                        type = scanner.next();
                        switch (type) {
                            case "猫":
                                if (isAlter == -1)
                                    list.add(new Cat(scanner.nextInt(), new Sex(scanner.next()), scanner.next()));
                                else {
                                    list.add(isAlter, new Cat(scanner.nextInt(), new Sex(scanner.next()), scanner.next()));
                                    list.remove(isAlter + 1);
                                    isAlter = -1;
                                }

                                break;
                            case "狗":
                                if (isAlter == -1)
                                    list.add(new Dog(scanner.nextInt(), new Sex(scanner.next()), scanner.next()));
                                else {
                                    list.add(isAlter, new Dog(scanner.nextInt(), new Sex(scanner.next()), scanner.next()));
                                    list.remove(isAlter + 1);
                                    isAlter = -1;
                                }

                                break;
                            case "鱼":
                                if (isAlter == -1)
                                    list.add(new Fish(scanner.nextInt(), new Sex(scanner.next()), scanner.next()));
                                else{
                                    list.add(isAlter, new Fish(scanner.nextInt(), new Sex(scanner.next()), scanner.next()));
                                    list.remove(isAlter + 1);
                                    isAlter = -1;
                                }

                                break;
                            default:
                                System.out.println("非法物种输入，添加失败！");
                        }
                    } catch (Exception e) {
                        System.out.println("非法输入，添加失败！");
                        isAlter = -1;
                        cmd = INVALID;
                        continue;
                    }
                    continue;
                case DELETE:
                    System.out.println("序号\t物种\t年龄\t性别\t详细种类描述");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(i + " -> " + list.get(i).getType() + "\t" + list.get(i).getAge() + "\t" +
                                list.get(i).getSex().getSex() + "\t" + list.get(i).getSpecies());
                    }
                    System.out.println("输入删除条目的序号：");
                    int index;
                    try {
                        index = scanner.nextInt();
                        list.remove(index);
                    } catch (Exception e) {
                        System.out.println("非法输入，删除失败！");
                        break;
                    }
                    break;
                case ALTER:
                    System.out.println("序号\t物种\t年龄\t性别\t详细种类描述");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(i + " -> " + list.get(i).getType() + "\t" + list.get(i).getAge() + "\t" +
                                list.get(i).getSex().getSex() + "\t" + list.get(i).getSpecies());
                    }
                    System.out.println("输入修改条目的序号：");
                    int aIndex;
                    try {
                        aIndex = scanner.nextInt();
                        if (aIndex < 0 || aIndex >= list.size()) {
                            System.out.println("非法输入，修改失败！");
                            break;
                        }
                        System.out.println("输入更新后的条目");
                        isAlter = aIndex;

                    } catch (Exception e) {
                        System.out.println("非法输入，修改失败！");
                        break;
                    }
                    break;
                case SEARCH:
                    System.out.println("请输入查询动物物种、年龄、性别");
                    String t, s;
                    int a;
                    try {
                        t = scanner.next();
                        a = scanner.nextInt();
                        s = scanner.next();
                        System.out.println("下列序号为符合要求项");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getType().equals(t) && list.get(i).getAge() == a &&
                                    list.get(i).getSex().getSex().equals(s)) {
                                System.out.println(i);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("非法输入，查找失败！");
                        break;
                    }
                    break;
                case ORDER_BY_AGE:
                    list.sort(Comparator.comparingInt(Animal::getAge));
                    System.out.println("序号\t物种\t年龄\t性别\t详细种类描述");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(i + " -> " + list.get(i).getType() + "\t" + list.get(i).getAge() + "\t" +
                                list.get(i).getSex().getSex() + "\t" + list.get(i).getSpecies());
                    }
                    break;
                default:
                    if (cmd != EXIT) System.out.println("非法输入！");
                    break;
            }
        }
    }
}
