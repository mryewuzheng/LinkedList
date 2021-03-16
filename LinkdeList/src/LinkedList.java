public class LinkedList {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1,"人物1","111");
        HeroNode heroNode2 = new HeroNode(2,"人物2","222");
        HeroNode heroNode3 = new HeroNode(3,"人物3","333");
        SingleLinkedList list = new SingleLinkedList();
        list.add(heroNode1);
        list.add(heroNode2);
        list.add(heroNode3);
        list.list();

    }
}
//定义链表
class SingleLinkedList{
    //初始化头结点，不存放具体的数据，不动他
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单向链表
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void list(){
        if(head.next ==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

}

//每个对象即为一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

}
