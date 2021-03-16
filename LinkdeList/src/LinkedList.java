public class LinkedList {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1,"人物1","111");
        HeroNode heroNode2 = new HeroNode(2,"人物2","222");
        HeroNode heroNode3 = new HeroNode(3,"人物3","333");
        HeroNode heroNode4 = new HeroNode(4,"人物4","444");
        HeroNode heroNode5 = new HeroNode(2,"人物4","444");
        SingleLinkedList list = new SingleLinkedList();
        list.addByNo(heroNode1);
        list.addByNo(heroNode3);
        list.addByNo(heroNode2);
        list.addByNo(heroNode4);
//        list.addByNo(heroNode5);
        list.list();
        System.out.println(list.getLength(list.getHead()));
        SingleLinkedList.getHero(list.getHead(),2);
        SingleLinkedList.LinkWord(list.getHead());
        list.list();
    }
}
//定义链表
class SingleLinkedList{

    //初始化头结点，不存放具体的数据，不动他
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

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

    //根据编号插入
    public void addByNo(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.no == heroNode.no){
                System.out.println("编号存在，不能插入");
                flag = true;
                break;
            }else if(temp.next.no>heroNode.no){
                break;
            }
            temp = temp.next;

        }
        if(flag == true){
            System.out.println("该编号"+temp.no+"已存在，请重新插入不同编号的值");
        }else{
            heroNode.next =temp.next;
            temp.next=heroNode;

        }
    }

    //根据编号进行修改
    //根据编号修改，直接传入要修改的对象，取no
    public void update(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while(true) {
            if (temp.next == null) {
                System.out.println("链表为空，不能修改，请插入");
                return;
            }
            if(temp == null){
                break;
            }else if(heroNode.no == temp.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag == false){
            System.out.println("没有找到"+heroNode.no+"这个编号");
        }else{
            temp.name = heroNode.name;
            temp.nickName = heroNode.name;
        }
    }

    //遍历链表进行输出
    public void list(){
        if(head.next ==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    //删除节点
    public void deleteByNo(HeroNode heroNode) {
        HeroNode temp = head.next;
        while (true) {
            if (temp.next == null) {
                System.out.println("链表为空");
                return;
            }
            if(temp == null){
                break;
            }else if(temp.next.no == heroNode.no){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    //统计节点
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        HeroNode cur = head.next;
        int length = 0;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
    //得到链表第几个的值
    public static HeroNode getHero(HeroNode head,int index){
        if(head.next == null){
            System.out.println("该链表为空");
            return null;
        }
        int length = getLength(head);
        HeroNode temp = head;
        for (int i = 0; i <length-index; i++) {
            temp = temp.next;
        }
        System.out.println(temp.no+temp.nickName+temp.name);
        return temp;
    }

    public static void LinkWord(HeroNode head){
        if(head.next == null || head.next.next==null){
            System.out.println("链表太少，不满足反转要求");
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");
        while(cur !=null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
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
