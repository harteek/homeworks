package myh;

public class DoubelLinkerList {
    public static void main(String[] args) {
        //创建几个节点
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        //创建一个双向链表
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.add(node1);
        dll.add(node2);
        dll.add(node3);
        dll.add(node4);
        //测试显示
        // dll.showList();
        //测试增加
        dll.add(new Node(5));
        //  dll.showList();
        //测试删除
        dll.del(3);
        // dll.showList();
        //测试改
        Node node6 = new Node(2);
        dll.Update(node2);
        dll.showList();
    }
}
//双向链表类
class DoubleLinkedList {
    //初始化头节点
    private Node head = new Node(0);
    //返回头节点
    public Node getHead(){
        return head;
    }
    //遍历显示链表
    public void showList(){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //定义一个辅助指针来遍历
        Node temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
    //添加节点
    public void add(Node node){
        Node temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            //若没有到最后，则继续后移
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }
    //修改节点
    public void Update(Node node){
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }
        Node temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;//遍历完了都没找到该节点
            }
            if(node.x == temp.x){
                //找到该节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag确定是否找到该节点
        if(flag){
            temp.x = node.x;
        }else{
            System.out.println("没有找到该节点");
        }

    }
    //删除节点
    public void del(int x){
        if(head.next == null){
            System.out.println("链表为空！");
            return ;
        }
        Node temp  = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                System.out.println("没有找到该节点");
            }
            if(temp.x == x){
                //找到该节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = temp.next;
        }else
        {
            System.out.println("该节点不存在！");
        }

    }
}
//节点类
class Node {
    public Node pre;//指向前一个节点
    public Node next;//指向下一个节点
    int x;

    public Node(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                '}';
    }
}
